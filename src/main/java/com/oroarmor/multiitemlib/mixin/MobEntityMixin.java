/*
 * MIT License
 *
 * Copyright (c) 2024 OroArmor (Eli Orona)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.oroarmor.multiitemlib.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.oroarmor.multiitemlib.api.UniqueItemRegistry;
import com.oroarmor.multiitemlib.impl.ShieldUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mixin(MobEntity.class)
public class MobEntityMixin {
    @Unique
    ThreadLocal<ItemStack> shieldStack = new ThreadLocal<>();

    @Unique
    ThreadLocal<ItemStack> attackingStack = new ThreadLocal<>();

    @Inject(method = "disablePlayerShield", at = @At("HEAD"))
    public void captureItemStacks(PlayerEntity player, ItemStack mobStack, ItemStack playerStack, CallbackInfo ci) {
        shieldStack.set(playerStack);
        attackingStack.set(mobStack);
    }

    @WrapOperation(method = "disablePlayerShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    public boolean allowMoreShields(ItemStack instance, Item item, Operation<Boolean> original) {
        return UniqueItemRegistry.SHIELD.isItemInRegistry(instance.getItem());
    }

    @WrapOperation(method = "disablePlayerShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/ItemCooldownManager;set(Lnet/minecraft/item/Item;I)V"))
    private void handleDisableShield(ItemCooldownManager instance, Item item, int duration, Operation<Void> original) {
        ShieldUtil.addShieldCooldown(instance, duration, original, this.shieldStack.get());
    }
}
