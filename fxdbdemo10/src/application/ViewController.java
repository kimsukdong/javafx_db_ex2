package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewController {
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
	private TextField txt_email2;
	@FXML
	private TextField txt_id2;
	@FXML
	private TextField txt_name2;
	@FXML
	private TextField txt_phone2;  
	
	@FXML
	private TextField txt_email3;
	@FXML
	private TextField txt_id3;
	@FXML
	private TextField txt_name3;
	@FXML
	private TextField txt_phone3;  

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
	private TableView<Student> tableContent1;    
	@FXML
	private TableColumn<Student, String> col_email1;
	@FXML
	private TableColumn<Student, String> col_id1;
	@FXML
	private TableColumn<Student, String> col_name1;
	@FXML
	private TableColumn<Student, String> col_phone1;

	@FXML
	private TableView<Student> tableContent2;    
	@FXML
	private TableColumn<Student, String> col_email2;
	@FXML
	private TableColumn<Student, String> col_id2;
	@FXML
	private TableColumn<Student, String> col_name2;
	@FXML
	private TableColumn<Student, String> col_phone2;
	
	@FXML
	private TableView<Student> tableContent3;    
	@FXML
	private TableColumn<Student, String> col_email3;
	@FXML
	private TableColumn<Student, String> col_id3;
	@FXML
	private TableColumn<Student, String> col_name3;
	@FXML
	private TableColumn<Student, String> col_phone3;

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

				col_id1.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
				col_name1.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
				col_email1.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
				col_phone1.setCellValueFactory(new PropertyValueFactory<Student,String>("phone"));										 
				tableContent1.setItems(list);


				col_id2.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
				col_name2.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
				col_email2.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
				col_phone2.setCellValueFactory(new PropertyValueFactory<Student,String>("phone"));										
				tableContent2.setItems(list);
				
				col_id3.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
				col_name3.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
				col_email3.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
				col_phone3.setCellValueFactory(new PropertyValueFactory<Student,String>("phone"));										
				tableContent3.setItems(list);

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
		
		txt_id2.setText("");
		txt_name2.setText("");
		txt_email2.setText("");
		txt_phone2.setText("");
		
		txt_id3.setText("");
		txt_name3.setText("");
		txt_email3.setText("");
		txt_phone3.setText("");
	}

	@FXML
	void onClickHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}

	@FXML
	void onClcikBack(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("NewWindow.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}

	@FXML
	void onMouseClicked(MouseEvent event) {
		TableViewSelectionModel<Student> model = tableContent.getSelectionModel();

		Student s = (Student)model.getSelectedItem();
		txt_id.setText(s.getId());
		txt_name.setText(s.getName());
		txt_email.setText(s.getEmail());
		txt_phone.setText(s.getPhone());

		index = s.getId();
	}

	@FXML
	void onMouseClicked2(MouseEvent event) {
		TableViewSelectionModel<Student> model = tableContent2.getSelectionModel();

		Student s = (Student)model.getSelectedItem();
		txt_id2.setText(s.getId());
		txt_name2.setText(s.getName());
		txt_email2.setText(s.getEmail());
		txt_phone2.setText(s.getPhone());

		index = s.getId();
	}
	
	@FXML
	void onMouseClicked3(MouseEvent event) {
		TableViewSelectionModel<Student> model = tableContent3.getSelectionModel();

		Student s = (Student)model.getSelectedItem();
		txt_id3.setText(s.getId());
		txt_name3.setText(s.getName());
		txt_email3.setText(s.getEmail());
		txt_phone3.setText(s.getPhone());

		index = s.getId();
	}

	
	@FXML
	void onClcikUpdate(ActionEvent event) {
		String r1 = txt_id.getText();
		String r2 = txt_name.getText();
		String r3 = txt_email.getText();
		String r4 = txt_phone.getText();
		if(r1.length()==0) {
			JOptionPane.showMessageDialog(null, "No id");
			return ;
		}

		try {
			pst = conn.prepareStatement("update student set name= ?, email=?,phone=? where id = ?");
			pst.setString(1, r2);
			pst.setString(2, r3);
			pst.setString(3, r4);
			pst.setString(4, r1);


			if(index.equals(r1)) {
				JOptionPane.showMessageDialog(null, "Student update!");
				pst.executeUpdate();
			} else
			{
				JOptionPane.showMessageDialog(null, "Different id");
			}

			cleartext();
			tablelookup();	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void onClcikAdd(ActionEvent event) {
		String r1 = txt_id2.getText();
		if(r1.length()==0) {
			JOptionPane.showMessageDialog(null, "No Record");
			return ;
		}

		String r2 = txt_name2.getText();
		String r3 = txt_email2.getText();
		String r4 = txt_phone2.getText();

		try {
			pst = conn.prepareStatement("insert into student (id,name, email, phone) values (?,?,?,?)");
			pst.setString(1, r1);
			pst.setString(2, r2);
			pst.setString(3, r3);
			pst.setString(4, r4);
			int k =pst.executeUpdate();

			if(k==1) {
				JOptionPane.showMessageDialog(null, "Add Student !!!");
			} else {
				JOptionPane.showMessageDialog(null, "Error!");
			}
		} catch(SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Duplicate!");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		cleartext();
		tablelookup();

	}
	
	@FXML
	void onClcikDelete(ActionEvent event) {
		if(index.length()==0) {
			JOptionPane.showMessageDialog(null, "No id");
			return ;
		}
		int dialogresult = JOptionPane.showConfirmDialog(null, "Do you want to delete this student?");
		if(dialogresult == JOptionPane.YES_NO_OPTION)
		{
			try {
				pst = conn.prepareStatement("delete from student where id = ?");
				pst.setString(1, index);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Student Deleted!");
				tablelookup();						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cleartext();
	}
}
