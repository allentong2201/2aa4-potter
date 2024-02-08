package ca.mcscert.se2aa4.demos.potter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class DiscountTest {
    private Cart cart;

    @BeforeEach
    public void initializeCart() {
        cart = new Cart(Book.BOOK1, Book.BOOK2, Book.BOOK3);
    }

    @Test
    public void twoDifferentBooks() {
        Discount discount = new Discount(2, 0.90);
        assertTrue(discount.canBeApplied(cart));
        cart.remove(Book.BOOK1);
        assertTrue(discount.canBeApplied(cart));
        cart.remove(Book.BOOK2);
        assertFalse(discount.canBeApplied(cart));
    }

    @Test
    public void threeDifferentBooks() {
        Discount discount = new Discount(3, 0.90);
        assertTrue(discount.canBeApplied(cart));
        cart.remove(Book.BOOK1);
        assertFalse(discount.canBeApplied(cart));
        cart.remove(Book.BOOK2);
        assertFalse(discount.canBeApplied(cart));
    }
}
