package java.homework3.db_patterns;

import java.util.UUID;

public class IdNotFoundException extends Exception {
    public IdNotFoundException(UUID id){
        super(id + " not found");
    }
}
