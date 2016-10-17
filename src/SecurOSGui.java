/**
 * Creates graphical user interface for SecureOS
 * @author Liam Brown
 * @author Jordan Blackadar
 * @version 0.1.2
 * @since 10/8/16
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class SecurOSGui extends JFrame implements ActionListener, KeyListener {
    private ArrayList<ItemButton> programs;
    private ArrayList<ItemButton> onlines;
    private ArrayList<ItemButton> documents;
    private ArrayList<ItemButton> all;
    private ArrayList<JButton> cats;

    private JTextField searchbar;
    private JPanel catbar;
    private JPanel mainbar;

    private JScrollPane mainScroll;

    private GridLayout catmanage; //MasterLayout
    private GridLayout mainmanage; //MasterLayout
    private BorderLayout mastermanage; //MasterLayout

    /**
     * Builds GUI
     * @param programs  The ArrayList of programs (from FileManager.java).
     * @param online    The ArrayList of websites (from FileManager.java).
     * @param documents The ArrayList of documents (from FileManager.java).
     */
    public SecurOSGui(ArrayList<File> programs, ArrayList<File> online, ArrayList<File> documents, ArrayList<File> all) {
        super("SecurOS");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Get screen size
        this.programs = new ArrayList<>();
        this.onlines = new ArrayList<>();
        this.documents = new ArrayList<>();
        this.all = new ArrayList<>();
        this.cats = new ArrayList<>();
        this.searchbar = new JTextField();

        catbar = new JPanel();
        mainbar = new JPanel();

        searchbar.addKeyListener(this);
        searchbar.setFont(new Font("Calibri", Font.PLAIN, 45));
        searchbar.setText("Search");
        searchbar.setToolTipText("Enter Terms and Press <ENTER>");
        searchbar.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                searchbar.setText("");
            }

            public void focusLost(FocusEvent e) {
                searchbar.setText("Search");
            }
        });
        //Layout of Master JFrame
        mastermanage = new BorderLayout();
        this.setLayout(this.mastermanage);

        //Layout of Category Bar
        catmanage = new GridLayout(programs.size(), 1);
        catbar.setLayout(catmanage);

        //Layout of Main Bar
        mainmanage = new GridLayout(programs.size(), 1);
        mainbar.setLayout(mainmanage);

        //Add Category Buttons
        cats.add(new JButton("Programs"));
        cats.add(new JButton("Online"));
        cats.add(new JButton("Files"));
        cats.add(new JButton("All"));

        //Tooltip Category Buttons
        cats.get(0).setToolTipText("Installed Software");
        cats.get(1).setToolTipText("Saved Websites");
        cats.get(2).setToolTipText("Saved Data for Programs");
        cats.get(3).setToolTipText("Alphabetical List of All");

        //Create Lists of Buttons
        for (File cur : programs) {
            ItemButton temp = new ItemButton(cur);
            this.programs.add(temp);
            this.all.add(temp);
        }
        for (File cur : online) {
            ItemButton temp = new ItemButton(cur);
            this.onlines.add(temp);
            this.all.add(temp);
        }
        for (File cur : documents) {
            ItemButton temp = new ItemButton(cur);
            this.documents.add(temp);
            this.all.add(temp);
        }

        int counter = 0;
        for (File f : all) {
            for (ItemButton a : this.all) {
                if (a.myFile.equals(f)) {
                    a.setIcon(FileManager.iconList.get(counter));
                }
            }
            counter++;
        }

        System.out.print(this.programs.get(0).toString() + " " + this.programs.get(0).getIcon().toString() + " ");

        cats.get(0).addActionListener(this);
        cats.get(1).addActionListener(this);
        cats.get(2).addActionListener(this);
        cats.get(3).addActionListener(this);

        catbar.add(cats.get(0)); //Adds 4 categories
        catbar.add(cats.get(1));
        catbar.add(cats.get(2));
        catbar.add(cats.get(3));

        //Start in 'Programs' view
        programsMode();

        cats.get(0).setBackground(Color.lightGray);
        //Final additions to true Jframe (this)
        this.add(catbar, BorderLayout.WEST);
        this.add(searchbar, BorderLayout.NORTH);
        catbar.revalidate();
        mainScroll.revalidate();
        cats.get(0).revalidate();
        cats.get(0).repaint();
        mainScroll.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);
        this.validate();
        this.repaint();
        this.cats.get(0).requestFocus();
    }

    /**
     * Takes action on a button press in the selector pane.
     * @param e The action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cats.get(0))) {
            cats.get(1).setBackground(null);
            cats.get(2).setBackground(null);
            cats.get(3).setBackground(null);
            cats.get(0).setBackground(Color.LIGHT_GRAY);
            programsMode();
        }
        if (e.getSource().equals(cats.get(1))) {
            cats.get(0).setBackground(null);
            cats.get(2).setBackground(null);
            cats.get(3).setBackground(null);
            cats.get(1).setBackground(Color.LIGHT_GRAY);
            onlinesMode();
        }
        if (e.getSource().equals(cats.get(2))) {
            cats.get(0).setBackground(null);
            cats.get(1).setBackground(null);
            cats.get(3).setBackground(null);
            cats.get(2).setBackground(Color.LIGHT_GRAY);
            documentsMode();
        }
        if (e.getSource().equals(cats.get(3))) {
            cats.get(0).setBackground(null);
            cats.get(1).setBackground(null);
            cats.get(2).setBackground(null);
            cats.get(3).setBackground(Color.LIGHT_GRAY);
            allMode();
        }

        for (ItemButton check : programs) {
            runProgram(e,check);
        }
        for (ItemButton check : onlines) {
            runProgram(e, check);
        }
        for (ItemButton check : documents) {
            runProgram(e,check);
        }
    }
    /**
     * Attempts to run the chosen program.
     * @param e The ActionListener e from the event
     * @param check The ItemButton selected, check
     */
    private void runProgram(ActionEvent e, ItemButton check){
        if (e.getSource().equals(check)) {
            try {
                Process p = Runtime.getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler " + check.myFile.getAbsolutePath());
            } catch (Exception exe) {
                exe.printStackTrace();
                System.out.println("Failed to execute, reporting to user.");
                JOptionPane frame = new JOptionPane();
                JOptionPane.showMessageDialog(frame, "Sorry, that didn't work.");
            }
        }
    }

    /**
     * Acts upon text in search bar.
     * @param keyEvent The key event to process
     */
    public void keyPressed(KeyEvent keyEvent) {
       if (keyEvent.getKeyCode() == (KeyEvent.VK_ENTER)){
           filteredMode(this.searchbar.getText());
       }
    }

    /**
     * Filler for released key event. Non-functional.
     * @param keyEvent The key event to process
     */
    public void keyReleased(KeyEvent keyEvent) {}

    /**
     * Filler for depressed key event. Non-functional.
     * @param keyEvent The key event to process
     */
    public void keyTyped(KeyEvent keyEvent) {}

    /**
     * Filters list to search terms and displays buttons
     * @param search String, search term to use
     */
    private void filteredMode(String search) {
        ArrayList<ItemButton> searched = new ArrayList<ItemButton>();
        //Rebuild Main Pane
        mainbar.removeAll();
        try {
            this.remove(mainScroll);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (ItemButton cur : this.programs) {
            if (cur.getText().toUpperCase().contains(search.toUpperCase()) || search.toUpperCase().contains( cur.getText().toUpperCase())) {
                searched.add(cur);
            }
        }
        for (ItemButton cur : this.onlines) {
            if (cur.getText().toUpperCase().contains(search.toUpperCase()) || search.toUpperCase().contains( cur.getText().toUpperCase())) {
                searched.add(cur);
            }
        }
        for (ItemButton cur : this.documents) {
            if (cur.getText().toUpperCase().contains(search.toUpperCase()) || search.toUpperCase().contains( cur.getText().toUpperCase())) {
                searched.add(cur);
            }
        }

        mainmanage = new GridLayout(searched.size(), 1);
        mainbar.setLayout(mainmanage);

        searched.forEach(this::buildMain);


        //Add New Main Bar to ScrollPane
        mainScroll = new JScrollPane(mainbar);
        //Configure the ScrollPane
        mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainScroll.setBounds(50, 30, 300, 50);
        mainScroll.getVerticalScrollBar().setUnitIncrement(1000); //Increases Speed of Scroll Bar
        this.add(mainScroll, BorderLayout.CENTER);
        mainScroll.revalidate();
        this.validate();
        this.repaint();

        // Alerts user if no results were returned
        if (searched.size() == 0) {
            JOptionPane frame = new JOptionPane();
            JOptionPane.showMessageDialog(frame, "No result found.");
        }
    }

    /**
     * Switches to programs mode, only displaying link files.
     */
    private void programsMode(){

        //Rebuild Main Pane
        mainbar.removeAll();
        try {
            this.remove(mainScroll);
        } catch (Exception e){
            e.printStackTrace();
        }
        mainmanage = new GridLayout(programs.size(), 1);
        mainbar.setLayout(mainmanage);

        this.programs.forEach(this::buildMain);

        //Add new Main Bar to ScrollPane
        mainScroll = new JScrollPane(mainbar);
        //Configure ScrollPane
        mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainScroll.setBounds(50, 30, 300, 50);
        mainScroll.getVerticalScrollBar().setUnitIncrement(1000); //Increases scrollbar speed
        this.add(mainScroll, BorderLayout.CENTER);
        mainScroll.revalidate();
        this.validate();
        this.repaint();
    }

    /**
     * Switches to online mode, only displaying html files.
     */
    private void onlinesMode(){
        //Rebuild Main Pane
        mainbar.removeAll();
        try {
            this.remove(mainScroll);
        } catch (Exception e){
            e.printStackTrace();
        }
        mainmanage = new GridLayout(onlines.size(), 1);
        mainbar.setLayout(mainmanage);

        this.onlines.forEach(this::buildMain);

        //Adds Main Bar to ScrollPane
        mainScroll = new JScrollPane(mainbar);
        //Configure ScrollPane
        mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainScroll.setBounds(50, 30, 300, 50);
        mainScroll.getVerticalScrollBar().setUnitIncrement(1000); //Increases scrollbar speed
        this.add(mainScroll, BorderLayout.CENTER);
        mainScroll.revalidate();
        this.validate();
        this.repaint();
    }

    /**
     * Switches to document mode, only displaying document related files.
     */
    private void documentsMode(){
        //Rebuild Main Pane
        mainbar.removeAll();
        try {
            this.remove(mainScroll);
        } catch (Exception e){
            e.printStackTrace();
        }
        mainmanage = new GridLayout(documents.size(), 1);
        mainbar.setLayout(mainmanage);

        this.documents.forEach(this::buildMain);

        //Add new Main Bar to Scroll Pane
        mainScroll = new JScrollPane(mainbar);
        //Configure the Scroll Pane
        mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainScroll.setBounds(50, 30, 300, 50);
        mainScroll.getVerticalScrollBar().setUnitIncrement(1000); //Changes scrollbar speed
        this.add(mainScroll, BorderLayout.CENTER); //Adds catbar
        mainScroll.revalidate();
        this.validate();
        this.repaint();
    }

    /**
     * Switches to 'all' mode, displays all files, programs and websites alphabetically.
     */
    private void allMode(){
        //rebuild main pane
        mainbar.removeAll();
        try {
            this.remove(mainScroll);
        } catch (Exception e){
           e.printStackTrace();
        }
        mainmanage = new GridLayout(all.size(), 1);
        mainbar.setLayout(mainmanage);

        this.all.forEach(this::buildMain);

        //add new Main Bar to Scroll Pane
        mainScroll = new JScrollPane(mainbar);
        //Configure the ScrollPane
        mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainScroll.setBounds(50, 30, 300, 50);
        mainScroll.getVerticalScrollBar().setUnitIncrement(20); //Changes scrollbar speed
        this.add(mainScroll, BorderLayout.CENTER);
        mainScroll.revalidate();
        this.validate();
        this.repaint();
    }

    /**
     * Adds button to the main list of buttons currently being displayed.
     * @param cur The current ItemButton.
     */
    private void buildMain(ItemButton cur){
        String modName = "";
        for(char c : cur.mes.toCharArray()){
            if(c == '.'){
                break;
            }
            modName += c;
        }
        cur.setText(modName);
        cur.removeActionListener(this);
        cur.addActionListener(this);
        mainbar.add(cur);
    }
}