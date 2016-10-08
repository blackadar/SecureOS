/**
 * Created by Liam Brown on 10/8/2016.
 */
/**
 * Created by Liam Brown on 10/8/2016.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;


public class SecurOSGui extends JFrame implements ActionListener {
    ArrayList <JButton> programs = new ArrayList<JButton>();
    ArrayList <JButton> online = new ArrayList<JButton>();
    ArrayList <JButton> files = new ArrayList<JButton>();

    /**
     * Builds Gui
     * @param programs
     * @param online
     * @param files
     */
    public SecurOSGui(ArrayList <File> programs, ArrayList <File> online,  ArrayList <File> files){
        for(File cur: programs){
            this.programs.add(newcur);
        }
        for(File cur: online){
            this.online.add(newcur);
        }
        for(File cur: files){
            this.files.add(newcur);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}





