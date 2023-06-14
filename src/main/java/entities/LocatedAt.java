package entities;

import jakarta.persistence.*;


@Entity
@Table(name = "located_at", schema = "public", catalog = "electronics_shop")
public class LocatedAt {
    @ManyToOne
    @JoinColumn(name = "street", referencedColumnName = "street")
    private ShopAddress shopAddressByStreet;
    @ManyToOne
    @JoinColumn(name = "serial_number", referencedColumnName = "serial_number")
    private Device deviceBySerialNumber;
    @Id
    private Long id;

    public ShopAddress getShopAddressByStreet() {
        return shopAddressByStreet;
    }

    public void setShopAddressByStreet(ShopAddress shopAddressByStreet) {
        this.shopAddressByStreet = shopAddressByStreet;
    }

    public Device getDeviceBySerialNumber() {
        return deviceBySerialNumber;
    }

    public void setDeviceBySerialNumber(Device deviceBySerialNumber) {
        this.deviceBySerialNumber = deviceBySerialNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
