package net.trique.mythicupgrades.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;
import net.trique.mythicupgrades.registry.RegisterMythicItems;

import java.util.function.Supplier;

public enum MythicToolMaterials implements ToolMaterial {

    SAPPHIRE(MiningLevels.NETHERITE, 2106, 9.0f, 6.0f, 18, Ingredient.ofItems(RegisterMythicItems.SAPPHIRE_INGOT)),
    RUBY(MiningLevels.NETHERITE, 2106, 12.0f, 4.0f, 18, Ingredient.ofItems(RegisterMythicItems.RUBY_INGOT)),
    JADE(MiningLevels.NETHERITE, 2106, 9.0f, 4.0f, 18, Ingredient.ofItems(RegisterMythicItems.JADE_INGOT)),
    TOPAZ(MiningLevels.NETHERITE, 6318, 10.0f, 4.5f, 18, Ingredient.ofItems(RegisterMythicItems.TOPAZ_INGOT)),
    AMETRINE(MiningLevels.NETHERITE, 2106, 9.0f, 4.0f, 18, Ingredient.ofItems(RegisterMythicItems.AMETRINE_INGOT)),
    AQUAMARINE(MiningLevels.NETHERITE, 2106, 9.0f, 4.0f, 18, Ingredient.ofItems(RegisterMythicItems.AQUAMARINE_INGOT));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Ingredient repairIngredient;

    MythicToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Ingredient repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}
