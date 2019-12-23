package java.homework3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.homework3.services.ClientSevice;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private ClientSevice clientSevice;

    @Autowired
    public void setClientSevice(ClientSevice clientSevice) {
        this.clientSevice = clientSevice;
    }

    @GetMapping
    public String showClients(Model model){
        model.addAttribute("clients", clientSevice.findAll());
        return "clinets_page";
    }
}
