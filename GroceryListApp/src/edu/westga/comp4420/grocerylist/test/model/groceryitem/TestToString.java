package edu.westga.comp4420.grocerylist.test.model.groceryitem;

import static org.junit.Assert.assertEquals;

import edu.westga.comp4420.grocerylist.model.FinancialValueType;
import edu.westga.comp4420.grocerylist.model.MoneyChange;
import org.junit.jupiter.api.Test;

class TestToString {
  @Test
  void testToString() {
    MoneyChange item = new MoneyChange("name", 1.0, FinancialValueType.income);

    String actual = item.toString();

    assertEquals(actual, "[income] name: $1.0");
  }
}
