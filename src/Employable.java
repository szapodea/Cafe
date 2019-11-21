import java.math.BigDecimal;
/**
 * Employable Interface
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version  November 1st, 2019
 */
public interface Employable {
    BigDecimal getHourlyWage();

    void setHourlyWage(BigDecimal hourlyWage) throws NullPointerException, IllegalArgumentException;

}
