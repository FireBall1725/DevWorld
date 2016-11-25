package com.fireball1725.devworld.common.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class WorldEvents {

    @SubscribeEvent
    public void worldTick(TickEvent.WorldTickEvent event) {
        if (event.world.getWorldInfo().isRaining())
            event.world.getWorldInfo().setRaining(false);
    }
}
