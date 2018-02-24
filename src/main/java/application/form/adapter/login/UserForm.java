/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.form.adapter.login;

/**
 *
 * @author taleb
 * 
 * on appel cette class un DTO : Data Transfert Object elle aide spring a communiquer avec les formulaire 
 * html et les convertir en objet de class grace a thymleaf 
 * 
 * la condition : les noms de variable dans cette class doit etre les meme que les nom des champ de formulaire (th:field)
 * 
 */
public class UserForm {


    private Long id;
    
    // <input type="text"  th:placeholder="#{login.user}" th:field="*{username}"  placeholder="name"/>
    private String username;

    private String password;

    private String email;

    public UserForm(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserForm() {
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
}
