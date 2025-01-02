package clients.customer;

import catalogue.Basket;
import catalogue.BetterBasket;
import clients.Picture;
import middle.MiddleFactory;
import middle.StockReader;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Implements the Customer view.
 */

public class CustomerView implements Observer {
  private static final int H = 600, W = 600;

  private final JTextField searchBar = new JTextField();
  private final JButton searchButton = new JButton("Search");

  private CustomerController customerController = null;



  /**
   * Construct the view
   * @param rpc   Window in which to construct
   * @param mf    Factor to deliver order and stock objects
   * @param x     x-cordinate of position of window on screen
   * @param y     y-cordinate of position of window on screen
   */

  public CustomerView( RootPaneContainer rpc, MiddleFactory mf, int x, int y ) {
    Container cp = rpc.getContentPane();
    Container rootWindow = (Container) rpc;
    cp.setLayout(null);
    rootWindow.setSize(H, W);
    rootWindow.setLocation(x, y);

    searchBar.setBounds(10, 10, 280, 40);
    cp.add(searchBar);

    searchButton.setBounds(300, 10, 80, 40);
    searchButton.addActionListener(e -> customerController.doCheck(searchBar.getText()));
    cp.add(searchButton);

    rootWindow.setVisible(true);
    searchBar.requestFocus();
  }

   /**
   * The controller object, used so that an interaction can be passed to the controller
   * @param c   The controller
   */

  public void setController( CustomerController c ) {
    customerController = c;
  }

  public void update( Observable o, Object arg ) {
    System.out.println( arg );

  }

}