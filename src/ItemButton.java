/**
 * Created by Liam Brown on 10/8/2016.
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
    public ItemButton(File myFile){
        super(myFile.getName());
        this.setName(myFile.getName());
        this.myFile = myFile;
        mes = this.getName();
        this.setPreferredSize(new Dimension(150, 100));
        this.revalidate();
    }
}
