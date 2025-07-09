package com.sudlicht.occult_arcana.elementa;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import com.sudlicht.occult_arcana.OccultArcana;
import com.sudlicht.occult_arcana.registration.OARegistrate;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.AbstractBuilder;
import com.tterrag.registrate.builders.BuilderCallback;
import com.tterrag.registrate.util.nullness.NonnullType;

import java.util.function.Supplier;

public class ElementaBuilder<T extends Elementa>
                            extends AbstractBuilder<Elementa, T, OARegistrate, ElementaBuilder<T>> {

    private final Supplier<? extends T> factory;

    // Location of icon for this element
    private ResourceLocation iconLocation;

    // Builder class for different Elementa
    public ElementaBuilder(Registrate owner, OARegistrate parent, String name, BuilderCallback callback,
                           Supplier<? extends T> factory, ResourceKey<Registry<Elementa>> registryKey) {
        super(owner, parent, name, callback, registryKey);
        this.factory = factory;
    }

    /**
     * Set the icon of this element
     * 
     * @param name
     */
    public ElementaBuilder<T> icon(String iconPath) {
        this.iconLocation = OccultArcana.resourceLocation(iconPath);
        return this;
    }

    @Override
    protected @NonnullType T createEntry() {
        T elementa = factory.get();

        // Fill fields from the builder
        elementa.setIconLocation(this.iconLocation);
        return elementa;
    }
}
