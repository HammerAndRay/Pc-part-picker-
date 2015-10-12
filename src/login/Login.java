/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author 
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/*
 * ¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
 * -------- THE USERMANE AND PASSWORD ARE login and pass321 -------------------
 * -------- THE USERS SELECTION IS SAVED WHEN HE CLICKS PURCHASE---------------
 * -------- ALL THE PARTS MUST BE SELECTED IN ORDER TO WORK -------------------
 * ¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
 */

//This class is called Login and is responable for the Creating the LoginScreen
class Login implements ActionListener {

    JButton ButtonLogin, ButtonReset, ButtonExit, ButtonContinue;
    JTextField UsernameField;
    JPasswordField PasswordField;
    JLabel UsernameLabel, PasswordLabel, successLabel;
    JFrame frame;

    public Login(String name) {
        //This is where the login in page was created
        //as well as the "Welcome to ECSE501 Computers" page
        //it was done by making two JFrames.
        JFrame frame = new JFrame("LoginScreen");
        JFrame frame2 = new JFrame("LoginScreen");

        ButtonContinue = new JButton("Continue");
        successLabel = new JLabel("Welcome to ECSE501 Computers");
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        //This bit is the code for the Welcome page.
        JPanel panel2 = new JPanel(new GridBagLayout());
        frame2.setContentPane(panel2);
        GridBagConstraints LaptopCheckSelection2 = new GridBagConstraints();
        LaptopCheckSelection2.gridx = 0;
        LaptopCheckSelection2.gridy = 0;
        panel2.add(successLabel, LaptopCheckSelection2);
        LaptopCheckSelection2.gridx = 0;
        LaptopCheckSelection2.gridy = 1;
        panel2.add(ButtonContinue, LaptopCheckSelection2);

        frame2.setSize(600, 600);
        ButtonContinue.addActionListener(new OpenShopFrame(frame2));
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        //This section is for the main login page.
        ButtonLogin = new JButton("Login");
        ButtonExit = new JButton(" Exit ");

        UsernameField = new JTextField(15);
        PasswordField = new JPasswordField(15);

        UsernameLabel = new JLabel("Username: ");
        PasswordLabel = new JLabel("Password: ");

        frame.setLayout(null);
        //These listeners link to the function that closes the program
        frame.addWindowListener(new MyWindowListener());
        frame2.addWindowListener(new MyWindowListener());
        //GridBag Layout manager arranges the items
        JPanel panel = new JPanel(new GridBagLayout());
        frame.setContentPane(panel);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        panel.add(UsernameLabel, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(PasswordLabel, c);
        c.gridx = 2;
        c.gridy = 0;
        panel.add(UsernameField, c);
        c.gridx = 2;
        c.gridy = 1;
        panel.add(PasswordField, c);
        c.gridx = 2;
        c.gridy = 3;
        panel.add(ButtonLogin, c);
        c.gridx = 2;
        c.gridy = 4;
        panel.add(ButtonExit, c);
        //This listener links to the function that checks if the username and 
        //password are correct and also changes the Background colour and gives a
        //message if it's incorrect
        ButtonLogin.addActionListener(new loginbutton(frame, UsernameField, PasswordField, frame2));
        //This button links to the function that exits the program.
        ButtonExit.addActionListener(new Exit());
        frame.setSize(600, 600);
        frame.setVisible(true);

    }

    public static void main(String args[]) {
        //This is the main excutable code, what is does is, it make a Login object
        //which makes the LoginScreen appear.
        Login ls = new Login("My Login screen");

    }

    public void actionPerformed(ActionEvent ae) {
    }
}

//This Class is is for closing the window
//<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
//----------------------------------------------
class MyWindowListener extends WindowAdapter {
//This makes sure that the program closes when you click the X button.

    public void windowClosing(WindowEvent e) {
        System.out.println("Closing window!");
        System.exit(0);
    }
}
//----------------------------------------------
//<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>

//This Class is for the Exit Button
//<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
//----------------------------------------------
class Exit implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        //This function quits the program.
        System.exit(0);
    }
}
//----------------------------------------------
//<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>

//This Class is for the Login Button
//<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
//----------------------------------------------
class loginbutton implements ActionListener {

    JFrame frame;
    JFrame frame2;
    JTextField Username;
    JTextField Password;
//The constructor takes in two JFrames and two Fields

    loginbutton(JFrame f, JTextField UsernameField, JPasswordField PasswordField, JFrame fr) {
        frame = f;
        frame2 = fr;
        Username = UsernameField;
        Password = PasswordField;

    }

    public void actionPerformed(ActionEvent evt) {
        //This convets the JFields into Strings so that it can be compared.
        String name = Username.getText();
        String pass = Password.getText();
        if ("login".equals(name) && "pass321".equals(pass)) {
            frame.getContentPane().setBackground(Color.green);
            frame.setVisible(false);
            frame2.getContentPane().setBackground(Color.green);
            //If it's correct the second frame is shown and the first hidden.
            frame2.setVisible(true);



        } else {
            //If it's not correct an error message appears and the background 
            //goes red.
            frame.getContentPane().setBackground(Color.red);
            JOptionPane.showMessageDialog(frame,
                    "Incorrect login name/password",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
//----------------------------------------------
//<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>

//This the class is for the button that opens the shop
//<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
//----------------------------------------------
class OpenShopFrame implements ActionListener {

    JFrame frame2;

    OpenShopFrame(JFrame fr) {
        frame2 = fr;
    }

    public void actionPerformed(ActionEvent e) {
        //when the button in the second frame is pressed the frame is hidden and
        //a shop object is created and made visible
        frame2.setVisible(false);
        Shop tbp = new Shop();
        try {
            tbp.createUI();
        } catch (IOException ex) {
            Logger.getLogger(OpenShopFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
//----------------------------------------------
//<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>

//This the class is for the Submit button.
//<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
//----------------------------------------------
class SubmitSummaryFrame implements ActionListener {
//this creates the Frame for the summary page

    JFrame frame3, frame;
    double TotalL;
    JLabel AddL2, AddL;
    JTextField priceW;

    SubmitSummaryFrame(JFrame fr, JFrame rf, JLabel LR, JLabel LC, JTextField placein) {
        AddL = LR;
        AddL2 = LC;
        frame3 = fr;
        frame = rf;
        priceW = placein;
    }

    public void actionPerformed(ActionEvent e) {
        //below the price of the parts is being calulated and then placed into
        //a TextFeild
        String AddoneT = AddL.getText();
        String AddtwoT = AddL2.getText();
        double Addone = Double.parseDouble(AddoneT) + Double.parseDouble(AddtwoT);

        String total2 = String.valueOf(Addone);
        priceW.setText(total2);
        frame.setVisible(false);
        frame3.setVisible(true);
    }
}
//----------------------------------------------
//<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>

//This the class is for the GoBack button.
//<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
//----------------------------------------------
class OpenGoBack implements ActionListener {

    JFrame frame3, frame;

    OpenGoBack(JFrame fr, JFrame rf) {
        frame3 = fr;
        frame = rf;
    }

    public void actionPerformed(ActionEvent e) {
        //This function allows the user to go back to the part list
        frame.setVisible(true);
        frame3.setVisible(false);


    }
}
//----------------------------------------------
//<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>

class Shop {

    JTabbedPane tp;
    JPanel laptop, desktop;
    JFrame frame, frame3;
    JButton ButtonSubmit, ButtonSubmit2, ButtonPurchase, ButtonGoBack;
    JLabel PriceLabel;
    JTextField PriceField;

    public void createUI() throws IOException {
		//create frame for parts selection
        frame = new JFrame("Computer Selection");
        frame3 = new JFrame("Price");
		//create buttons and labels
        ButtonSubmit = new JButton("Submit");
        ButtonSubmit2 = new JButton("Submit");
        ButtonPurchase = new JButton("Purchase");
        ButtonGoBack = new JButton("Go Back");
        PriceLabel = new JLabel("Total Price is: ");
        PriceField = new JTextField(5);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//create laptop panel with gridlayout
        laptop = new JPanel(new GridLayout(5, 7));
		//create radio buttons and labels for CPU type
        JLabel lab1 = new JLabel("Choose CPU type");
        JRadioButton rd1 = new JRadioButton("intel core i3");
        JRadioButton rd2 = new JRadioButton("intel core i5");
        JRadioButton rd3 = new JRadioButton("intel core i7");
        JRadioButton rd30 = new JRadioButton("AMD A8");
		//add labels to laptop panel
        laptop.add(lab1);
        laptop.add(rd1);
        laptop.add(rd2);
        laptop.add(rd3);
        laptop.add(rd30);
		//group buttons so only one can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(rd1);
        group.add(rd2);
        group.add(rd3);
        group.add(rd30);

		//create hard drive label and radio buttons
        JLabel lab2 = new JLabel("Choose Hard Drive");
        JRadioButton rd4 = new JRadioButton("5200RPM 1TB");
        JRadioButton rd5 = new JRadioButton("7200RPM 1TB");
        JRadioButton rd6 = new JRadioButton("128GB SSD");
        JRadioButton rd7 = new JRadioButton("256GB SSD");
		//add label and buttons to laptop panel
        laptop.add(lab2);
        laptop.add(rd4);
        laptop.add(rd5);
        laptop.add(rd6);
        laptop.add(rd7);
		//group buttons so only one can be selected
        ButtonGroup group1 = new ButtonGroup();
        group1.add(rd4);
        group1.add(rd5);
        group1.add(rd6);
        group1.add(rd7);
		//create listener to tell when a radio button is selected
        MyRadioButtonListener mListener = new MyRadioButtonListener();
        rd1.addItemListener(mListener);
        rd2.addItemListener(mListener);
        rd3.addItemListener(mListener);
        rd4.addItemListener(mListener);
        rd5.addItemListener(mListener);
        rd6.addItemListener(mListener);
        rd7.addItemListener(mListener);
        rd30.addItemListener(mListener);
		//create gpu and screen labels and check boxes
        JLabel lab3 = new JLabel("Choose GPU");
        JCheckBox chk1 = new JCheckBox("AMD 7850");
        JCheckBox chk2 = new JCheckBox("AMD 7970");
        JCheckBox chk3 = new JCheckBox("Nvidia 760Ti");
        JCheckBox chk4 = new JCheckBox("Nvidia 790");
        JLabel lab4 = new JLabel("Choose screen size");
        JCheckBox chk5 = new JCheckBox("10 inch");
        JCheckBox chk6 = new JCheckBox("13 inch");
        JCheckBox chk7 = new JCheckBox("15 inch");
        JCheckBox chk8 = new JCheckBox("17 inch");
		//create listener to tell when a check box is selected
        MyCheckBoxListener chkListener = new MyCheckBoxListener();
        chk1.addItemListener(chkListener);
        chk2.addItemListener(chkListener);
        chk3.addItemListener(chkListener);
        chk4.addItemListener(chkListener);
        chk5.addItemListener(chkListener);
        chk6.addItemListener(chkListener);
        chk7.addItemListener(chkListener);
        chk8.addItemListener(chkListener);
		//add gpu and screen elements to laptop panel
        laptop.add(lab3);
        laptop.add(chk1);
        laptop.add(chk2);
        laptop.add(chk3);
        laptop.add(chk4);
		//group checkboxes so only one can be selected
        ButtonGroup group2 = new ButtonGroup();
        group2.add(chk1);
        group2.add(chk2);
        group2.add(chk3);
        group2.add(chk4);

        laptop.add(lab4);
        laptop.add(chk5);
        laptop.add(chk6);
        laptop.add(chk7);
        laptop.add(chk8);
        ButtonGroup group3 = new ButtonGroup();
        group3.add(chk5);
        group3.add(chk6);
        group3.add(chk7);
        group3.add(chk8);
		//add submit button
        laptop.add(ButtonSubmit);
		//create desktop JPanel with gridlayout
        desktop = new JPanel(new GridLayout(5, 7));
		//create labels and radio buttons for cpu
        JLabel lab12 = new JLabel("Choose CPU type");
        JRadioButton rd12 = new JRadioButton("intel core i3");
        JRadioButton rd22 = new JRadioButton("intel core i5");
        JRadioButton rd32 = new JRadioButton("intel core i7");
        JRadioButton rd321 = new JRadioButton("AMD A8");
		//add labels and radiobuttons to desktop panel
        desktop.add(lab12);
        desktop.add(rd12);
        desktop.add(rd22);
        desktop.add(rd32);
        desktop.add(rd321);
		//group buttons so only one can be selected
        ButtonGroup group6 = new ButtonGroup();
        group6.add(rd12);
        group6.add(rd22);
        group6.add(rd32);
        group6.add(rd321);
		//create label and radio buttons for hard drives
        JLabel lab22 = new JLabel("Choose Hard Drive");
        JRadioButton rd42 = new JRadioButton("5200RPM 1TB");
        JRadioButton rd52 = new JRadioButton("7200RPM 1TB");
        JRadioButton rd62 = new JRadioButton("128GB SSD");
        JRadioButton rd72 = new JRadioButton("256GB SSD");
		//add radiobuttons to desktop panel
        desktop.add(lab22);
        desktop.add(rd42);
        desktop.add(rd52);
        desktop.add(rd62);
        desktop.add(rd72);
		//group buttons so only one can be selected
        ButtonGroup group12 = new ButtonGroup();
        group12.add(rd42);
        group12.add(rd52);
        group12.add(rd62);
        group12.add(rd72);
		//create listener to tell when a radio button is selected
        MyRadioButtonListener maListener = new MyRadioButtonListener();
        rd12.addItemListener(maListener);
        rd22.addItemListener(maListener);
        rd32.addItemListener(maListener);
        rd42.addItemListener(maListener);
        rd52.addItemListener(maListener);
        rd62.addItemListener(maListener);
        rd72.addItemListener(maListener);
        rd321.addItemListener(maListener);
		//create label and checkboxes for GPU
        JLabel lab32 = new JLabel("Choose GPU");
        JCheckBox chk12 = new JCheckBox("AMD 7850");
        JCheckBox chk22 = new JCheckBox("AMD 7970");
        JCheckBox chk32 = new JCheckBox("Nvidia 760Ti");
        JCheckBox chk42 = new JCheckBox("Nvidia 790");

		//create listener to tell when a check box is selected
        MyCheckBoxListener chkListener33 = new MyCheckBoxListener();
        chk12.addItemListener(chkListener33);
        chk22.addItemListener(chkListener33);
        chk32.addItemListener(chkListener33);
        chk42.addItemListener(chkListener33);
		//add label and checkboxes to desktop panel
        desktop.add(lab32);
        desktop.add(chk12);
        desktop.add(chk22);
        desktop.add(chk32);
        desktop.add(chk42);
		//group checkbox so only one can be selected
        ButtonGroup group42 = new ButtonGroup();
        group42.add(chk12);
        group42.add(chk22);
        group42.add(chk32);
        group42.add(chk42);
		//create label and checkboxes for screen
        JLabel lab42 = new JLabel("Choose screen size");
        JCheckBox chk52 = new JCheckBox("10 inch");
        JCheckBox chk62 = new JCheckBox("13 inch");
        JCheckBox chk72 = new JCheckBox("15 inch");
        JCheckBox chk82 = new JCheckBox("17 inch");


		//add listener for checkboxes
        chk52.addItemListener(chkListener33);
        chk62.addItemListener(chkListener33);
        chk72.addItemListener(chkListener33);
        chk82.addItemListener(chkListener33);
		//add checkboxes to desktop panel
        desktop.add(lab42);
        desktop.add(chk52);
        desktop.add(chk62);
        desktop.add(chk72);
        desktop.add(chk82);
		//group checkboxes so only one can be selected
        ButtonGroup group32 = new ButtonGroup();
        group32.add(chk52);
        group32.add(chk62);
        group32.add(chk72);
        group32.add(chk82);
		//add submit button
        desktop.add(ButtonSubmit2);

		//listeners for window closing
        frame.addWindowListener(new MyWindowListener());
        frame3.addWindowListener(new MyWindowListener());
		
        JPanel panel = new JPanel(new GridBagLayout());
        frame3.setContentPane(panel);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        panel.add(PriceLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(PriceField, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(ButtonGoBack, c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(ButtonPurchase, c);
        ButtonPurchase.addActionListener(new Purchase(rd1, rd2, rd3, rd4, rd5,
                rd6, rd7, rd30, chk1, chk2, chk3, chk4, chk5, chk6,
                chk7, chk8, rd12, rd22, rd32, rd42, rd52, rd62, rd72, rd321,
                chk12, chk22, chk32, chk42, chk52, chk62, chk72, chk82));
        ButtonGoBack.addActionListener(new OpenGoBack(frame3, frame));

		//create tabbed panel
        tp = new JTabbedPane();
        Container pane = frame.getContentPane();
        pane.add(tp);
		//add laptop and desktop tabs
        tp.addTab("Laptop", laptop);
        tp.addTab("Desktop", desktop);
		//set size of frames
        frame.setSize(600, 600);
        frame3.setSize(600, 600);
		//make frame visible
        frame.setVisible(true);
        ButtonSubmit.addActionListener(new SubmitSummaryFrame(frame3, frame,
                mListener.getLabel(), chkListener.getLabel(), PriceField));
        ButtonSubmit2.addActionListener(new SubmitSummaryFrame(frame3, frame,
                maListener.getLabel(), chkListener33.getLabel(), PriceField));
        
        //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        //The Section below is initialising the files as well as checking 
        //if there are any selection that it should load from the last run.

        File f = new File("laptoplist.txt");
        File g = new File("desktoplist.txt");
        //Below checks if the laptop and desktop files exist. If so it will
        //load the users selection from the last run. Otherwise it will create
        //blank files.
        if (f.exists() && g.exists()) {
            String[] anArray;
            anArray = new String[4];
            try {
                FileInputStream fs = new FileInputStream("laptoplist.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fs));
                for (int i = 0; i < anArray.length; i++) {
                    anArray[i] = br.readLine();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
            }


            //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>

			//create array
            String[] anArray1;
            anArray1 = new String[4];
			//read in array using .readLine and array position
            try {
                FileInputStream fs = new FileInputStream("desktoplist.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fs));
                for (int i = 0; i < anArray1.length; i++) {
                    anArray1[i] = br.readLine();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
            }
            //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>
			//select radio buttons and check boxes depending on text inside file read in
            if (anArray[0].equals("intel core i3")) {
                rd1.setSelected(true);
            }
            if (anArray[0].equals("intel core i5")) {
                rd2.setSelected(true);
            }
            if (anArray[0].equals("intel core i7")) {
                rd3.setSelected(true);
            }
            if (anArray[0].equals("AMD A8")) {
                rd30.setSelected(true);
            }
            if (anArray[1].equals("5200RPM 1TB")) {
                rd4.setSelected(true);
            }
            if (anArray[1].equals("7200RPM 1TB")) {
                rd5.setSelected(true);
            }
            if (anArray[1].equals("128GB SSD")) {
                rd6.setSelected(true);
            }
            if (anArray[1].equals("256GB SSD")) {
                rd7.setSelected(true);
            }
            if (anArray[2].equals("AMD 7850")) {
                chk1.setSelected(true);
            }
            if (anArray[2].equals("AMD 7970")) {
                chk2.setSelected(true);
            }
            if (anArray[2].equals("Nvidia 760Ti")) {
                chk3.setSelected(true);
            }
            if (anArray[2].equals("Nvidia 790")) {
                chk4.setSelected(true);
            }
            if (anArray[3].equals("10 inch")) {
                chk5.setSelected(true);
            }
            if (anArray[3].equals("13 inch")) {
                chk6.setSelected(true);
            }
            if (anArray[3].equals("15 inch")) {
                chk7.setSelected(true);
            }
            if (anArray[3].equals("17 inch")) {
                chk8.setSelected(true);
            }
            //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            if (anArray1[0].equals("intel core i3")) {
                rd12.setSelected(true);
            }
            if (anArray1[0].equals("intel core i5")) {
                rd22.setSelected(true);
            }
            if (anArray1[0].equals("intel core i7")) {
                rd32.setSelected(true);
            }
            if (anArray1[0].equals("AMD A8")) {
                rd321.setSelected(true);
            }
            if (anArray1[1].equals("5200RPM 1TB")) {
                rd42.setSelected(true);
            }
            if (anArray1[1].equals("7200RPM 1TB")) {
                rd52.setSelected(true);
            }
            if (anArray1[1].equals("128GB SSD")) {
                rd62.setSelected(true);
            }
            if (anArray1[1].equals("256GB SSD")) {
                rd72.setSelected(true);
            }
            if (anArray1[2].equals("AMD 7850")) {
                chk12.setSelected(true);
            }
            if (anArray1[2].equals("AMD 7970")) {
                chk22.setSelected(true);
            }
            if (anArray1[2].equals("Nvidia 760Ti")) {
                chk32.setSelected(true);
            }
            if (anArray1[2].equals("Nvidia 790")) {
                chk42.setSelected(true);
            }
            if (anArray1[3].equals("10 inch")) {
                chk52.setSelected(true);
            }
            if (anArray1[3].equals("13 inch")) {
                chk62.setSelected(true);
            }
            if (anArray1[3].equals("15 inch")) {
                chk72.setSelected(true);
            }
            if (anArray1[3].equals("17 inch")) {
                chk82.setSelected(true);
            }
        } else {
            try (PrintWriter out = new PrintWriter(new FileWriter("laptoplist.txt"))) {
                out.println("");
                out.println("");
                out.println("");
                out.println("");

            } catch (IOException ex) {
                Logger.getLogger(MyWindowListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            try (PrintWriter out = new PrintWriter(new FileWriter("desktoplist.txt"))) {
                out.println("");
                out.println("");
                out.println("");
                out.println("");

            } catch (IOException ex) {
                Logger.getLogger(MyWindowListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//This the class is for the Purchase button.
//<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>
//----------------------------------------------

    class Purchase implements ActionListener {
//When the user clicks Purchase it will save the users choices in a text file

        JRadioButton LaptopRadioSelection1, LaptopRadioSelection2,
                LaptopRadioSelection3, LaptopRadioSelection4, LaptopRadioSelection5,
                LaptopRadioSelection6, LaptopRadioSelection7, LaptopRadioSelection8;
        JCheckBox LaptopCheckSelection1, LaptopCheckSelection2, LaptopCheckSelection3,
                LaptopCheckSelection4, LaptopCheckSelection5, LaptopCheckSelection6,
                LaptopCheckSelection7, LaptopCheckSelection8;
        JRadioButton DesktopRadioSelection1, DesktopRadioSelection2,
                DesktopRadioSelection3, DesktopRadioSelection4,
                DesktopRadioSelection5, DesktopRadioSelection6,
                DesktopRadioSelection7, DesktopRadioSelection8;
        JCheckBox DesktopCheckSelection1, DesktopCheckSelection2, DesktopCheckSelection3,
                DesktopCheckSelection4, DesktopCheckSelection5, DesktopCheckSelection6,
                DesktopCheckSelection7, DesktopCheckSelection8;

        Purchase(JRadioButton rr1, JRadioButton rr2, JRadioButton rr3,
                JRadioButton rr4, JRadioButton rr5, JRadioButton rr6,
                JRadioButton rr7, JRadioButton rr30, JCheckBox cc1, JCheckBox cc2,
                JCheckBox cc3, JCheckBox cc4, JCheckBox cc5, JCheckBox cc6,
                JCheckBox cc7, JCheckBox cc8, JRadioButton dd1, JRadioButton dd2,
                JRadioButton dd3, JRadioButton dd4, JRadioButton dd5,
                JRadioButton dd6, JRadioButton dd7, JRadioButton dd8,
                JCheckBox ccd1, JCheckBox ccd2, JCheckBox ccd3,
                JCheckBox ccd4, JCheckBox ccd5, JCheckBox ccd6,
                JCheckBox ccd7, JCheckBox ccd8) {
            LaptopRadioSelection1 = rr1;
            LaptopRadioSelection2 = rr2;
            LaptopRadioSelection3 = rr3;
            LaptopRadioSelection4 = rr4;
            LaptopRadioSelection5 = rr5;
            LaptopRadioSelection6 = rr6;
            LaptopRadioSelection7 = rr7;
            LaptopRadioSelection8 = rr30;
            LaptopCheckSelection1 = cc1;
            LaptopCheckSelection2 = cc2;
            LaptopCheckSelection3 = cc3;
            LaptopCheckSelection4 = cc4;
            LaptopCheckSelection5 = cc5;
            LaptopCheckSelection6 = cc6;
            LaptopCheckSelection7 = cc7;
            LaptopCheckSelection8 = cc8;
            DesktopRadioSelection1 = dd1;
            DesktopRadioSelection2 = dd2;
            DesktopRadioSelection3 = dd3;
            DesktopRadioSelection4 = dd4;
            DesktopRadioSelection5 = dd5;
            DesktopRadioSelection6 = dd6;
            DesktopRadioSelection7 = dd7;
            DesktopRadioSelection8 = dd8;
            DesktopCheckSelection1 = ccd1;
            DesktopCheckSelection2 = ccd2;
            DesktopCheckSelection3 = ccd3;
            DesktopCheckSelection4 = ccd4;
            DesktopCheckSelection5 = ccd5;
            DesktopCheckSelection6 = ccd6;
            DesktopCheckSelection7 = ccd7;
            DesktopCheckSelection8 = ccd8;
        }

        public void actionPerformed(ActionEvent e) {
            //the IF Statments below are checking to see which options are
            //selected and will save them in a file.
            String LaptopSpec = "";
            String LaptopSpec2 = "";
            String LaptopSpec3 = "";
            String LaptopSpec4 = "";
            String DesktopSpec = "";
            String DesktopSpec2 = "";
            String DesktopSpec3 = "";
            String DesktopSpec4 = "";
            if (LaptopRadioSelection1.isSelected()) {
                LaptopSpec = LaptopRadioSelection1.getText();
            }
            if (LaptopRadioSelection2.isSelected()) {
                LaptopSpec = LaptopRadioSelection2.getText();
            }
            if (LaptopRadioSelection3.isSelected()) {
                LaptopSpec = LaptopRadioSelection3.getText();
            }
            if (LaptopRadioSelection8.isSelected()) {
                LaptopSpec = LaptopRadioSelection8.getText();
            }


            if (LaptopRadioSelection4.isSelected()) {
                LaptopSpec2 = LaptopRadioSelection4.getText();
            }
            if (LaptopRadioSelection5.isSelected()) {
                LaptopSpec2 = LaptopRadioSelection5.getText();
            }
            if (LaptopRadioSelection6.isSelected()) {
                LaptopSpec2 = LaptopRadioSelection6.getText();
            }
            if (LaptopRadioSelection7.isSelected()) {
                LaptopSpec2 = LaptopRadioSelection7.getText();
            }
            if (LaptopCheckSelection1.isSelected()) {
                LaptopSpec3 = LaptopCheckSelection1.getText();
            }
            if (LaptopCheckSelection2.isSelected()) {
                LaptopSpec3 = LaptopCheckSelection2.getText();
            }
            if (LaptopCheckSelection3.isSelected()) {
                LaptopSpec3 = LaptopCheckSelection3.getText();
            }
            if (LaptopCheckSelection4.isSelected()) {
                LaptopSpec3 = LaptopCheckSelection4.getText();
            }
            if (LaptopCheckSelection5.isSelected()) {
                LaptopSpec4 = LaptopCheckSelection5.getText();
            }
            if (LaptopCheckSelection6.isSelected()) {
                LaptopSpec4 = LaptopCheckSelection6.getText();
            }
            if (LaptopCheckSelection7.isSelected()) {
                LaptopSpec4 = LaptopCheckSelection7.getText();
            }
            if (LaptopCheckSelection8.isSelected()) {
                LaptopSpec4 = LaptopCheckSelection8.getText();
            }
            if (DesktopRadioSelection1.isSelected()) {
                DesktopSpec = DesktopRadioSelection1.getText();
            }
            if (DesktopRadioSelection2.isSelected()) {
                DesktopSpec = DesktopRadioSelection2.getText();
            }
            if (DesktopRadioSelection3.isSelected()) {
                DesktopSpec = DesktopRadioSelection3.getText();
            }
            if (DesktopRadioSelection8.isSelected()) {
                DesktopSpec = DesktopRadioSelection8.getText();
            }


            if (DesktopRadioSelection4.isSelected()) {
                DesktopSpec2 = DesktopRadioSelection4.getText();
            }
            if (DesktopRadioSelection5.isSelected()) {
                DesktopSpec2 = DesktopRadioSelection5.getText();
            }
            if (DesktopRadioSelection6.isSelected()) {
                DesktopSpec2 = DesktopRadioSelection6.getText();
            }
            if (DesktopRadioSelection7.isSelected()) {
                DesktopSpec2 = DesktopRadioSelection7.getText();
            }
            if (DesktopCheckSelection1.isSelected()) {
                DesktopSpec3 = DesktopCheckSelection1.getText();
            }
            if (DesktopCheckSelection2.isSelected()) {
                DesktopSpec3 = DesktopCheckSelection2.getText();
            }
            if (DesktopCheckSelection3.isSelected()) {
                DesktopSpec3 = DesktopCheckSelection3.getText();
            }
            if (DesktopCheckSelection4.isSelected()) {
                DesktopSpec3 = DesktopCheckSelection4.getText();
            }
            if (DesktopCheckSelection5.isSelected()) {
                DesktopSpec4 = DesktopCheckSelection5.getText();
            }
            if (DesktopCheckSelection6.isSelected()) {
                DesktopSpec4 = DesktopCheckSelection6.getText();
            }
            if (DesktopCheckSelection7.isSelected()) {
                DesktopSpec4 = DesktopCheckSelection7.getText();
            }
            if (DesktopCheckSelection8.isSelected()) {
                DesktopSpec4 = DesktopCheckSelection8.getText();
            }
            //The choices for the Laptop and Desktop will be saved in two 
            //different files.
            try (PrintWriter out = new PrintWriter(new FileWriter("laptoplist.txt"))) {
                out.println(LaptopSpec);
                out.println(LaptopSpec2);
                out.println(LaptopSpec3);
                out.println(LaptopSpec4);

            } catch (IOException ex) {
                Logger.getLogger(MyWindowListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            try (PrintWriter out = new PrintWriter(new FileWriter("desktoplist.txt"))) {
                out.println(DesktopSpec);
                out.println(DesktopSpec2);
                out.println(DesktopSpec3);
                out.println(DesktopSpec4);

            } catch (IOException ex) {
                Logger.getLogger(MyWindowListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Then program will quit.
            System.exit(0);
        }
    }

    class MyRadioButtonListener implements ItemListener {

        public double price1;
        JLabel totalCost = new JLabel();
		//detect radio button state changes
        @Override
        public void itemStateChanged(ItemEvent e) {
            JRadioButton rad = (JRadioButton) e.getItem();
            String label0 = rad.getText();
            if (e.getStateChange() == e.SELECTED) {
                if ("intel core i3".equals(label0)) {
                    price1 = price1 + 99.00;
                    totalCost.setText("" + price1);
                }
                if ("intel core i5".equals(label0)) {
                    price1 = price1 + 159.00;
                    totalCost.setText("" + price1);

                }
                if ("intel core i7".equals(label0)) {
                    price1 = price1 + 219.00;
                    totalCost.setText("" + price1);
                }
                if ("AMD A8".equals(label0)) {
                    price1 = price1 + 149.00;
                    totalCost.setText("" + price1);
                }
                if ("5200RPM 1TB".equals(label0)) {
                    price1 = price1 + 59.99;
                    totalCost.setText("" + price1);
                }
                if ("7200RPM 1TB".equals(label0)) {
                    price1 = price1 + 79.99;
                    totalCost.setText("" + price1);
                }
                if ("128GB SSD".equals(label0)) {
                    price1 = price1 + 105.99;
                    totalCost.setText("" + price1);
                }
                if ("256GB SSD".equals(label0)) {
                    price1 = price1 + 169.99;
                    totalCost.setText("" + price1);
                }
				//if statements to add or remove correct prices as well as totalCost variable.

            } else {
                if ("intel core i3".equals(label0)) {
                    price1 = price1 - 99.00;
                    totalCost.setText("" + price1);
                }
                if ("intel core i5".equals(label0)) {
                    price1 = price1 - 159.00;
                    totalCost.setText("" + price1);
                }
                if ("intel core i7".equals(label0)) {
                    price1 = price1 - 219.00;
                    totalCost.setText("" + price1);
                }
                if ("AMD A8".equals(label0)) {
                    price1 = price1 - 149.00;
                    totalCost.setText("" + price1);
                }
                if ("5200RPM 1TB".equals(label0)) {
                    price1 = price1 - 59.99;
                    totalCost.setText("" + price1);
                }
                if ("7200RPM 1TB".equals(label0)) {
                    price1 = price1 - 79.99;
                    totalCost.setText("" + price1);
                }
                if ("128GB SSD".equals(label0)) {
                    price1 = price1 - 105.99;
                    totalCost.setText("" + price1);
                }
                if ("256GB SSD".equals(label0)) {
                    price1 = price1 - 169.99;
                    totalCost.setText("" + price1);
                }

            }

        }
		//return variables
        public double getprice() {
            return price1;
        }

        JLabel getLabel() {
            return totalCost;
        }
    }

    class MyCheckBoxListener implements ItemListener {

        public double price;
        JLabel totalCost = new JLabel();
		
        public void itemStateChanged(ItemEvent e) {
			//checkbox listener for state change
            JCheckBox chk = (JCheckBox) e.getItem();
            String label = chk.getText();
            if (e.getStateChange() == e.SELECTED) {
                if ("AMD 7850".equals(label)) {
                    price = price + 159.00;
                    totalCost.setText("" + price);
                }
                if ("AMD 7970".equals(label)) {
                    price = price + 309.99;
                    totalCost.setText("" + price);
                }
                if ("Nvidia 760Ti".equals(label)) {
                    price = price + 189.99;
                    totalCost.setText("" + price);
                }
                if ("Nvidia 790".equals(label)) {
                    price = price + 349.99;
                    totalCost.setText("" + price);
                }
                if ("10 inch".equals(label)) {
                    price = price + 99.99;
                    totalCost.setText("" + price);
                }
                if ("13 inch".equals(label)) {
                    price = price + 149.99;
                    totalCost.setText("" + price);
                }
                if ("15 inch".equals(label)) {
                    price = price + 199.99;
                    totalCost.setText("" + price);
                }
                if ("17 inch".equals(label)) {
                    price = price + 249.99;
                    totalCost.setText("" + price);
                }
				//if statements for individual cost and total price
            } else {

                if ("AMD 7850".equals(label)) {
                    price = price - 159.00;
                    totalCost.setText("" + price);
                }
                if ("AMD 7970".equals(label)) {
                    price = price - 309.99;
                    totalCost.setText("" + price);
                }
                if ("Nvidia 760Ti".equals(label)) {
                    price = price - 189.99;
                    totalCost.setText("" + price);
                }
                if ("Nvidia 790".equals(label)) {
                    price = price - 349.99;
                    totalCost.setText("" + price);
                }
                if ("10 inch".equals(label)) {
                    price = price - 99.99;
                    totalCost.setText("" + price);
                }
                if ("13 inch".equals(label)) {
                    price = price - 149.99;
                    totalCost.setText("" + price);
                }
                if ("15 inch".equals(label)) {
                    price = price - 199.99;
                    totalCost.setText("" + price);
                }
                if ("17 inch".equals(label)) {
                    price = price - 249.99;
                    totalCost.setText("" + price);
                }
            }
        }

        double getprice() {
            return price;
        }

        JLabel getLabel() {
            return totalCost;
        }
		//return variables
    }
}
