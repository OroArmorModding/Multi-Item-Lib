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

package com.oroarmor.multiitemlib.api;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

/**
 * A wrapper class for a set of {@link Item}s.
 */
public final class UniqueItemRegistry {
    /**
     * The {@link UniqueItemRegistry} for shears. Allows for use on entities and blocks.
     */
    public static final UniqueItemRegistry SHEARS = new UniqueItemRegistry(Items.SHEARS);
    /**
     * The {@link UniqueItemRegistry} for fishing rods. Allows for the fishing bobber to work normally and correct rendering.
     */
    public static final UniqueItemRegistry FISHING_ROD = new UniqueItemRegistry(Items.FISHING_ROD);
    /**
     * The {@link UniqueItemRegistry} for shields. Allows for blocking and correct rendering.
     */
    public static final UniqueItemRegistry SHIELD = new UniqueItemRegistry(Items.SHIELD);
    /**
     * The {@link UniqueItemRegistry} for bows. Allows for shooting arrows and correct rendering.
     */
    public static final UniqueItemRegistry BOW = new UniqueItemRegistry(Items.BOW);
    /**
     * The {@link UniqueItemRegistry} for crossbows. Allows for shooting arrows and correct rendering.
     */
    public static final UniqueItemRegistry CROSSBOW = new UniqueItemRegistry(Items.CROSSBOW);
    /**
     * The {@link UniqueItemRegistry} for tridents. Allows for some correct rendering. Mixins will be needed for full correct rendering.
     */
    public static final UniqueItemRegistry TRIDENT = new UniqueItemRegistry(Items.TRIDENT);

    private final Set<Item> itemList;

    private final Item defaultItem;

    private UniqueItemRegistry(Item defaultItem) {
        this.defaultItem = defaultItem;
        itemList = new HashSet<>();
        addItemToRegistry(defaultItem);
    }

    public void addItemToRegistry(Item item) {
        itemList.add(item);
    }

    public Item getDefaultItem(Item item) {
        if (isItemInRegistry(item)) {
            return defaultItem;
        }
        return item;
    }

    public boolean isItemInRegistry(Item item) {
        return itemList.contains(item);
    }

    public Set<Item> getValues() {
        return Collections.unmodifiableSet(itemList);
    }
}