package views;

import controllers.LibraryController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Main extends Application {
    private LibraryController libraryController;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library System");

        libraryController = new LibraryController();

        VBox root = new VBox();
        root.setSpacing(10);

        Label welcomeLabel = new Label("Welcome to the Library System");
        Button borrowButton = new Button("Borrow Book");
        borrowButton.setOnAction(event -> {
            libraryController.borrowBook("1", libraryController.getLibraryService().getBooks().get(0).getClass());
        });

        Button returnButton = new Button("Return Book");
        returnButton.setOnAction(event -> {
            libraryController.returnBook("1", libraryController.getLibraryService().getBooks().get(0).getClass());
        });

        root.getChildren().addAll(welcomeLabel, borrowButton, returnButton);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
