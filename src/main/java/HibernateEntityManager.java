import entities.*;
import jakarta.persistence.*;

import java.util.List;

public class HibernateEntityManager {
    final private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public static void getAllDevicesTypedQuery() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Device> query = entityManager
                .createQuery("SELECT d FROM Device AS d", Device.class);
        List<Device> results = query.getResultList();
        for (Device result : results) {
            System.out.println(result);}
        entityManager.close();}
    public static void insertAdmin(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Query query = entityManager.createNativeQuery("INSERT INTO administrator VALUES (?1)", Administrator.class);
            query.setParameter(1, name).executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (PersistenceException e) {
            System.out.println();
        }entityManager.close();}
    public static void getAllAdmins() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Administrator> table = entityManager.createNamedQuery("Administrator.getAll", Administrator.class);
        for (Administrator administrator : table.getResultList()) {
            System.out.println(administrator);}
        entityManager.close();
        System.out.println();}
    public static void deleteShop(String street) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Query query = entityManager.createNativeQuery("DELETE FROM shop_address WHERE street IN (?1) ", Administrator.class);
            query.setParameter(1, street).executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (PersistenceException e) {
            System.out.println();}
        entityManager.close();}
    public static void getAllShopAddresses() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<ShopAddress> table = entityManager.createNamedQuery("ShopAddress.getAll", ShopAddress.class);
        for (ShopAddress shopAddress : table.getResultList()) {
            System.out.println(shopAddress);}
        entityManager.close();
        System.out.println();}
    public static void updateDeviceName(String serial, String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Query query = entityManager.createNativeQuery("UPDATE device " +
                    "SET device_name=?1 WHERE serial_number=?2", Device.class);
            query.setParameter(1, name).setParameter(2, serial).executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (PersistenceException e) {
            System.out.println();}
        entityManager.close();}
    public static void getAllDevicesNamedQuery() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Device> table = entityManager.createNamedQuery("Device.getAll", Device.class);
        for (Device device : table.getResultList()) {
            System.out.println(device);
        }
        entityManager.close();
        System.out.println();}}
