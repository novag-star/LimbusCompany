module co.edu.uniquindio.poo.inmobilaria {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.bootstrapfx.core;

    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    requires java.logging;


    exports co.edu.uniquindio.poo.inmobilaria;
    opens co.edu.uniquindio.poo.inmobilaria to javafx.graphics, javafx.fxml;


    exports co.edu.uniquindio.poo.inmobilaria.controller;
    opens co.edu.uniquindio.poo.inmobilaria.controller to javafx.fxml;


    exports co.edu.uniquindio.poo.inmobilaria.model;
    opens co.edu.uniquindio.poo.inmobilaria.model to javafx.fxml;
}