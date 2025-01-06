package clients.customer;

import catalogue.Product;
import clients.Style;
import middle.MiddleFactory;
import middle.StockException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Implements the Customer view.
 */

  public class CatalogueView implements Observer {
  private static final int H = 600, W = 600;

  private final JTextField searchBar = new JTextField();

  private final JTextField prodName = new JTextField();
  private final JTextField prodPrice = new JTextField();
  private final JTextField prodQuantity = new JTextField();
  private final JLabel prodNameLabel = new JLabel("Product Name: ");
  private final JLabel prodPriceLabel = new JLabel("Product Price: ");
  private final JLabel prodQuantityLabel = new JLabel("Product Quantity: ");

  private CatalogueController customerController = null;

  private JList<String> productListView;
  private DefaultListModel<String> productListModel;

  /**
   * Construct the view
   * @param rpc   Window in which to construct
   * @param mf    Factor to deliver order and stock objects
   * @param x     x-cordinate of position of window on screen
   * @param y     y-cordinate of position of window on screen
   */

  public CatalogueView(RootPaneContainer rpc, MiddleFactory mf, int x, int y ) {
    Container cp = rpc.getContentPane();
    Container rootWindow = (Container) rpc;
    cp.setLayout(null);
    rootWindow.setSize(H, W);
    rootWindow.setLocation(x, y);
    cp.setBackground(Style.BACKGROUND_COLOR);

    productListModel = new DefaultListModel<>();
    productListView = new JList<>(productListModel);
    JScrollPane productScrollPane = new JScrollPane(productListView);
    productScrollPane.setBounds(10, 10, 570, 250);
    productListView.setBackground(Style.FIELD_COLOR);
    productListView.setForeground(Color.WHITE);
    cp.add(productScrollPane);

    Font labelFont = new Font("", Font.BOLD, 25);
    prodNameLabel.setFont(labelFont);
    prodPriceLabel.setFont(labelFont);
    prodQuantityLabel.setFont(labelFont);

    prodNameLabel.setBounds(10, 270, 200, 20);
    prodPriceLabel.setBounds(10, 350, 200, 20);
    prodQuantityLabel.setBounds(10, 428, 250, 29);
    cp.add(prodNameLabel);
    cp.add(prodPriceLabel);
    cp.add(prodQuantityLabel);


    Font fieldFont = new Font("", Font.BOLD, 25);
    prodName.setFont(fieldFont);
    prodPrice.setFont(fieldFont);
    prodQuantity.setFont(fieldFont);
    Style.styleTextField(prodName);
    Style.styleTextField(prodPrice);
    Style.styleTextField(prodQuantity);

    prodName.setBounds(10, 300, 300, 40);
    prodPrice.setBounds(10, 380, 300, 40);
    prodQuantity.setBounds(10, 460, 300, 40);
    cp.add(prodName);
    cp.add(prodPrice);
    cp.add(prodQuantity);

    productListView.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
          String selectedProduct = productListView.getSelectedValue();
          if (selectedProduct != null) {
            String productNum = extractProductNumber(selectedProduct);
            if (productNum != null) {
              customerController.doCheck(productNum);
            }
          }
        }
      }
    });

    rootWindow.setVisible(true);
    searchBar.requestFocus();
  }

   /**
   * The controller object, used so that an interaction can be passed to the controller
   * @param c   The controller
   */

  public void setController( CatalogueController c ) throws StockException {
    customerController = c;

    customerController.displayAllProducts();
  }

  public void update( Observable o, Object arg ) {
  }

  public void displayProducts(List<Product> products) {
    System.out.println( products.size() );
    productListModel.clear();
    for (Product product : products) {
      String productDetails = "Product Number: " + product.getProductNum() +
                              " - " + product.getDescription();
      productListModel.addElement(productDetails);

    }
  }

  public void updateProductDetails(Product product) {
    prodName.setText(product.getDescription());
    prodPrice.setText(String.valueOf(product.getPrice()));
    prodQuantity.setText(String.valueOf(product.getQuantity()));
  }


  public String extractProductNumber(String productDetails) {
    String[] parts = productDetails.split(" - ");
    if (parts.length > 0) {
      return parts[0].replace("Product Number: ", "").trim();
    }
    return null;
  }



}