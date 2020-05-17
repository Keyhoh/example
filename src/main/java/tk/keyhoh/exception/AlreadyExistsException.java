package tk.keyhoh.exception;

import java.text.MessageFormat;

public class AlreadyExistsException extends Exception {
    public AlreadyExistsException(Object id) {
        super((new MessageFormat("There is already an object identified by {0}.")).format(new Object[] {id}));
    }
}
