module com.example.inscripcionup {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.inscripcionup to javafx.fxml;
    exports com.example.inscripcionup;
    exports com.example.inscripcionup.Controllers;
    opens com.example.inscripcionup.Controllers to javafx.fxml;
}