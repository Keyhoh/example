package tk.keyhoh.domain.account;

public class Account {
    final Id id;
    final Name name;

    {
        id = new Id();
    }

    Account(String name){
        this.name = new Name(name);
    }

    public boolean equals(Account account) {
        return account != null && id.equals(account.id);
    }
}
