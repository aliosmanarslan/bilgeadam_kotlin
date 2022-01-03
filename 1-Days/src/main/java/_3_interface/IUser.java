package _3_interface;

public interface IUser extends ICompany {

    boolean userLogin( String email, String password );
    String profileName( int userID );
    String emailName( int userID );

    // default key using
    default public int sum( int a, int b ) {
        return a + b;
    }

}
