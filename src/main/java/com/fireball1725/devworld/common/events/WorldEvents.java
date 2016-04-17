package com.fireball1725.devworld.common.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class WorldEvents {

    @SubscribeEvent
    public void worldTick(TickEvent.WorldTickEvent event) {
        if (event.world.getWorldInfo().isRaining())
            event.world.getWorldInfo().setRaining(false);
    }
}
