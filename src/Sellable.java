import java.math.BigDecimal;
/**
 * Sellable Interface
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version  November 1st, 2019
 */
public interface Sellable {
    BigDecimal getCost();
    BigDecimal getPrice();
}
