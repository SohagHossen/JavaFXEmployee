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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DisplaySpecificController implements Initializable {
    
    @FXML private TextField idbar;
    @FXML private TextArea disbar;
    @FXML private TextField unbar;

    @FXML
    private void backAction(ActionEvent event) throws IOException {
          
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();  
    }
    
    @FXML
    private void ETAction(ActionEvent event) throws IOException {
          
            Parent root = FXMLLoader.load(getClass().getResource("EmployeeType.fxml"));
            Scene scene = new Scene(root);
            
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();  
    }
    
    @FXML
    private void submitAction(ActionEvent event) throws IOException {
        
        try {
            int id = Integer.parseInt(idbar.getText());
            unbar.setText("");
        } catch (NumberFormatException e) {
            idbar.setText("");
            unbar.setText("ID should be in Digit");
        }
        
        boolean f = false;
        String id = idbar.getText();
        
        disbar.setText("");
        
        for(EmployeeType emp: employeeList)
        {
            if(emp.getId().equals(id)){
                f = true;
                String s = String.valueOf(emp.getSalary());
                disbar.setText("Name: "+emp.getName()+"\n\nID: "+id+"\n\nDesignation: "+emp.getDesignation()+"\n\nSalary: "+s+" BDT");
                break;
            }
        }
        if(f==false) disbar.setText("Employee not in the List");
    }
    
    @FXML
    private void cleartAction(ActionEvent event) throws IOException {
        
        idbar.setText("");
        disbar.setText("");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
