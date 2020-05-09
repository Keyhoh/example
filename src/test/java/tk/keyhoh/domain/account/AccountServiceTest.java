package tk.keyhoh.domain.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountServiceTest {
    private static final AccountService accountService = new AccountService();

    @Test
    void createAccount() {
        Account account = accountService.createAccount();
        assertTrue(account != null && account.getClass().equals(Account.class));
    }
}
