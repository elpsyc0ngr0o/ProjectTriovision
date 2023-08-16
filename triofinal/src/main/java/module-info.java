module com.isep.triovisioncarlos {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.isep.triofinal to javafx.fxml;
    exports com.isep.triofinal;
}