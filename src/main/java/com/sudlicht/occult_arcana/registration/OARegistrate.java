package com.sudlicht.occult_arcana.registration;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.registries.RegistryObject;

import com.sudlicht.occult_arcana.registration.OARegistry.OABuilderConstructor;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.AbstractBuilder;
import com.tterrag.registrate.builders.Builder;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;

public class OARegistrate extends Registrate {

    protected OARegistrate(String modid) {
        super(modid);
    }

    /**
     * Create a new OARegistrate using the supplied modid.
     * 
     * @param modid - Mod id to begin registered items resource locatiaons
     * @return OARegistrate
     */
    public static OARegistrate create(String modid) {
        return new OARegistrate(modid);
    }

    /**
     * Create's a new OARegistry which corresponds to some type and it's builder.
     * 
     * @param name        - ID of the new registry
     * @param constructor - A method reference to the constructor of the Builder
     * @return OARegistry<T, B> - The new registry.
     */
    public <T,
            B extends AbstractBuilder<T, ? extends T, OARegistrate, B>> OARegistry<T, B> createOARegistry(String name,
                                                                                                          OABuilderConstructor<T, B> constructor) {
        return new OARegistry<T, B>(name, this, constructor);
    }

    /**
     * Access modified version of Registrate accept to allow OARegistry's to call this method.
     * Read doc of the superclass.
     */
    @SuppressWarnings("null")
    @Override
    public <R, T extends R> RegistryEntry<T> accept(String name, ResourceKey<? extends Registry<R>> type,
                                                    Builder<R, T, ?, ?> builder, NonNullSupplier<? extends T> creator,
                                                    NonNullFunction<RegistryObject<T>, ? extends RegistryEntry<T>> entryFactory) {
        return super.accept(name, type, builder, creator, entryFactory);
    }
}
