module com.tugasrakamin.tugasrakamin1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tugasrakamin.tugasrakamin1 to javafx.fxml;
    exports com.tugasrakamin.tugasrakamin1;
}