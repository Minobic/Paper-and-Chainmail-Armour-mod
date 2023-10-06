package net.minobic.minobot.item.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minobic.minobot.minobot;

import java.util.function.Supplier;

public enum modArmorMaterial implements ArmorMaterial {
    PAPER("paper", 5, new int[]{2, 3, 2, 1}, 20, SoundEvents.ARMOR_EQUIP_LEATHER, 1f, 0f, () -> Ingredient.of(Items.PAPER));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent eqipSound;
    private final float toughness;
    private final float KnockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {11, 16, 16, 13};

    modArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent eqipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.eqipSound = eqipSound;
        this.toughness = toughness;
        KnockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot pType) {
        int ordinal = pType.ordinal();
        if (ordinal >= 0 && ordinal < BASE_DURABILITY.length) {
            return BASE_DURABILITY[ordinal] * this.durabilityMultiplier;
        }
        // Handle the case where the ordinal is out of bounds (e.g., log an error or return a default value)
        return 0; // You can adjust the default value as needed
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot pType) {
        int ordinal = pType.ordinal();
        if (ordinal >= 0 && ordinal < protectionAmounts.length) {
            return this.protectionAmounts[ordinal];
        }
        // Handle the case where the ordinal is out of bounds (e.g., log an error or return a default value)
        return 0; // You can adjust the default value as needed
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.eqipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return minobot.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.KnockbackResistance;
    }
}
