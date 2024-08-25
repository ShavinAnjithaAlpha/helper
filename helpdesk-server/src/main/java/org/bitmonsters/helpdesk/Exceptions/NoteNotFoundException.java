package org.bitmonsters.helpdesk.Exceptions;

public class NoteNotFoundException extends RuntimeException{
    public NoteNotFoundException(String message) {
        super(message);
    }
}
