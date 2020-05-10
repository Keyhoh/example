package tk.keyhoh.domain.account;

public class Account {
    final Id id;
    final Name name;

    {
        id = new Id();
    }

    Account(Name name){
        this.name = name;
    }

    public boolean equals(Account account) {
        return account != null && id.equals(account.id);
    }
}
