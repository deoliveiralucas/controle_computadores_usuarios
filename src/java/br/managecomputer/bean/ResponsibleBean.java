package br.managecomputer.bean;

import br.managecomputer.dao.ResponsibleDao;
import br.managecomputer.model.Responsible;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "responsibleBean")
@ViewScoped
public class ResponsibleBean implements Serializable{
    private static final long serialVersionUID = 1L;    
    private List responsibles = new ArrayList();
    private Responsible responsible;
    private ResponsibleDao dao;

    //construtor
    public ResponsibleBean() {        
        responsibles = getDao().getAll();
        responsible = new Responsible();
    }
    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        getDao().insert(responsible);
        responsibles = getDao().getAll();
        responsible = new Responsible();
    }

    public void alterar(ActionEvent actionEvent) {
        getDao().update(responsible);
        responsibles = getDao().getAll();
        responsible = new Responsible();
    }

    public void excluir(ActionEvent actionEvent) {
        getDao().remove(responsible);
        responsibles = getDao().getAll();
        responsible = new Responsible();
    }

    //getters and setters
    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }

    public List getResponsibles() {
        return responsibles;
    }

    public void setResponsibles(List responsibles) {
        this.responsibles = responsibles;
    }

    public final ResponsibleDao getDao() {        
        if(dao == null){
            dao = new ResponsibleDao();
        }
        return dao;
    }
}
