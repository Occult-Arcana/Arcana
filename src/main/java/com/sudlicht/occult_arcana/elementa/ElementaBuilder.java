package com.sudlicht.occult_arcana.elementa;

import java.util.function.Supplier;

import com.ibm.icu.util.RangeValueIterator.Element;
import com.sudlicht.occult_arcana.OccultArcana;
import com.sudlicht.occult_arcana.registration.OARegistries;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.AbstractBuilder;
import com.tterrag.registrate.builders.BuilderCallback;
import com.tterrag.registrate.util.nullness.NonnullType;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class ElementaBuilder<T extends Elementa, P> extends AbstractBuilder<Elementa, T, P, ElementaBuilder<T, P>> {

    private final Supplier<? extends T> factory;

    // Location of icon for this element
    private ResourceLocation iconLocation;

    // Builder class for different Elementa
    public ElementaBuilder(Registrate owner, P parent, String name, BuilderCallback callback, Supplier<? extends T> factory) {
        super(owner, parent, name, callback, OARegistries.ELEMENTA_REGISTRY);
        this.factory = factory;
    }

    
    /** 
     * Set the icon of this element
     * @param name
     */
    public ElementaBuilder<T, P> icon(String iconPath) {
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
