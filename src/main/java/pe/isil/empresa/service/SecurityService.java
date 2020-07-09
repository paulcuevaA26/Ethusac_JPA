package pe.isil.empresa.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

}
