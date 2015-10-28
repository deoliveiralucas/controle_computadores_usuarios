package br.managecomputer.bean;

import br.managecomputer.dao.ComputerDao;
import br.managecomputer.model.Computer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "computerBean")
@ViewScoped
public class ComputerBean implements Serializable{
    private static final long serialVersionUID = 1L;    
    private List computers = new ArrayList();
    private Computer computer;    
    private ComputerDao dao;

    //construtor
    public ComputerBean() {        
        computers = getDao().getAll();
        computer = new Computer();
    }
    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        getDao().insert(computer);
        computers = getDao().getAll();
        computer = new Computer();
    }

    public void alterar(ActionEvent actionEvent) {
        getDao().update(computer);
        computers = getDao().getAll();
        computer = new Computer();
    }

    public void excluir(ActionEvent actionEvent) {
        getDao().remove(computer);
        computers = getDao().getAll();
        computer = new Computer();
    }

    //getters and setters
    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public List getComputers() {
        return computers;
    }

    public void setComputers(List computers) {
        this.computers = computers;
    }

    public final ComputerDao getDao() {        
        if(dao == null){
            dao = new ComputerDao();
        }
        return dao;
    }
}
