package org.rarityextended.mixin.Weapons;

import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import org.rarityextended.mixin.extensions.ItemMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CrossbowItem.class)
public abstract class CrossbowMixin extends ItemMixin {
    @Inject(method = "<init>", at = @At("CTOR_HEAD"))
    protected void init(Item.Settings settings, CallbackInfo ci) {
        this.genRarity();
    }
}
