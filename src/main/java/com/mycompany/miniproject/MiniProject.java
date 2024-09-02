/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.miniproject;

/**
 *
 * @author Hafeez
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniProject {
    private static JPanel mainPanel;
    private static ImageIcon selectedBackgroundImage;
    private static JLabel backgroundLabel;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createMainMenuFrame();
            }
        });
    }

    private static void createMainMenuFrame() {
        JFrame mainMenuFrame = new JFrame("Bank");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(1000, 610);
        mainMenuFrame.setLocationRelativeTo(null);
        mainMenuFrame.setResizable(false);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainMenuFrame.add(mainPanel);
       
        ImageIcon headerImage = new ImageIcon("diyBank.jpg");
        JLabel headerLabel = new JLabel(headerImage);
        headerLabel.setBounds(-310, 0, mainMenuFrame.getWidth(), 100);
        mainPanel.add(headerLabel);
        headerLabel.setBackground(new Color(0,0,0,100));

        JLabel label = new JLabel("Welcome to the GMI banking system!");
        label.setBounds(300, 80, 400, 50);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(label);

        JLabel label1 = new JLabel("What would you like to do?");
        label1.setBounds(350, 120, 300, 50);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(label1);

        JLabel createAccountLabel = new JLabel("Create Account");
        createAccountLabel.setBounds(775,35,150,30);
        
        ImageIcon buttonCreateAccount = new ImageIcon("buttonFront.png");
        JButton createAccountImage = new JButton(buttonCreateAccount);
        createAccountImage.setBounds(750, 35,148,30);
        createAccountImage.setOpaque(false);
        createAccountImage.setContentAreaFilled(false);
        createAccountImage.setBorderPainted(false);
        
        createAccountImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                createAccountPanel();
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(createAccountLabel);
        mainPanel.add(createAccountImage);
        
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(160,240,150,30);
        
        ImageIcon buttonLogin = new ImageIcon("buttonLogin.png");
        JButton loginImage = new JButton(buttonLogin);
        loginImage.setBounds(95, 230,160,50);
        loginImage.setOpaque(false);
        loginImage.setContentAreaFilled(false);
        loginImage.setBorderPainted(false);
        
        loginImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                loginFrame();
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(loginLabel);
        mainPanel.add(loginImage);
        
        ImageIcon backgroundImage = new ImageIcon("MainMenu.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, mainMenuFrame.getWidth(), mainMenuFrame.getHeight());
        mainPanel.add(backgroundLabel);
        

        mainMenuFrame.setVisible(true);
    }

    private static void createAccountPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(0, 0, 1000, 50);
        loginPanel.setOpaque(true);
        
        ImageIcon headerImage = new ImageIcon("diyBank.jpg");
        JLabel headerLabel = new JLabel(headerImage);
        headerLabel.setBounds(300, -2, 400, 50);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(headerLabel);
        
        mainPanel.add(loginPanel);
        
        Color lightBlue = new Color(100,149,237);
        mainPanel.setBackground(lightBlue);
        
        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setBounds(600, 140, 200, 30);
        mainPanel.add(nameLabel);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(735, 140, 150, 30);
        mainPanel.add(nameTextField);

        JLabel passwordLabel = new JLabel("Enter a password:");
        passwordLabel.setBounds(600, 190, 200, 30);
        mainPanel.add(passwordLabel);

        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setBounds(735, 190, 150, 30);
        mainPanel.add(passwordTextField);

        JLabel initialBalanceLabel = new JLabel("Enter amount needed");
        initialBalanceLabel.setBounds(600, 240, 150, 30);
        mainPanel.add(initialBalanceLabel);

        JLabel initial2Label = new JLabel("to open account:");
        initial2Label.setBounds(600, 260, 150, 30);
        mainPanel.add(initial2Label);

        JTextField initialBalanceTextField = new JTextField();
        initialBalanceTextField.setBounds(735, 240, 150, 30);
        mainPanel.add(initialBalanceTextField);

        JLabel createLabel = new JLabel("Create");
        createLabel.setBounds(795, 300, 150, 30);
        
        ImageIcon buttonCreate = new ImageIcon("buttonLogin.png");
        JButton createButton = new JButton(buttonCreate);
        createButton.setBounds(730, 290, 160, 50);
        createButton.setOpaque(false);
        createButton.setContentAreaFilled(false);
        createButton.setBorderPainted(false);
        
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String password = passwordTextField.getText();
                double initialBalance = Double.parseDouble(initialBalanceTextField.getText());

                //Account object
                Account account = new Account(name, password, initialBalance);

                mainPanel.removeAll();
                loginFrame(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(createLabel);
        mainPanel.add(createButton);
        
        JLabel initial3Label = new JLabel("Have an account?");
        initial3Label.setBounds(600, 360, 200, 30);
        mainPanel.add(initial3Label);
        
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(795, 360, 150, 30);
        
        ImageIcon buttonLogin = new ImageIcon("buttonLogin.png");
        JButton loginButton = new JButton(buttonLogin);
        loginButton.setBounds(730, 350, 160, 50);
        loginButton.setOpaque(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                loginFrame();
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(loginLabel);
        mainPanel.add(loginButton);
        
        ImageIcon imageIcon = new ImageIcon("register.jpg");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(800, 610, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setBounds(-250, 0, 800, 700);
        imageLabel.setOpaque(true);
        imageLabel.setBackground(new Color(0, 0, 0, 100));
        imageLabel.setOpaque(false);
        mainPanel.add(imageLabel);
    }
    
    private static void successLogout(){
        JLabel failedLabel = new JLabel("Logged out.");
        failedLabel.setBounds(900,10, 200, 30);
        failedLabel.setForeground(Color.RED);
        failedLabel.setVisible(true);
        mainPanel.add(failedLabel);
    }
    
private static void loginFrame() {
    JPanel loginPanel = new JPanel();
    loginPanel.setLayout(null);
    loginPanel.setBounds(300, 150, 400, 300);
    loginPanel.setOpaque(true);
    Color lightBlue = new Color(100,149,237);
    loginPanel.setBackground(lightBlue);
    
    JPanel loginPanel2 = new JPanel();
    loginPanel2.setLayout(null);
    loginPanel2.setBounds(0, 0, 1000, 50);
    loginPanel2.setOpaque(true);
    
    ImageIcon headerImage = new ImageIcon("diyBank.jpg");
    JLabel headerLabel = new JLabel(headerImage);
    headerLabel.setBounds(300, -2, 400, 50);
    headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
    mainPanel.add(headerLabel);
    headerLabel.setBackground(new Color(0,0,0,100));
    
    mainPanel.add(loginPanel2);
    
    JLabel label = new JLabel("Welcome back");
    label.setBounds(100, 10, 200, 30);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setFont(new Font("Arial", Font.BOLD, 15));
    loginPanel.add(label);

    JLabel nameLabel = new JLabel("Enter your account ID:");
    nameLabel.setBounds(50, 50, 200, 30);
    loginPanel.add(nameLabel);

    JTextField nameTextField = new JTextField();
    nameTextField.setBounds(200, 50, 150, 30);
    loginPanel.add(nameTextField);

    JLabel passwordLabel = new JLabel("Enter a password:");
    passwordLabel.setBounds(50, 100, 200, 30);
    loginPanel.add(passwordLabel);

    JPasswordField passwordTextField = new JPasswordField();
    passwordTextField.setBounds(200, 100, 150, 30);
    loginPanel.add(passwordTextField);
    
    JLabel failedLabel = new JLabel("Invalid ID or password.");
    failedLabel.setBounds(210, 130, 200, 30);
    failedLabel.setForeground(Color.RED);
    failedLabel.setVisible(false);
    loginPanel.add(failedLabel);
    

    JLabel loginLabel = new JLabel("Login");
    loginLabel.setBounds(255, 160, 150, 30);
        
    ImageIcon buttonLogin = new ImageIcon("buttonLogin.png");
    JButton loginButton = new JButton(buttonLogin);
    loginButton.setBounds(190, 150, 160, 50);
    loginButton.setOpaque(false);
    loginButton.setContentAreaFilled(false);
    loginButton.setBorderPainted(false);
    
    loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = nameTextField.getText();
            String password = passwordTextField.getText();

            // Attempt to log in to the account
            Account account = Account.login(id, password);

            if (account != null) {
                mainPanel.removeAll();
                successloginFrame(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            } else {
                failedLabel.setVisible(true);
            }
        }
    });
    loginPanel.add(loginLabel);
    loginPanel.add(loginButton);

    JLabel initial3Label = new JLabel("Don't have an account?");
    initial3Label.setBounds(350, 360, 200, 30);
    mainPanel.add(initial3Label);

    
    JLabel mainMenuLabel = new JLabel("Register");
    mainMenuLabel.setBounds(550, 360, 150, 30);
        
    ImageIcon buttonCreateAccount = new ImageIcon("buttonLogin.png");
    JButton createAccountButton = new JButton(buttonCreateAccount);
    createAccountButton.setBounds(490, 350, 160, 50);
    createAccountButton.setOpaque(false);
    createAccountButton.setContentAreaFilled(false);
    createAccountButton.setBorderPainted(false);
    
    createAccountButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.removeAll();
            createAccountPanel();
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    });
    mainPanel.add(mainMenuLabel);
    mainPanel.add(createAccountButton);
    
    mainPanel.add(loginPanel);

        ImageIcon backgroundImage = new ImageIcon("background.jpg");
        Image background = backgroundImage.getImage();
        Image scaledBackground = background.getScaledInstance(1000, 610, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledBackground);
        JLabel backgroundLabel = new JLabel(scaledImageIcon);
        backgroundLabel.setBounds(0, 0, 1000, 700);
        backgroundLabel.setOpaque(false);
        backgroundLabel.setBackground(new Color(0, 0, 0, 100));
    
    mainPanel.add(backgroundLabel);
}

private static void successloginFrame(Account account){
    JPanel loginPanel = new JPanel();
    loginPanel.setLayout(null);
    loginPanel.setBounds(300, 150, 400, 300);
    ImageIcon backgroundImage = new ImageIcon("background4.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);
    backgroundLabel.setBounds(0, 75, 1000, 520);
    
    JPanel loginPanel2 = new JPanel();
    loginPanel2.setLayout(null);
    loginPanel2.setBounds(0, 0, 1000, 75);
    loginPanel2.setOpaque(true);
    Color lightBlue = new Color(100,149,237);
    loginPanel.setBackground(lightBlue);
    
    ImageIcon headerImage = new ImageIcon("diyBank.jpg");
    JLabel headerLabel = new JLabel(headerImage);
    headerLabel.setBounds(0, 0, mainPanel.getWidth(), 80);
    mainPanel.add(headerLabel);
    headerLabel.setBackground(new Color(0,0,0,100));
        
    mainPanel.add(loginPanel2);
        
    ImageIcon check = new ImageIcon("iconCheck.gif");
    JLabel icon = new JLabel(check);
    icon.setBounds(170, 10, 80, 80);
    loginPanel.add(icon);
       
        
    JLabel successLabel = new JLabel("Login successful.");
    successLabel.setBounds(10, 100, 400, 50);
    successLabel.setHorizontalAlignment(SwingConstants.CENTER);
    loginPanel.add(successLabel);
    
    JLabel successLabel2 = new JLabel("Welcome, "+ account.getName() + "!");
    successLabel2.setBounds(8, 140, 400, 50);
    successLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    loginPanel.add(successLabel2);
    
    JLabel mainMenuLabel = new JLabel("Main Menu");
        mainMenuLabel.setBounds(180, 240, 150, 30);
        
        ImageIcon buttonMainMenu = new ImageIcon("buttonFront.png");
        JButton MainMenuImage = new JButton(buttonMainMenu);
        MainMenuImage.setBounds(130, 230, 160, 50);
        MainMenuImage.setOpaque(false);
        MainMenuImage.setContentAreaFilled(false);
        MainMenuImage.setBorderPainted(false);
        MainMenuImage.setHorizontalAlignment(SwingConstants.CENTER);
        
        MainMenuImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showMenuFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        loginPanel.add(mainMenuLabel);
        loginPanel.add(MainMenuImage);
        mainPanel.add(loginPanel);
        mainPanel.add(backgroundLabel);
}

private static void loginFrame(Account account) {
    JPanel loginPanel = new JPanel();
    loginPanel.setLayout(null);
    loginPanel.setBounds(300, 150, 400, 300);
    /*loginPanel.setOpaque(true);
    Color lightBlue = new Color(100,149,237);
    mainPanel.setBackground(lightBlue);*/
    ImageIcon backgroundImage = new ImageIcon("background4.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);
    backgroundLabel.setBounds(0, 75, 1000, 520);
        
    JPanel loginPanel2 = new JPanel();
    loginPanel2.setLayout(null);
    loginPanel2.setBounds(0, 0, 1000, 75);
    loginPanel2.setOpaque(true);
    Color lightBlue = new Color(100,149,237);
    loginPanel.setBackground(lightBlue);
        
    ImageIcon headerImage = new ImageIcon("diyBank.jpg");
    JLabel headerLabel = new JLabel(headerImage);
    headerLabel.setBounds(0, 0, mainPanel.getWidth(), 80);
    mainPanel.add(headerLabel);
    headerLabel.setBackground(new Color(0,0,0,100));
        
    mainPanel.add(loginPanel2);
        
    ImageIcon check = new ImageIcon("iconCheck.gif");
    JLabel icon = new JLabel(check);
    icon.setBounds(170, 10, 80, 80);
    loginPanel.add(icon);
       
        
    JLabel successLabel = new JLabel("Login successful. Welcome, " + account.getName() + "!");
    successLabel.setBounds(10, 100, 400, 50);
        successLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginPanel.add(successLabel);
        
        JLabel accountID1 = new JLabel("Account created successfully.");
        accountID1.setBounds(10, 140, 400, 50);
        accountID1.setHorizontalAlignment(SwingConstants.CENTER);
        loginPanel.add(accountID1);
        
        JLabel accountID2 = new JLabel("Your account ID is " + account.getId() + ".");
        accountID2.setBounds(10, 180, 400, 50);
        accountID2.setHorizontalAlignment(SwingConstants.CENTER);
        loginPanel.add(accountID2);

        JLabel mainMenuLabel = new JLabel("Main Menu");
        mainMenuLabel.setBounds(180, 240, 150, 30);
        
        ImageIcon buttonMainMenu = new ImageIcon("buttonFront.png");
        JButton MainMenuImage = new JButton(buttonMainMenu);
        MainMenuImage.setBounds(130, 230, 160, 50);
        MainMenuImage.setOpaque(false);
        MainMenuImage.setContentAreaFilled(false);
        MainMenuImage.setBorderPainted(false);
        MainMenuImage.setHorizontalAlignment(SwingConstants.CENTER);
        
        MainMenuImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showMenuFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        loginPanel.add(mainMenuLabel);
        loginPanel.add(MainMenuImage);
        mainPanel.add(loginPanel);
        mainPanel.add(backgroundLabel);
    }
    
    private static void showMenuFrame(Account account){
        JPanel transc = new JPanel();
        transc.setLayout(null);
        transc.setBounds(650,250,300,200);
        transc.setOpaque(true);
        transc.setBackground(Color.lightGray);
        
        JPanel summ = new JPanel();
        summ.setLayout(null);
        summ.setBounds(250,250,300,200);
        summ.setOpaque(true);
        summ.setBackground(Color.lightGray);
        
        JLabel scheduleLabel = new JLabel("Scheduled Transactions");
        scheduleLabel.setBounds(70, 15, 300, 30);
        scheduleLabel.setFont(new Font("Arial", Font.BOLD, 17));
        transc.add(scheduleLabel);
        
        ImageIcon schedule = new ImageIcon("schedule.png");
        JLabel icon = new JLabel(schedule);
        icon.setBounds(10,10,40,40);
        transc.add(icon);
        
        JLabel write = new JLabel("You do not have any scheduled transactions.");
        write.setBounds(20, 90, 300, 30);
        transc.add(write);
        
        JLabel sum = new JLabel("Account Summary");
        sum.setBounds(70, 15, 300, 30);
        sum.setFont(new Font("Arial", Font.BOLD, 17));
        summ.add(sum);
        
        ImageIcon sumi = new ImageIcon("summary.png");
        JLabel sumicon = new JLabel(sumi);
        sumicon.setBounds(10,10,40,40);
        summ.add(sumicon);
        
        JLabel write2 = new JLabel("Account Name: "+ account.getName());
        write2.setBounds(20, 70, 300, 30);
        summ.add(write2);
        
        JLabel write3 = new JLabel("Account ID: "+ account.getId());
        write3.setBounds(20, 100, 300, 30);
        summ.add(write3);
        
        JLabel write5 = new JLabel("Account Balance: "+ account.getBalance());
        write5.setBounds(20, 130, 300, 30);
        summ.add(write5);
        
        mainPanel.add(transc);
        mainPanel.add(summ);
        defaultBackground();
    }

    private static void showMainMenuFrame(Account account) {
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(0, 0, 200, 610);
        leftPanel.setOpaque(true);
        Color lightBlue = new Color(135,206,235);
        leftPanel.setBackground(lightBlue);
        
        JPanel topleft = new JPanel();
        topleft.setLayout(null);
        topleft.setBounds(0,0,200,150);
        topleft.setOpaque(true);
        Color Blue = new Color(0,0,139);
        topleft.setBackground(Blue);
        
        JPanel top = new JPanel();
        top.setLayout(null);
        top.setBounds(0,0,1000,150);
        top.setOpaque(true);
        Color lightBlue2 = new Color(135,206,235);
        top.setBackground(lightBlue2);
        
        JButton icon = new JButton();
        ImageIcon userIcon = new ImageIcon("user1.png");
        icon.setIcon(userIcon);
        icon.setBounds(60, 40, 80, 80);
        
        //transparent
        icon.setOpaque(false);
        icon.setContentAreaFilled(false);
        icon.setBorderPainted(false);
        
        icon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showMainFrame(account);
                showAccountDetailsFrame(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(icon);
        
        JLabel nameLabel = new JLabel("Welcome, " + account.getName() + "!");
        nameLabel.setBounds(550, 100, 200, 30);
        mainPanel.add(nameLabel);

        JLabel details = new JLabel("Account Details");
        details.setBounds(60, 250, 150, 30);
        
        ImageIcon buttondetails = new ImageIcon("buttonMain.png");
        JButton detailsImage = new JButton(buttondetails);
        detailsImage.setBounds(30, 240, 160, 50);
        detailsImage.setOpaque(false);
        detailsImage.setContentAreaFilled(false);
        detailsImage.setBorderPainted(false);
        
        detailsImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showMainFrame(account);
                showMenuFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
                
            }
        });
        mainPanel.add(details);
        mainPanel.add(detailsImage);

        
        JLabel others = new JLabel("Others");
        others.setBounds(90, 310, 150, 30);
        
        ImageIcon buttonOthers = new ImageIcon("buttonMain.png");
        JButton OthersImage = new JButton(buttonOthers);
        OthersImage.setBounds(30, 300, 160, 50);
        OthersImage.setOpaque(false);
        OthersImage.setContentAreaFilled(false);
        OthersImage.setBorderPainted(false);
        
        OthersImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showOthersFrame(account);
                showMenuFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
                
            }
        });
        mainPanel.add(others);
        mainPanel.add(OthersImage);
        
       
        JLabel History = new JLabel("Transaction History");
        History.setBounds(50, 370, 150, 30);
        
        ImageIcon buttonHistory = new ImageIcon("buttonMain.png");
        JButton historyImage = new JButton(buttonHistory);
        historyImage.setBounds(30, 360, 160, 50);
        historyImage.setOpaque(false);
        historyImage.setContentAreaFilled(false);
        historyImage.setBorderPainted(false);
        
        historyImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                transactionHistoryFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
                
            }
        });
        mainPanel.add(History);
        mainPanel.add(historyImage);
        
        JLabel settings = new JLabel("Settings");
        settings.setBounds(80, 430, 150, 30);
        
        ImageIcon buttonSettings = new ImageIcon("buttonMain.png");
        JButton settingsImage = new JButton(buttonSettings);
        settingsImage.setBounds(30, 420, 160, 50);
        settingsImage.setOpaque(false);
        settingsImage.setContentAreaFilled(false);
        settingsImage.setBorderPainted(false);
        
        settingsImage.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.removeAll();
            showMainMenuFrame(account);
            showSettingsFrame(account);
            changeBackgroundImage(account);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    });

    mainPanel.add(settings);
    mainPanel.add(settingsImage);

        
        JLabel outLabel = new JLabel("Log out");
        outLabel.setBounds(860, 38, 150, 30);
        
        ImageIcon buttonIcon = new ImageIcon("button.png");
        JButton buttonImage = new JButton(buttonIcon);
        buttonImage.setBounds(810, 30, 130, 50);
        buttonImage.setOpaque(false);
        buttonImage.setContentAreaFilled(false);
        buttonImage.setBorderPainted(false);
        
        ImageIcon exitIcon = new ImageIcon("exit.png");
        JLabel exitLabel = new JLabel(exitIcon);
        exitLabel.setBounds(770, 30, 150, 50);
        
        mainPanel.add(outLabel);
        mainPanel.add(exitLabel);
        mainPanel.add(buttonImage);
        
        buttonImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                successLogout();
                loginFrame();
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        
        
        JButton headerButton = new JButton();
        ImageIcon headerImage = new ImageIcon("diyBank.jpg");
        headerButton.setIcon(headerImage);
        headerButton.setBounds(350, 20, 400, 50);
        headerButton.setHorizontalAlignment(SwingConstants.CENTER);
        headerButton.setOpaque(false);
        headerButton.setContentAreaFilled(false);
        headerButton.setBorderPainted(false);
        
        headerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showMenuFrame(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        
        mainPanel.add(headerButton);
        
        ImageIcon backgroundImage = new ImageIcon("background2.jpg");
        Image background = backgroundImage.getImage();
        Image scaledBackground = background.getScaledInstance(800, 610, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledBackground);
        JLabel backgroundLabel = new JLabel(scaledImageIcon);
        backgroundLabel.setBounds(200, 0, 800, 610);
        backgroundLabel.setOpaque(false);
        backgroundLabel.setBackground(new Color(0, 0, 0, 100));

        mainPanel.add(topleft);
        mainPanel.add(leftPanel);
        mainPanel.add(top);
        //mainPanel.add(backgroundLabel);
    }
    
private static void showSettingsFrame(Account account) {
    JLabel changeBackground = new JLabel("Change Background");
    changeBackground.setBounds(378, 165, 150, 30);
        
    ImageIcon buttonchangeBackground = new ImageIcon("buttonMain.png");
    JButton changeBackgroundImage = new JButton(buttonchangeBackground);
    changeBackgroundImage.setBounds(360, 155, 160, 50);
    changeBackgroundImage.setOpaque(false);
    changeBackgroundImage.setContentAreaFilled(false);
    changeBackgroundImage.setBorderPainted(false);
    
    changeBackgroundImage.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            mainPanel.removeAll();
            showMainMenuFrame(account);
            changeBackgroundImageSaccountelectionDialog(account);
            changeBackgroundImage(account);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    });

    JLabel changeAccountDetails = new JLabel("Change Account Details");
    changeAccountDetails.setBounds(610, 165, 150, 30);
        
    ImageIcon buttonchangeAccountDetails = new ImageIcon("buttonMain.png");
    JButton changeAccountDetailsImage = new JButton(buttonchangeAccountDetails);
    changeAccountDetailsImage.setBounds(600, 155, 160, 50);
    changeAccountDetailsImage.setOpaque(false);
    changeAccountDetailsImage.setContentAreaFilled(false);
    changeAccountDetailsImage.setBorderPainted(false);
    
    changeAccountDetailsImage.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            mainPanel.removeAll();
            showMainMenuFrame(account);
            changeAccountDetailsFrame(account);
            changeBackgroundImage(account);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    });
    mainPanel.add(changeBackground);
    mainPanel.add(changeBackgroundImage);
    mainPanel.add(changeAccountDetails);
    mainPanel.add(changeAccountDetailsImage);
    defaultBackground();
}

private static void changeAccountDetailsFrame(Account account){
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBounds(400,200,400,253);
    panel.setOpaque(true);
    panel.setBackground(Color.lightGray);
    
    JLabel passwordLabel = new JLabel("Enter a new password:");
    passwordLabel.setBounds(450, 300, 200, 30);
    mainPanel.add(passwordLabel);

    JPasswordField passwordTextField = new JPasswordField();
    passwordTextField.setBounds(600, 300, 150, 30);
    mainPanel.add(passwordTextField);

    JLabel usernameLabel = new JLabel("Enter a new username:");
    usernameLabel.setBounds(450, 250, 200, 30);
    mainPanel.add(usernameLabel);

    JTextField usernameTextField = new JTextField();
    usernameTextField.setBounds(600, 250, 150, 30);
    mainPanel.add(usernameTextField);

    JLabel updateLabel = new JLabel("Update");
    updateLabel.setBounds(660, 360, 150, 30);

    ImageIcon buttonUpdate = new ImageIcon("buttonLogin.png");
    JButton updateButton = new JButton(buttonUpdate);
    updateButton.setBounds(600, 350, 160, 50);
    updateButton.setOpaque(false);
    updateButton.setContentAreaFilled(false);
    updateButton.setBorderPainted(false);
    
    updateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String newPassword = new String(passwordTextField.getPassword());
            String newUsername = usernameTextField.getText();
            
            account.setPassword(newPassword);
            account.setUsername(newUsername);
            
            JLabel successLabel = new JLabel("Account details updated successfully!");
            successLabel.setBounds(470, 300, 250, 30);
                
            mainPanel.removeAll();
            showMainMenuFrame(account);
            mainPanel.add(successLabel);
            mainPanel.add(panel);
            changeBackgroundImage(account);
            mainPanel.revalidate();
            mainPanel.repaint();
                
        }
    });
    
    JLabel cancelBackgroundLabel = new JLabel("Cancel");
    cancelBackgroundLabel.setBounds(660, 410, 150, 30);

    ImageIcon buttoncancelBackground = new ImageIcon("buttonLogin.png");
    JButton cancelBackgroundButton = new JButton(buttoncancelBackground);
    cancelBackgroundButton.setBounds(600, 400, 160, 50);
    cancelBackgroundButton.setOpaque(false);
    cancelBackgroundButton.setContentAreaFilled(false);
    cancelBackgroundButton.setBorderPainted(false);
    
    cancelBackgroundButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.removeAll();
            showMainMenuFrame(account);
            showSettingsFrame(account);
            changeBackgroundImage(account);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    });
    mainPanel.add(cancelBackgroundLabel);
    mainPanel.add(cancelBackgroundButton);

    mainPanel.add(updateLabel);
    mainPanel.add(updateButton);
    
    mainPanel.add(panel);
    defaultBackground();
}

private static void changeBackgroundImageSaccountelectionDialog(Account account) {
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBounds(400,200,400,253);
    panel.setOpaque(true);
    panel.setBackground(Color.lightGray);

    JLabel dialog = new JLabel("Select Background Image");
    dialog.setBounds(530, 220, 150, 30);

    ImageIcon background1 = new ImageIcon("background5.jpg");
    ImageIcon background2 = new ImageIcon("Iconbackground5.jpg");
    JButton backgroundImage = new JButton(background2);
    backgroundImage.setBounds(500, 270, 80, 80);
    backgroundImage.setOpaque(false);
    backgroundImage.setContentAreaFilled(false);
    backgroundImage.setBorderPainted(false);

    backgroundImage.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.removeAll();
            selectedBackgroundImage = background1;
            showMainMenuFrame(account);
            showMenuFrame(account);
            changeBackgroundImage(account);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    });
    mainPanel.add(dialog);
    mainPanel.add(backgroundImage);

    ImageIcon background3 = new ImageIcon("background6.jpg");
    ImageIcon background4 = new ImageIcon("Iconbackground6.jpg");
    JButton backgroundImage2 = new JButton(background4);
    backgroundImage2.setBounds(630, 270, 80, 80);
    backgroundImage2.setOpaque(false);
    backgroundImage2.setContentAreaFilled(false);
    backgroundImage2.setBorderPainted(false);

    backgroundImage2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.removeAll();
            selectedBackgroundImage = background3;
            showMainMenuFrame(account);
            showMenuFrame(account);
            changeBackgroundImage(account);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    });
    mainPanel.add(backgroundImage2);

    JLabel cancelBackgroundLabel = new JLabel("Cancel");
    cancelBackgroundLabel.setBounds(590, 390, 150, 30);

    ImageIcon buttoncancelBackground = new ImageIcon("buttonLogin.png");
    JButton cancelBackgroundButton = new JButton(buttoncancelBackground);
    cancelBackgroundButton.setBounds(530, 380, 160, 50);
    cancelBackgroundButton.setOpaque(false);
    cancelBackgroundButton.setContentAreaFilled(false);
    cancelBackgroundButton.setBorderPainted(false);
    
    cancelBackgroundButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.removeAll();
            showMainMenuFrame(account);
            showSettingsFrame(account);
            changeBackgroundImage(account);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    });
    mainPanel.add(cancelBackgroundLabel);
    mainPanel.add(cancelBackgroundButton);

    mainPanel.revalidate();
    mainPanel.repaint();
    mainPanel.add(panel);
    defaultBackground();
}


private static void defaultBackground(){
    backgroundLabel = new JLabel();
backgroundLabel.setBounds(200, 150, 800, 460);
backgroundLabel.setIcon(new ImageIcon("background5.jpg"));
mainPanel.add(backgroundLabel);
}

private static void changeBackgroundImage(Account account) {
    if (selectedBackgroundImage != null) {
        mainPanel.remove(backgroundLabel);
        backgroundLabel = new JLabel(selectedBackgroundImage);
        backgroundLabel.setBounds(200, 150, 800, 460);
        mainPanel.add(backgroundLabel);
    }
    mainPanel.revalidate();
    mainPanel.repaint();
}

private static void transactionHistoryFrame(Account account) {
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBounds(400, 200, 400, 300);
    Color lightBlue2 = new Color(135,206,235);
    panel.setBackground(lightBlue2);

    JLabel titleLabel = new JLabel("Transaction History");
    titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    titleLabel.setBounds(50, 10, 300, 30);
    panel.add(titleLabel);
    
    JLabel desc = new JLabel("Description");
    desc.setHorizontalAlignment(SwingConstants.CENTER);
    desc.setBounds(-60,40,300,30);
    panel.add(desc);
    
    JLabel amount = new JLabel("Amount");
    amount.setHorizontalAlignment(SwingConstants.CENTER);
    amount.setBounds(60,40,300,30);
    panel.add(amount);
    
    JLabel balance = new JLabel("Balance");
    balance.setHorizontalAlignment(SwingConstants.CENTER);
    balance.setBounds(160,40,300,30);
    panel.add(balance);

    List<String> transactionHistory = account.getTransactionHistory();
    JTextArea historyTextArea = new JTextArea();
    historyTextArea.setBackground(Color.lightGray);
    historyTextArea.setEditable(false);

    // Build the transaction history text
    StringBuilder transactionText = new StringBuilder();
    for (String transaction : transactionHistory) {
        transactionText.append(transaction).append("\n");
    }
    historyTextArea.setText(transactionText.toString());

    JScrollPane scrollPane = new JScrollPane(historyTextArea);
    scrollPane.setBounds(50, 70, 300, 200);
    historyTextArea.setBackground(Color.lightGray);
    panel.add(scrollPane);

    mainPanel.removeAll();
    showMainMenuFrame(account);
    mainPanel.add(panel);
    mainPanel.revalidate();
    mainPanel.repaint();
    

        JLabel backButton = new JLabel("Back");
        backButton.setBounds(585, 163, 150, 30);
        
        ImageIcon buttonBack = new ImageIcon("buttonMain.png");
        JButton backbuttonImage = new JButton(buttonBack);
        backbuttonImage.setBounds(520, 155, 160, 50);
        backbuttonImage.setOpaque(false);
        backbuttonImage.setContentAreaFilled(false);
        backbuttonImage.setBorderPainted(false);
        
        backbuttonImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showMenuFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(backButton);
        mainPanel.add(backbuttonImage);
        defaultBackground();
}
    
    private static void showMainFrame(Account account){
        JLabel details = new JLabel("Account Details");
        details.setBounds(250, 163, 150, 30);
        
        ImageIcon buttondetails = new ImageIcon("buttonMain.png");
        JButton detailsImage = new JButton(buttondetails);
        detailsImage.setBounds(220, 155, 160, 50);
        detailsImage.setOpaque(false);
        detailsImage.setContentAreaFilled(false);
        detailsImage.setBorderPainted(false);
        
        detailsImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showMainFrame(account);
                showAccountDetailsFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(details);
        mainPanel.add(detailsImage);


        JLabel withdraw = new JLabel("Withdraw");
        withdraw.setBounds(465, 163, 150, 30);
        
        ImageIcon buttonwithdraw = new ImageIcon("buttonMain.png");
        JButton withdrawImage = new JButton(buttonwithdraw);
        withdrawImage.setBounds(410, 155, 160, 50);
        withdrawImage.setOpaque(false);
        withdrawImage.setContentAreaFilled(false);
        withdrawImage.setBorderPainted(false);
        
        withdrawImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showMainFrame(account);
                showWithdrawFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(withdraw);
        mainPanel.add(withdrawImage);


        JLabel currencyExchange = new JLabel("Deposit");
        currencyExchange.setBounds(670, 163, 150, 30);
        
        ImageIcon buttoncurrencyExchange = new ImageIcon("buttonMain.png");
        JButton currencyExchangeImage = new JButton(buttoncurrencyExchange);
        currencyExchangeImage.setBounds(610, 155, 160, 50);
        currencyExchangeImage.setOpaque(false);
        currencyExchangeImage.setContentAreaFilled(false);
        currencyExchangeImage.setBorderPainted(false);
        currencyExchangeImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showMainFrame(account);                
                showDepositFrame(account);
                defaultBackground();
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(currencyExchange);
        mainPanel.add(currencyExchangeImage);


        JLabel back = new JLabel("Back");
        back.setBounds(875, 163, 150, 30);
        
        ImageIcon buttonBack = new ImageIcon("buttonMain.png");
        JButton backImage = new JButton(buttonBack);
        backImage.setBounds(810, 155, 160, 50);
        backImage.setOpaque(false);
        backImage.setContentAreaFilled(false);
        backImage.setBorderPainted(false);
        
        backImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showMenuFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(back);
        mainPanel.add(backImage);
    }
    
    private static void showWithdrawFrame(Account account) {
        JPanel withdraw = new JPanel();
        withdraw.setLayout(null);
        withdraw.setBounds(445,250,300,230);
        withdraw.setOpaque(true);
        withdraw.setBackground(Color.lightGray);
        
        JLabel WithdrawLabel = new JLabel("Enter amount to withdraw: ");
        WithdrawLabel.setBounds(520, 250, 200, 30);
        mainPanel.add(WithdrawLabel);
        
        JTextField WithdrawTextField = new JTextField();
        WithdrawTextField.setBounds(520, 300, 150, 30);
        mainPanel.add(WithdrawTextField);

        JLabel draw = new JLabel("Withdraw");
        draw.setBounds(575, 360, 150, 30);
        
        ImageIcon buttonDraw = new ImageIcon("buttonMain.png");
        JButton drawImage = new JButton(buttonDraw);
        drawImage.setBounds(520, 350, 160, 50);
        drawImage.setOpaque(false);
        drawImage.setContentAreaFilled(false);
        drawImage.setBorderPainted(false);
        
        drawImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double withdrawAmount = Double.parseDouble(WithdrawTextField.getText());
                    if (withdrawAmount > account.getBalance()) {
                        mainPanel.removeAll();
                        showMainMenuFrame(account);
                        showMainFrame(account);
                        
                        JLabel insufficientLabel = new JLabel("Insufficient balance.");
                        insufficientLabel.setBounds(520, 300, 200, 30);
                        JLabel balance = new JLabel("Your balance is " + account.getBalance());
                        balance.setBounds(520, 320, 200, 30);
                        
                        mainPanel.revalidate();
                        mainPanel.repaint();
                        mainPanel.add(insufficientLabel);
                        mainPanel.add(balance);
                        
                                JLabel backButton = new JLabel("Back");
                                backButton.setBounds(590, 410, 150, 30);
                                
                                ImageIcon buttonBack = new ImageIcon("buttonMain.png");
                                JButton backbuttonImage = new JButton(buttonBack);
                                backbuttonImage.setBounds(520, 400, 160, 50);
                                backbuttonImage.setOpaque(false);
                                backbuttonImage.setContentAreaFilled(false);
                                backbuttonImage.setBorderPainted(false);
                                backbuttonImage.addActionListener(new ActionListener() {
                            
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mainPanel.removeAll();
                                showMainMenuFrame(account);
                                showMainFrame(account);
                                showWithdrawFrame(account);
                                changeBackgroundImage(account);
                                mainPanel.revalidate();
                                mainPanel.repaint();
                            }
                        });
                                mainPanel.add(backButton);
                                mainPanel.add(backbuttonImage);
                                mainPanel.add(withdraw);
                                defaultBackground();
                                changeBackgroundImage(account);
                    
                    }
                    else{
                    mainPanel.removeAll();
                    showMainMenuFrame(account);
                    showMainFrame(account);
                        
                    account.withdraw(withdrawAmount);
                    JLabel success = new JLabel("Withdrawal successful.");
                    success.setBounds(520, 300, 200, 30);
                    JLabel newbalance = new JLabel("Your new balance is RM" + account.getBalance());
                    newbalance.setBounds(520, 320, 200, 30);
                    
                    mainPanel.revalidate();
                    mainPanel.repaint();
                    mainPanel.add(success);
                    mainPanel.add(newbalance);
                    
                            JLabel backButton2 = new JLabel("Back");
                            backButton2.setBounds(590, 410, 150, 30);
     
                            ImageIcon buttonBack2 = new ImageIcon("buttonMain.png");
                            JButton backbuttonImage2 = new JButton(buttonBack2);
                            backbuttonImage2.setBounds(520, 400, 160, 50);
                            backbuttonImage2.setOpaque(false);
                            backbuttonImage2.setContentAreaFilled(false);
                            backbuttonImage2.setBorderPainted(false);
                            backbuttonImage2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    mainPanel.removeAll();
                                    showMainMenuFrame(account);
                                    showMainFrame(account);
                                    showMenuFrame(account);
                                    changeBackgroundImage(account);
                                    mainPanel.revalidate();
                                    mainPanel.repaint();
                        }
                    });
                            mainPanel.add(backButton2);
                            mainPanel.add(backbuttonImage2);
                            mainPanel.add(withdraw);
                            defaultBackground();
                            changeBackgroundImage(account);
                    }
            }
        });
        mainPanel.add(draw);
        mainPanel.add(drawImage);
        

        JLabel backButton3 = new JLabel("Back");
        backButton3.setBounds(590, 410, 150, 30);
        
        ImageIcon buttonBack3 = new ImageIcon("buttonMain.png");
        JButton backbuttonImage3 = new JButton(buttonBack3);
        backbuttonImage3.setBounds(520, 400, 160, 50);
        backbuttonImage3.setOpaque(false);
        backbuttonImage3.setContentAreaFilled(false);
        backbuttonImage3.setBorderPainted(false);
        backbuttonImage3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showMainFrame(account);
                showMenuFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(backButton3);
        mainPanel.add(backbuttonImage3);
        mainPanel.add(withdraw);
        defaultBackground();
    }
    
    private static void showDepositFrame(Account account) {
        JPanel deposit = new JPanel();
        deposit.setLayout(null);
        deposit.setBounds(445,250,300,230);
        deposit.setOpaque(true);
        deposit.setBackground(Color.lightGray);
        
        JLabel DepositLabel = new JLabel("Enter amount to Deposit: ");
        DepositLabel.setBounds(520, 250, 200, 30);
        mainPanel.add(DepositLabel);
        
        JTextField DepositTextField = new JTextField();
        DepositTextField.setBounds(520, 300, 150, 30);
        mainPanel.add(DepositTextField);
               
        JLabel depo = new JLabel("Deposit");
        depo.setBounds(575, 360, 150, 30);
        
        ImageIcon buttonDepo = new ImageIcon("buttonMain.png");
        JButton depoImage = new JButton(buttonDepo);
        depoImage.setBounds(520, 350, 160, 50);
        depoImage.setOpaque(false);
        depoImage.setContentAreaFilled(false);
        depoImage.setBorderPainted(false);
        depoImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double DepositAmount = Double.parseDouble(DepositTextField.getText());
                    account.deposit(DepositAmount);
                    mainPanel.removeAll();
                    showMainMenuFrame(account);
                    showMainFrame(account);
                    
                    JLabel success = new JLabel("Deposit successful.");
                    success.setBounds(520, 300, 200, 30);
                    JLabel newbalance = new JLabel("Your new balance is RM" + account.getBalance());
                    newbalance.setBounds(500, 330, 200, 30);
                    
                    mainPanel.revalidate();
                    mainPanel.repaint();
                    mainPanel.add(success);
                    mainPanel.add(newbalance);
                    

                    JLabel backButton2 = new JLabel("Back");
                    backButton2.setBounds(590, 410, 150, 30);
     
                    ImageIcon buttonBack2 = new ImageIcon("buttonMain.png");
                    JButton backbuttonImage2 = new JButton(buttonBack2);
                    backbuttonImage2.setBounds(520, 400, 160, 50);
                    backbuttonImage2.setOpaque(false);
                    backbuttonImage2.setContentAreaFilled(false);
                    backbuttonImage2.setBorderPainted(false);
                    backbuttonImage2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            mainPanel.removeAll();
                            showMainMenuFrame(account);
                            showMainFrame(account);
                            showMenuFrame(account);
                            changeBackgroundImage(account);
                            mainPanel.revalidate();
                            mainPanel.repaint();
                        }
                    });
                    mainPanel.add(backButton2);
                    mainPanel.add(backbuttonImage2);
                    mainPanel.add(deposit);
                    defaultBackground();
                    changeBackgroundImage(account);        
            }
        });
        mainPanel.add(depo);
        mainPanel.add(depoImage);
        

        JLabel backButton2 = new JLabel("Back");
        backButton2.setBounds(590, 410, 150, 30);
     
        ImageIcon buttonBack2 = new ImageIcon("buttonMain.png");
        JButton backbuttonImage2 = new JButton(buttonBack2);
        backbuttonImage2.setBounds(520, 400, 160, 50);
        backbuttonImage2.setOpaque(false);
        backbuttonImage2.setContentAreaFilled(false);
        backbuttonImage2.setBorderPainted(false);
        backbuttonImage2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showMainFrame(account);
                showMenuFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(backButton2);
        mainPanel.add(backbuttonImage2);
        mainPanel.add(deposit);
        defaultBackground();
        changeBackgroundImage(account);
    }

    private static void showAccountDetailsFrame(Account account) {
        JPanel details = new JPanel();
        details.setLayout(null);
        details.setBounds(445,250,300,230);
        details.setOpaque(true);
        details.setBackground(Color.lightGray);
        
        JLabel idLabel = new JLabel("Account ID: " + account.getId());
        idLabel.setBounds(540, 270, 200, 30);
        mainPanel.add(idLabel);

        JLabel nameLabel = new JLabel("Account Name: " + account.getName());
        nameLabel.setBounds(540, 310, 300, 30);
        mainPanel.add(nameLabel);

        JLabel balanceLabel = new JLabel("Balance: " + account.getBalance());
        balanceLabel.setBounds(540, 350, 300, 30);
        mainPanel.add(balanceLabel);

        JLabel backButton2 = new JLabel("Back");
        backButton2.setBounds(590, 410, 150, 30);
     
        ImageIcon buttonBack2 = new ImageIcon("buttonMain.png");
        JButton backbuttonImage2 = new JButton(buttonBack2);
        backbuttonImage2.setBounds(520, 400, 160, 50);
        backbuttonImage2.setOpaque(false);
        backbuttonImage2.setContentAreaFilled(false);
        backbuttonImage2.setBorderPainted(false);
        backbuttonImage2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showMainFrame(account);
                showMenuFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(backButton2);
        mainPanel.add(backbuttonImage2);
        mainPanel.add(details);
        defaultBackground();
        changeBackgroundImage(account);
    }

    private static void showOthersFrame(Account account) {
        JLabel loans = new JLabel("Loans");
        loans.setBounds(380, 163, 150, 30);
        
        ImageIcon buttonloans = new ImageIcon("buttonMain.png");
        JButton loansImage = new JButton(buttonloans);
        loansImage.setBounds(320, 155, 160, 50);
        loansImage.setOpaque(false);
        loansImage.setContentAreaFilled(false);
        loansImage.setBorderPainted(false);
        
        loansImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showOthersFrame(account);
                showLoansFrame(account);
                defaultBackground();
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(loans);
        mainPanel.add(loansImage);


        JLabel CurrencyExchange = new JLabel("Currency Exchange");
        CurrencyExchange.setBounds(540, 163, 150, 30);
        
        ImageIcon buttonCurrency = new ImageIcon("buttonMain.png");
        JButton currencyImage = new JButton(buttonCurrency);
        currencyImage.setBounds(520, 155, 160, 50);
        currencyImage.setOpaque(false);
        currencyImage.setContentAreaFilled(false);
        currencyImage.setBorderPainted(false);
        
        currencyImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showOthersFrame(account);
                showCurrencyExchangeFrame(account);
                defaultBackground();
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(CurrencyExchange);
        mainPanel.add(currencyImage);


        JLabel Back = new JLabel("Back");
        Back.setBounds(785, 163, 150, 30);
        
        ImageIcon buttonBack = new ImageIcon("buttonMain.png");
        JButton backImage = new JButton(buttonBack);
        backImage.setBounds(720, 155, 160, 50);
        backImage.setOpaque(false);
        backImage.setContentAreaFilled(false);
        backImage.setBorderPainted(false);
        
        backImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showMenuFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(Back);
        mainPanel.add(backImage);
    }

    private static void showLoansFrame(Account account) {
        JPanel loan = new JPanel();
        loan.setLayout(null);
        loan.setBounds(400,250,400,253);
        loan.setOpaque(true);
        loan.setBackground(Color.lightGray);
        
        JLabel loanAmountLabel = new JLabel("Enter the amount of loan you want to apply for:");
        loanAmountLabel.setBounds(458, 250, 400, 30);
        mainPanel.add(loanAmountLabel);
        
        JLabel loanLimitLabel = new JLabel("Max loan limit: " + account.getBalance() / 2);
        loanLimitLabel.setBounds(535, 300, 200, 30);
        mainPanel.add(loanLimitLabel);

        JTextField loanAmountTextField = new JTextField();
        loanAmountTextField.setBounds(520, 350, 150, 30);
        mainPanel.add(loanAmountTextField);


        JLabel apply = new JLabel("Apply");
        apply.setBounds(586, 410, 150, 30);
     
        ImageIcon buttonApply = new ImageIcon("buttonMain.png");
        JButton applyImage = new JButton(buttonApply);
        applyImage.setBounds(520, 400, 160, 50);
        applyImage.setOpaque(false);
        applyImage.setContentAreaFilled(false);
        applyImage.setBorderPainted(false);
        applyImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double loanAmount = Double.parseDouble(loanAmountTextField.getText());
                if (loanAmount > account.getBalance() / 2) {
                    mainPanel.removeAll();
                    showMainMenuFrame(account);
                    showOthersFrame(account);
                    
                    JLabel notsuccess = new JLabel("Loan amount cannot exceed ");
                    notsuccess.setBounds(520, 300, 300, 30);
                    
                    JLabel notsuccess2 = new JLabel(""+account.getBalance() / 2);
                    notsuccess2.setBounds(530, 320, 300, 30);
                    
                    mainPanel.revalidate();
                    mainPanel.repaint();
                    mainPanel.add(notsuccess);
                    mainPanel.add(notsuccess2);
                    
                    JLabel backButton2 = new JLabel("Back");
                    backButton2.setBounds(590, 410, 150, 30);
     
                    ImageIcon buttonBack2 = new ImageIcon("buttonMain.png");
                    JButton backbuttonImage2 = new JButton(buttonBack2);
                    backbuttonImage2.setBounds(530, 400, 160, 50);
                    backbuttonImage2.setOpaque(false);
                    backbuttonImage2.setContentAreaFilled(false);
                    backbuttonImage2.setBorderPainted(false);
                    backbuttonImage2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            mainPanel.removeAll();
                            showMainMenuFrame(account);
                            showOthersFrame(account);
                            showMenuFrame(account);
                            changeBackgroundImage(account);
                            mainPanel.revalidate();
                            mainPanel.repaint();
                        }
                    });
                    mainPanel.add(backButton2);
                    mainPanel.add(backbuttonImage2);
                    mainPanel.add(loan);
                    defaultBackground();
                    changeBackgroundImage(account);
                } else {
                    account.getLoan(loanAmount);
                    account.deposit(loanAmount);
                    mainPanel.removeAll();
                    showMainMenuFrame(account);
                    showOthersFrame(account);
                    
                    JLabel notsuccess = new JLabel("Loan application successful.");
                    notsuccess.setBounds(520, 300, 200, 30);
                    
                    JLabel newbalance = new JLabel("Your loan of RM " + loanAmount + " has been approved ");
                    newbalance.setBounds(490, 330, 600, 30);
                    
                    JLabel newbalance2 = new JLabel("and will be added to your account.");
                    newbalance2.setBounds(510, 360, 600, 30);
                    
                    mainPanel.revalidate();
                    mainPanel.repaint();
                    mainPanel.add(notsuccess);
                    mainPanel.add(newbalance);
                    mainPanel.add(newbalance2);
                    

                    JLabel backButton2 = new JLabel("Back");
                    backButton2.setBounds(590, 410, 150, 30);
     
                    ImageIcon buttonBack2 = new ImageIcon("buttonMain.png");
                    JButton backbuttonImage2 = new JButton(buttonBack2);
                    backbuttonImage2.setBounds(530, 400, 160, 50);
                    backbuttonImage2.setOpaque(false);
                    backbuttonImage2.setContentAreaFilled(false);
                    backbuttonImage2.setBorderPainted(false);
                    backbuttonImage2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            mainPanel.removeAll();
                            showMainMenuFrame(account);
                            showOthersFrame(account);
                            showMenuFrame(account);
                            changeBackgroundImage(account);
                            mainPanel.revalidate();
                            mainPanel.repaint();
                        }
                    });
                    mainPanel.add(backButton2);
                    mainPanel.add(backbuttonImage2);
                    mainPanel.add(loan);
                    defaultBackground();
                    changeBackgroundImage(account);
                }
            }
        });
        mainPanel.add(apply);
        mainPanel.add(applyImage);


        JLabel back = new JLabel("Back");
        back.setBounds(590, 460, 150, 30);
     
        ImageIcon buttonBack = new ImageIcon("buttonMain.png");
        JButton backImage = new JButton(buttonBack);
        backImage.setBounds(520, 450, 160, 50);
        backImage.setOpaque(false);
        backImage.setContentAreaFilled(false);
        backImage.setBorderPainted(false);
        backImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showOthersFrame(account);
                showMenuFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(back);
        mainPanel.add(backImage);
        mainPanel.add(loan);
        defaultBackground();
        changeBackgroundImage(account);
    }
    
    

    private static void showCurrencyExchangeFrame(Account account) {
        JPanel exchange = new JPanel();
        exchange.setLayout(new BoxLayout(exchange, BoxLayout.Y_AXIS));
        exchange.setBounds(400,250,400,253);
        exchange.setOpaque(true);
        exchange.setBackground(Color.lightGray);
        
        String[] currencies = {
            "USD", "Euro", "Japanese Yen", "Canadian Dollar", "Singapore Dollar",
            "Australian Dollar", "Chinese Yuan", "Indian Rupee", "Russian ruble",
            "Indonesian Rupiah", "Saudi riyal"
        };
        
        JLabel CurrencyLabel = new JLabel("Choose which currencies you want to convert:");
        CurrencyLabel.setBounds(460, 250, 400, 30);
        mainPanel.add(CurrencyLabel);

        JComboBox<String> currencyComboBox = new JComboBox<>(currencies);
        currencyComboBox.setBounds(525, 310, 150, 30);
        mainPanel.add(currencyComboBox);


        JLabel convert = new JLabel("Convert");
        convert.setBounds(585, 360, 150, 30);
     
        ImageIcon buttonConvert = new ImageIcon("buttonMain.png");
        JButton convertImage = new JButton(buttonConvert);
        convertImage.setBounds(525, 350, 160, 50);
        convertImage.setOpaque(false);
        convertImage.setContentAreaFilled(false);
        convertImage.setBorderPainted(false);
        convertImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCurrency = (String) currencyComboBox.getSelectedItem();
                double exchangeRate = 0.00;

                switch (selectedCurrency) {
                    case "USD":
                        exchangeRate = 0.23;
                        break;
                    case "Euro":
                        exchangeRate = 0.21;
                        break;
                    case "Japanese Yen":
                        exchangeRate = 30.31;
                        break;
                    case "Canadian Dollar":
                        exchangeRate = 0.31;
                        break;
                    case "Singapore Dollar":
                        exchangeRate = 0.30;
                        break;
                    case "Australian Dollar":
                        exchangeRate = 0.34;
                        break;
                    case "Chinese Yuan":
                        exchangeRate = 1.56;
                        break;
                    case "Indian Rupee":
                        exchangeRate = 18.58;
                        break;
                    case "Russian Ruble":
                        exchangeRate = 18.50;
                        break;
                    case "Indonesian Rupiah":
                        exchangeRate = 3390.28;
                        break;
                    case "Saudi Riyal":
                        exchangeRate = 0.85;
                        break;
                    default:
                        JLabel invalid = new JLabel("Invalid choice.");
                        invalid.setBounds(540, 320, 200, 30);
                        mainPanel.add(invalid);
                        break;
                }

                double convertedAmount = account.getBalance() * exchangeRate;
                double roundedAmount = Math.round(convertedAmount * 100.0) / 100.0;
                
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showOthersFrame(account);
                
                JLabel balance = new JLabel("Your current balance RM " + String.format("%.2f", account.getBalance()));
                balance.setAlignmentX(Component.CENTER_ALIGNMENT);
                exchange.add(Box.createVerticalStrut(20));
                
                JLabel notsuccess = new JLabel("converted to " + selectedCurrency + " is ");
                notsuccess.setAlignmentX(Component.CENTER_ALIGNMENT);
                exchange.add(Box.createVerticalStrut(20));
                
                JLabel currencies = new JLabel(selectedCurrency + " " + String.format("%.2f", roundedAmount));
                currencies.setAlignmentX(Component.CENTER_ALIGNMENT);
                exchange.add(Box.createVerticalStrut(20));
                
                mainPanel.revalidate();
                mainPanel.repaint();
                exchange.add(balance);
                exchange.add(notsuccess);
                exchange.add(currencies);
                

                JLabel back = new JLabel("Back");
                back.setBounds(600, 410, 150, 30);
                
                ImageIcon buttonBack = new ImageIcon("buttonMain.png");
                JButton backImage = new JButton(buttonBack);
                backImage.setBounds(530, 400, 160, 50);
                backImage.setOpaque(false);
                backImage.setContentAreaFilled(false);
                backImage.setBorderPainted(false);
                backImage.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainPanel.removeAll();
                        showMainMenuFrame(account);
                        showOthersFrame(account);
                        showMenuFrame(account);
                        changeBackgroundImage(account);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                        }
                    });
                    mainPanel.add(back);
                    mainPanel.add(backImage);
                    mainPanel.add(exchange);
                    defaultBackground();
                    changeBackgroundImage(account);
            }
        });
        mainPanel.add(convert);
        mainPanel.add(convertImage);


        JLabel back2 = new JLabel("Back");
        back2.setBounds(595, 420, 150, 30);
     
        ImageIcon buttonBack2 = new ImageIcon("buttonMain.png");
        JButton backImage2 = new JButton(buttonBack2);
        backImage2.setBounds(525, 410, 160, 50);
        backImage2.setOpaque(false);
        backImage2.setContentAreaFilled(false);
        backImage2.setBorderPainted(false);
        
        backImage2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                showMainMenuFrame(account);
                showOthersFrame(account);
                showMenuFrame(account);
                changeBackgroundImage(account);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        mainPanel.add(back2);
        mainPanel.add(backImage2);
        mainPanel.add(exchange);
        defaultBackground();
        changeBackgroundImage(account);
    }
}
