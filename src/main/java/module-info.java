module com.palmen.libreria.app.libreria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.palmen.libreria.app.libreria to javafx.fxml;
    exports com.palmen.libreria.app.libreria;
    exports com.palmen.libreria.app.libreria.utilities;
    opens com.palmen.libreria.app.libreria.utilities to javafx.fxml;
    exports com.palmen.libreria.app.libreria.controllers;
    opens com.palmen.libreria.app.libreria.controllers to javafx.fxml;
}