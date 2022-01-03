package _3_interface;

public class User implements IUser {

    @Override
    public boolean userLogin(String email, String password) {
        if ( email.equals("ali@ali.com") && password.equals("12345") ) {
            return true;
        }
        return false;
    }

    @Override
    public String profileName(int userID) {
        if ( userID == 100 ) {
            return "Ali Bilmem";
        }
        return null;
    }

    @Override
    public String emailName(int userID) {
        return null;
    }

    @Override
    public String companyName(int userID) {
        int sm = sum(10, 55);
        System.out.println("Sum : " + sm );
        return null;
    }


}
