// THE (“EpicTextWarning”) SOURCE IS PROVIDED AS IS AT NO MONETARY COST FOR PERSONAL USE ONLY. ANY COMMERCIAL DISTRIBUTION/USE OF THE (“EpicTextWarninfg”) SOURCE IS STRICTLY PROHIBITED.
package com.gmail.justbru00.epic.textwarning.main;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.justbru00.epic.textwarning.commandexecutors.Warn;
import com.gmail.justbru00.epic.textwarning.utils.Messager;

public class Main extends JavaPlugin {

	public static final String PREFIX = Messager.color("&8[&bEpic&fTextWarning&8] &f");
	public static ConsoleCommandSender console = Bukkit.getConsoleSender();
	public FileConfiguration config = getConfig();

	@Override
	public void onDisable() {	
		
	}

	@Override
	public void onEnable() {
		Messager.msgConsole("&bTHIS PLUGIN IS COPYRIGHT 2016 JUSTIN BRUBAKER.");
		Messager.msgConsole("&aBeginning Enable...");
		
		getCommand("warn").setExecutor(new Warn(this));
		
		Messager.msgConsole("&aEnabled!");
	}
	
	
	
	
}
