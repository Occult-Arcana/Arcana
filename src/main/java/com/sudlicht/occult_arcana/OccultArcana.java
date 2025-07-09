package com.sudlicht.occult_arcana;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;

import com.sudlicht.occult_arcana.elementa.OAElementa;
import com.sudlicht.occult_arcana.registration.OARegistrate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(OccultArcana.MOD_ID)
public class OccultArcana {

    public static final String MOD_ID = "occult_arcana";
    public static final Logger LOGGER = LogManager.getLogger();

    // Registry for Occult Arcana
    public static final OARegistrate REGISTRATE = OARegistrate.create(MOD_ID);

    public OccultArcana() {
        OAElementa.init();
    }

    /**
     * Create a ResourceLocation in the format "modid:path"
     *
     * @param path
     * @return ResourceLocation with the namespace of your mod
     */
    public static ResourceLocation resourceLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
