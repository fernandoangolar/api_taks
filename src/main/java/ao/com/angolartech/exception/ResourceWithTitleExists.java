package ao.com.angolartech.exception;

public class ResourceWithTitleExists extends RuntimeException {

    public ResourceWithTitleExists(String message) {
        super(message);
    }
}
