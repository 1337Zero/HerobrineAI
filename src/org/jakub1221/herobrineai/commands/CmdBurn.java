package org.jakub1221.herobrineai.commands;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jakub1221.herobrineai.HerobrineAI;
import org.jakub1221.herobrineai.AI.Core.CoreType;

public class CmdBurn extends SubCommand {

	public CmdBurn(HerobrineAI plugin, Logger log) {
		super(plugin, log);
	}

	@Override
	public boolean execute(Player player, String[] args) {
		
		if (args.length > 1) {

			
			Player target = Bukkit.getServer().getPlayer(args[1]);
			
			if (target == null) {
				sendMessage(player, ChatColor.RED + "[HerobrineAI] Player is offline.");
				return true;
			}
			
			if (!target.isOnline()) {
				sendMessage(player, ChatColor.RED + "[HerobrineAI] Player is offline.");
				return true;
			}

			Object[] data = { target };
			sendMessage(player, ChatColor.RED + "[HerobrineAI] " + plugin.getAICore().getCore(CoreType.BURN).RunCore(data).getResultString());	
		
			return true;
		}
		
		return false;
	}

	@Override
	public String help() {
		return ChatColor.GREEN + "/hb-ai burn <player name>";
	}

}
