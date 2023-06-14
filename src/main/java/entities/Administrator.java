package entities;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQuery(name = "Administrator.getAll", query = "SELECT a FROM Administrator a")
public class Administrator {
    @Override
    public String toString() {
        return "Administrator{" +
                "adminName='" + adminName + '\'' +
                '}';}
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "admin_name")
    private String adminName;
    @OneToMany(mappedBy = "administratorByAdminName")
    private Collection<Zakaz> zakazsByAdminName;
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(adminName, that.adminName);}
    @Override
    public int hashCode() {
        return Objects.hash(adminName);
    }
    public Collection<Zakaz> getZakazsByAdminName() {
        return zakazsByAdminName;
    }
    public void setZakazsByAdminName(Collection<Zakaz> zakazsByAdminName) {
        this.zakazsByAdminName = zakazsByAdminName;}}
