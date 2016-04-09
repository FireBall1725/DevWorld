package com.fireball1725.devworld;

public class ModInfo {
    public static final String MOD_ID = "devworld";
    public static final String MOD_NAME = "Development World";
    public static final String VERSION_BUILD = "@VERSION@";
    public static final String MINECRAFT_VERSION = "@MCVERSION@";
    public static final String DEPENDENCIES = "";
    public static final String SERVER_PROXY_CLASS = "com.fireball1725." + MOD_ID + ".proxy.ServerProxy";
    public static final String CLIENT_PROXY_CLASS = "com.fireball1725." + MOD_ID + ".proxy.ClientProxy";
    public static final String FINGERPRINT = "@FINGERPRINT@";
    public static final String GUI_FACTORY = "com.fireball1725." + MOD_ID + ".configuration.AppLogConfigGuiFactory";
    public static final String PATH_INTEGRATIONS = "com.fireball1725." + MOD_ID + ".common.integrations.";
}
