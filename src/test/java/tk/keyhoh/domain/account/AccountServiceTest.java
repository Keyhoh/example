package tk.keyhoh.domain.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tk.keyhoh.domain.account.password.Password;

import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {
    private static final AccountService accountService = new AccountService(new PasswordRepository());

    @Test
    void createAccountWithPassword() {
        Account account = accountService.createAccount("name", "password");
        assertTrue(account != null && account.getClass().equals(Account.class));
    }

    @ParameterizedTest
    @CsvSource({
            "Correct Password,   Correct Password,  true",
            "Correct Password, InCorrect Password, false",
    })
    void authenticateAccount(String expected, String actual, boolean result) {
        var account = accountService.createAccount("name", expected);
        var password = new Password(actual);
        assertEquals(accountService.authenticate(account.id, password), result);
    }
}
