package sample.action;



import java.util.List;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import sample.entity.Syain;
import sample.form.SyainForm;
import sample.service.SyainService;

public class SyainAction {


    public List<Syain> syainItems;

    @ActionForm
    @Resource
    protected SyainForm syainForm;

    @Resource
    protected SyainService syainService;

    public JdbcManager jdbcManager;

    @Execute(validator = false)
    public String index() {
        syainItems = syainService.findAll();

        return "list.jsp";
    }





    @Execute(validator = false, urlPattern = "show/{id}")
    public String show() {
        Syain entity = syainService.findById(Integer.valueOf(syainForm.id));
        Beans.copy(entity, syainForm).dateConverter("yyyy-MM-dd").execute();
        return "show.jsp";
    }

    @Execute(validator = false, urlPattern = "edit/{id}")
    public String edit() {
        Syain entity = syainService.findById(Integer.valueOf(syainForm.id));
        Beans.copy(entity, syainForm).dateConverter("yyyy-MM-dd").execute();
        return "edit.jsp";
    }

    @Execute(validator = false)
    public String create() {
        return "create.jsp";
    }

    @Execute(validator = false, urlPattern = "delete/{id}", redirect = true)
    public String delete() {
        Syain entity = Beans.createAndCopy(Syain.class, syainForm).dateConverter("yyyy-MM-dd").execute();
        syainService.delete(entity);
        return "/syain/";
    }

    @Execute(input = "create.jsp", redirect = true)
    public String insert() {
        Syain entity = Beans.createAndCopy(Syain.class, syainForm).dateConverter("yyyy-MM-dd").execute();
        syainService.insert(entity);
        return "/syain/";
    }

    @Execute(input = "edit.jsp", redirect = true)
    public String update() {
        Syain entity = Beans.createAndCopy(Syain.class, syainForm).dateConverter("yyyy-MM-dd").execute();
        syainService.update(entity);
        return "/syain/";
    }
}