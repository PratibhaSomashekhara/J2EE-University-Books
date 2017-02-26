/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Login Controller
 * @author sas691
 */
@Named
@RequestScoped
public class LoginController extends BaseController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    public LoginController() {
    }

    @PostConstruct
    protected void postConstruct() {
        super.postConstruct();
        // loginController specific things go here
    }

    public String doLogin() {
        try {
            HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
            req.login(username, password);
        } catch (ServletException ex) {
            System.out.println(ex.getMessage());
            LOG.warning("User unable to login: " + username);
            LOG.log(Level.SEVERE, null, ex);
            // set a nicey nice user error message
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bad Login Summary", "Bad Login Detail"));
            // pass the user back to the login page
            return "/login.xhtml";
        }

        // this can force a redirect as opposed to using RD forward
        //return "/vet/welcome.xhtml?faces-redirect=true";

        // this isn't a real solution - we need to accomodate role of user
        // when routing the navigation
        // could be vet, owner, admin, pet, doctor
        return conditionalizeContextPath("welcome.xhtml");
    }

    public String conditionalizeContextPath(String intent) {
        if (isStudent()) {
            return "/students/" + intent;
        } else if (isLibrarian()) {
            return "/librarian/" + intent;
        } else {
            return intent;
        }
    }

    public boolean isStudent() {
        return context.getExternalContext().isUserInRole("students");
    }

    public boolean isLibrarian() {
        return context.getExternalContext().isUserInRole("librarian");
    }
//
//    public boolean isOwner() {
//        return context.getExternalContext().isUserInRole("owner");
//    }

    public String doLogout() {
        try {
            HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
            req.logout();
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
            LOG.warning("Problem with the logout occurred");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bad Logout Summary", "I don't know why on earth we would throw an exception on logout, but you sure did it!  Way to go user!"));
        }
        return "/login.xhtml";
    }

    public String getRemoteUser() {
        return context.getExternalContext().getRemoteUser();
    }

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
