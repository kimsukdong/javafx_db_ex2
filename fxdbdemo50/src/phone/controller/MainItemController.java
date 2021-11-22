package phone.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import phone.Main;
import phone.mysqlconnect;

public class MainItemController {
	@FXML
	Parent root;
	Main main = new Main();
	Connection conn = null;
	Window owner;

	@FXML	public TextField txt_username;
	@FXML	public PasswordField txt_password;
	@FXML	private Label lblname;
	@FXML	private AnchorPane loginpane;
	@FXML	private AnchorPane logoutpane;

	@FXML
	private void initialize() {
		if( Main.main_username != null &&!Main.main_username.isEmpty()) {
			txt_username.setText(Main.main_username);
			txt_password.setText(Main.main_password);
		}
		if(Main.login.equals("ON")) {
			String s1 = "æ»≥Á«œººø‰? " +Main.main_username+ " ¥‘ !!!";
			loginpane.setVisible(false);
			lblname.setText(s1);
			logoutpane.setVisible(true);
		}
	}

	@FXML
	void onClickLogin(ActionEvent event) throws SQLException {
		owner = txt_username.getScene().getWindow();
		if(txt_username.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR,owner,"Please enter a valid username", "Form error!");
			return;
		}
		if(txt_password.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR,owner,"Please enter a valid Password", "Form error!");
			return;
		}
		conn = mysqlconnect.ConnectDb();
		String username = txt_username.getText();
		String password = txt_password.getText();

		boolean flag =true;
		flag = mysqlconnect.validate(username, password);
		if(!flag)
			infoBox("Please enter correct username and password",null,"Failed");
		else {
			// infoBox("Login Successful , " + username,null,"Success");	
			Main.main_username = username;
			Main.main_password = password;
			Main.login = "ON";
		}
		if(Main.login.equals("ON")) {
			String s1 = "æ»≥Á«œººø‰? " +Main.main_username+ " ¥‘ !!!";
			loginpane.setVisible(false);
			lblname.setText(s1);
			logoutpane.setVisible(true);
		}
	}

	@FXML
	void onClickLogout(ActionEvent event) throws SQLException {
		conn = null;
		Main.main_username = "";
		Main.main_password = "";

		Main.login = "OFF";

		txt_username.setText("");
		txt_password.setText("");

		loginpane.setVisible(true);
		logoutpane.setVisible(false);	
		Main.login = "OFF";

	}

	public static void infoBox(String infoMessage, String headerText, String title) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(infoMessage);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();    	
	}

	public static void showAlert(Alert.AlertType alertType, Window owner, String message, String title) {
		Alert alert = new Alert(alertType);
		alert.setContentText(message);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.initOwner(owner);
		alert.show();    	
	}

	@FXML
	void onClickCafe(MouseEvent event) {
		if(Main.login.equals("ON"))
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/CafeMain.fxml"));
				Main.mainLayout.setCenter(root);
			} catch(Exception e) {
				e.printStackTrace();
			}
		else
		{
			owner = txt_username.getScene().getWindow();
			showAlert(Alert.AlertType.ERROR,owner,"First, You must do login", "Form error!");
			return;
		}
	}
	@FXML
	void onClickAdress(MouseEvent event) {
		if(Main.login.equals("ON"))
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/AddressMain.fxml"));
				Main.mainLayout.setCenter(root);
			} catch(Exception e) {
				e.printStackTrace();
			}
		else
		{
			owner = txt_username.getScene().getWindow();
			showAlert(Alert.AlertType.ERROR,owner,"First, You must do login", "Form error!");
			return;
		}
	}

	@FXML
	void onClickPizza(MouseEvent event) {
		if(Main.login.equals("ON"))
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/PizzaMain.fxml"));
				Main.mainLayout.setCenter(root);
			} catch(Exception e) {
				e.printStackTrace();
			}
		else
		{
			owner = txt_username.getScene().getWindow();
			showAlert(Alert.AlertType.ERROR,owner,"First, You must do login", "Form error!");
			return;
		}
	}
	@FXML
	void onClickBus(MouseEvent event) {
		if(Main.login.equals("ON"))
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/BusMain.fxml"));
				Main.mainLayout.setCenter(root);
			} catch(Exception e) {
				e.printStackTrace();
			}
		else
		{
			owner = txt_username.getScene().getWindow();
			showAlert(Alert.AlertType.ERROR,owner,"First, You must do login", "Form error!");
			return;
		}
	}


	@FXML
	void onClickRestaurant(MouseEvent event) {
		if(Main.login.equals("ON"))
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/RestaurantMain.fxml"));
				Main.mainLayout.setCenter(root);
			} catch(Exception e) {
				e.printStackTrace();
			}
		else
		{
			owner = txt_username.getScene().getWindow();
			showAlert(Alert.AlertType.ERROR,owner,"First, You must do login", "Form error!");
			return;
		}
	}

	@FXML
	void onClickEmployee(MouseEvent event) {
		if(Main.login.equals("ON"))
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/EmployeeMain.fxml"));
				Main.mainLayout.setCenter(root);
			} catch(Exception e) {
				e.printStackTrace();
			}
		else
		{
			owner = txt_username.getScene().getWindow();
			showAlert(Alert.AlertType.ERROR,owner,"First, You must do login", "Form error!");
			return;
		}
	}

}
