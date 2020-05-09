package tk.keyhoh.domain.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {
    @Test
    void accountEquality() {
        var account = new Account();
        assertTrue(account.equals(account));
        assertFalse(account.equals(new Account()));
        assertFalse(account.equals(null));
    }
}
