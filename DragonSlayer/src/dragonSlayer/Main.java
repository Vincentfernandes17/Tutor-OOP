package dragonSlayer;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.addItem(new Item("Inferno Blade", "SWORD", 300, 100, 0, true, 0));
        shop.addItem(new Item("Frostfang", "SWORD", 200, 90, 0, false, 0));
        shop.addItem(new Item("Thunderstrike", "SWORD", 500, 150, 0, false, 0));
        shop.addItem(new Item("Obsidian Slayer", "SWORD", 800, 250, 0, true, 0));
        shop.addItem(new Item("Blazebringer", "SWORD", 2000, 500, 0, true, 0));
        shop.addItem(new Item("Dragonbone Plate", "ARMOR", 100, 0, 100, false, 0));
        shop.addItem(new Item("Celestial Armor", "ARMOR", 200, 0, 200, true, 0));
        shop.addItem(new Item("Elixir of Vitality", "CONSUMABLE", 75, 0, 0, false, 75));
        shop.addItem(new Item("Phoenix Draught", "CONSUMABLE", 100, 0, 0, false, 100));

        Knight darius = new Knight("Darius", new Gold(1700));

        shop.buyItem("Berserker Brew", darius);
        shop.buyItem("Blazebringer", darius);
        shop.buyItem("Obsidian Slayer", darius);
        shop.buyItem("Celestial Armor", darius);
        shop.buyItem("Phoenix Draught", darius);

        Dragon dragon = new Dragon("Obsidian Dreadwing", 5000, 50, 200, 1000);

        darius.attack(dragon);

        darius.equipSword("Inferno Blade");
        darius.equipSword("Obsidian Slayer");
        darius.equipArmor("Dragonbone Plate");
        darius.equipArmor("Celestial Armor");

        dragon.attack(darius, "CLAW");
        darius.attack(dragon);
        dragon.attack(darius, "FIRE");

        dragon.buff();

        darius.enhanceWeapon();
        darius.enhanceWeapon();

        dragon.attack(darius, "FIRE");
        dragon.attack(darius, "FIRE");
        dragon.attack(darius, "FIRE");
        dragon.attack(darius, "FIRE");

        darius.useConsumable("Phoenix Draught");

        darius.earnGold(500);

        shop.buyItem("Phoenix Draught", darius);
        shop.buyItem("Elixir of Vitality", darius);

        shop.upgradeInventory(darius, 10);
        shop.upgradeInventory(darius, 1);

        darius.unequipArmor();
        darius.unequipSword();

        shop.sellItem("Inferno Blade", darius);
        shop.sellItem("Celestial Armor", darius);

        dragon.attack(darius, "FIRE");
        dragon.attack(darius, "FIRE");
        dragon.attack(darius, "FIRE");
        dragon.attack(darius, "FIRE");
        dragon.attack(darius, "FIRE");

        Knight orin = new Knight("Orin", new Gold(3000));

        shop.buyItem("Blazebringer", orin);
        shop.buyItem("Celestial Armor", orin);

        orin.equipSword("Blazebringer");
        orin.equipArmor("Celestial Armor");

        dragon.buff();
        dragon.buff();

        orin.attack(dragon);
        dragon.attack(orin, "FIRE");
        dragon.attack(orin, "CLAW");
        dragon.attack(orin, "FIRE");

        orin.enhanceWeapon();

        orin.attack(dragon);
        orin.attack(dragon);
        orin.attack(dragon);
        orin.attack(dragon);
        orin.attack(dragon);
        orin.attack(dragon);
        orin.attack(dragon);
        orin.attack(dragon);
        orin.attack(dragon);
        orin.attack(dragon);
        orin.attack(dragon);
        orin.attack(dragon);
    }
}