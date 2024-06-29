/*
 * MIT License
 *
 * Copyright (c) 2021-2024 OroArmor (Eli Orona)
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

package com.oroarmor.multiitemlib.impl;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.oroarmor.multiitemlib.api.ShieldCooldownSettings;
import com.oroarmor.multiitemlib.api.UniqueItemRegistry;

import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class ShieldUtil {
    /**
     * Sets the shield cooldown for all shields.
     *
     * @param cooldownManager the item cooldown manager
     * @param duration        the original duration (100 ticks)
     * @param original        the original method for the cooldown
     * @param shield          the shield stack
     */
    public static void addShieldCooldown(ItemCooldownManager cooldownManager, int duration, Operation<Void> original, ItemStack shield) {
        int disableTime = duration;
        if (shield.getItem() instanceof ShieldCooldownSettings item) {
            disableTime = item.getDisableCooldown(shield);

            if (item.cooldownAffectsOtherShields()) {
                for (Item registryEntry : UniqueItemRegistry.SHIELD.getValues()) {
                    original.call(cooldownManager, registryEntry, disableTime);
                }
            }
        }
        original.call(cooldownManager, shield.getItem(), disableTime);
    }
}
