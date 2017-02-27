/**
 * 
 * @author Recai
 * simple class for Patient's informations
 * getters setters and constructor
 */
public class User {
	private String name;
/**
 * Constructor of Patient
 * @param name
 * @param unit
 */
	public User(String name, Double unit) {
		super();
		this.name = name;
		this.unit = unit;
	}

	private double unit;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getUnit() {
		return unit;
	}

	public void setUnit(Double unit) {
		this.unit = unit;
	}

}
