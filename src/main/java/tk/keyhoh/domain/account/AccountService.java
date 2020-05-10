package tk.keyhoh.domain.account;

import tk.keyhoh.domain.account.id.Id;
import tk.keyhoh.domain.account.name.Name;
import tk.keyhoh.domain.account.password.IPassword;
import tk.keyhoh.domain.account.password.Password;

public class AccountService {
    private final IPassword iPassword;

    AccountService(IPassword iPassword){
        this.iPassword = iPassword;
    }

    public boolean authenticate(Id id, Password password) {
        return iPassword.exists(id, password);
    }

    public Account createAccount(String name, String password) {
        var account = new Account(new Name(name));
        iPassword.save(account.id, new Password(password));
        return account;
    }
}
