package entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Client {
    @Basic
    @Column(name = "login")
    private String login;
    @Basic
    @Column(name = "password")
    private String password;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @OneToMany(mappedBy = "clientByClientId")
    private Collection<Zakaz> zakazsById;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(login, client.login) && Objects.equals(password, client.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, id);
    }

    public Collection<Zakaz> getZakazsById() {
        return zakazsById;
    }

    @Override
    public String toString() {
        return "Client{" +
                "login='" + login + '\'' +
                ", id=" + id +
                '}';
    }

    public void setZakazsById(Collection<Zakaz> zakazsById) {
        this.zakazsById = zakazsById;
    }
}
