
package scrumproj;

import javax.swing.JPanel;

public abstract class Page extends JPanel {
    
    protected Application app;
    
    public Page(Application app) {
        this.app = app;
        setBounds(0, 0, app.getWidth(), app.getHeight());
    }
    
    public void select() {
        setVisible(true);
    }
    
    public void deselect() {
        setVisible(false);
    }
    
    //Denna metod måste implementeras av varje subklass
    public abstract void updateInfo();
    
}

