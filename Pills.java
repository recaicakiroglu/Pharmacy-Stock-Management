/**
 * 
 * @author Recai
 * simple class for Pill's informations
 * getters setters and constructor
 */
import java.util.Date;

public class Pills {
	private String name;
	private String socialSecurity;
	private Date effectiveDate;
	private Date expiryDate;
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}
	/**
	 * Constructor for Pill
	 * @param name
	 * @param socialSecurity
	 * @param effectiveDate
	 * @param expiryDate
	 * @param price
	 */
	public Pills(String name, String socialSecurity, Date effectiveDate, Date expiryDate, double price) {
		super();
		this.name = name;
		this.socialSecurity = socialSecurity;
		this.effectiveDate = effectiveDate;
		this.expiryDate = expiryDate;
		this.price = price;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
