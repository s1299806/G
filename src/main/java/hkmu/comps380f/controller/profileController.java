package hkmu.comps380f.controller;

import hkmu.comps380f.dao.TicketService;
import hkmu.comps380f.dao.UserManagementService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class profileController {
    @Resource
    private UserManagementService umService;
    @Resource
    private TicketService tService;
    public static class Form{
        public String body;
        public String getBody(){ return body; }
        public void setBody(String body){ this.body = body; }
    }
    @GetMapping(value = {""})
    public String profile(ModelMap model, Principal principal){
        model.addAttribute("ticketUsers", umService.getUser(principal.getName()));
        model.addAttribute("ticketDatabase", tService.getTicketsByUser(principal.getName()));
        return "profile";
    }
    @GetMapping("/edit")
    public ModelAndView discription(){ return new ModelAndView("editDiscription", "discriptionForm", new Form()); }
    @PostMapping("/edit")
    public View discription(TicketController.Form form, Principal principal)throws IOException {
        umService.updateDiscription(principal.getName(), form.getBody());
        return new RedirectView("/profile",true);
    }
}
