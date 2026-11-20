package edu.westga.comp4420.grocerylist.view.codebehind;

import edu.westga.comp4420.grocerylist.Main;
import edu.westga.comp4420.grocerylist.model.FinancialValueType;
import edu.westga.comp4420.grocerylist.model.MoneyChange;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * CodeBehind To Handle Processing for the MainWindow.
 *
 * @author sc00278
 * @version Fall 2026
 */
public class MainWindow {
  @FXML
  private ListView<MoneyChange> moneyChanges;
  @FXML
  private AnchorPane guiPane;
  @FXML
  private TextField name;
  @FXML
  private TextField value;
  @FXML
  private ComboBox<FinancialValueType> valueType;
  @FXML
  private Label errorLabel;

  @FXML
  void addItem(ActionEvent event) {
    if (!this.name.getText().trim().isEmpty() && !this.value.getText().trim().isEmpty()) {
      this.errorLabel.setText("");
      String value = this.value.getText().trim();
      this.moneyChanges.getItems().add(new MoneyChange(this.name.getText().trim(),
          Double.parseDouble(value), this.valueType.getValue()));
    } else {
      this.errorLabel.setText("must have a valid name and dollar amount");
    }
  }

  @FXML
  void removeItem(ActionEvent event) {
    MoneyChange selectedItem = this.moneyChanges.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
      this.moneyChanges.getItems().remove(selectedItem);
    }
  }

  @FXML
  void initialize() {
    assert this.moneyChanges != null : "fx:id=\"groceryItems\" was not injected: check your FXML file 'MainWindow.fxml'.";
    assert this.guiPane != null : "fx:id=\"guiPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
    this.errorLabel.setWrapText(true);

    this.valueType.getItems().setAll(FinancialValueType.values());
    this.valueType.getSelectionModel().select(FinancialValueType.expense);

    this.value.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue.matches("^\\d*(\\.\\d{0,2})?$")) {
        this.value.setText(oldValue);
      }
    });
  }
}
