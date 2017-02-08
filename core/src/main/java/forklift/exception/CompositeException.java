package forklift.exception;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * @Author talpers
 */
public class CompositeException extends Exception {
    private final List<Exception> exceptions;

    public CompositeException(Exception ... exceptions) {
        this.exceptions = Arrays.asList(exceptions);
    }

    public CompositeException(List<Exception> exceptions) {
        this.exceptions = exceptions;
    }

    @Override
    public void printStackTrace(PrintStream s) {
        if (exceptions == null) {
            return;
        }
        exceptions.forEach(exception -> exception.printStackTrace(s));
    }

    @Override
    public String getMessage() {
        if (exceptions == null) {
            return "";
        }
        return exceptions.stream().map(Exception::getMessage).reduce("", (a, b) -> a + ", " + b);
    }
}
