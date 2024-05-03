module org.lms {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.lms to javafx.fxml;
    exports org.lms;
}