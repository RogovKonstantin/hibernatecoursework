package entities;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Phone {
    @Id
    @Column(name = "serial_number_id")
    private String serialNumberId;
    @Override
    public String toString() {
        return "Phone{" +
                "ram='" + ram + '\'' +
                ", memory='" + memory + '\'' +
                ", resolution='" + resolution + '\'' +
                '}';}
    @Basic
    @Column(name = "ram")
    private String ram;
    @Basic
    @Column(name = "memory")
    private String memory;
    @Basic
    @Column(name = "resolution")
    private String resolution;
    @OneToOne
    @JoinColumn(name = "serial_number_id", referencedColumnName = "serial_number", nullable = false)
    private Device deviceBySerialNumberId;

    public String getSerialNumberId() {
        return serialNumberId;
    }

    public void setSerialNumberId(String serialNumberId) {
        this.serialNumberId = serialNumberId;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(serialNumberId, phone.serialNumberId) && Objects.equals(ram, phone.ram)
                && Objects.equals(memory, phone.memory) && Objects.equals(resolution, phone.resolution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumberId, ram, memory, resolution);
    }

    public Device getDeviceBySerialNumberId() {
        return deviceBySerialNumberId;
    }

    public void setDeviceBySerialNumberId(Device deviceBySerialNumberId) {
        this.deviceBySerialNumberId = deviceBySerialNumberId;
    }
}
