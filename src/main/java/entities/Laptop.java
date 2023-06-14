package entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Laptop {
    @Id
    @Column(name = "serial_number_id")
    private String serialNumberId;
    @Override
    public String toString() {
        return "Laptop{" +
                "gpu='" + gpu + '\'' +
                ", diagonal='" + diagonal + '\'' +
                ", deviceBySerialNumberId=" + deviceBySerialNumberId +
                '}';}
    @Basic
    @Column(name = "cpu")
    private String cpu;
    @Basic
    @Column(name = "gpu")
    private String gpu;
    @Basic
    @Column(name = "diagonal")
    private String diagonal;
    @OneToOne
    @JoinColumn(name = "serial_number_id", referencedColumnName = "serial_number", nullable = false)
    private Device deviceBySerialNumberId;

    public String getSerialNumberId() {
        return serialNumberId;
    }

    public void setSerialNumberId(String serialNumberId) {
        this.serialNumberId = serialNumberId;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return Objects.equals(serialNumberId, laptop.serialNumberId) && Objects.equals(cpu, laptop.cpu)
                && Objects.equals(gpu, laptop.gpu) && Objects.equals(diagonal, laptop.diagonal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumberId, cpu, gpu, diagonal);
    }

    public Device getDeviceBySerialNumberId() {
        return deviceBySerialNumberId;
    }

    public void setDeviceBySerialNumberId(Device deviceBySerialNumberId) {
        this.deviceBySerialNumberId = deviceBySerialNumberId;
    }
}
