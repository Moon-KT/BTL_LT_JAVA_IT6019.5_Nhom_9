package org.lms;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private Stage primaryStage;
    private Scene loginScene;
    private Scene loggedInScene;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Login Form");

        // Login scene
        GridPane loginGrid = new GridPane();
        loginGrid.setPadding(new Insets(20, 20, 20, 20));
        loginGrid.setVgap(10);
        loginGrid.setHgap(10);

        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameInput = new TextField();
        GridPane.setConstraints(usernameInput, 1, 0);

        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordInput = new PasswordField();
        GridPane.setConstraints(passwordInput, 1, 1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        loginGrid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton);

        // Logged-in scene
        VBox loggedInLayout = new VBox(10);
        loggedInLayout.setPadding(new Insets(20, 20, 20, 20));

        Label welcomeLabel = new Label("Welcome!");
        Button logoutButton = new Button("Logout");
        loggedInLayout.getChildren().addAll(welcomeLabel, logoutButton);

        loginButton.setOnAction(e -> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();

            // Authentication logic, will implement later
            if (username.equals("admin") && password.equals("password")) {
                primaryStage.setScene(loggedInScene);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password.");
                alert.showAndWait();
            }
        });

        logoutButton.setOnAction(e -> {
            primaryStage.setScene(loginScene);
        });

        loginScene = new Scene(loginGrid, 300, 200);
        loggedInScene = new Scene(loggedInLayout, 300, 200);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
