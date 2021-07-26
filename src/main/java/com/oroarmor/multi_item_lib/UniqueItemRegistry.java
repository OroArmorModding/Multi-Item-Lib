/*
 * MIT License
 *
 * Copyright (c) 2021 OroArmor (Eli Orona)
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

package com.oroarmor.multi_item_lib;

import net.minecraft.item.Item;

@Deprecated(forRemoval = true)
public final class UniqueItemRegistry {
    @Deprecated(forRemoval = true)
    public static final UniqueItemRegistry SHEARS = new UniqueItemRegistry(com.oroarmor.multiitemlib.api.UniqueItemRegistry.SHEARS);
    @Deprecated(forRemoval = true)
    public static final UniqueItemRegistry ELYTRA = new UniqueItemRegistry(com.oroarmor.multiitemlib.api.UniqueItemRegistry.ELYTRA);
    @Deprecated(forRemoval = true)
    public static final UniqueItemRegistry FISHING_ROD = new UniqueItemRegistry(com.oroarmor.multiitemlib.api.UniqueItemRegistry.FISHING_ROD);
    @Deprecated(forRemoval = true)
    public static final UniqueItemRegistry SHIELD = new UniqueItemRegistry(com.oroarmor.multiitemlib.api.UniqueItemRegistry.SHIELD);
    @Deprecated(forRemoval = true)
    public static final UniqueItemRegistry BOW = new UniqueItemRegistry(com.oroarmor.multiitemlib.api.UniqueItemRegistry.BOW);
    @Deprecated(forRemoval = true)
    public static final UniqueItemRegistry CROSSBOW = new UniqueItemRegistry(com.oroarmor.multiitemlib.api.UniqueItemRegistry.CROSSBOW);
    @Deprecated(forRemoval = true)
    public static final UniqueItemRegistry TRIDENT = new UniqueItemRegistry(com.oroarmor.multiitemlib.api.UniqueItemRegistry.TRIDENT);

    private final com.oroarmor.multiitemlib.api.UniqueItemRegistry registry;

    private UniqueItemRegistry(com.oroarmor.multiitemlib.api.UniqueItemRegistry registry) {
        this.registry = registry;
    }

    @Deprecated(forRemoval = true)
    public void addItemToRegistry(Item item) {
        registry.addItemToRegistry(item);
    }

    @Deprecated(forRemoval = true)
    public Item getDefaultItem(Item item) {
        return registry.getDefaultItem(item);
    }

    @Deprecated(forRemoval = true)
    public boolean isItemInRegistry(Item item) {
        return registry.isItemInRegistry(item);
    }
}
