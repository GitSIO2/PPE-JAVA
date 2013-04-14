import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ModeleDynamicObjetSalle extends AbstractTableModel {
	private final List<Salle> salles = new ArrayList<Salle>();
 
    private final String[] entetes = {"id", "disabled", "area_id", "room_name", "sort_key", "description", "capacity", "room_admin_email","custom_html" };

 
    public ModeleDynamicObjetSalle() {
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
			String sql = "SELECT * FROM mrbs_rooms;";
			// Etape 4 : exécution requête rs =Resultset
			rs = st.executeQuery(sql);
 
			while(rs.next()){
			salles.add(new Salle(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9))); 
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
        return salles.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

	
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return salles.get(rowIndex).getId();
            case 1:
                return salles.get(rowIndex).getDisabled();
            case 2:
                return salles.get(rowIndex).getArea_Id();
            case 3:
                return salles.get(rowIndex).getRoom_Name();
            case 4:
                return salles.get(rowIndex).getSort_Key();
            case 5:
                return salles.get(rowIndex).getDescription();
            case 6:
                return salles.get(rowIndex).getCapacity();
            case 7:
                return salles.get(rowIndex).getRoom_Admin_Email();
            case 8:
                return salles.get(rowIndex).getCustomHtml();
                
            default:
                return null; //Ne devrait jamais arriver
        }
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(aValue != null){
            Salle salle = salles.get(rowIndex);
     
            switch(columnIndex){
                case 1:
                	salle.setDisabled(Integer.parseInt((String) aValue));
                    break;
                case 2:
                	salle.setArea_Id((String)aValue);
                    break;
                case 3:
                	salle.getRoom_Name((String)aValue);
                    break;
                case 4:
                	salle.setSort_Key((String)aValue);
                	break;
                case 5:
                	salle.setDescription((String)aValue);
                	break;
                case 6:
                	salle.setCapacity(Integer.parseInt((String)aValue));
                    break;
                case 7:
                	salle.setRoom_Admin_Email((String)aValue);
                    break;
                case 8:
                	salle.getCustomHtml((String)aValue);
                    break;
                  
            }
        }
    }
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true; //Toutes les cellules éditables
    }
}
