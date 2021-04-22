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
        
        addPage(new Inloggning(this)); //0
        addPage (new AdminMeny(this));  //1
        addPage(new RegistreraAnvandare(this)); //2
        addPage(new TaBortAnvandare(this)); //3
        addPage(new AnvandarMeny(this));//4
        addPage(new SokAnvandare(this));//5
        addPage(new PubliceraInlagg(this));//6
        addPage(new InformellBlogg(this));//7
        addPage(new SkapaKategoriInformell(this));//8
        addPage(new FormellBlogg(this));//9
        addPage(new AnvandareKontoUppgifter(this)); //10 
        addPage(new RedigeraAnvandare(this)); // 11
        addPage(new Motesbokning(this)); // 12
        addPage(new Moten (this)); // 13
        addPage(new TaBortMote (this)); // 14
        addPage(new RedigeraMote (this)); // 15
        addPage(new HanteraPrenumerationer (this)); // 16
        addPage(new BokadeMoten (this)); // 17
        
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
    private int currentUser;{
    currentUser = 0;}
    
    public void logInUser(int id) {
        currentUser = id;
        System.out.println("User logged in: id = " + currentUser);
    }
    //Loggar ut ur systemet, nollst�ller ID och anv�ndartyp
    public void logOut() {
        currentUser = 0;
        System.out.println("User logged out: id = " + currentUser);
    }
    public int getCurrentUser() {
        return currentUser;
    }
}
