package scrumproj;

import javax.swing.JFrame;
import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.JOptionPane;

public class Application extends JFrame {
    private String title;
    private int width, height;
    private int previousPage;

    private int currentPage;
    private ArrayList<Page> pages;
    
    private InfDB dataBaseConnection;
    

    public Application(String title, int width, int height) {
        super(title);
        this.title = title;
        this.width = width;
        this.height = height;

        currentPage = 0;
        previousPage = 0;
        pages = new ArrayList<>(); 
    }
    
    public void init() {
        
        boolean connected = false;
        
        try {
            dataBaseConnection = new InfDB("C:\\db\\scrum.FDB");
            connected = true;
        } catch(InfException e) { 
            System.err.println("Kunde inte koppla upp till databasen. Om du anv�nder Mac s� kan detta meddelande ignoreras");
            System.err.println("Error message:" + e.getMessage());
        }
        
        if (dataBaseConnection == null) {
            try {
                String name = JOptionPane.showInputDialog("Skriv namnet p� din anv�ndare: ");
                dataBaseConnection = new InfDB("/Users/" + name + "/db/scrum.FDB");
                connected = true;
            } catch(InfException e) {
                System.err.println("Kunde inte koppla upp till databasen");
                System.err.println("Error message:" + e.getMessage());
            }
        }
        //Om databasuppkoppling misslyckas printas ett meddelande samt st�nger ner programmet
        if (!connected) {
            JOptionPane.showMessageDialog(null, "Kontrollera att databasfilen (.FDB) ligger i C:\\db om du anv�nder PC eller i \\Users\\\"ditt anv�ndarnamn\"\\db om du anv�nder Mac.");
            System.exit(0);
        }

     //Inst�llningar till f�nstret som skapas
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        // L�gger till alla sidor med hj�lp av metoden addPage
        //addPage(new SokAnvandare(this)); //0
        addPage(new AdminMeny(this)); //0
        addPage(new RegistreraAnvandare(this)); //1
        addPage(new TaBortAnvandare(this)); //2
         addPage(new AnvandarMeny(this));//3
        
         
        
                setVisible(true);
    }
    
    
     public void run() {
        pages.get(currentPage).setVisible(true);
    }
    //Metoden som l�gger till de olika sidor som finns 
    public void addPage(Page page) {
        this.add(page);
        page.setVisible(false);
        pages.add(page);
    }
    //Metod som h�mtar en sida med en parameter som tar in en siffra
    //S�tter variabeln previousPage till den sidan som visades innan metoden har k�rts klart
    public void selectPage(int newPage) {
        previousPage = currentPage;
        pages.get(currentPage).deselect();
        currentPage = newPage;
        pages.get(currentPage).select();
        
        pages.get(currentPage).updateInfo();
    }
    
    //H�mtar index p� den f�rra sidan. Anv�nds sedan i knappar f�r att g� tillbaka till f�reg�ende sida
    public int getPreviousPage() {
        return previousPage;   
    }
    //H�mtar index p� sidan d�r metoden k�rs
    public Page getPage(int page) {
        return pages.get(page);
    }
    //Returnerar InfDB-objektet
    public InfDB getDataBaseConnection() {
        return dataBaseConnection;
    }
}
