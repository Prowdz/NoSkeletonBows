package net.prowdz.NoSkeletonBows;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class SkeletonHandler implements Listener
{
    public SkeletonHandler()
    {
        Bukkit.getServer().getPluginManager().registerListener(NoSkeletonBows.instance, this);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event)
    {
        if (event.getEntity() instanceof Skeleton)
        {
            /*for (Player p : Bukkit.getOnlinePlayers())
            {
                p.sendMessage(ChatColor.BLUE + "Skeleton Death: " + event.getEntity().getUniqueId());
            }*/

            if (event.getDrops() != null)
            {
                List<ItemStack> skeleDrops = event.getDrops();

                for (int i = 0; i < skeleDrops.size(); i++)
                {
                    ItemStack itemStack = skeleDrops.get(i);
                    ItemMeta itemMeta = itemStack.getItemMeta();

                    if (itemStack.getType() == Material.BOW)
                    {
                        for (Enchantment e : itemStack.getItemMeta().getEnchants().keySet())
                        {
                            itemMeta.removeEnchant(e);
                        }
                        itemStack.setItemMeta(itemMeta);

                        /*for (Player p : Bukkit.getOnlinePlayers())
                        {
                            p.sendMessage(ChatColor.AQUA + "Skeleton bow removed of enchantments: " + event.getEntity().getUniqueId());
                        }*/
                    }
                }
            }
        }
    }
}
