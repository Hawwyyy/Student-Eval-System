package org.evalsys.finalevalsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.evalsys.finalevalsystem.backend.Subject;

import java.util.List;

public class RecommendedSubjectsController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label programLabel;

    @FXML
    private TableView<Subject> subjectsTable;

    @FXML
    private TableColumn<Subject, String> codeColumn;

    @FXML
    private TableColumn<Subject, Integer> unitsColumn;

    @FXML
    private Label totalUnitsLabel;

    @FXML
    private Button closeButton;

    private ObservableList<Subject> subjectsList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Set up the table columns
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        unitsColumn.setCellValueFactory(new PropertyValueFactory<>("units"));

        // Bind the table to the observable list
        subjectsTable.setItems(subjectsList);
    }

    public void setupRecommendedSubjects(String name, int id, String program, List<org.evalsys.finalevalsystem.backend.Subject> recommendedSubjects) {
        // Set student information
        nameLabel.setText(name);
        idLabel.setText(String.valueOf(id));
        programLabel.setText(program);

        // Add subjects to the table
        subjectsList.addAll(recommendedSubjects);


        // Calculate and display total units
        int totalUnits = recommendedSubjects.stream()
                .mapToInt(Subject::getUnits)
                .sum();
        totalUnitsLabel.setText(String.valueOf(totalUnits));
    }

    @FXML
    private void handleClose() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
