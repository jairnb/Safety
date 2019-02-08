package safety.model.database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Database {

    private static final String USER = "root";
    private static final String PASS = "";
//    private static final String URL = "jdbc:mysql://localhost:3306/gpi2019_db";
    //private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/gpi2019_db?useTimezone=true&serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";


    // Conectar ao banco
    public static Connection getConnection() {

        try {

            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Capturar a conexão
            if (conn != null) {

                //JOptionPane.showMessageDialog(null, "Conection sucessfully establish");

            } else {

                JOptionPane.showMessageDialog(null, "Conection fail");

            }

            return conn; // Retorna a conexao aberta

        } catch (SQLException s) {

            JOptionPane.showMessageDialog(null, "Error to establish conection " + s);

            return null;
        }

    }

    public static boolean isConectado(Connection conn) throws SQLException {

        return conn != null;

    }

    public static void fecharConnection(Connection comn) {
        //metodo responsavel para terminar a comunicacao

        if (comn != null) {

            try {
                comn.close();

            } catch (SQLException sqle) {

                JOptionPane.showMessageDialog(null, "Fail to close connection" + sqle);

            }

        }
    }

    public static void fecharConnection(Connection comn, PreparedStatement ps) {
        //sobrecarga do metodo fecharConnection ----- polimorfismo

        if (ps != null) {

            try {
                ps.close();

            } catch (SQLException sqle) {

                JOptionPane.showMessageDialog(null, "Fail to close connection" + sqle);

            }

        }
        fecharConnection(comn);

    }

    public static void fecharConnection(Connection comn, PreparedStatement ps, ResultSet rs) {
        //sobrecarga do metodo fecharConnection ----- polimorfismo

        if (rs != null) {

            try {
                rs.close();

            } catch (SQLException sqle) {

                JOptionPane.showMessageDialog(null, "Fail to close connection" + sqle);

            }

        }
        fecharConnection(comn, ps);

    }

}
