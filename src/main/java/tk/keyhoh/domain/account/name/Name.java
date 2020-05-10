package tk.keyhoh.domain.account.name;

public class Name {
    private final String value;

    public Name(String value){
        this.value = value;
    }

    public boolean equals(Name name){
        return name != null && this.value.equals(name.value);
    }
}
