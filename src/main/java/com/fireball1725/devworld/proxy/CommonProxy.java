package com.fireball1725.devworld.proxy;

import com.fireball1725.devworld.common.events.GuiEvents;
import net.minecraftforge.common.MinecraftForge;

public abstract class CommonProxy implements IProxy {
    @Override
    public void registerEvents() {
        MinecraftForge.EVENT_BUS.register(new GuiEvents());
    }
}
