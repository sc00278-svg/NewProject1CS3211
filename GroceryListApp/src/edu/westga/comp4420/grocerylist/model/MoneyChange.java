package edu.westga.comp4420.grocerylist.model;

/**
 * Creates a new item of Financial value with a name value and type.
 *
 * @author sc00278
 */
public class MoneyChange {
  private String name;
  private double amount;
  private FinancialValueType type;

  /**
   * Initializes a new financial item.
   *
   * @param name the name of the item
   * @param value the value of the item
   * @param type the type of the item
   */
  public MoneyChange(String name, double value, FinancialValueType type) {
    if (name == null) {
      throw new IllegalArgumentException("Must provide a name.");
    }
    if (type == null) {
      throw new IllegalArgumentException("must have a type");
    }

    this.name = name;
    this.amount = value;
    this.type = type;
  }

  /**
   * Return the amount of the item.
   *
   *@precondition none
   *@postcondition none
   *
   * @return the amount of the item
   */
  public double getAmount() {
    return this.amount;
  }

  /**
   * Return the type of value.
   *
   * @return the type of the item
   */
  public FinancialValueType getType() {
    return this.type;
  }

  /**
   * Return the name for the grocery item.
   *
   * @precondition none
   * @postcondition none
   *
   * @return the name for the new grocery item
   */
  public String getName() {
    return this.name;
  }

  /**
   * Overrides the toString method.
   *
   * @return the new to string for this class.
   */
  @Override
  public String toString() {
    return "[" + this.type.toString() + "] " + this.name + ": $" + this.amount;
  }
}
