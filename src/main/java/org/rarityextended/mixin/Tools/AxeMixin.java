package org.rarityextended.mixin.Tools;

import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import org.rarityextended.Rarity.Rarity;
import org.rarityextended.mixin.extensions.ItemMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AxeItem.class)
public abstract class AxeMixin extends ItemMixin {

    @Inject(method = "<init>", at = @At("CTOR_HEAD"))
    protected void initInject(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings, CallbackInfo ci) {
        this.genRarity();
    }


}
