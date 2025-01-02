package clients;

import clients.backDoor.BackDoorController;
import clients.backDoor.BackDoorModel;
import clients.backDoor.BackDoorView;
import clients.cashier.CashierController;
import clients.cashier.CashierModel;
import clients.cashier.CashierView;
import clients.customer.CustomerController;
import clients.customer.CustomerModel;
import clients.customer.CustomerView;
import clients.packing.PackingController;
import clients.packing.PackingModel;
import clients.packing.PackingView;
import middle.LocalMiddleFactory;
import middle.MiddleFactory;
import javax.swing.*;
import java.awt.*;

/**
 * Starts all the clients (user interface)  as a single application.
 * Good for testing the system using a single application.
 * @author  Mike Smith University of Brighton
 * @version 2.0
 * @author  Shine University of Brighton
 * @version year-2024
 */

class Main
{
  public static void main (String args[])
  {
    new Main().begin();
  }

  /**
   * Starts the system (Non distributed)
   */
  public void begin()
  {
    //DEBUG.set(true); /* Lots of debug info */
    MiddleFactory mlf = new LocalMiddleFactory();  // Direct access
    startMenu( mlf );
  }

  public void startMenu(MiddleFactory mlf) {
    JFrame menuWindow = new JFrame("Mini-Store Main Menu");
    menuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menuWindow.setSize(700, 900);
    menuWindow.setLayout(new GridLayout(5, 1));

    JButton customerButton = new JButton("Catalogue Client");
    JButton cashierButton = new JButton("Cashier Client");
    JButton packingButton = new JButton("Packing Client");
    JButton backDoorButton = new JButton("Manager Client");
    JButton exitButton = new JButton("Exit");

    Font buttonFont = new Font("", Font.BOLD, 30);
    customerButton.setFont(buttonFont);
    cashierButton.setFont(buttonFont);
    packingButton.setFont(buttonFont);
    backDoorButton.setFont(buttonFont);
    exitButton.setFont(buttonFont);

    customerButton.addActionListener( e -> startCustomerGUI_MVC( mlf ) );
    cashierButton.addActionListener( e -> cashierLogIn( mlf ) );
    packingButton.addActionListener( e -> warehouseLogIn( mlf ) );
    backDoorButton.addActionListener( e -> managerLogIn( mlf ) );
    exitButton.addActionListener( e -> System.exit(0));

    menuWindow.add(customerButton);
    menuWindow.add(cashierButton);
    menuWindow.add(packingButton);
    menuWindow.add(backDoorButton);
    menuWindow.add(exitButton);

    menuWindow.setLocationRelativeTo(null);
    menuWindow.setVisible(true);
  }

  private void cashierLogIn(MiddleFactory mlf) {
    JFrame logInWindow = new JFrame("Log In Page");
    logInWindow.setSize(600, 600);

    JButton logInButton = new JButton("Log In");
    JButton cancelButton = new JButton("Cancel");
    JLabel usernameLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    logInWindow.setLayout(null);

    Font labelFont = new Font("", Font.BOLD, 30);
    usernameLabel.setFont(labelFont);
    passwordLabel.setFont(labelFont);

    usernameLabel.setBounds(20, 50, 200, 50);
    passwordLabel.setBounds(21, 160, 200, 50);
    usernameField.setBounds(200, 60, 350, 40);
    passwordField.setBounds(200, 170, 350, 40);
    logInButton.setBounds(40, 450, 500, 100);
    cancelButton.setBounds(40, 340, 500, 100);

    logInButton.addActionListener( e -> {
      String username = usernameField.getText();
      String password = new String(passwordField.getPassword());

      String validUsername = "admin";
      String validPassword = "12345";

      if(username.equals(validUsername) && password.equals(validPassword)) {
        JOptionPane.showMessageDialog(logInWindow, "Logged in successfully!");
        logInWindow.dispose();
        startCashierGUI_MVC( mlf );
      } else {
        JOptionPane.showMessageDialog(logInWindow, "Invalid Username/Password!");
      }
    });

    cancelButton.addActionListener( e -> {
      logInWindow.dispose();
    });

    logInWindow.add(logInButton);
    logInWindow.add(cancelButton);
    logInWindow.add(usernameLabel);
    logInWindow.add(passwordLabel);
    logInWindow.add(usernameField);
    logInWindow.add(passwordField);

    logInWindow.setLocationRelativeTo(null);
    logInWindow.setVisible(true);
  }

  private void warehouseLogIn(MiddleFactory mlf) {
    JFrame logInWindow = new JFrame("Log In Page");
    logInWindow.setSize(600, 600);

    JButton logInButton = new JButton("Log In");
    JButton cancelButton = new JButton("Cancel");
    JLabel usernameLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    logInWindow.setLayout(null);

    Font labelFont = new Font("", Font.BOLD, 30);
    usernameLabel.setFont(labelFont);
    passwordLabel.setFont(labelFont);

    usernameLabel.setBounds(20, 50, 200, 50);
    passwordLabel.setBounds(21, 160, 200, 50);
    usernameField.setBounds(200, 60, 350, 40);
    passwordField.setBounds(200, 170, 350, 40);
    logInButton.setBounds(40, 450, 500, 100);
    cancelButton.setBounds(40, 340, 500, 100);

    logInButton.addActionListener( e -> {
      String username = usernameField.getText();
      String password = new String(passwordField.getPassword());

      String validUsername = "admin";
      String validPassword = "12345";

      if(username.equals(validUsername) && password.equals(validPassword)) {
        JOptionPane.showMessageDialog(logInWindow, "Logged in successfully!");
        logInWindow.dispose();
        startPackingGUI_MVC( mlf );
      } else {
        JOptionPane.showMessageDialog(logInWindow, "Invalid Username/Password!");
      }
    });

    cancelButton.addActionListener( e -> {
      logInWindow.dispose();
    });

    logInWindow.add(logInButton);
    logInWindow.add(cancelButton);
    logInWindow.add(usernameLabel);
    logInWindow.add(passwordLabel);
    logInWindow.add(usernameField);
    logInWindow.add(passwordField);

    logInWindow.setLocationRelativeTo(null);
    logInWindow.setVisible(true);
  }

  private void managerLogIn(MiddleFactory mlf) {
    JFrame logInWindow = new JFrame("Log In Page");
    logInWindow.setSize(600, 600);

    JButton logInButton = new JButton("Log In");
    JButton cancelButton = new JButton("Cancel");
    JLabel usernameLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    logInWindow.setLayout(null);

    Font labelFont = new Font("", Font.BOLD, 30);
    usernameLabel.setFont(labelFont);
    passwordLabel.setFont(labelFont);

    usernameLabel.setBounds(20, 50, 200, 50);
    passwordLabel.setBounds(21, 160, 200, 50);
    usernameField.setBounds(200, 60, 350, 40);
    passwordField.setBounds(200, 170, 350, 40);
    logInButton.setBounds(40, 450, 500, 100);
    cancelButton.setBounds(40, 340, 500, 100);

    logInButton.addActionListener( e -> {
      String username = usernameField.getText();
      String password = new String(passwordField.getPassword());

      String validUsername = "admin";
      String validPassword = "12345";

      if(username.equals(validUsername) && password.equals(validPassword)) {
        JOptionPane.showMessageDialog(logInWindow, "Logged in successfully!");
        logInWindow.dispose();
        startBackDoorGUI_MVC( mlf );
      } else {
        JOptionPane.showMessageDialog(logInWindow, "Invalid Username/Password!");
      }
    });

    cancelButton.addActionListener( e -> {
      logInWindow.dispose();
    });

    logInWindow.add(logInButton);
    logInWindow.add(cancelButton);
    logInWindow.add(usernameLabel);
    logInWindow.add(passwordLabel);
    logInWindow.add(usernameField);
    logInWindow.add(passwordField);

    logInWindow.setLocationRelativeTo(null);
    logInWindow.setVisible(true);
  }

  /**
  * start the Customer client, -search product
  * @param mlf A factory to create objects to access the stock list
  */
  public void startCustomerGUI_MVC(MiddleFactory mlf )
  {
    JFrame  window = new JFrame();
    window.setTitle( "Customer Client MVC");
    Dimension pos = PosOnScrn.getPos();
    
    CustomerModel model      = new CustomerModel(mlf);
    CustomerView view        = new CustomerView( window, mlf, pos.width, pos.height );
    CustomerController cont  = new CustomerController( model, view );
    view.setController( cont );

    model.addObserver( view );       // Add observer to the model, ---view is observer, model is Observable
    window.setVisible(true);         // start Screen
  }

  /**
   * start the cashier client - customer check stock, buy product
   * @param mlf A factory to create objects to access the stock list
   */
  public void startCashierGUI_MVC(MiddleFactory mlf )
  {
    JFrame  window = new JFrame();
    window.setTitle( "Cashier Client MVC");
    Dimension pos = PosOnScrn.getPos();
    
    CashierModel model      = new CashierModel(mlf);
    CashierView view        = new CashierView( window, mlf, pos.width, pos.height );
    CashierController cont  = new CashierController( model, view );
    view.setController( cont );

    model.addObserver( view );       // Add observer to the model
    window.setVisible(true);         // Make window visible
    model.askForUpdate();            // Initial display
  }

  /**
   * start the Packing client - for warehouse staff to pack the bought order for customer, one order at a time
   * @param mlf A factory to create objects to access the stock list
   */
  
  public void startPackingGUI_MVC(MiddleFactory mlf)
  {
    JFrame  window = new JFrame();

    window.setTitle( "Packing Client MVC");
    Dimension pos = PosOnScrn.getPos();
    
    PackingModel model      = new PackingModel(mlf);
    PackingView view        = new PackingView( window, mlf, pos.width, pos.height );
    PackingController cont  = new PackingController( model, view );
    view.setController( cont );

    model.addObserver( view );       // Add observer to the model
    window.setVisible(true);         // Make window visible
  }
  
  /**
   * start the BackDoor client - store staff to check and update stock
   * @param mlf A factory to create objects to access the stock list
   */
  public void startBackDoorGUI_MVC(MiddleFactory mlf )
  {
    JFrame  window = new JFrame();

    window.setTitle( "BackDoor Client MVC");
    Dimension pos = PosOnScrn.getPos();
    
    BackDoorModel model      = new BackDoorModel(mlf);
    BackDoorView view        = new BackDoorView( window, mlf, pos.width, pos.height );
    BackDoorController cont  = new BackDoorController( model, view );
    view.setController( cont );

    model.addObserver( view );       // Add observer to the model
    window.setVisible(true);         // Make window visible
  }
  
}
