package scb.backend.exception;

public class DeliveryNotFoundException extends RuntimeException{
    public DeliveryNotFoundException(long id) {
        super("Could not find delivery with ID: " + id);
    }

}
