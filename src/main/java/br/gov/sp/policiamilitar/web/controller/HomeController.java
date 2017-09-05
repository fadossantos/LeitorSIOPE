package br.gov.sp.policiamilitar.web.controller;

import br.gov.sp.policiamilitar.business.entities.Conta;
import br.gov.sp.policiamilitar.web.mail.SmtpMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    SmtpMailSender smtpMailSender;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/construcao", method = RequestMethod.GET)
    public ModelAndView construcao() {
        return new ModelAndView("construcao");
    }

    @RequestMapping(value = "/menuNavegacao", method = RequestMethod.GET)
    public ModelAndView menuNavegacao() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/_menuNavegacao");
        return mav;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home/home");
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home/login");
        mav.addObject("formLogin", new Conta());
        mav.addObject("message", "");
        return mav;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/enviaemail", method = RequestMethod.GET)
    public String enviaemail() {
        try {
            smtpMailSender.send("murilow@gmail.com", "teste email", "Email enviado do site.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    public HttpEntity<byte[]> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String arquivoCSV = file.getOriginalFilename();
        BufferedReader in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(file.getBytes())));
        String linha;
        List<String> responseData = new ArrayList<String>();
        String registro = null;
        String nome= null;
        String cargo= null;
        String SalarioBase= null;
        String SalarioBruto= null;
        String AuxilioAlimentacao= null;
        String SalarioSemAuxilioAlimentacao= null;
        String IPR= null;
        String CAPEP= null;
        String INSS= null;
        String FGTS= null;
        String nomeEscola= null;
        String codigoEscolaPrefeitura= null;



        while ((linha = in.readLine()) != null) {
            if (linha.matches(".*\\d{2}\\.\\d{2}\\.\\d{2}\\.\\d{2}.*")){
                codigoEscolaPrefeitura = linha.substring(20,32).trim();
                nomeEscola = linha.substring(36,150).trim();
            }

            if (linha.matches("^\\*\\d{2}\\.\\d{3}\\.\\d{1}.*")){
                 registro = linha.substring(1,9).trim();
                 nome = linha.substring(10,51).trim();
                 cargo = linha.substring(51,79).trim();
                 SalarioBase = linha.substring(79,89).replace(".","").trim();
                 SalarioBruto = linha.substring(89,100).replace(".","").trim();
                 AuxilioAlimentacao = linha.substring(101,110).replace(".","").trim();
                 SalarioSemAuxilioAlimentacao = linha.substring(111,122).replace(".","").trim();
                 IPR = linha.substring(123,133).replace(".","").trim();
                 CAPEP = linha.substring(134,144).replace(".","").trim();
                 INSS = linha.substring(145,155).replace(".","").trim();
                 FGTS = linha.substring(156,166).replace(".","").trim();
                System.out.printf("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;\n", registro,nome,cargo,SalarioBase,SalarioBruto,AuxilioAlimentacao,SalarioSemAuxilioAlimentacao,
                        IPR,CAPEP,INSS,FGTS,codigoEscolaPrefeitura, nomeEscola);
            }

            responseData.add(linha);
        }
        for (String line:responseData) {
         //   System.out.println(line);
        }
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_PDF);
        header.set(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=arquivo.txt");
        header.setContentLength(arquivoCSV.getBytes().length);
        return new HttpEntity<byte[]>(arquivoCSV.getBytes(), header);
    }

}