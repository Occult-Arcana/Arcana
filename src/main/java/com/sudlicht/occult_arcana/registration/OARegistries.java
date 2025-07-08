package com.sudlicht.occult_arcana.registration;

import com.sudlicht.occult_arcana.OccultArcana;
import com.sudlicht.occult_arcana.elementa.Elementa;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.registries.RegistryBuilder;

public class OARegistries {
    // Different registries in our Registrate

    // Elementa
    public static ResourceKey<Registry<Elementa>> ELEMENTA_REGISTRY = OccultArcana.REGISTRATE.makeRegistry("elementa", RegistryBuilder::new);
}
