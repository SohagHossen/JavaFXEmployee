/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.employee.JavaFXEmployee.employeeList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HourlyEmployeeController implements Initializable {

    @FXML
    private TextField namebar;
    @FXML
    private TextField idbar;
    @FXML
    private TextField desbar;
    @FXML
    private TextField hrbar;
    @FXML
    private TextField hwbar;
    @FXML
    private TextField sbar;
    @FXML
    private TextField unbar;

    @FXML
    private void backAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("EmployeeType.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void HomeAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void submitAction(ActionEvent event) throws IOException {

        String name = namebar.getText();
        String id = idbar.getText();
        String designation = desbar.getText();
        boolean f = true;
        boolean fn = true;
        boolean fd = true;
        double hourlyRate = 0;
        int hourWorked = 0;

        unbar.setText("");

        for (int i = 0; i < name.length(); i++) {

            if (name.charAt(i) >= '0' && name.charAt(i) <= '9') {
                fn = false;
                namebar.setText("");
                unbar.setText("Name should be Alphabet");
                break;
            }
        }

        for (int i = 0; i < designation.length(); i++) {

            if (designation.charAt(i) >= '0' && designation.charAt(i) <= '9') {
                fd = false;
                desbar.setText("");
                unbar.setText("Designation should be Alphabetic");
                break;
            }
        }

        try {
            int ID = Integer.parseInt(idbar.getText());
        } catch (NumberFormatException e) {
            idbar.setText("");
            unbar.setText("ID should be in Digit");
        }

        for (EmployeeType emp : employeeList) {
            if (emp.getId().equals(id)) {
                f = false;
                unbar.setText("ID should be Unique");
                idbar.setText("");
                break;
            }
        }

        try {
            hourlyRate = Double.parseDouble(hrbar.getText());
        } catch (NumberFormatException e) {
            hrbar.setText("");
            unbar.setText("Invalid Hourly Rate");
        }

        try {
            hourWorked = Integer.parseInt(hwbar.getText());
        } catch (NumberFormatException e) {
            hwbar.setText("");
            unbar.setText("Invalid Hourly Worked");
        }

        if (unbar.getText().equals("Invalid Hourly Rate") || unbar.getText().equals("Invalid Hourly Worked")) {
            sbar.setText("Unable to add in List");
        } else if (unbar.getText().equals("ID should be in Digit") || f == false) {
            sbar.setText("Unable to add in List");
        } else if (fn == false) {
            sbar.setText("Unable to add in List");
        } else if (fd == false) {
            sbar.setText("Unable to add in List");
        } else {
            EmployeeType e = new HourlyEmployee(name, id, designation, hourlyRate, hourWorked);
            employeeList.add(e);
            sbar.setText("Successfully added in the List");
        }
    }

    @FXML
    private void cleartAction(ActionEvent event) throws IOException {

        namebar.setText("");
        idbar.setText("");
        desbar.setText("");
        hrbar.setText("");
        hwbar.setText("");
        sbar.setText("");
    }

    @FXML
    private void showAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Display Specific.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void showlistAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("DisplayAll.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
