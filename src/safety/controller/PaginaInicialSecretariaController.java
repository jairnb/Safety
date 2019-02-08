/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safety.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import safety.Safety;

/**
 * FXML Controller class
 *
 * @author Jair
 */
public class PaginaInicialSecretariaController implements Initializable {

    @FXML
    private AnchorPane paginaIniciaSecretariaAnchorPane;
    @FXML
    private AnchorPane conteudosSecretariaAnchorPane;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/safety/view/ConteudosInicialSecretaria.fxml"));
            conteudosSecretariaAnchorPane.getChildren().setAll(a);
        } catch (IOException ex) {
            //Logger.getLogger(PaginaInicialAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    public void paginaInicialSecClicked() throws IOException  {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/safety/view/ConteudosInicialSecretaria.fxml"));
        conteudosSecretariaAnchorPane.getChildren().setAll(a);        
    }
    
    public void clientesClicked() throws IOException  {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/safety/view/Cliente.fxml"));
        conteudosSecretariaAnchorPane.getChildren().setAll(a);
    }
    
    public void sairClicked() throws IOException  {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/safety/view/Login.fxml"));
        paginaIniciaSecretariaAnchorPane.getChildren().setAll(a);
//        Scene sc = new Scene(a);
//        Stage st = new Stage();
//        st.setScene(sc);
//        st.show();
//        Safety.stage.close();
    }
    
}
