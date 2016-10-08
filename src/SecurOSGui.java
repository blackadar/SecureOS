/**
 * Created by Liam Brown on 10/8/2016.
 */
/**
 * Created by Liam Brown on 10/8/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;


public class SecurOSGui extends JFrame implements ActionListener {
    ArrayList <ItemButton> programs;
    ArrayList <ItemButton> online;
    ArrayList <ItemButton> documents;
    ArrayList <JButton> cats;

    JPanel catbar;
    JPanel mainbar;

    JScrollPane mainScroll;

    GridLayout catmanage; //MasterLayout
    GridLayout mainmanage; //MasterLayout
    BorderLayout mastermanage; //MasterLayout
    /**
     * Builds Gui
     * @param programs
     * @param online
     * @param documents
     */
    public SecurOSGui(ArrayList <File> programs, ArrayList <File> online,  ArrayList <File> documents){
        super("SecurOS");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Get screen size
        this.programs = new ArrayList<ItemButton>();
        this.online = new ArrayList<ItemButton>();
        this.documents = new ArrayList<ItemButton>();
        this.cats = new ArrayList<JButton>();
        catbar = new JPanel();
        mainbar = new JPanel();



        //layout of master JFrame
        mastermanage = new BorderLayout();
        this.setLayout(this.mastermanage); //Set layout of JFrame

        //layout of category bar
        catmanage = new GridLayout(programs.size(), 1);
        catbar.setLayout(catmanage);

        //layout of main bar
        mainmanage = new GridLayout(programs.size(), 1);
        mainbar.setLayout(mainmanage);

        //Add Category Buttons
        cats.add(new JButton("Programs"));
        cats.add(new JButton("Online"));
        cats.add(new JButton("Files"));
        cats.add(new JButton("All"));

        //Create Lists of Buttons
        for(File cur: programs){
            this.programs.add(new ItemButton(cur));
        }
        for(File cur: online){
            this.online.add(new ItemButton(cur));
        }
        for(File cur: documents){
            this.documents.add(new ItemButton(cur));
        }
        //Initialize buttons?
        for(JButton curButton : cats){
            curButton.setPreferredSize(new Dimension(100, 100));
            curButton.setVisible(true);
        }
        for(ItemButton curButton : this.programs){
            curButton.setPreferredSize(new Dimension(100, 100));
            curButton.setVisible(true);
        }
        for(ItemButton curButton : this.online){
            curButton.setPreferredSize(new Dimension(100, 100));
            curButton.setVisible(true);
        }
        for(ItemButton curButton : this.documents){
            curButton.setPreferredSize(new Dimension(100, 100));
            curButton.setVisible(true);
        }
        //Initialize the main bar with programs
        for(ItemButton cur : this.programs){
            System.out.println("added: " + cur.mes);
            mainbar.add(cur);
        }

        catbar.add(cats.get(0)); //adds 4 categories
        catbar.add(cats.get(1));
        catbar.add(cats.get(2));
        catbar.add(cats.get(3));


        mainScroll = new JScrollPane(mainbar);
        //Do stuff for the scrollpane
        mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainScroll.setBounds(50, 30, 300, 50);



        //Final additions to true Jframe (this)
        this.add(catbar, BorderLayout.WEST); //Adds catbar
        this.add(mainScroll, BorderLayout.CENTER); //Adds catbar
        catbar.revalidate();
        mainScroll.revalidate();
        cats.get(0).revalidate();
        cats.get(0).repaint();
        mainScroll.setVisible(true);
        this.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.validate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
