package tk.keyhoh.domain.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tk.keyhoh.domain.account.name.Name;
import tk.keyhoh.domain.account.password.Password;
import tk.keyhoh.exception.AlreadyExistsException;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountServiceTest {
    private static final AccountService accountService = new AccountService(new AccountRepository(), new NameRepository());

    @Test
    void createAccountWithPassword() throws AlreadyExistsException {
        Account account = accountService.createAccount("name", "password");
        assertTrue(account != null && account.getClass().equals(Account.class));
    }

    @ParameterizedTest
    @CsvSource({
            "Correct Password,   Correct Password,  true",
            "Correct Password, InCorrect Password, false",
    })
    void authenticateAccount(String expected, String actual, boolean result) throws AlreadyExistsException {
        var account = accountService.createAccount(UUID.randomUUID().toString(), expected);
        var password = new Password(actual);
        assertEquals(accountService.authenticate(account.id, password), result);
    }

    @ParameterizedTest
    @CsvSource({
            "Correct Password,   Correct Password,  true",
            "Correct Password, InCorrect Password, false",
    })
    void authenticateAccountWithName(String expected, String actual, boolean result) throws AlreadyExistsException {
        var name = UUID.randomUUID().toString();
        var account = accountService.createAccount(name, expected);
        var password = new Password(actual);
        assertEquals(accountService.authenticate(new Name(name), password), result);
    }
}
