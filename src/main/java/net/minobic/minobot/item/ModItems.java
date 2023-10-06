package net.minobic.minobot.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minobic.minobot.item.custom.modArmorMaterial;
import net.minobic.minobot.minobot;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, minobot.MOD_ID);

    public static final RegistryObject<Item> SUBSCRIBER_SCRAPS = ITEMS.register("subscriber_scrap",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> SUBSCRIBE = ITEMS.register("subscribe",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> PAPER_HELMET = ITEMS.register("paper_helmet",
            () -> new ArmorItem(modArmorMaterial.PAPER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> PAPER_CHESTPLATE = ITEMS.register("paper_chestplate",
            () -> new ArmorItem(modArmorMaterial.PAPER, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> PAPER_LEGGINS = ITEMS.register("paper_leggings",
            () -> new ArmorItem(modArmorMaterial.PAPER, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> PAPER_BOOTS = ITEMS.register("paper_boots",
            () -> new ArmorItem(modArmorMaterial.PAPER, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
