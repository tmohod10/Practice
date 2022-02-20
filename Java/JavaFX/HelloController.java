package com.example.javafxcomponents;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class HelloController {
    @FXML
    private Label label;

    @FXML
    private Button button4;

    @FXML
    private GridPane gridPane;

    @FXML
    private WebView webView;

    public void initialize() {
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter() {
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit() {
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    @FXML
    public void handleClick() {
        // Files chooser for choosing file
        FileChooser chooser = new FileChooser();
        chooser.setTitle("File Chooser");

        // Directory chooser for choosing directory
        DirectoryChooser directoryChooser = new DirectoryChooser();

        // Setting File Extension filters
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Zip", "*.zip"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        // Open single file
        File file = chooser.showOpenDialog(gridPane.getScene().getWindow());

        // Open multiple files
        List<File> files = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        if(files != null) {
            for(File thisFile : files) {
                System.out.println(thisFile);
            }
        } else {
            System.out.println("Chooser was cancelled");
        }
    }

    @FXML
    public void handleLinkClick() {
        // Link will be redirected to a browser.
        try {
            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));
        } catch(IOException e) {
            e.printStackTrace();
        } catch(URISyntaxException e) {
            e.printStackTrace();
        }

        // Webpage will shown inside the component
        WebEngine engine = webView.getEngine();
        engine.load("http://www.javafx.com");
    }
}