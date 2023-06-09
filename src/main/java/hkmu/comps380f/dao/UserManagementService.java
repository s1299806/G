package hkmu.comps380f.dao;

import hkmu.comps380f.model.Ticket;
import hkmu.comps380f.model.TicketUser;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManagementService {
    @Resource
    private TicketUserRepository tuRepo;

    @Transactional
    public void createTicketUser(String username, String password, String[] roles ,String emailaddr) {
        TicketUser user = new TicketUser(username, password, roles, emailaddr);
        tuRepo.save(user);
    }
    @Transactional
    public List<TicketUser> getTicketUsers() {
        return tuRepo.findAll();
    }

    @Transactional
    public void delete(String username) {
        TicketUser ticketUser = tuRepo.findById(username).orElse(null);
        if (ticketUser == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found.");
        }
        tuRepo.delete(ticketUser);
    }

    @Transactional
    public List<TicketUser> getUser(String username){
        List<TicketUser> targetUser = new ArrayList<TicketUser>();
        targetUser.add(tuRepo.findById(username).orElse(null));
        return targetUser;
    }

    @Transactional
    public void updateDiscription(String username, String Discription){
        TicketUser targetUser = tuRepo.findById(username).orElse(null);
        targetUser.setDiscription(Discription);
        tuRepo.save(targetUser);
    }
}

