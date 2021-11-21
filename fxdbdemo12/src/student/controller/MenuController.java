package student.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import student.Main;

public class MenuController {

    @FXML
    void onClickAdd(ActionEvent event) throws IOException {
    	if(Main.login.equals("ON")) {
    	AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/Add.fxml"));
    	Main.mainLayout.setCenter(root);
    	} 
    	else {
    		JOptionPane.showMessageDialog(null, "First, You must do login !");
    	}
    }

    @FXML
    void onClickDelete(ActionEvent event) throws IOException {
    	if(Main.login.equals("ON")) {
    	AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/Delete.fxml"));
    	Main.mainLayout.setCenter(root);
    	} 
    	else {
    		JOptionPane.showMessageDialog(null, "First, You must do login !");
    	}
    }

    @FXML
    void onClickSearch(ActionEvent event) throws IOException {
     	if(Main.login.equals("ON")) {
        	AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/Search.fxml"));
        	Main.mainLayout.setCenter(root);
        	} 
        	else {
        		JOptionPane.showMessageDialog(null, "First, You must do login !");
        	}
    }

    @FXML
    void onClickUpdate(ActionEvent event) throws IOException {
     	if(Main.login.equals("ON")) {
        	AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/Update.fxml"));
        	Main.mainLayout.setCenter(root);
        	} 
        	else {
        		JOptionPane.showMessageDialog(null, "First, You must do login !");
        	}
    }

    @FXML
    void onClickHome(ActionEvent event) throws IOException {
     	if(Main.login.equals("ON")) {
        	AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/Sample.fxml"));
        	Main.mainLayout.setCenter(root);
        	} 
        	else {
        		JOptionPane.showMessageDialog(null, "First, You must do login !");
        	}
    }
}
