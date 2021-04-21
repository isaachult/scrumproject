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
            System.err.println("Kunde inte koppla upp till databasen. Om du använder Mac så kan detta meddelande ignoreras");
            System.err.println("Error message:" + e.getMessage());
        }
        
        if (dataBaseConnection == null) {
            try {
                String name = JOptionPane.showInputDialog("Skriv namnet på din användare: ");
                dataBaseConnection = new InfDB("/Users/" + name + "/db/scrum.FDB");
                connected = true;
            } catch(InfException e) {
                System.err.println("Kunde inte koppla upp till databasen");
                System.err.println("Error message:" + e.getMessage());
            }
        }
        //Om databasuppkoppling misslyckas printas ett meddelande samt stänger ner programmet
        if (!connected) {
            JOptionPane.showMessageDialog(null, "Kontrollera att databasfilen (.FDB) ligger i C:\\db om du använder PC eller i \\Users\\\"ditt användarnamn\"\\db om du använder Mac.");
            System.exit(0);
        }

     //Inställningar till fönstret som skapas
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        // Lägger till alla sidor med hjälp av metoden addPage
        
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
        
        
                setVisible(true);
    }
    
    
     public void run() {
        pages.get(currentPage).setVisible(true);
    }
    //Metoden som lägger till de olika sidor som finns 
    public void addPage(Page page) {
        this.add(page);
        page.setVisible(false);
        pages.add(page);
    }
    //Metod som hämtar en sida med en parameter som tar in en siffra
    //Sätter variabeln previousPage till den sidan som visades innan metoden har körts klart
    public void selectPage(int newPage) {
        previousPage = currentPage;
        pages.get(currentPage).deselect();
        currentPage = newPage;
        pages.get(currentPage).select();
        
        pages.get(currentPage).updateInfo();
    }
    
    //Hämtar index på den förra sidan. Används sedan i knappar för att gå tillbaka till föregående sida
    public int getPreviousPage() {
        return previousPage;   
    }
    //Hämtar index på sidan där metoden körs
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
    //Loggar ut ur systemet, nollställer ID och användartyp
    public void logOut() {
        currentUser = 0;
        System.out.println("User logged out: id = " + currentUser);
    }
    public int getCurrentUser() {
        return currentUser;
    }
}
