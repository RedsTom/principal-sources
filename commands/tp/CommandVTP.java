package fr.mrredstom.principal.commands.tp;

import fr.mrredstom.principal.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandVTP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        try {
            Player p = (Player) commandSender;
            String message = "";
            for (int i = 0; i <= (strings.length - 1); i++) {
                message += strings[i] + " ";
            }
            p.chat("/minecraft:tp " + message);
        }catch (Exception e){
            Main.printErrorMessage(commandSender, e);
        }
        return false;
    }
}
