package net.trique.mythicupgrades.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.trique.mythicupgrades.util.EffectMeta;
import net.trique.mythicupgrades.util.ItemEffectsList;
import net.trique.mythicupgrades.util.MythicEffectVirtualItemHandler;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

public class MythicGemItem extends Item implements BaseMythicItem {
    private final MythicEffectVirtualItemHandler virtualItemHandler;
    private final String translationKey;

    public MythicGemItem(String translationKey, ItemEffectsList effects, Settings settings) {
        super(settings);
        this.virtualItemHandler = new MythicEffectVirtualItemHandler(effects);
        this.translationKey = translationKey;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        virtualItemHandler.handlePostHit(target, attacker);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(translationKey));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public HashMap<StatusEffect, EffectMeta> getForSelf() {
        return virtualItemHandler.getSelfEffects();
    }
}
