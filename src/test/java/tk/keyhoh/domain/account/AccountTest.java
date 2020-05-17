package tk.keyhoh.domain.account;

import org.junit.jupiter.api.Test;
import tk.keyhoh.exception.AlreadyExistsException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {
    AccountService accountService = new AccountService(new AccountRepository(), new NameRepository());

    @Test
    void accountEquality() throws AlreadyExistsException {
        var account = accountService.createAccount("name1", "password1");
        assertTrue(account.equals(account));
        assertFalse(account.equals(accountService.createAccount("name2", "password2")));
        assertFalse(account.equals(null));
    }
}
