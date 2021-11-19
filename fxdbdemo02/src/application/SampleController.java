package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

public class SampleController {
	Connection conn;
	Statement stmt = null;
	ResultSet srs;
	@FXML
	private void initialize() {
		conn = mysqlconnect.ConnectDb();
		try {

			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE );
			srs = stmt.executeQuery("select * from student");

			if(srs.next()) {
				tf1.setText(srs.getString("id"));
				tf2.setText(srs.getString("name"));
				tf3.setText(srs.getString("email"));
				tf4.setText(srs.getString("phone"));
				label1.setText("confirm");
			}

		} catch (SQLException e) {
			System.out.println("SQL Error");
		} 
	}
	@FXML
	private TextField tf1;

	@FXML
	private TextField tf2;

	@FXML
	private TextField tf3;

	@FXML
	private TextField tf4;
	@FXML
	private Label label1;
	private void repeat() throws SQLException {
		stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE );
		srs = stmt.executeQuery("select * from student");
		if(srs.next()) {
			tf1.setText(srs.getString("id"));
			tf2.setText(srs.getString("name"));
			tf3.setText(srs.getString("email"));
			tf4.setText(srs.getString("phone"));
			label1.setText("confirm");
		}
	}

	@FXML
	void onClickNext(ActionEvent event) {
		try {
			if(srs.next()) {
				tf1.setText(srs.getString("id"));
				tf2.setText(srs.getString("name"));
				tf3.setText(srs.getString("email"));
				tf4.setText(srs.getString("phone"));
			}
			else {
				label1.setText("No data !");     		
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void onClickBack(ActionEvent event) {
		try {
			if(srs.previous()) {
				tf1.setText(srs.getString("id"));
				tf2.setText(srs.getString("name"));
				tf3.setText(srs.getString("email"));
				tf4.setText(srs.getString("phone"));
			}
			else {
				label1.setText("No data !");    		
				}  			      
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void onClickFirst(ActionEvent event) {
		try {
			repeat();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
