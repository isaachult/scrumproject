/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumproj;

/**
 *
 * @author Isaac
 */
public class Scrumproj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Application app = new Application("Scrum & XP Project", 640, 640);
        app.init();
        app.run();
    }
    
}
