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

package com.oroarmor.multiitemlib.api;

import net.minecraft.item.ItemStack;

public interface ShieldCooldownSettings {

    /**
     * Returns the shield disable cooldown, such as when attacked by an axe.
     *
     * @param shieldStack the stack for the shield
     * @return the number of ticks to disable the shield
     */
    default int getDisableCooldown(ItemStack shieldStack) {
        return 100;
    }

    /**
     * Returns how long it takes for the shield to be raised.
     *
     * @param shield the stack for the shield
     * @return the number of ticks before the shield is raised
     */
    default int getRaiseCooldown(ItemStack shield) {
        return 5;
    }
}
