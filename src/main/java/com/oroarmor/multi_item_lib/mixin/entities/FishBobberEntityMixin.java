package com.oroarmor.multi_item_lib.mixin.entities;

import com.oroarmor.multi_item_lib.UniqueItemRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FishingBobberEntity.class)
public abstract class FishBobberEntityMixin {

    @Redirect(method = "removeIfInvalid", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"))
    private Item replaceGetItem1(ItemStack itemStack, PlayerEntity playerEntity) {
        return UniqueItemRegistry.FISHING_ROD.getDefaultItem(itemStack.getItem());
    }
}
