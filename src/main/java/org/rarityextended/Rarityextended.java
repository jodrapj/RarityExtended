package org.rarityextended;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rarityextended implements ModInitializer {



    public static final String MOD_ID = "rarityextended";
    public static final String NBT_TAG_KEY = "rarity_extended";
    public static final String NBT_DATA_KEY = "tier";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("IM WORKING");
    }
}
