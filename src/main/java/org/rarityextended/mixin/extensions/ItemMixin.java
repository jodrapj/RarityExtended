package org.rarityextended.mixin.extensions;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.rarityextended.Rarity.Rarity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Item.class)
public class ItemMixin {
    @Unique
    protected Rarity.Types rarity;

    @Unique
    public Rarity.Types getRarity() {
        return rarity;
    }

    @Unique
    public void setRarity(Rarity.Types data) {
        rarity = data;
    }

    @Unique
    protected void genRarity() {
        if (this.rarity == null) {
            rarity = Rarity.calculateType();
        }
    }

    @Inject(method = "appendTooltip", at = @At("HEAD"))
    protected void injectTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        if (!context.isCreative()) {
            MutableText data = null;
            if (rarity != null) {
                data = rarity.getName();
            }
            if (data != null) {
                tooltip.add(data);
            }
        }
    }
}
