package dev.estela.mentoria.Exception;

public class ItemAlreadyExistsException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ItemAlreadyExistsException(String message){
        super(message);
    }
}
