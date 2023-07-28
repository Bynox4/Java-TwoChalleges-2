module com.conversor {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    opens com.conversor to javafx.fxml;
    exports com.conversor;
}
