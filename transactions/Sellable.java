package game.transactions;
/**
 * A sellable class to determine sell price and way to display it along with it's name
 * @author Ian Teoh, Ho Wai Leong, Yash Kumar
 */
public interface Sellable
{
    /**
     * getter for seeling price
     * @return the selling price
     */
    int getSellPrice();
    /**
     * Display the sell price with $ sign
     * @return $sign and getsellPrice()
     */
    String showSellOption();
    /**
     * Name of the item we want to sell
     * @return name of weapon
     */
    String getSellName();
}
