package org.rarityextended.mixin.Tools;

import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Item;
import org.rarityextended.mixin.extensions.ItemMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FishingRodItem.class)
public abstract class FishingRodMixin extends ItemMixin {
    @Inject(method = "<init>", at = @At("CTOR_HEAD"))
    protected void init(Item.Settings settings, CallbackInfo ci) {
        this.genRarity();
    }
}
