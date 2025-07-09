package com.sudlicht.occult_arcana.elementa;

import com.sudlicht.occult_arcana.registration.OARegistries;
import com.tterrag.registrate.util.entry.RegistryEntry;

public class OAElementa {

    public static final RegistryEntry<Elementa> PYR = OARegistries.ELEMENTA_REGISTRY.create("pyr", Elementa::new)
            .register();

    public static final void init() {}
}
