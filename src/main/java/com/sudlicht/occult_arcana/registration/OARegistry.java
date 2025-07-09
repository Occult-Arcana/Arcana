package com.sudlicht.occult_arcana.registration;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.AbstractBuilder;
import com.tterrag.registrate.builders.Builder;
import com.tterrag.registrate.builders.BuilderCallback;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class OARegistry<T, B extends AbstractBuilder<T, ? extends T, OARegistrate, B>> {

    // Internal registry key
    public ResourceKey<Registry<T>> RESOURCE_KEY;

    // Map of registered values for this registry
    private Map<ResourceLocation, RegistryEntry<T>> registered = new HashMap<>();

    // Associated registrate
    private OARegistrate registrate;

    // Type required for a constructor of a builder for this registry type
    private OABuilderConstructor<T, B> constructor;

    // Constructor functional interface for readability elsewhere.
    @FunctionalInterface
    interface OABuilderConstructor<T, R> {

        R apply(Registrate arg1, OARegistrate arg2, String arg3, BuilderCallback arg4, Supplier<? extends T> arg5,
                ResourceKey<Registry<T>> arg6);
    }

    public OARegistry(
                      String name,
                      OARegistrate registrate,
                      OABuilderConstructor<T, B> builderConstructor) {
        this.RESOURCE_KEY = registrate.makeRegistry(name, RegistryBuilder::new);
        this.registrate = registrate;
        this.constructor = builderConstructor;
    }

    /**
     * Builder callback wrapper for adding registered items to this OARegistry
     */
    @SuppressWarnings("unchecked")
    public <R, Y extends R> RegistryEntry<Y> accept(String name, ResourceKey<? extends Registry<R>> type,
                                                    Builder<R, Y, ?, ?> builder, NonNullSupplier<? extends Y> creator,
                                                    NonNullFunction<RegistryObject<Y>, ? extends RegistryEntry<Y>> entryFactory) {
        // Insert into the registered map of this registry
        RegistryEntry<Y> entry = registrate.accept(name, type, builder, creator, entryFactory);
        ResourceLocation location = entry.getId();

        // Inherently this cast should be safe since the same builder must return some type ? extends T
        // but the BuilderCallback interface doesn't let us change the types of accept.
        this.registered.put(location, (RegistryEntry<T>) entry);

        return entry;
    }

    /**
     * Create a new builder from this registry for items of this registries type.
     * 
     * @param name    - ID of the item under this registry
     * @param factory - Supplier that creates the specific item
     * @return B - Builder for the item
     */
    public B create(String name, Supplier<? extends T> factory) {
        return constructor.apply(registrate, registrate, name, this::accept, factory, RESOURCE_KEY);
    }
}
