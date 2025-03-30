package ekrem.plugins.zehirBaltasi;

import org.bukkit.plugin.java.JavaPlugin;

public class ZehirBaltasi extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Zehir Baltası plugin aktif!");
        getServer().getPluginManager().registerEvents(new Algilayici(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Zehir Baltası plugin devre dışı!");
    }
}
