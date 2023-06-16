import entities.*;
import jakarta.persistence.TypedQuery;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class HibernateSessions {
    private final static Configuration cfg = new Configuration().configure();

    public static List<Device> getOrderedDevice() {
        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            TypedQuery<Device> query = session.createQuery("SELECT d From Device d JOIN Zakaz z " +
                    "ON z.deviceBySerialNumber.serialNumber=d.serialNumber JOIN Phone p " +
                    "ON p.serialNumberId=d.serialNumber", Device.class);
            return (query.getResultList());
        }
    }

    public static List<Laptop> getLaptopCpuByBrandPriceStreet(String brand, int price) {
        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            TypedQuery<Laptop> query = session.createQuery("SELECT l From Laptop l JOIN Device d" +
                    " ON d.serialNumber=l.serialNumberId WHERE d.price<:price AND d.brand =:brand", Laptop.class);
            query.setParameter("price", price).setParameter("brand", brand);
            return query.getResultList();
        }
    }

    public static void getDeviceTypeBySerialNumber(String serialNumber) {
        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Camera camera = session.get(Camera.class, serialNumber);
            Laptop laptop = session.get(Laptop.class, serialNumber);
            Phone phone = session.get(Phone.class, serialNumber);
            if (camera != null) {
                System.out.println(serialNumber + " is camera");
            }
            if (laptop != null) {
                System.out.println(serialNumber + " is laptop");
            }
            if (phone != null) {
                System.out.println(serialNumber + " is phone");
            }
            System.out.println();
        }
    }

    public static List<Zakaz> getOrderInfoByClientIDAndAdminName(int clientId, String adminName) {
        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            TypedQuery<Zakaz> query = session.createQuery("SELECT z FROM Zakaz z JOIN Client c " +
                    "ON z.clientByClientId.id=c.id " +
                    "join Administrator a ON z.administratorByAdminName.adminName=a.adminName" +
                    " WHERE c.id=:clientId AND a.adminName=:adminName", Zakaz.class);
            query.setParameter("clientId", clientId).setParameter("adminName", adminName);
            return query.getResultList();
        }
    }

    public static void addDevice(Device device) {
        Transaction transaction;
        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(device);
            transaction.commit();
        }
        HibernateEntityManager.getAllDevicesNamedQuery();
    }

    public static List<Device> getDevicesInShopsByColor(String color) {
        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            TypedQuery<Device> query = session.createQuery("SELECT d FROM Device d join LocatedAt l on d.serialNumber = l.deviceBySerialNumber.serialNumber WHERE d.color IN (?1)  ", Device.class);
            query.setParameter(1, color);
            sessionFactory.close();
            return query.getResultList();

        }
    }

}






