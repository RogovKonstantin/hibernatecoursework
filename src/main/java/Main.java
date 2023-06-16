import entities.*;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static final Scanner scanner2 = new Scanner(System.in);
    public static void main(String[] args) {
        JDBC.checkJDBC();
        Scanner scanner1 = new Scanner(System.in);
        int next;
        System.out.println("1) Вывести всю информацию о девайсах\n" +
                "2) Вывести имена администраторов, ID клиентов, номера заказов, на сумму менее "
                + ConsoleColors.YELLOW + "total\n" + ConsoleColors.RESET +
                "3) Определить тип девайса по серийному номеру "
                + ConsoleColors.YELLOW + "serial number\n" + ConsoleColors.RESET +
                "4) Вывести процессоры ноутбуков брэнда " + ConsoleColors.YELLOW + "brand"
                + ConsoleColors.RESET + ", дешевле " + ConsoleColors.YELLOW + "price\n" + ConsoleColors.RESET +
                "5) Вывести детали заказов, оформленных клиентом с " + ConsoleColors.YELLOW + "ID"
                + ConsoleColors.RESET + " и обработанных администратором с именем "
                + ConsoleColors.YELLOW + "admin name\n" + ConsoleColors.RESET +
                "6) Вывести названия только заказанных телефонов\n" +
                "7) Добавить администратора с именем " + ConsoleColors.YELLOW + "admin name\n" + ConsoleColors.RESET +
                "8) Удалить магазин, находящийся на улице " + ConsoleColors.YELLOW + "street\n" + ConsoleColors.RESET +
                "9) Изменить название девайса с серийным номером " + ConsoleColors.YELLOW + "serial number"
                + ConsoleColors.RESET + " на " + "device name\n" + ConsoleColors.RESET +
                "10) Добавить девайс\n" +
                "11) Вывести девайсы определенного" + ConsoleColors.YELLOW + " цвета,"
                + ConsoleColors.RESET + " которые доступны в магазинах" + ConsoleColors.RESET);
        next = scanner1.nextInt();
        switch (next) {
            case 1:
                firstQuery();
                break;
            case 2:
                secondQuery();
                break;
            case 3:
                thirdQuery();
                break;
            case 4:
                fourthQuery();
                break;
            case 5:
                fifthQuery();
                break;
            case 6:
                sixthQuery();
                break;
            case 7:
                seventhQuery();
                break;
            case 8:
                eighthQuery();
                break;
            case 9:
                ninthQuery();
                break;
            case 10:
                tenthQuery();
                break;
            case 11:
                eleventhQuery();
                break;
            case 12:
                System.exit(0);
                break;}}
    public static void firstQuery() {
        HibernateEntityManager.getAllDevicesTypedQuery();}
    public static void secondQuery() {
        System.out.println("Введите сумму заказа");
        JDBC.getAdminNameClientIdOrderNumberByOrderTotal(Integer.parseInt(scanner2.next()));
    }
    public static void thirdQuery() {
        HibernateEntityManager.getAllDevicesNamedQuery();
        System.out.println("Введите серийный номер");
        HibernateSessions.getDeviceTypeBySerialNumber(scanner2.next());}
    public static void fourthQuery() {
        System.out.println("Введите брэнд, цену");
        List<Laptop> listLaptop = HibernateSessions.
                getLaptopCpuByBrandPriceStreet(scanner2.next(), Integer.parseInt(scanner2.next()));
        for (Laptop laptop : listLaptop) {
            System.out.println(laptop.getCpu());}}
    public static void fifthQuery() {
        System.out.println("Введите ID клиента и имя администратора");
        List<Zakaz> listZakaz = HibernateSessions.
                getOrderInfoByClientIDAndAdminName(Integer.parseInt(scanner2.next()), scanner2.next());
        for (Zakaz zakaz : listZakaz) {
            System.out.println(zakaz);}}
    public static void sixthQuery() {
        List<Device> deviceList = HibernateSessions.getOrderedDevice();
        for (Device device : deviceList) {
            System.out.println(device.getDeviceName());}}
    public static void seventhQuery() {
        HibernateEntityManager.getAllAdmins();
        System.out.println("Введите имя администратора для добавления");
        HibernateEntityManager.insertAdmin(scanner2.nextLine());
        HibernateEntityManager.getAllAdmins();}
    public static void eighthQuery() {
        HibernateEntityManager.getAllShopAddresses();
        System.out.println("Введите адрес магазина для удаления");
        HibernateEntityManager.deleteShop(scanner2.nextLine());
        HibernateEntityManager.getAllShopAddresses();}
    public static void ninthQuery() {
        HibernateEntityManager.getAllDevicesNamedQuery();
        System.out.println("Введите серийный номер девайса и новое название девайса");
        HibernateEntityManager.updateDeviceName(scanner2.nextLine(), scanner2.nextLine());
        HibernateEntityManager.getAllDevicesNamedQuery();}
    public static void tenthQuery() {
        HibernateEntityManager.getAllDevicesNamedQuery();
        System.out.println("Введите брэнд, название, материал, описание, цвет, цену, серийный номер");
        Device device = new Device();
        device.setBrand(scanner2.next());
        device.setDeviceName(scanner2.next());
        device.setMaterial(scanner2.next());
        device.setDescription(scanner2.next());
        device.setPrice(Integer.parseInt(scanner2.next()));
        device.setSerialNumber(scanner2.next());
        HibernateSessions.addDevice(device);
        HibernateEntityManager.getAllDevicesNamedQuery();}
    public static void eleventhQuery() {
        System.out.println("Введите цвет");
        List<Device> deviceList1 = HibernateSessions.getDevicesInShopsByColor(scanner2.next());
        for (Device device : deviceList1) {
            System.out.println(device.getDeviceName());
            System.out.println(device.getColor());
        }}}


