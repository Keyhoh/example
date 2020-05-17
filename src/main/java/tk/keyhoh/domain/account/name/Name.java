package tk.keyhoh.domain.account.name;

import java.util.Objects;

public class Name {
    private final String value;

    public Name(String value){
        this.value = value;
    }

    public boolean equals(Name name){
        return name != null && this.value.equals(name.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name = (Name) o;

        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Name{" +
                "value='" + value + '\'' +
                '}';
    }
}
