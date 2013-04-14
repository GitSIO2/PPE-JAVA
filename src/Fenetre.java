import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;



public class Fenetre extends JFrame 
{   //d�claration  variables
	private JMenuBar barreMenus ;
	private JMenu Fichier, Connexion, dateHeure , mResa ;
	private JMenuItem Fermer, Lancer, date, resa ;
	private JPanel container = new JPanel(); 
	
	
	private Ecouteur ec = new Ecouteur(this);

	double longueur, largeur;

	public Fenetre ()
	{ setTitle ("menu de l'application") ;
	setSize (800, 600) ;
	/* creation barre de menu*/
	barreMenus = new JMenuBar() ;
	setJMenuBar(barreMenus) ;
	barreMenus.setBackground(Color.orange);//COULEUR DU MENU
	/* creation menu Fichier et ses options */
	Fichier = new JMenu ("Fichier") ;
	barreMenus.add(Fichier) ;//ajoute le fichier a la barre de menu
	//sous menu fermer
	Fermer = new JMenuItem ("Fermer");
	Fichier.add (Fermer) ;//ajoute le sous menu fermer a l'onglet fichier
	Fermer.addActionListener(ec);
	Fermer.setForeground(Color.black);//COULEUR DU SOUS MENU
	Fermer.setBackground(Color.white);

	Connexion = new JMenu ("Connexion");
	barreMenus.add (Connexion) ;
	//sous menu lancer
	Lancer= new JMenuItem ("Lancer la connexion");
	Connexion.add (Lancer) ;
	Lancer.addActionListener(ec);//permet de mettre un �couteur sur le sous menu
	Lancer.setForeground(Color.black);//COULEUR DU SOUS MENU text couleur
	Lancer.setBackground(Color.white); //fond du sous menu

	mResa = new JMenu ("r�server salle");
	barreMenus.add (mResa) ;
	resa = new JMenuItem ("nouvelle res�rvation");
	mResa.add (resa) ;//ajoute le sous menu "nouvelle res�rvation" a l'onglet "r�server salle"
	resa.addActionListener(ec);
	resa.setForeground(Color.black);//COULEUR DU SOUS MENU text couleur
	resa.setBackground(Color.white); //fond du sous menu

	dateHeure = new JMenu ("date et heure") ;
	barreMenus.add(dateHeure) ;
	date= new JMenuItem ("date et heure");
	dateHeure.add (date) ;
	date.addActionListener(ec);//bouton surprise
	date.setForeground(Color.black);//COULEUR DU SOUS MENU text couleur
	date.setBackground(Color.white); //fond du sous menu



	this.setLocationRelativeTo(null);//fenetre afficher au centre de l'�cran
	container.setLayout(new BorderLayout());

	//JLabel label = new JLabel("Bienvenue sur le site");
	JLabel label1 = new JLabel("<html> MAISONS DES LIGUES<br><br> mission r�servation<br><br>Cette application vous" +
			" permettra de vous connecter � notre base de donn�es mrbs.</center><br> Vous pourrez consulter les salles  " +
			"ainsi que les differentes zones de l'�tablissement.</html>");
	container.add(label1, BorderLayout.CENTER);

	this.setContentPane(container);//ajout container � la fenetre
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}     
	
	public boolean jmiFermer(JMenuItem jmi)
	{
		return jmi==Fermer;
	}
	public boolean jmiDate(JMenuItem jmi)
	{
		return jmi==date;
	}
	public boolean jmiResa(JMenuItem jmi)
	{
		return jmi==resa;
	}
	
	public boolean jmiLancer(JMenuItem jmi)
	{
		return jmi==Lancer;
	}
	
	
	
}


