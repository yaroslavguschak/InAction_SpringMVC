package com.github.yaroslavguschak.slownews.controllers;

import com.github.yaroslavguschak.slownews.classes.Article;
import com.github.yaroslavguschak.slownews.classes.DAO;
import com.github.yaroslavguschak.slownews.classes.Rss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.WebTarget;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
public class IndexController {
    @Autowired
    public WebTarget webTarget;


    @RequestMapping(value = "/news.html")
    public ModelAndView showNews(){

        final ModelAndView mav = new ModelAndView("WEB-INF/views/index.jsp");

        Rss rss = webTarget.request().get().readEntity(com.github.yaroslavguschak.slownews.classes.Rss.class);
        System.out.println(rss.toString());
        mav.addObject("rss", rss);
        return mav;



    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        DAO dao = new DAO();
//        //WebTargetFabrique webServiceMain = new WebTargetFabrique();
//        List <Article> articleList = dao.getNews();
//
//        String articleListID = UUID.randomUUID().toString();
//
//        HttpSession httpSession = req.getSession();
//        String httpSessionId = httpSession.getId();
//
//        System.out.println("httpSessionId" + httpSessionId);
//        System.out.println("articleListID" + articleListID);
//
//        httpSession.setAttribute(articleListID, articleList);
//        req.setAttribute("articleListID", articleListID);
//
//        req.setAttribute("allNews", articleList);
//
//        RequestDispatcher requestDispatcher;
//        requestDispatcher = req.getRequestDispatcher("/index.jsp");
//        requestDispatcher.forward(req,resp);
//    }

}
