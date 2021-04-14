package scrumproj;

import java.text.ParseException;
import oru.inf.InfDB;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import oru.inf.InfException;
import java.text.SimpleDateFormat;

/**
 *
 * @author krillenorden
 */
public class Validering {
   

    public static boolean tfHarVarde(JTextField rutaAttKolla) {

        boolean resultat = true;

        if (rutaAttKolla.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "En eller flera textrutor är tomma!");
            rutaAttKolla.requestFocus();
            resultat = false;
        }

        return resultat;
    }

    public static boolean tfIsTomt(JTextField rutaAttKolla) {

        boolean resultat = false;

        if (rutaAttKolla.getText().isEmpty()) {
            resultat = true;
        }

        return resultat;
    }

    public static boolean tfIsHeltal(JTextField rutaAttKolla) {

        boolean resultat = true;

        try {
            String inStrang = rutaAttKolla.getText();
            Integer.parseInt(inStrang);
            rutaAttKolla.requestFocus();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Var god ange ett heltal!");
            resultat = false;
        }

        return resultat;
    }

    public static boolean tfIsID(JTextField rutaAttKolla) {

        boolean resultat = true;

        try {
            String inStrang = rutaAttKolla.getText();
            Integer.parseInt(inStrang);
            rutaAttKolla.requestFocus();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Var god ange giltigt ID!");
            resultat = false;
        }

        return resultat;
    }  

    public static boolean passwordHarVarde(JPasswordField losenordAttKolla) {

        boolean resultat = true;

        String inStrang = new String(losenordAttKolla.getPassword());

        if (inStrang.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lösenordsrutan är tom!");
            losenordAttKolla.requestFocus();
            resultat = false;
        }

        return resultat;
    }

    public static boolean intIsGreaterThan(int intAttKontrollera, int intForKontroll) {
        
        boolean resultat = false;

        if(intAttKontrollera > intForKontroll) {
            resultat = true;
        }

        return resultat;
    }
    public static boolean stringIsNull(String stringAttKontrollera) {
        
        boolean resultat = false;
        
        if(stringAttKontrollera == null) {
            resultat = true;
        }
        
        return resultat;
    }
    public static boolean isAdmin(Application app, int id) {
        try {
            String result = app.getDataBaseConnection().fetchSingle("SELECT ADMINISTRATOR FROM AGENT WHERE AGENT_ID = " + id + "");
            if(result.equals ("J")) {
                return true; }
        }
        catch (InfException e) {
            System.err.println("Error in isAdmin: " + e.getMessage());
        }
        return false;
        }
public static String formatNameUpperCase(String nameInput) {
        String name = "";

        boolean newWord = true;

        for (int i = 0; i < nameInput.length(); i++) {
            char letter = nameInput.charAt(i);

            if (letter == ' ') {
                name += ' ';
                newWord = true;
            }

            else {
                if (newWord) {
                    name += nameInput.substring(i + 0, i + 1).toUpperCase();
                    newWord = false;
                }

                else {
                    name += nameInput.substring(i + 0, i + 1).toLowerCase();
                }
            }
        }
        return name;
    }
//public static boolean isValidPasswordCharacterLength(String input)
   // {
        //if (input.length() <= 12) {
          //  return true;
        

       // else
       // {
          //  return false;
     //   }
   // }
//public static boolean isValidDate(String input, String format) {

        //SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        //try {
            //Date date = dateFormat.parse(input);
        //} catch (ParseException e) {
         //   return false;
      //  }

}