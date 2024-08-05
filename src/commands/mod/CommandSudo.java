package fr.mrredstom.principal.commands.mod;

import fr.mrredstom.principal.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSudo implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        try {

            if (args.length < 2) return false;
            Player target = Bukkit.getPlayer(args[0]);
            String message = "";
            for (int i = 1; i < args.length; i++) {
                message = message + args[i].replace("&", "§") + " ";
            }
            target.chat(message.toString());
            commandSender.sendMessage(Main.getModPrefix() + "Vous avez forcé §a" + target.getName() + " §6a éxécuter la commande §c" + message.toString());
        }catch (Exception e){
            Main.printErrorMessage(commandSender, e);
        }
        return false;
    }
}
