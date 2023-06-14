package entities;
import jakarta.persistence.*;
import java.util.Objects;
@Entity
public class Zakaz {
    @Basic
    @Column(name = "total")
    private Integer total;
    @Basic
    @Column(name = "order_details")
    private String orderDetails;

    @Override
    public String toString() {
        return "Zakaz{" +
                "total=" + total +
                ", orderDetails='" + orderDetails + '\'' +
                ", orderNumber=" + orderNumber +
                ", administratorByAdminName=" + administratorByAdminName +
                ", deviceBySerialNumber=" + deviceBySerialNumber +
                ", clientByClientId=" + clientByClientId +
                '}';}
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_number")
    private int orderNumber;
    @ManyToOne
    @JoinColumn(name = "admin_name", referencedColumnName = "admin_name")
    private Administrator administratorByAdminName;
    @ManyToOne
    @JoinColumn(name = "serial_number", referencedColumnName = "serial_number")
    private Device deviceBySerialNumber;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client clientByClientId;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zakaz zakaz = (Zakaz) o;
        return orderNumber == zakaz.orderNumber && Objects.equals(total, zakaz.total) && Objects.equals(orderDetails, zakaz.orderDetails);}
    @Override
    public int hashCode() {
        return Objects.hash(total, orderDetails, orderNumber);
    }
    public Administrator getAdministratorByAdminName() {
        return administratorByAdminName;
    }
    public void setAdministratorByAdminName(Administrator administratorByAdminName) {
        this.administratorByAdminName = administratorByAdminName;}
    public Device getDeviceBySerialNumber() {
        return deviceBySerialNumber;
    }
    public void setDeviceBySerialNumber(Device deviceBySerialNumber) {
        this.deviceBySerialNumber = deviceBySerialNumber;}
    public Client getClientByClientId() {
        return clientByClientId;
    }
    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }}
