/**
 * Creates button objects for GUI.
 * @author Liam Brown
 * @version 0.1.0
 * @since 10/8/2016
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;

public class ItemButton extends JButton {
    String mes;
    File myFile;
    Icon myImage;

    public ItemButton(File myFile){
        super(myFile.getName());
        this.setName(myFile.getName());
        this.myFile = myFile;
        mes = this.getName();
        this.setIconTextGap(10);
        this.setFont(new Font("Calibri", Font.BOLD, 30));
        this.setPreferredSize(new Dimension(150, 100));
        this.revalidate();
    }
    public void setIcon(Icon i){
        this.myImage = i;
    }
    public Icon getIcon(){
        return myImage;
    }
}
