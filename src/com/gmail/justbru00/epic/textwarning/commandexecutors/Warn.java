// THE (“EpicTextWarning”) SOURCE IS PROVIDED AS IS AT NO MONETARY COST FOR PERSONAL USE ONLY. ANY COMMERCIAL DISTRIBUTION/USE OF THE (“EpicTextWarninfg”) SOURCE IS STRICTLY PROHIBITED.
package com.gmail.justbru00.epic.textwarning.commandexecutors;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.justbru00.epic.textwarning.main.Main;
import com.gmail.justbru00.epic.textwarning.utils.Messager;
import com.gmail.justbru00.epic.textwarning.utils.TimeGetter;


public class Warn implements CommandExecutor {
	
	Main main;
	
	public Warn(Main main) {
		this.main = main;
	}	
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	
		if (command.getName().equalsIgnoreCase("warn")) {
			
			if (!(sender.hasPermission("epictextwarning.warn"))) {
				Messager.msgSender("&cYou don't have permission!", sender);
				return true;
			}	
			
			if (!(args.length >= 1)) {
				Messager.msgSender("&cPlease provide at least one arg.", sender);
				return true;
			}
			
			Player warned;
			
			try {
				warned = Bukkit.getServer().getPlayer(args[0]);
			} catch(Exception e) {
				Messager.msgSender("&cInvalid Player!", sender);
				return true;
			}
			
			String reason = " ";
			int i = 1;
			while (i < args.length) {
				reason = reason + " " + args[i];				
				i++;
			}		
			
					
			
			Bukkit.broadcastMessage(Messager.color(Main.PREFIX + "&c" + warned.getName() + " &fwas warned for: &c" + reason + " &fby: &c" + sender.getName()));
			Messager.msgPlayer("&fYou were warned for: &c" + reason + " &fby: &c" + sender.getName(), warned);
			
			List<String> log = main.getConfig().getStringList("log");
				
			String addToLog = "[" + TimeGetter.getCurrentTimeStamp() + "] " + warned.getName() + " was warned for: " + reason + " by: " + sender.getName();
			
			log.add(addToLog);
			
			main.config.set("log", log);
			main.saveConfig();
			
			return true;						
		}
		
		return false;
	}

}
