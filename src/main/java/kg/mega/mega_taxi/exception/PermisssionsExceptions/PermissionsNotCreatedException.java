package kg.mega.mega_taxi.exception.PermisssionsExceptions;



public class PermissionsNotCreatedException extends RuntimeException {
    public PermissionsNotCreatedException(){
        super("Permissions not created. ");
    }

    public PermissionsNotCreatedException(Throwable  cause){
        super("Permissions not created: " + cause);
    }
}
