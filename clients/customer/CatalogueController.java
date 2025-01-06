package clients.customer;

import catalogue.Product;
import dbAccess.StockR;
import middle.StockException;
import middle.StockReader;

import java.util.List;

/**
 * The Customer Controller
 */

public class CatalogueController
{
  private CatalogueModel model = null;
  private CatalogueView view  = null;

  /**
   * Constructor
   * @param model The model 
   * @param view  The view from which the interaction came
   */
  public CatalogueController(CatalogueModel model, CatalogueView view )
  {
    this.view  = view;
    this.model = model;
  }

  /**
   * Check interaction from view
   * @param productNum The product number to be checked
   */
  public void doCheck( String productNum ) {

    try {
      StockReader theStock = model.getStockReader();
      if (theStock.exists(productNum)) {
        Product product = theStock.getDetails(productNum);
        view.updateProductDetails(product);
      } else {
        System.out.println("Product does not exist" + productNum);
      }
    } catch (StockException e) {
      e.printStackTrace();
    }
  }

//  public void checkName( String pName ) {
//    model.checkName(pName);
//  }

  /**
   * Clear interaction from view
   */
  public void doClear()
  {
    model.doClear();
  }

  public void displayAllProducts() throws StockException {
    try {
      List<Product> products = model.getAllProducts();
      view.displayProducts(products);
    } catch (StockException e) {
      System.err.println("ERROR FETCHING PRODUCTS" + e.getMessage());
    }
  }

  
}

