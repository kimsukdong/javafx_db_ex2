module fxdbdemo14 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	
	opens student to javafx.graphics, javafx.fxml,javafx.base;
	opens student.controller to javafx.graphics, javafx.fxml;
}
