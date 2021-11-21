package student.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import student.Main;
import student.Student;
import student.mysqlconnect;

public class SearchController {
	Connection conn;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet srs;
	
	ObservableList<Student> list;
	String index;
	
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_id;
    @FXML
    private TextField txt_name;
    @FXML
    private TextField txt_phone;  
    @FXML
    private TableView<Student> tableContent;
    @FXML
    private TableColumn<Student, String> col_email;

    @FXML
    private TableColumn<Student, String> col_id;

    @FXML
    private TableColumn<Student, String> col_name;

    @FXML
    private TableColumn<Student, String> col_phone;
	
	@FXML
	private void initialize() {
		conn = mysqlconnect.ConnectDb();
		tablelookup();
	}
	
	public void tablelookup() {
		
		try {
			stmt = conn.createStatement();
			srs = stmt.executeQuery("select * from student");

			list = FXCollections.observableArrayList();
			while(srs.next()) {

				String r1 = srs.getString("id");
				String r2 = srs.getString("name");
				String r3 = srs.getString("email");
				String r4 = srs.getString("phone");				

				Student student = new Student(r1,r2,r3,r4);	

				list.add(student);

				col_id.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
				col_name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
				col_email.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
				col_phone.setCellValueFactory(new PropertyValueFactory<Student,String>("phone"));										
 
				tableContent.setItems(list);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cleartext() {
		txt_id.setText("");
		txt_name.setText("");
		txt_email.setText("");
		txt_phone.setText("");
	}
    
    @FXML
    void onClickHome(ActionEvent event) throws IOException {
    	AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/Sample.fxml"));
    	Main.mainLayout.setCenter(root);
    }
    
    @FXML
    void onClickBack(ActionEvent event) throws IOException {
    	AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/Menu.fxml"));
    	Main.mainLayout.setCenter(root);
    }

    @FXML
    void onMouseClicked(MouseEvent event) {
	
    }

}
