package tk.keyhoh.domain.account;

import tk.keyhoh.domain.account.id.Id;
import tk.keyhoh.domain.account.name.Name;
import tk.keyhoh.domain.account.password.Password;

public class AccountService {
    private final IAccountRepository iAccountRepository;

    AccountService(IAccountRepository iAccountRepository) {
        this.iAccountRepository = iAccountRepository;
    }

    public boolean authenticate(Id id, Password password) {
        return iAccountRepository.exists(id, password);
    }

    public boolean authenticate(Name name, Password password) {
        return iAccountRepository.exists(name, password);
    }

    public Account createAccount(String name, String password) {
        var account = new Account(new Name(name));
        iAccountRepository.save(account, new Password(password));
        return account;
    }
}
