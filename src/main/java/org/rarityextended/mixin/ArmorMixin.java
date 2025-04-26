package org.rarityextended.mixin;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import org.rarityextended.mixin.extensions.ItemMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorItem.class)
public abstract class ArmorMixin extends ItemMixin {
    @Inject(method = "<init>", at = @At("CTOR_HEAD"))
    protected void init(ArmorMaterial material, ArmorItem.Type type, Item.Settings settings, CallbackInfo ci) {
        this.genRarity();
    }
}
