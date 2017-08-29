package br.gov.sp.policiamilitar.web.controller;

import br.gov.sp.policiamilitar.web.mail.SmtpMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    SmtpMailSender smtpMailSender;

    @RequestMapping(value="", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(value="/construcao", method = RequestMethod.GET)
    public ModelAndView construcao(){
        return new ModelAndView("construcao");
    }

    @RequestMapping(value="/menuNavegacao", method = RequestMethod.GET)
    public ModelAndView menuNavegacao() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/_menuNavegacao");
        return mav;
    }

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ArrayList<String> listaPermissoes = new ArrayList<String>();
        for(GrantedAuthority authority:auth.getAuthorities()){
            listaPermissoes.add(authority.getAuthority());
        }
        if(listaPermissoes.contains("Admin")){
            mav.setViewName("redirect:/cliente/gestaoCliente");
        }
        else if(listaPermissoes.contains("User"))
        {
            mav.setViewName("home/homeUsuario");
        }
        else
        {
            mav.setViewName("home/home");
        }
        return mav;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home/login");
        mav.addObject("formLogin", new ContaMvpn());
        mav.addObject("message", "");
        return mav;
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping(value="/enviaemail", method = RequestMethod.GET)
    public String enviaemail () {
        try {
            smtpMailSender.send("murilow@gmail.com", "teste email", "Email enviado do site.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

}