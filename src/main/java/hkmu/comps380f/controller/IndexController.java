package hkmu.comps380f.controller;

import hkmu.comps380f.dao.UserManagementService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class IndexController {
    @Resource
    private UserManagementService umService;

    @GetMapping("/")
    public String index() {
        return "redirect:/ticket/list";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/register")
    public ModelAndView register(){ return new ModelAndView("register", "ticketUser", new Form());}
    @PostMapping("/register")
    public String register(Form form) throws IOException {
        umService.createTicketUser(form.getUsername(), form.getPassword(), new String[]{"ROLE_USER"}, form.getEmailaddr());
        return "redirect:/login";
    }

    public static class Form {
        private String username;  private String password; private String emailaddr;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmailaddr(){return emailaddr;}

        public void setEmailaddr(String emailaddr){ this.emailaddr = emailaddr;}
    }
}


