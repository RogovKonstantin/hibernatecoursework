package entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQuery(name = "Device.getAll", query = "SELECT d FROM Device d")
public class Device {
    @Basic
    @Column(name = "brand")
    private String brand;
    @Basic
    @Column(name = "device_name")
    private String deviceName;
    @Override
    public String toString() {
        return "Device{" +
                "brand='" + brand + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", material='" + material + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", serialNumber='" + serialNumber + "}";}
    @Basic
    @Column(name = "material")
    private String material;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "color")
    private String color;
    @Basic
    @Column(name = "price")
    private Integer price;

    @Id
    @Column(name = "serial_number")
    private String serialNumber;
    @OneToOne(mappedBy = "deviceBySerialNumberId")
    private Camera cameraBySerialNumber;
    @OneToOne(mappedBy = "deviceBySerialNumberId")
    private Laptop laptopBySerialNumber;
    @OneToMany(mappedBy = "deviceBySerialNumber")
    private Collection<LocatedAt> locatedAtsBySerialNumber;
    @OneToOne(mappedBy = "deviceBySerialNumberId")
    private Phone phoneBySerialNumber;
    @OneToMany(mappedBy = "deviceBySerialNumber")
    private Collection<Zakaz> zakazsBySerialNumber;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(brand, device.brand) && Objects.equals(deviceName, device.deviceName)
                && Objects.equals(material, device.material) && Objects.equals(description, device.description)
                && Objects.equals(color, device.color) && Objects.equals(price, device.price)
                && Objects.equals(serialNumber, device.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, deviceName, material, description, color, price, serialNumber);
    }

    public Camera getCameraBySerialNumber() {
        return cameraBySerialNumber;
    }

    public void setCameraBySerialNumber(Camera cameraBySerialNumber) {
        this.cameraBySerialNumber = cameraBySerialNumber;
    }

    public Laptop getLaptopBySerialNumber() {
        return laptopBySerialNumber;
    }

    public void setLaptopBySerialNumber(Laptop laptopBySerialNumber) {
        this.laptopBySerialNumber = laptopBySerialNumber;
    }

    public Collection<LocatedAt> getLocatedAtsBySerialNumber() {
        return locatedAtsBySerialNumber;
    }

    public void setLocatedAtsBySerialNumber(Collection<LocatedAt> locatedAtsBySerialNumber) {
        this.locatedAtsBySerialNumber = locatedAtsBySerialNumber;
    }

    public Phone getPhoneBySerialNumber() {
        return phoneBySerialNumber;
    }

    public void setPhoneBySerialNumber(Phone phoneBySerialNumber) {
        this.phoneBySerialNumber = phoneBySerialNumber;
    }

    public Collection<Zakaz> getZakazsBySerialNumber() {
        return zakazsBySerialNumber;
    }

    public void setZakazsBySerialNumber(Collection<Zakaz> zakazsBySerialNumber) {
        this.zakazsBySerialNumber = zakazsBySerialNumber;
    }
}
