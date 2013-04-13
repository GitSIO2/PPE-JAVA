import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ModeleDynamicObjetUser extends AbstractTableModel {
	private final List<User> users = new ArrayList<User>();
 
    private final String[] entetes = {"id", "level", "name", "Password", "Email" };

 
    public ModeleDynamicObjetUser() {
        super();
        
        String url = "jdbc:mysql://localhost/mrbs";
		String login = "root";
		String passwd = "";
		Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
		
		try {
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Création d'un statement + requete
			st = cn.createStatement();
			String sql = "SELECT * FROM mrbs_users;";
			// Etape 4 : exécution requête rs =Resultset
			rs = st.executeQuery(sql);
 
			while(rs.next()){
			users.add(new User(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5))); 
			}
        
		} catch (SQLException e) {//execption
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erreur sql \n");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    public int getRowCount() {
        return users.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

	@Override
	/*public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}*/
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return users.get(rowIndex).getId();
            case 1:
                return users.get(rowIndex).getLevel();
            case 2:
                return users.get(rowIndex).getName();
            case 3:
                return users.get(rowIndex).getPassword();
            case 4:
                return users.get(rowIndex).getEmail();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
}
