package org.rarityextended.mixin.Tools;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import org.rarityextended.mixin.extensions.ItemMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PickaxeItem.class)
public abstract class PickaxeMixin extends ItemMixin {
    @Inject(method = "<init>", at = @At("CTOR_HEAD"))
    protected void init(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings, CallbackInfo ci) {
        this.genRarity();
    }
}
