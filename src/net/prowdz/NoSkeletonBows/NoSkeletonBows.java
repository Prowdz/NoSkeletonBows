package net.prowdz.NoSkeletonBows;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class NoSkeletonBows extends JavaPlugin
{
    public static NoSkeletonBows instance;
    public SkeletonHandler skeletonHandler;

    @Override
    public void onEnable()
    {
        Bukkit.getServer().getConsoleSender().sendMessage("NoSkeletonBows by Prowdz has been enabled. Halleujah! Praise the Lord God Almighty! The Lord Jesus Christ! Amen.");
        instance = this;
        skeletonHandler = new SkeletonHandler();
    }

    @Override
    public void onDisable()
    {
        Bukkit.getServer().getConsoleSender().sendMessage("NoSkeletonBows has been disabled");
    }
}
