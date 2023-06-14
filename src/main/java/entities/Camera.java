package entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Camera {
    @Id
    @Column(name = "serial_number_id")
    private String serialNumberId;
    @Basic
    @Column(name = "resolution")
    private String resolution;
    @Override
    public String toString() {
        return "Camera{" +
                "resolution='" + resolution + '\'' +
                ", hasWifi=" + hasWifi +
                ", opticalzoom='" + opticalzoom + '\'' +
                '}';}
    @Basic
    @Column(name = "has_wifi")
    private Boolean hasWifi;
    @Basic
    @Column(name = "opticalzoom")
    private String opticalzoom;
    @OneToOne
    @JoinColumn(name = "serial_number_id", referencedColumnName = "serial_number", nullable = false)
    private Device deviceBySerialNumberId;
    public String getSerialNumberId() {
        return serialNumberId;
    }
    public void setSerialNumberId(String serialNumberId) {
        this.serialNumberId = serialNumberId;
    }
    public String getResolution() {
        return resolution;
    }
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    public Boolean getHasWifi() {
        return hasWifi;}
    public void setHasWifi(Boolean hasWifi) {
        this.hasWifi = hasWifi;}
    public String getOpticalzoom() {
        return opticalzoom;}
    public void setOpticalzoom(String opticalzoom) {
        this.opticalzoom = opticalzoom;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return Objects.equals(serialNumberId, camera.serialNumberId) && Objects.equals(resolution, camera.resolution)
                && Objects.equals(hasWifi, camera.hasWifi) && Objects.equals(opticalzoom, camera.opticalzoom);}
    @Override
    public int hashCode() {
        return Objects.hash(serialNumberId, resolution, hasWifi, opticalzoom);}
    public Device getDeviceBySerialNumberId() {
        return deviceBySerialNumberId;}
    public void setDeviceBySerialNumberId(Device deviceBySerialNumberId) {
        this.deviceBySerialNumberId = deviceBySerialNumberId;}}
