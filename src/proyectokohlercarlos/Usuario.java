/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectokohlercarlos;

/**
 *
 * @author TecaFondo
 */
public class Usuario {
    
    private String Usr;
    private String pwd;

    public Usuario() {
    }

    public Usuario(String Usr, String pwd) {
        this.Usr = Usr;
        this.pwd = pwd;
    }

    public String getUsr() {
        return Usr;
    }

    public void setUsr(String Usr) {
        this.Usr = Usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    
}
