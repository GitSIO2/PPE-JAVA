import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JMenuItem;

public class Ecouteur implements ActionListener
{
	private Fenetre fen;
	public Ecouteur(Fenetre fen) 
	{
		this.fen = fen;
	}

	public void actionPerformed(ActionEvent e) 
	{   
		JMenuItem jmi=(JMenuItem)e.getSource();//e.getSource() permet de savoir si l'utilisateur a cliqué sur le bouton

		if (fen.jmiFermer(jmi))
		{
			System.exit(0);//ferme le programme
		}
		if (fen.jmiDate(jmi))//e.getSource() permet de savoir si utilisateur a clicque sur le bouton
		{    DateFormat date = DateFormat.getDateInstance(DateFormat.FULL);//recupere la date
		SimpleDateFormat heure = new SimpleDateFormat("HH 'h' mm 'mn'");//forma de l'heure
		String[] message = {date.format(new Date()), heure.format(new Date())};
		JOptionPane.showMessageDialog(null, message );//affiche dans une fenetre
		}


		if(fen.jmiResa(jmi))
		{

			JTextField disabled = new JTextField();		//cree un champ text
			JTextField area_id= new JTextField();		//cree un champ text
			JTextField room_name = new JTextField();	//cree un champ text
			JTextField sort_key = new JTextField();		//cree un champ text
			JTextField description= new JTextField();	//cree un champ text
			JTextField capacity= new JTextField();		//cree un champ text
			int option1 = JOptionPane.showOptionDialog(null, 
					new Object[] {"Réserver une nouvelle salle (* champ obligatoire) ?","*Disponibilité(0/1) :", disabled, "*identifiant de la zone :", area_id,"sort_key :", sort_key,"description :", description,"*nom de la salle :", room_name,"* capacité :", capacity},
					"formulaire rdv",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null,  null, null); 

			if (option1 == JOptionPane.OK_OPTION)
			{  
				String url = "jdbc:mysql://localhost/mrbs";
				String root = "root";
				String passwd = "";
				Connection cn =null;
				Statement st =null;

				String sDisabled =disabled.getText();//saisie de l utilisateur mis dans une variable
				String  sId =  area_id.getText();
				String  sName = room_name.getText();
				String sSortKey =   sort_key.getText();
				String  sDescrption =	description.getText();   
				String  sCapacity =	capacity.getText();  
				try {
					// Etape 1 : Chargement du driver
					Class.forName("com.mysql.jdbc.Driver");
					// Etape 2 : récupération de la connexion
					cn = DriverManager.getConnection(url, root, passwd);
					// Etape 3 : Création d'un statement + requete
					st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					String sql = "SELECT * FROM mrbs_rooms";
					ResultSet resultat = st.executeQuery(sql);
					// on se place sur la ligne à insérer
					resultat.moveToInsertRow();
					//on renseigne les différents champs
					resultat.updateString("disabled",sDisabled);//nom colonne puis saisie de l utilisateur
					resultat.updateString("area_id",sId);
					resultat.updateString("room_name",sName);
					resultat.updateString("sort_key",sSortKey);
					resultat.updateString("description",sDescrption);
					resultat.updateString("capacity", sCapacity);
					//on insère la nouvelle ligne
					resultat.insertRow();
					String sql1 ="INSERT INTO mrbs_rooms  VALUES ('','"+sDisabled+"','"+ sId+"','"+ sName+"','"+ sSortKey+"','"+ sDescrption+"','"+sCapacity+"');";  

					/*if (sql1 != null)
	 	    			{
	 	    				// Etape 1 : Chargement du driver
	 		    			Class.forName("com.mysql.jdbc.Driver");
	 		    			// Etape 2 : récupération de la connexion
	 		    			cn = DriverManager.getConnection(url, login, passwd);
	 		    			// Etape 3 : Création d'un statement + requete
	 		    			st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

	 	    				String sqll2 ="UPDATE mrbs_areas SET disabled='1'WHERE id=3;";
	 	                    ResultSet rs = st.executeQuery(sqll2);
	 	    		    }*/
					/*booleen faux  if */
					JOptionPane.showMessageDialog(null, "insertion des données en base\n"+sId+ "\n"+sName+"\n"+sSortKey+"\n"+sDescrption+"\n"+sCapacity);
				} catch (SQLException ev) {//execption
					// TODO Auto-generated catch block
					ev.printStackTrace();
					JOptionPane.showMessageDialog(null, "erreur insertion des données en base\n");
				} catch (ClassNotFoundException ev) {
					// TODO Auto-generated catch block
					ev.printStackTrace();
				}
			}
		}


		if(fen.jmiLancer(jmi))
		{
			// On récupère les valeurs par défaut :
			Object optionPaneBackground = UIManager.get("OptionPane.background");
			Object panelBackground = UIManager.get("Panel.background");
			// On modifie ces valeurs :
			UIManager.put("OptionPane.background", Color.yellow);
			UIManager.put("Panel.background", Color.yellow);

			JTextField login = new JTextField();//cree un champ text
			JPasswordField motDePasse = new JPasswordField();//cree un mot de passe
			int option = JOptionPane.showOptionDialog(null, 
					new Object[] {"Voulez-vous vous connecter ?","Login :", login, "Mot de passe :", motDePasse},
					"Connexion",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null,  null, null); 

			if (option == JOptionPane.OK_OPTION) //si ok et si utilisateur et mot de passe bon on se connecte a la bd

				//mdp pour connexion
				if (login.getText().equalsIgnoreCase("admin") && motDePasse.getText().equals("admin"))
				{  JOptionPane.showMessageDialog(null, "Vous êtes connecté"); 

				// Puis on restaure les valeurs :
				UIManager.put("OptionPane.background", optionPaneBackground);
				UIManager.put("Panel.background", panelBackground);

				// Information d'accès à la base de données
				String url = "jdbc:mysql://localhost/mrbs";
				String root = "root";
				String passwd = "";
				Connection cn =null;
				Statement st =null;

				try {
					// Etape 1 : Chargement du driver
					Class.forName("com.mysql.jdbc.Driver");
					// Etape 2 : récupération de la connexion
					cn = DriverManager.getConnection(url, root, passwd);
					// Etape 3 : Création d'un statement 
					st = cn.createStatement();
					//creation d'une fenêtre 
					JFrame fenetre = new JFrame();
					JButton btnSalle = new JButton("TABLE salle");
					JButton btnUser = new JButton("TABLE users");
					JButton btnReserver = new JButton("TABLE réserver"); 
					JPanel container2 = new JPanel();
					fenetre.setTitle("contenue de la base de données");
					fenetre.setSize(700, 550);
					fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					fenetre.setLocationRelativeTo(null);
					fenetre.setContentPane(container2);
					//cree des panel pour placer les texts et les boutons
					container2.setLayout(new BorderLayout());
					JPanel top0 = new JPanel();
					JPanel top1 = new JPanel();

					JLabel text1 = new JLabel("<html> choisissez une table pour voir le contenue de notre base de données.</html>");
					top0.add(text1);
					top0.setBackground(Color.white);
					container2.add(top0, BorderLayout.NORTH);

					GridLayout disposition = new GridLayout(3,3);//grille pour placer les boutons  
					top1.setLayout(disposition); 
					top1.add(btnSalle); 
					top1.add(btnUser); 
					top1.add(btnReserver); 

					container2.add("Center", top1); 

					fenetre.setVisible(true);

					btnSalle.addActionListener(new ActionListener(){//action du bouton
						public  void actionPerformed(ActionEvent arg0) {
							JFrame fenetreSalle = new JFrame();
							ModeleStatiqueObjet modele = new ModeleStatiqueObjet();
							fenetreSalle. setTitle("JTable basique dans un JScrollPane");
							JTable tableau;
							tableau = new JTable(modele);
							fenetreSalle.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
							fenetreSalle.setVisible(true);
							

						}
					}); 
					btnUser.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
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
								/* Etape 3 : Création d'un statement + requete
	 		  	    	  L'objet Statement permet d'exécuter des instructions SQL, il interroge la base de données et
	                       retourne les résultats. Ensuite, ces résultats sont stockés dans l'objet ResultSet, grâce auquel 
	 					  on peut parcourir les lignes de résultats et les afficher.

	                      L'objet Statement est fourni par l'objet Connection grâce à l'instruction conn.createStatement().
	                      c'est demander à mon objet Statement d'exécuter une requête SQL de type SELECT : SELECT * FROM classe. 
								 */
								st = cn.createStatement();
								String sql = "SELECT * FROM mrbs_users;";
								// Etape 4 : exécution requête rs =Resultset
								rs = st.executeQuery(sql);

								while(rs.next()){				
									int id = rs.getInt(1);
									int level = rs.getInt(2);
									String name = rs.getString(3);
									String password = rs.getString(4);
									String email = rs.getString(5);
									int row = rs.getRow();

									JOptionPane.showMessageDialog( null,"table users\n"+ "Données contenues dans la ligne : "+row+"\nid : "+id +"\nlevel : "+level+"\npassword : "+password+"\nemail : "+email); 
								};
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, "erreur sql verifier la requête\n");
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}); 
					btnReserver.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
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
									int id = rs.getInt(1);
									int  disabled = rs.getInt(2);
									String area_name  = rs.getString(3);
									String area_admin_email	 = rs.getString(4);
									int resolution	= rs.getInt(5);
									int default_duration= rs.getInt(6);
									int morningstarts= rs.getInt(7);
									int morningstarts_minutes= rs.getInt(8);
									int eveningends	= rs.getInt(9);
									int eveningends_minutes	= rs.getInt(10);
									int private_enabled	= rs.getInt(11);
									int private_default	= rs.getInt(12);
									int private_mandatory = rs.getInt(13);
									String private_override = rs.getString(14);
									int min_book_ahead_enabled	  = rs.getInt(15);
									int min_book_ahead_secs	  = rs.getInt(16);
									int max_book_ahead_enabled  = rs.getInt(17);
									int max_book_ahead_secs	  = rs.getInt(18);
									int custom_html	  = rs.getInt(19);
									int approval_enabled  = rs.getInt(20);
									int reminders_enabled	 = rs.getInt(21);
									int enable_periods	  = rs.getInt(22);
									int confirmation_enabled	  = rs.getInt(23);
									int  confirmed_defaul	 = rs.getInt(24);
									int row = rs.getRow();

									JOptionPane.showMessageDialog( null,"table mrbs_areas\n"+
											"Données contenues dans la ligne : "+row+
											"\nidentifiant : "+id +
											"\nhandicapé : "+disabled  +
											"\nnom de la zone : "+area_name+
											"\nzone admin_email : "+area_admin_email+
											"\nresolution : "+resolution+
											"\ndurée par défaut: "+default_duration+
											"\nheure de départ: "+morningstarts+
											"\nheure de départ (minutes): "+morningstarts_minutes+
											"\nheure de fermeture : "+eveningends	+
											"\nheure de fermeture (nimutes) : "+eveningends_minutes+
											"\nactivé privé : "+private_enabled	+
											"\nactivé par défaut : "+private_default+
											"\nactivité obligatoire : "+private_mandatory+
											"\n dérogation privé: "+private_override+
											"\nréserver à l'avance activée minimum : "+min_book_ahead_enabled+
											"\nmin_book_ahead_secs : "+ min_book_ahead_secs+
											"\nréserver à l'avance activée maximum : "+ max_book_ahead_enabled  +
											"\nmax_book_ahead_secs : "+ max_book_ahead_secs+
											"\nhTML personnalisé : "+custom_html+	  
											"\nl'approbation activée : "+approval_enabled +
											"\nrappels permis : "+ reminders_enabled+  
											"\npermis périodes : "+ enable_periods+  
											"\nconfirmation de permis : "+confirmation_enabled+
											"\ndéfaut confirmé : "+ confirmed_defaul);	
								};
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, "erreur sql verifier la requête\n");
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}); 
				} 
				catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "erreur sql verifier la requête\n");
				} catch (ClassNotFoundException cf) {
					cf.printStackTrace();
				} finally//quoi qu'il arrive permet de fermer les fichiers
				{   try 
				{
					// Etape 6 : libérer ressources de la mémoire.
					cn.close();
					st.close();
				} catch (SQLException er) 
				{
					er.printStackTrace();
				}
				}
				} else
					JOptionPane.showMessageDialog(null,  new String[] {"Utilisateur inconnu", "ou mot de passe incorrecte"},//mot de 
							"Connexion refusée",JOptionPane.ERROR_MESSAGE);//si erreur utilisateur ou mot de passe
			else
				JOptionPane.showMessageDialog(null, "Non connecté...", "ATTENTION", JOptionPane.ERROR_MESSAGE);//si annule connection    			
		}}
		}	

