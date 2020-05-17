package tk.keyhoh.domain.account;

import tk.keyhoh.domain.account.id.Id;
import tk.keyhoh.domain.account.name.Name;
import tk.keyhoh.domain.account.password.Password;

public interface IAccountRepository {
    void save(Account account, Password password);
    Account find(Id id);
    boolean exists(Id id, Password password);
    boolean exists(Name name, Password password);
}
