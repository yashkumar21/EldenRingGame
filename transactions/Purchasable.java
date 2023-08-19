package game.transactions;
/**
 * A Purchasable class to determine price and way to display it
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 */
public interface Purchasable
{
    /**
     * getter for the Price it can be Purchase in
     * @return the PurchasePrice
     */
    int getPurchasePrice();
    /**
     * Display the price with $ sign
     * @return $sign and getPurchasePrice()
     */
    String showPurchaseOption();
}

