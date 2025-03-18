module org.evalsys.finalevalsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;

    opens org.evalsys.finalevalsystem to javafx.fxml;
    exports org.evalsys.finalevalsystem;

    opens org.evalsys.finalevalsystem.backend to javafx.base;
}