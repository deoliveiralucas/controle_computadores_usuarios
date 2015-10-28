package br.managecomputer.bean;

import br.managecomputer.dao.ComputerUserDao;
import br.managecomputer.model.ComputerUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "computerUserBean")
@ViewScoped
public class ComputerUserBean implements Serializable{
    private static final long serialVersionUID = 1L;    
    private List computerUsers = new ArrayList();
    private ComputerUser computerUser;    
    private ComputerUserDao dao;

    //construtor
    public ComputerUserBean() {        
        computerUsers = getDao().getAll();
        computerUser = new ComputerUser();
    }
    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        getDao().insert(computerUser);
        computerUsers = getDao().getAll();
        computerUser = new ComputerUser();
    }

    public void alterar(ActionEvent actionEvent) {
        getDao().update(computerUser);
        computerUsers = getDao().getAll();
        computerUser = new ComputerUser();
    }

    public void excluir(ActionEvent actionEvent) {
        getDao().remove(computerUser);
        computerUsers = getDao().getAll();
        computerUser = new ComputerUser();
    }

    //getters and setters
    public ComputerUser getComputerUser() {
        return computerUser;
    }

    public void setComputerUser(ComputerUser computer) {
        this.computerUser = computer;
    }

    public List getComputerUsers() {
        return computerUsers;
    }

    public void setComputerUsers(List computers) {
        this.computerUsers = computers;
    }

    public final ComputerUserDao getDao() {        
        if(dao == null){
            dao = new ComputerUserDao();
        }
        return dao;
    }
}
