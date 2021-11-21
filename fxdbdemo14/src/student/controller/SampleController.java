package student.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import student.Main;
import student.mysqlconnect;

public class SampleController {

	Connection conn = null;
	ResultSet srs = null;
	PreparedStatement pst = null;
	Main main = new Main();
	
    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

	@FXML
	private void initialize() {
		conn = mysqlconnect.ConnectDb();
		try {
			pst = conn.prepareStatement("select * from user where name =? and password=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
    @FXML
    void onClickCancel(ActionEvent event) {
    	System.exit(0);
    }  
    
    @FXML
    void onClickLogin(ActionEvent event) throws IOException {  	
       	String id = tf1.getText();
    	String name = tf2.getText();
       	
    	if(id.equals("") && name.equals(""))
    	{
    		JOptionPane.showMessageDialog(null, "UserName or Password Blank");    		    		
    	} else 
    	{
			try {
				pst.setString(1, id);
				pst.setString(2, name);
				
				srs = pst.executeQuery();
				if(srs.next()) {
					JOptionPane.showMessageDialog(null, "Login Success");  
					Main.login = "ON";
					AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/Menu.fxml"));
					Main.mainLayout.setCenter(root);

				} else
				{
					JOptionPane.showMessageDialog(null, "Login Failed");  
					tf1.setText("");
					tf2.setText("");
					tf1.requestFocus();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
   
    
    @FXML
    void onClickSignup(ActionEvent event) {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/SignUp.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}	
    }

}
