package hkmu.comps380f.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class TicketUser {
    @Id
    private String username;
    private String password;
    @Column
    private String discription;
    @Column
    private String emailaddr;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRole> roles = new ArrayList<>();
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();
    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;

    public TicketUser() {}
    public TicketUser(String username, String password, String[] roles, String emailaddr) {
        this.username = username;
        this.password = "{noop}" + password;
        this.emailaddr = emailaddr;
        for (String role : roles) {
            this.roles.add(new UserRole(this, role));
        }
    }

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

    public String getDiscription() { return discription; }

    public void setDiscription(String discription) { this.discription = discription; }

    public  String getEmailaddr(){ return  emailaddr; }

    public void setEmailaddr(String emailaddr) { this.emailaddr = emailaddr; }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

