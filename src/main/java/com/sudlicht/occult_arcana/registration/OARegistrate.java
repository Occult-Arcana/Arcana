package com.sudlicht.occult_arcana.registration;

import java.util.function.Supplier;

import com.sudlicht.occult_arcana.OccultArcana;
import com.sudlicht.occult_arcana.elementa.Elementa;
import com.sudlicht.occult_arcana.elementa.ElementaBuilder;
import com.tterrag.registrate.Registrate;

public class OARegistrate extends Registrate {

    protected OARegistrate(String modid) {
        super(modid);
    }

    /** 
     * Create a new OARegistrate using the supplied modid.
     * @param modid - Mod id to begin registered items resource locatiaons
     * @return OARegistrate
     */
    public static OARegistrate create(String modid) {
        return new OARegistrate(modid);
    }

    /** 
     * Create a new Elementa
     * @param name - Name of the new element 
     * @param factory - Factory to create an instance of this element
     * @return ElementaBuilder<T, P>
     */
    public <T extends Elementa> ElementaBuilder<T, OARegistrate> createElementa(String name, Supplier<? extends T> factory) {
        return entry(name, callback -> new ElementaBuilder<>(this, this, name, callback, factory));
    }
}
