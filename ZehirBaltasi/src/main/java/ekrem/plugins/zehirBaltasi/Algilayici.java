package ekrem.plugins.zehirBaltasi;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;



public class Algilayici implements Listener {

    @EventHandler
    public void onBaltaSagTik(PlayerInteractEvent event) {
        Player oyuncu = event.getPlayer();
        ItemStack itemStack = oyuncu.getInventory().getItemInMainHand();
        if (event.getHand() == EquipmentSlot.HAND &&
                event.getAction().toString().contains("RIGHT_CLICK") &&
                oyuncu.isSneaking() &&
                itemStack.getType() == Material.DIAMOND_AXE) {

            oyuncu.sendMessage("Yeteneği kullandın!");

            List<Entity> yakinindakiYaratiklar = oyuncu.getNearbyEntities(5, 3, 5);
            for (Entity varlik : yakinindakiYaratiklar) {
                if (varlik instanceof Monster canavar) {
                    canavar.addPotionEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.POISON, 5, 1));
                    Vector itmeYonu = oyuncu.getLocation().getDirection();
                    itmeYonu.setY(0).normalize().multiply(1.5);
                    canavar.getWorld().spawnParticle(Particle.EXPLOSION,canavar.getLocation(), 1);
                    canavar.getWorld().spawnParticle(Particle.CRIT,canavar.getLocation(), 15, 0.5, 0.5, 0.5, 0.1);
                    canavar.setVelocity(itmeYonu);
                }
            }
        }
    }
}
