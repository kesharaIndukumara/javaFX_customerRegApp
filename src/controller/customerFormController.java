package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

    ArrayList<customer> customerList = new ArrayList<>();

    public void btnRegOnAction(ActionEvent actionEvent) {
        customerList.add(new customer(
                txtFirstName.getText(),
                txtLastName.getText(),
                txtEmail.getText(),
                txtContactNumber.getText()
        ));
    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
        customerList.forEach(customer -> {
            System.out.println(customer);
        });
    }
}
