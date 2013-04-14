import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ModeleDynamicObjetZone extends AbstractTableModel {
	private final List<Reserver> resa = new ArrayList<Reserver>();
 
    private final String[] entetes = {"id", "disabled", "area_name", "area_admin_email", "resolution", "default_duration","morningstarts","morningstarts_minutes","eveningends","eveningends_minutes","private_enabled","private_default","private_mandatory","private_override","min_book_ahead_enabled","min_book_ahead_secs","max_book_ahead_enabled","max_book_ahead_secs","custom_html","approval_enabled","reminders_enabled","enable_periods","confirmation_enabled" ,"confirmed_default" };

 
    public ModeleDynamicObjetZone() {
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
			String sql = "SELECT * FROM mrbs_areas;";
			// Etape 4 : exécution requête rs =Resultset
			rs = st.executeQuery(sql);
 
			while(rs.next()){
				resa.add(new Reserver(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getString(14), rs.getInt(15), rs.getInt(16), rs.getInt(17), rs.getInt(18), rs.getInt(19), rs.getInt(20), rs.getInt(21), rs.getInt(22), rs.getInt(23), rs.getInt(24))); 
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
        return resa.size();
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
                return resa.get(rowIndex).getId();
            case 1:
                return resa.get(rowIndex).getDisabled();
            case 2:
                return resa.get(rowIndex).getArea_Name();
            case 3:
                return resa.get(rowIndex).getAreaAdminEmail();
            case 4:
                return resa.get(rowIndex).getResolution();
            case 5:
                return resa.get(rowIndex).getDefaultDuration();
            case 6:
                return resa.get(rowIndex).getMorningStarts();
            case 7:
                return resa.get(rowIndex).getMorningStartsMinutes();
            case 8:
                return resa.get(rowIndex).getEveningEnds();
            case 9:
                return resa.get(rowIndex).getEveningEndsMinutes();
            case 10:
                return resa.get(rowIndex).getPrivateEnabled();
            case 11:
                return resa.get(rowIndex).getPrivateDefault();
            case 12:
                return resa.get(rowIndex).getPrivateMandatory();
            case 13:
                return resa.get(rowIndex).getPrivateOverride();
            case 14:
                return resa.get(rowIndex).getMinBookAheadEnabled();
            case 15:
                return resa.get(rowIndex).getMinBookAheadSecs();
            case 16:
                return resa.get(rowIndex).getMaxBookAheadEnabled();
            case 17:
                return resa.get(rowIndex).getMaxBookAheadSecs();
            case 18:
                return resa.get(rowIndex).getCustomHtml();
            case 19:
                return resa.get(rowIndex).getApprovalEnabled();
            case 20:
                return resa.get(rowIndex).getRemindersEnabled();
            case 21:
                return resa.get(rowIndex).getEnablePeriods();
            case 22:
                return resa.get(rowIndex).getConfirmationEnabled();
            case 23:
                return resa.get(rowIndex).getConfirmedDefault();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
}
