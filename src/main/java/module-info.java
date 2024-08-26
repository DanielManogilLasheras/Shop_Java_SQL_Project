module com.shop.leinadprojects.shop_java_sql {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.shop.leinadprojects.shop_java_sql to javafx.fxml;
    exports com.shop.leinadprojects.shop_java_sql;
    exports controller;
    opens controller to javafx.fxml;
}