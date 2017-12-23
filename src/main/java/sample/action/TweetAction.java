package sample.action;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import sample.entity.Tweet;
import sample.form.TweetForm;
import sample.service.TweetService;

public class TweetAction {

    public List<Tweet> tweetItems;

    @ActionForm
    @Resource
    protected TweetForm tweetForm;

    @Resource
    protected TweetService tweetService;

    public JdbcManager jdbcManager;

    @Execute(validator = false)
    public String index() {
        tweetItems = tweetService.findAll();
        return "list.jsp";
    }





    @Execute(validator = false, urlPattern = "show/{id}")
    public String show() {
        Tweet entity = tweetService.findById(Integer.valueOf(tweetForm.id));
        Beans.copy(entity, tweetForm).dateConverter("yyyy-MM-dd").execute();
        return "show.jsp";
    }

    @Execute(validator = false, urlPattern = "edit/{id}")
    public String edit() {
    	Tweet entity = tweetService.findById(Integer.valueOf(tweetForm.id));
        Beans.copy(entity, tweetForm).dateConverter("yyyy-MM-dd").execute();
        return "edit.jsp";
    }

    @Execute(validator = false)
    public String create() {
        return "create.jsp";
    }

    @Execute(validator = false, urlPattern = "delete/{id}", redirect = true)
    public String delete() {
    	Tweet entity = Beans.createAndCopy(Tweet.class, tweetForm).dateConverter("yyyy-MM-dd").execute();
        tweetService.delete(entity);
        return "/syain/";
    }

    @Execute(input = "create.jsp", redirect = true)
    public String insert() {
    	Tweet entity = Beans.createAndCopy(Tweet.class, tweetForm).dateConverter("yyyy-MM-dd").execute();
        tweetService.insert(entity);
        return "/syain/";
    }

    @Execute(input = "edit.jsp", redirect = true)
    public String update() {
    	Tweet entity = Beans.createAndCopy(Tweet.class, tweetForm).dateConverter("yyyy-MM-dd").execute();
        tweetService.update(entity);
        return "/syain/";
    }
}
