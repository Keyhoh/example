package tk.keyhoh.domain.account.password;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class Password {
    private final String value;

    public Password(String password) {
        this.value = hash(password);
    }

    private static String hash(String s) {
        return Hashing.sha512().hashString(s, StandardCharsets.UTF_8).toString();
    }

    public boolean equals(Password password) {
        return password != null && this.value.equals(password.value);
    }
}
