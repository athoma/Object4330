/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

/**
 *
 * @author athomaperry
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML 
    private MenuItem openMenu;
    
    @FXML
    private TreeView domTree;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {} 
    
    private TreeItem<String> buildTree(SAXNode root) {
        if(root == null) return null;
        String rootAttributes = "";
        rootAttributes = root.getAttributes().entrySet().stream().map((attribute) -> " " + attribute.getKey() + "=" + attribute.getValue()).reduce(rootAttributes, String::concat);
        TreeItem<String> treeRoot = new TreeItem<>(root.getKey() + rootAttributes);
        if(root.getProperties() != null) {
            root.getProperties().entrySet().forEach((property) -> {
                int numberOfProperties = root.getProperty(property.getKey()).size();
                for(int i = 0; i < numberOfProperties; i++) {
                    treeRoot.getChildren().add(buildTree(property.getValue().get(i)));
                }
            });
        } else {
            treeRoot.getChildren().add(new TreeItem<>(root.getValue()));
        }
        return treeRoot;
    }
    
    public void start(Stage stage) {
        openMenu.setOnAction((event) -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Open XML File");
            chooser.getExtensionFilters().add(new ExtensionFilter("XML files", "*.xml"));
            File selected = chooser.showOpenDialog(stage);
            if(selected != null) {
                try {
                    SAXNode xmlRoot = Parser.load(selected);
                    TreeItem<String> treeRoot = buildTree(xmlRoot);
                    treeRoot.setExpanded(true);
                    domTree.setRoot(treeRoot);
                } catch (Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.showAndWait();
                }
            }
       });
    }
}
