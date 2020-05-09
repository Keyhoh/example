package tk.keyhoh.domain.account;

public class Account {
    final Id id;

    {
        id = new Id();
    }

    public boolean equals(Account account) {
        return account != null && id.equals(account.id);
    }
}
