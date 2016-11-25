package com.fireball1725.devworld.common.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.storage.AnvilSaveConverter;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.client.event.GuiScreenEvent;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Random;

public class GuiEvents {
    private Minecraft mc = Minecraft.getMinecraft();
    private String worldName = "Development World";
    private String worldSaveName = "DevWorld";
    private static final String[] disallowedFilenames = new String[] {"CON", "COM", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};

    @SubscribeEvent
    public void onScreenInitPost(GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.gui instanceof GuiMainMenu) {
            int buttonY = event.gui.height / 4 + 48;
            event.buttonList.remove(0); // Remove the single player world button...

            event.buttonList.add(new GuiButton(1725, event.gui.width / 2 + 2, buttonY, 98, 20, I18n.format("New Dev World", new Object[0])));
            event.buttonList.add(new GuiButton(1, event.gui.width / 2 - 100, buttonY, 98, 20, I18n.format("menu.singleplayer", new Object[0])));
        }
    }

    @SubscribeEvent
    public void onButtonClickPost(GuiScreenEvent.ActionPerformedEvent.Post event) {
        if (event.gui instanceof GuiMainMenu) {
            if (event.button.id == 1725) {
                // todo: make a new world...
                this.mc.displayGuiScreen((GuiScreen)null);

                long i = (new Random()).nextLong();
                String s = "DevWorld"; // World Seed

                if (!StringUtils.isEmpty(s))
                {
                    try
                    {
                        long j = Long.parseLong(s);

                        if (j != 0L)
                        {
                            i = j;
                        }
                    }
                    catch (NumberFormatException var7)
                    {
                        i = (long)s.hashCode();
                    }
                }

                WorldSettings.GameType gameType = WorldSettings.GameType.CREATIVE;
                WorldSettings worldsettings = new WorldSettings(i, gameType, true, false, WorldType.FLAT);

                func_146314_g();

                this.launchIntegratedServer(this.worldSaveName, this.worldName.trim(), worldsettings);
            }
        }
    }

    private void func_146314_g()
    {
        this.worldSaveName = this.worldName.trim();

        for (char c0 : ChatAllowedCharacters.allowedCharacters)
        {
            this.worldSaveName = this.worldSaveName.replace(c0, '_');
        }

        if (StringUtils.isEmpty(this.worldSaveName))
        {
            this.worldSaveName = "World";
        }

        this.worldSaveName = func_146317_a(this.mc.getSaveLoader(), this.worldSaveName);
    }

    public static String func_146317_a(ISaveFormat p_146317_0_, String p_146317_1_)
    {
        p_146317_1_ = p_146317_1_.replaceAll("[\\./\"]", "_");

        for (String s : disallowedFilenames)
        {
            if (p_146317_1_.equalsIgnoreCase(s))
            {
                p_146317_1_ = "_" + p_146317_1_ + "_";
            }
        }

        while (p_146317_0_.getWorldInfo(p_146317_1_) != null)
        {
            p_146317_1_ = p_146317_1_ + "-";
        }

        return p_146317_1_;
    }

    private ISaveFormat saveLoader;

    public void launchIntegratedServer(String p_71371_1_, String p_71371_2_, WorldSettings p_71371_3_) {
        this.saveLoader = new AnvilSaveConverter(new File(Minecraft.getMinecraft().mcDataDir, "saves"));

        Minecraft.getMinecraft().loadWorld((WorldClient)null);
        System.gc();
        ISaveHandler isavehandler = saveLoader.getSaveLoader(p_71371_1_, false);

        NBTTagCompound worldData = new NBTTagCompound();
        worldData.setString("generatorName", "flat");
        worldData.setString("generatorOptions", "2;7,3x1,52x24;2;");
        worldData.setInteger("generatorVersion", 0);

        worldData.setInteger("GameType", 1);

        worldData.setBoolean("MapFeatures", true);

        worldData.setInteger("SpawnX", 0);
        worldData.setInteger("SpawnY", 80);
        worldData.setInteger("SpawnZ", 0);

        worldData.setLong("Time", 6000);
        worldData.setLong("DayTime", 6000);

        worldData.setBoolean("initialized", true);

        worldData.setBoolean("allowCommands", true);

        NBTTagCompound worldRules = new NBTTagCompound();
        worldRules.setString("doMobSpawning", "false");
        worldRules.setString("doDaylightCycle", "false");
        worldRules.setString("doFireTick", "false");

        worldData.setTag("GameRules", worldRules);

        WorldInfo worldInfo = new WorldInfo(worldData);

        isavehandler.saveWorldInfo(worldInfo);

        WorldSettings worldSettings = new WorldSettings(worldInfo);

        Minecraft.getMinecraft().launchIntegratedServer(p_71371_1_, p_71371_2_, worldSettings);
    }
}
