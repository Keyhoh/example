package tk.keyhoh.domain.account;

import tk.keyhoh.domain.account.id.Id;
import tk.keyhoh.domain.account.name.Name;

public class Account {
    final Id id;

    {
        id = new Id();
    }

    public boolean equals(Account account) {
        return account != null && id.equals(account.id);
    }
}
