package controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.customer;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

public class customerFormController {
    public Button btnReg;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtEmail;
    public TextField txtContactNumber;
    public Button btnReload;
    public TableView tblCustomers;
    public TableColumn colFName;
    public TableColumn colLName;
    public TableColumn colEmail;
    public TableColumn colConNumber;

    ArrayList<customer> customerList = new ArrayList<>();

    public void btnRegOnAction(ActionEvent actionEvent) {
        customerList.add(new customer(
                txtFirstName.getText(),
                txtLastName.getText(),
                txtEmail.getText(),
                txtContactNumber.getText()
        ));
        btnReloadOnAction(actionEvent);
    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
        colFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colConNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));

        ObservableList<customer> customerObservableList = FXCollections.observableArrayList();

        customerList.forEach(customer -> {
            customerObservableList.add(customer);
        });

        tblCustomers.setItems(customerObservableList);
    }
}
