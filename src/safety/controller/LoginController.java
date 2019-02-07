package safety.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import safety.Safety;
import safety.model.dao.UtilizadorDAO;
import safety.model.database.Database;
import safety.model.domain.Utilizador;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane anchorpanelogin;
    @FXML
    private JFXTextField txtnomeutilizador;

    @FXML
    private JFXPasswordField txtsenha;

    @FXML
    private JFXButton btnentrar;

    private final UtilizadorDAO utilizadordao = new UtilizadorDAO();
    private Utilizador utilizador = new Utilizador();
    public static String nomeUsuerActualLogado;
    public static String tipoUsuerActualLogado;
    public static Utilizador userAtucalLogado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Connection conn = Database.getConnection();
        
         btnentrar.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent k) {
                if(k.getCode()==KeyCode.ENTER){
                    
                    try {
                        login();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Nome ou Senha Invalido " + ex);
                    }
                }
            }
        });


        btnentrar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    login();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Nome ou Senha Invalido " + ex);
                }
            }
        });
        
       
    }

    public void login() throws IOException {

        Utilizador utilizadorForm = new Utilizador();
        utilizadorForm.setNomeutilizador(txtnomeutilizador.getText());
        utilizadorForm.setSenha(txtsenha.getText());

        utilizador = utilizadordao.SelecionarUsuario(utilizadorForm);

        if (utilizador != null) {

            if (utilizador.getSenha().equals(utilizadorForm.getSenha()) && utilizador.getNomeutilizador().equals(utilizadorForm.getNomeutilizador())) {
                nomeUsuerActualLogado = txtnomeutilizador.getText();
                tipoUsuerActualLogado = utilizador.getEstado();

                userAtucalLogado = utilizador;

                if (utilizador.getEstado().equals("ativo")) {
                    //JOptionPane.showMessageDialog(null, "Utilizador valido");
                    AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/safety/view/PaginaInicialAdministrador.fxml"));
                    Scene sc = new Scene(a);
                    Stage st = new Stage();
                    st.setScene(sc);
                    st.show();
                    Safety.stage.close();

                } else {
                    JOptionPane.showMessageDialog(null, "Nome ou Senha Invalido");
                }
                /* AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/safety/view/segundoInicialAdmin.fxml"));
                    anchorpaneusersuport.getChildren().setAll(a);
                } else if (utilizador.getTipo().equals("Vendedor")) {
                    AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/epconstrucao/view/SegundoInicialAtend.fxml"));
                    loginAnchorPane.getChildren().setAll(a);
                } else {
                    JOptionPane.showMessageDialog(null, "Nome ou Senha Invalido");
                }
            }*/

            } else {
                JOptionPane.showMessageDialog(null, "Preenchimento obrigatorio");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nome ou Senha Invalido");
        }
    }

}
