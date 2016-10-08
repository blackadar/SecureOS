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


public class SecurOSGui extends JFrame implements ActionListener, KeyListener{
    ArrayList <ItemButton> programs;
    ArrayList <ItemButton> onlines;
    ArrayList <ItemButton> documents;
    ArrayList <ItemButton> all;
    ArrayList <JButton> cats;

    JTextField searchbar;
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
    public SecurOSGui(ArrayList <File> programs, ArrayList <File> online,  ArrayList <File> documents, ArrayList<File> all){
        super("SecurOS");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Get screen size
        this.programs = new ArrayList<ItemButton>();
        this.onlines = new ArrayList<ItemButton>();
        this.documents = new ArrayList<ItemButton>();
        this.all = new ArrayList<ItemButton>();
        this.cats = new ArrayList<JButton>();
        this.searchbar = new JTextField();

        catbar = new JPanel();
        mainbar = new JPanel();

        searchbar.addKeyListener(this);

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
            this.onlines.add(new ItemButton(cur));
        }
        for(File cur: documents){
            this.documents.add(new ItemButton(cur));
        }
        for(File cur: all){
            this.all.add(new ItemButton(cur));
        }


        //Initialize buttons?
        /*
        for(JButton curButton : cats){
            curButton.setPreferredSize(new Dimension(100, 100));
            curButton.setVisible(true);
        }
        for(ItemButton curButton : this.programs){
            curButton.setPreferredSize(new Dimension(100, 100));
            curButton.setVisible(true);
        }
        for(ItemButton curButton : this.onlines){
            curButton.setPreferredSize(new Dimension(100, 100));
            curButton.setVisible(true);
        }
        for(ItemButton curButton : this.documents){
            curButton.setPreferredSize(new Dimension(100, 100));
            curButton.setVisible(true);
        } */
        cats.get(0).addActionListener(this);
        cats.get(1).addActionListener(this);
        cats.get(2).addActionListener(this);
        cats.get(3).addActionListener(this);
        catbar.add(cats.get(0)); //adds 4 categories
        catbar.add(cats.get(1));
        catbar.add(cats.get(2));
        catbar.add(cats.get(3));


        programsMode();
        //mainScroll = new JScrollPane(mainbar);
        //Do stuff for the scrollpane
        //mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //mainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //mainScroll.setBounds(50, 30, 300, 50);



        //Final additions to true Jframe (this)
        this.add(catbar, BorderLayout.WEST); //Adds catbar
        this.add(searchbar, BorderLayout.NORTH);
        //this.add(mainScroll, BorderLayout.CENTER); //Adds catbar
        catbar.revalidate();
        mainScroll.revalidate();
        cats.get(0).revalidate();
        cats.get(0).repaint();
        mainScroll.setVisible(true);
        //fullscreen
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);

        this.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.validate();
        this.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("got action!");
        Runtime runExe = Runtime.getRuntime();

        if(e.getSource().equals(cats.get(0))){
            programsMode();
        }
        if(e.getSource().equals(cats.get(1))){
            onlinesMode();
        }
        if(e.getSource().equals(cats.get(2))){
            documentsMode();
        }
        if(e.getSource().equals(cats.get(3))){
            allMode();
        }


        for(ItemButton check: programs){
            if(e.getSource().equals(check)){
                try {

                    Process p = Runtime.getRuntime()
                            .exec("rundll32 url.dll,FileProtocolHandler " + check.myFile.getAbsolutePath());
                    System.out.println("Starting process: " + p.toString() + "for file: " + check.getName());
                } catch(Exception exe) {
                    System.out.println("Failed to run file!");
                    Object[] options = { "OK", "CANCEL" };
                    JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning: Failed to run file",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                }
                return;
            }
        }
        for(ItemButton check: onlines){
            if(e.getSource().equals(check)) {
                try {
                    Process p = Runtime.getRuntime()
                            .exec("rundll32 url.dll,FileProtocolHandler " + check.myFile.getAbsolutePath());
                } catch (Exception exe) {
                    exe.printStackTrace();
                    System.out.println("Failed to run file!");
                    Object[] options = {"OK", "CANCEL"};
                    JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning: Failed to run file",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                }
                return;
            }
        }

        for(ItemButton check: documents) {
            if (e.getSource().equals(check)) {
                try {
                    Process p = Runtime.getRuntime()
                            .exec("rundll32 url.dll,FileProtocolHandler " + check.myFile.getAbsolutePath());

                } catch (Exception exe) {
                    exe.printStackTrace();
                    System.out.println("Failed to run file!");
                    Object[] options = {"OK", "CANCEL"};
                    JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning: Failed to run file",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                }
                return;
            }
        }

        for(ItemButton check: all) {
            if (e.getSource().equals(check)) {
                try {
                    Process p = Runtime.getRuntime()
                            .exec("rundll32 url.dll,FileProtocolHandler " + check.myFile.getAbsolutePath());
                } catch (Exception exe) {
                    exe.printStackTrace();
                    System.out.println("Failed to run file!");
                    Object[] options = {"OK", "CANCEL"};
                    JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning: Failed to run file",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                }
                return;
            }
        }
    }
    public void keyPressed(KeyEvent keyEvent) {
       if (keyEvent.getKeyCode() == (KeyEvent.VK_ENTER)){
           filteredMode(this.searchbar.getText());
       }
    }

    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == (KeyEvent.VK_ENTER)){
            //filteredMode(this.searchbar.getText());
        }
    }

    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == (KeyEvent.VK_ENTER)){

        }
    }


    public void filteredMode(String search){
        ArrayList<ItemButton> searched = new ArrayList<ItemButton>();
        int count = 0;
        //rebuild main pane
        mainbar.removeAll();
        try {
            this.remove(mainScroll);
        } catch (Exception e){
            System.out.println("I have not created the main scroll pane yet");
        }


        for(ItemButton cur : this.programs) {
            System.out.println("added: " + cur.mes);
            System.out.println("compared against " + cur.mes + ", got: " + Math.abs(cur.mes.compareTo(search)));
            if(cur.mes.toUpperCase().contains((CharSequence) search.toUpperCase()) || search.toUpperCase().contains((CharSequence) cur.mes.toUpperCase())){
                searched.add(cur);
                count++;
            }
        }
        for(ItemButton cur : this.onlines) {
            System.out.println("added: " + cur.mes);
            System.out.println("compared against " + cur.mes + ", got: " + Math.abs(cur.mes.compareTo(search)));
            if(cur.mes.contains((CharSequence) search) || search.contains((CharSequence) cur.mes)){
                searched.add(cur);
                count++;
            }
        }
        for(ItemButton cur : this.documents) {
            System.out.println("added: " + cur.mes);
            System.out.println("compared against " + cur.mes + ", got: " + Math.abs(cur.mes.compareTo(search)));
            if(cur.mes.contains((CharSequence) search) || search.contains((CharSequence) cur.mes)){
                searched.add(cur);
                count++;
            }
        }

        mainmanage = new GridLayout(searched.size(), 1);
        mainbar.setLayout(mainmanage);

        for(ItemButton cur : searched) {
            String modName = "";
            for(char c : cur.mes.toCharArray()){
                if(c == '.'){
                    break;
                }
                modName += c;
            }
            System.out.println("added: " + cur.mes);
            System.out.println("added: " + modName);
            cur.setLabel(modName); //DANGER
            cur.removeActionListener(this);
            cur.addActionListener(this);
            mainbar.add(cur);
        }
        //add new mainbar to scrollpane
        mainScroll = new JScrollPane(mainbar);
        //Do stuff for the scrollpane
        mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainScroll.setBounds(50, 30, 300, 50);
        this.add(mainScroll, BorderLayout.CENTER); //Adds catbar
        mainScroll.revalidate();
        this.validate();
        this.repaint();
    }
    /**
     * Sets mode to programs
     */
    public void programsMode(){

        //rebuild main pane
        mainbar.removeAll();
        try {
            this.remove(mainScroll);
        } catch (Exception e){
            System.out.println("I have not created the main scroll pane yet");
        }
        mainmanage = new GridLayout(programs.size(), 1);
        mainbar.setLayout(mainmanage);

        for(ItemButton cur : this.programs) {
            //System.out.println("added: " + cur.mes);
            //test
            String modName = "";
            for(char c : cur.mes.toCharArray()){
                if(c == '.'){
                    break;
                }
                modName += c;
            }
            System.out.println("added: " + cur.mes);
            System.out.println("added: " + modName);
            cur.setLabel(modName); //DANGER
            cur.removeActionListener(this);
            cur.addActionListener(this);
            mainbar.add(cur);
        }

        //add new mainbar to scrollpane
        mainScroll = new JScrollPane(mainbar);
        //Do stuff for the scrollpane
        mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainScroll.setBounds(50, 30, 300, 50);
        this.add(mainScroll, BorderLayout.CENTER); //Adds catbar
        mainScroll.revalidate();
        this.validate();
        this.repaint();
    }
    /**
     * Sets mode to online
     */
    public void onlinesMode(){
        //rebuild main pane
        mainbar.removeAll();
        try {
            this.remove(mainScroll);
        } catch (Exception e){
            System.out.println("I have not created the main scroll pane yet");
        }
        mainmanage = new GridLayout(onlines.size(), 1);
        mainbar.setLayout(mainmanage);

        for(ItemButton cur : this.onlines) {
            System.out.println("added: " + cur.mes);
            String modName = "";
            for(char c : cur.mes.toCharArray()){
                if(c == '.'){
                    break;
                }
                modName += c;
            }
            System.out.println("added: " + cur.mes);
            System.out.println("added: " + modName);
            cur.setLabel(modName); //DANGER
            cur.removeActionListener(this);
            cur.addActionListener(this);
            mainbar.add(cur);
        }

        //add new mainbar to scrollpane
        mainScroll = new JScrollPane(mainbar);
        //Do stuff for the scrollpane
        mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainScroll.setBounds(50, 30, 300, 50);
        this.add(mainScroll, BorderLayout.CENTER); //Adds catbar
        mainScroll.revalidate();
        this.validate();
        this.repaint();
    }
    /**
     * Sets mode to documents
     */
    public void documentsMode(){
        //rebuild main pane
        mainbar.removeAll();
        try {
            this.remove(mainScroll);
        } catch (Exception e){
            System.out.println("I have not created the main scroll pane yet");
        }
        mainmanage = new GridLayout(documents.size(), 1);
        mainbar.setLayout(mainmanage);

        for(ItemButton cur : this.documents) {
            System.out.println("added: " + cur.mes);
            String modName = "";
            for(char c : cur.mes.toCharArray()){
                if(c == '.'){
                    break;
                }
                modName += c;
            }
            System.out.println("added: " + cur.mes);
            System.out.println("added: " + modName);
            cur.setLabel(modName); //DANGER
            cur.removeActionListener(this);
            cur.addActionListener(this);
            mainbar.add(cur);
        }

        //add new mainbar to scrollpane
        mainScroll = new JScrollPane(mainbar);
        //Do stuff for the scrollpane
        mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainScroll.setBounds(50, 30, 300, 50);
        this.add(mainScroll, BorderLayout.CENTER); //Adds catbar
        mainScroll.revalidate();
        this.validate();
        this.repaint();
    }
    /**
     * Sets mode to all
     */
    public void allMode(){
        //rebuild main pane
        mainbar.removeAll();
        try {
            this.remove(mainScroll);
        } catch (Exception e){
            System.out.println("I have not created the main scroll pane yet");
        }
        mainmanage = new GridLayout(all.size(), 1);
        mainbar.setLayout(mainmanage);

        for(ItemButton cur : this.all) {
            System.out.println("added: " + cur.mes);
            String modName = "";
            for(char c : cur.mes.toCharArray()){
                if(c == '.'){
                    break;
                }
                modName += c;
            }
            System.out.println("added: " + cur.mes);
            System.out.println("added: " + modName);
            cur.setLabel(modName); //DANGER
            cur.removeActionListener(this);
            cur.addActionListener(this);
            mainbar.add(cur);
        }

        //add new mainbar to scrollpane
        mainScroll = new JScrollPane(mainbar);
        //Do stuff for the scrollpane
        mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainScroll.setBounds(50, 30, 300, 50);
        this.add(mainScroll, BorderLayout.CENTER); //Adds catbar
        mainScroll.revalidate();
        this.validate();
        this.repaint();
    }
}
