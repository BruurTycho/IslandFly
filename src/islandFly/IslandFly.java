package islandFly;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.wasteofplastic.askyblock.events.IslandEnterEvent;
import com.wasteofplastic.askyblock.events.IslandExitEvent;

public class IslandFly extends JavaPlugin implements Listener {
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onIslandEnter(IslandEnterEvent event) {
		final UUID owner = event.getIslandOwner();
		final Player ownerusername = Bukkit.getServer().getPlayer(owner);
		if (ownerusername.hasPermission("suppixel.islandfly")) {
			final UUID playerenter = event.getPlayer();
			final Player playerenterusername = Bukkit.getServer().getPlayer(playerenter);
			playerenterusername.setAllowFlight(true);
			playerenterusername.setFlying(true);
			final String IslandEnterMessage1raw = "&7[&cAuto-Fly&7] &fEnabled fly.";
			final String IslandEnterMessage1fancy = ChatColor.translateAlternateColorCodes('&', IslandEnterMessage1raw);
			playerenterusername.sendMessage(IslandEnterMessage1fancy);
		}
	}

	@EventHandler
	public void onIslandExit(IslandExitEvent event) {
		final UUID owner = event.getIslandOwner();
		final Player ownerusername = Bukkit.getServer().getPlayer(owner);
		if (ownerusername.hasPermission("suppixel.islandfly")) {
			final UUID playerenter = event.getPlayer();
			final Player playerenterusername = Bukkit.getServer().getPlayer(playerenter);
			playerenterusername.setAllowFlight(false);
			playerenterusername.setFlying(false);
			final String IslandExitMessage1raw = "&7[&cAuto-Fly&7] &fDisabled fly.";
			final String IslandExitMessage1fancy = ChatColor.translateAlternateColorCodes('&', IslandExitMessage1raw);
			playerenterusername.sendMessage(IslandExitMessage1fancy);
		}

	}
}
