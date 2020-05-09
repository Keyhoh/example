package tk.keyhoh.domain.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {
    @Test
    void accountEquality() {
        var account1 = new Account();
        assertTrue(account1.equals(account1));
        assertFalse(account1.equals(new Account()));
        assertFalse(account1.equals(null));
    }
}
