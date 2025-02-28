package kiosTalenta;

public class Main {
    public static void main(String[] args) {
        Kios kiosTalenta = new Kios();

        kiosTalenta.registerAdmin("SU123", "Susanto", "santo128$$");
        kiosTalenta.registerAdmin("BU178", "Budianto", "budi099!");
        kiosTalenta.registerAdmin("DO122", "Dono", "donowati123");
        kiosTalenta.registerAdmin("SU888", "Sudiarto", "omg");
        kiosTalenta.registerAdmin("SU909", "Susanto", "@masanto12");

        Admin currentAdmin;

        currentAdmin = kiosTalenta.login("Jono", "whojono123");

        if (currentAdmin == null) System.out.println("Error: Admin not found!");
        else System.out.printf("Login successfully! Welcome back %s!\n", currentAdmin.getUsername());

        currentAdmin = kiosTalenta.login("Susanto", "santo128$$");

        if (currentAdmin == null) System.out.println("Error: Admin not found!");
        else System.out.printf("Login successfully! Welcome back %s!\n", currentAdmin.getUsername());

        Item item1 = new Item("Magnum Matcha", 10, 17500);
        Item item2 = new Item("Indomie Jumbo Biru", 5, 4000);
        Item item3 = new Item("Facial Tissue", 7, 20000);
        Item item4 = new Item("Nivea Body Lotion", 3, 15000);

        kiosTalenta.displayItems();

        // Unauthorized admin to add item, because Bambang is not registered as admin
        kiosTalenta.addItem(item1, new Admin("BA737", "Bambang", "superbambang"));

        kiosTalenta.addItem(item1, currentAdmin);
        kiosTalenta.addItem(item1, currentAdmin);
        kiosTalenta.addItem(item2, currentAdmin);
        kiosTalenta.addItem(item3, currentAdmin);
        kiosTalenta.addItem(item4, currentAdmin);

        kiosTalenta.displayItems();

        Buyer buyer1 = new Buyer("Josh", "PPTI 20", 100000);
        Buyer buyer2 = new Buyer("Jonea", "PPTI 21", 200000);
        Buyer buyer3 = new Buyer("Edwin", "PPTI 22", 150000);

        kiosTalenta.purchase(item1, buyer1, 15);
        kiosTalenta.purchase(item1, buyer1, 10);
        kiosTalenta.purchase(item1, buyer2, 10);
        kiosTalenta.purchase(item1, buyer1, 1);
        kiosTalenta.purchase(item3, buyer1, 2);
        kiosTalenta.purchase(item4, buyer3, 1);

        kiosTalenta.displayItems();
        kiosTalenta.displayTransactionHistory();
    }
}
