package com.fireball1725.devworld.proxy;

import com.fireball1725.devworld.common.events.GuiEvents;
import com.fireball1725.devworld.common.events.WorldEvents;
import net.minecraftforge.common.MinecraftForge;

public abstract class CommonProxy implements IProxy {
    @Override
    public void registerEvents() {
        MinecraftForge.EVENT_BUS.register(new GuiEvents());
        MinecraftForge.EVENT_BUS.register(new WorldEvents());
    }
}
