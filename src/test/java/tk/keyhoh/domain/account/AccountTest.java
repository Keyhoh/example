package tk.keyhoh.domain.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {
    AccountService accountService = new AccountService(new AccountRepository());

    @Test
    void accountEquality() {
        var account = accountService.createAccount(null, "password1");
        assertTrue(account.equals(account));
        assertFalse(account.equals(accountService.createAccount(null, "password2")));
        assertFalse(account.equals(null));
    }
}
