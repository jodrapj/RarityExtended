package org.rarityextended.mixin.Weapons;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import org.rarityextended.mixin.extensions.ItemMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SwordItem.class)
public abstract class SwordMixin extends ItemMixin {
    @Inject(method = "<init>", at = @At("CTOR_HEAD"))
    protected void init(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings, CallbackInfo ci) {
        this.genRarity();
    }
}
