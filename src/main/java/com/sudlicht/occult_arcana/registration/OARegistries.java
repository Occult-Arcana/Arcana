package com.sudlicht.occult_arcana.registration;

import com.sudlicht.occult_arcana.OccultArcana;
import com.sudlicht.occult_arcana.elementa.Elementa;
import com.sudlicht.occult_arcana.elementa.ElementaBuilder;

public class OARegistries {

    // Elemental types
    public static OARegistry<Elementa, ElementaBuilder<Elementa>> ELEMENTA_REGISTRY = OccultArcana.REGISTRATE
            .createOARegistry("elementa", ElementaBuilder::new);
}
