package br.managecomputer.bean;

import br.managecomputer.dao.UserSupportDao;
import br.managecomputer.model.UserSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "userSupportBean")
@ViewScoped
public class UserSupportBean implements Serializable{
    private static final long serialVersionUID = 1L;    
    private List usersSupport = new ArrayList();
    private UserSupport userSupport;
    private UserSupportDao dao;

    //construtor
    public UserSupportBean() {
        usersSupport = getDao().getAll();
        userSupport = new UserSupport();
    }
    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        getDao().insert(userSupport);
        usersSupport = getDao().getAll();
        userSupport = new UserSupport();
    }

    public void alterar(ActionEvent actionEvent) {
        getDao().update(userSupport);
        usersSupport = getDao().getAll();
        userSupport = new UserSupport();
    }

    public void excluir(ActionEvent actionEvent) {
        getDao().remove(userSupport);
        usersSupport = getDao().getAll();
        userSupport = new UserSupport();
    }

    //getters and setters
    public UserSupport getResponsible() {
        return userSupport;
    }

    public void setResponsible(UserSupport userSupport) {
        this.userSupport = userSupport;
    }

    public List getResponsibles() {
        return usersSupport;
    }

    public void setResponsibles(List usersSupport) {
        this.usersSupport = usersSupport;
    }

    public final UserSupportDao getDao() {        
        if(dao == null){
            dao = new UserSupportDao();
        }
        return dao;
    }
}
