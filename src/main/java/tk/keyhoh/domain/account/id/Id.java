package tk.keyhoh.domain.account.id;

import java.util.UUID;

/**
 * システム内でアカウントを一意に識別するためのID
 */
public class Id {
    private final UUID value;

    {
        value = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Id id = (Id) o;

        return this.value.equals(id.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
