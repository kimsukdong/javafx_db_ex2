package student.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import student.Main;
import student.mysqlconnect;

public class SignUpController {
	Connection conn = null;
	ResultSet srs = null;
	PreparedStatement pst = null;

	@FXML
	private TextField tf1;

	@FXML
	private TextField tf2;

	@FXML
	private TextField tf3;

	@FXML
	private TextField tf4;

	@FXML
	void onClickUp(ActionEvent event) {
		conn = mysqlconnect.ConnectDb();

		String name;
		if(tf1.getText().isEmpty())
			name = "";
		else name = tf1.getText();
		String password = tf2.getText();
		String email = tf3.getText();
		String phone = tf4.getText();
		

		if(name.length()==0) {
			JOptionPane.showMessageDialog(null, "Please, enter the Username");
			return ;
		}
		if(password.length()==0) {
			JOptionPane.showMessageDialog(null, "Please, enter the Password");
			return ;
		}
		int k=0;
		try {
			pst = conn.prepareStatement("select * from user where name =?");
			pst.setString(1, name);	
			srs = pst.executeQuery();
			if(!srs.next()) {
				pst = conn.prepareStatement("insert into user (name, password,email,phone) values (?,?,?,?)");
				pst.setString(1, name);
				pst.setString(2, password);
				pst.setString(3, email);
				pst.setString(4, phone);
				k =pst.executeUpdate();
			}
			else {
				JOptionPane.showMessageDialog(null, "사용자 중복!");
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				return;
			}
			if(k==1) {
				JOptionPane.showMessageDialog(null, "New User !!!");
			} else {
				JOptionPane.showMessageDialog(null, "Error!");
			}
		} catch(SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Duplicate!");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
