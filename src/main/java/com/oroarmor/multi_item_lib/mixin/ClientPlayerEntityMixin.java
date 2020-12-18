package com.oroarmor.multi_item_lib.mixin;

import com.oroarmor.multi_item_lib.UniqueItemRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

    @Redirect(method = "tickMovement()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"))
    public Item tickMovement(ItemStack itemStack) {
        return UniqueItemRegistry.ELYTRA.getDefaultItem(itemStack.getItem());
    }
}
