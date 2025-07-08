package com.sudlicht.occult_arcana.elementa;

import com.sudlicht.occult_arcana.OccultArcana;
import com.tterrag.registrate.util.entry.RegistryEntry;

import net.minecraftforge.registries.RegistryObject;

public class OAElementa {
    public static final RegistryEntry<Elementa> PYR = OccultArcana.REGISTRATE.createElementa("pyr", Elementa::new)
        .register();

    public static final void init() {}
}
