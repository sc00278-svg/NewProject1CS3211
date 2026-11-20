package edu.westga.comp4420.grocerylist.test.model.groceryitem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.westga.comp4420.grocerylist.model.FinancialValueType;
import edu.westga.comp4420.grocerylist.model.MoneyChange;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TestConstructor {
  @Test
  void testWhenValidParams() {
    MoneyChange change = new MoneyChange("name", 1.00, FinancialValueType.expense);

    assertEquals(change.getName(), "name", "checking the name");
    assertEquals(change.getAmount(), 1.0, "chcking the amount");
    assertEquals(change.getType(), FinancialValueType.expense);
  }

  @Test
  void testWhenInvalidName() {
    assertThrows(IllegalArgumentException.class, () -> {
      new MoneyChange(null, 1.0, FinancialValueType.expense);
    });
  }

  @Test
  void testWhenInvalidType() {
    assertThrows(IllegalArgumentException.class, () -> {
      new MoneyChange("name", 1.0, null);
    });
  }
}
