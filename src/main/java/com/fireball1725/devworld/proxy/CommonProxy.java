package com.fireball1725.devworld.proxy;

import com.fireball1725.devworld.common.events.GuiEvents;
import com.fireball1725.devworld.common.events.WorldEvents;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

public abstract class CommonProxy implements IProxy {
    @Override
    public void registerEvents() {
        MinecraftForge.EVENT_BUS.register(new GuiEvents());
        MinecraftForge.EVENT_BUS.register(new WorldEvents());

        FMLCommonHandler.instance().bus().register(new GuiEvents());
        FMLCommonHandler.instance().bus().register(new WorldEvents());
    }
}
