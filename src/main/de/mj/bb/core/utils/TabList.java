package main.de.mj.bb.core.utils;

import main.de.mj.bb.core.CoreSpigot;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

/*
 * @author MJ
 * Created in 25.08.2018
 * Copyright (c) 2017 - 2018 by MJ. All rights reserved.
 *
 */
public class TabList {

    private final CoreSpigot coreSpigot;

    private Scoreboard scoreboard;

    public TabList(CoreSpigot coreSpigot) {
        this.coreSpigot = coreSpigot;
        createTabList();
    }

    public void createTabList() {
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        scoreboard.registerNewTeam("0").setPrefix("§4§lAdmin §8|§7 ");
        scoreboard.registerNewTeam("1").setPrefix("§c§lSrMod §8|§7 ");
        scoreboard.registerNewTeam("2").setPrefix("§c§lMod §8|§7 ");
        scoreboard.registerNewTeam("3").setPrefix("§3§lSrDev §8|§7 ");
        scoreboard.registerNewTeam("4").setPrefix("§3§lDev §8|§7 ");
        scoreboard.registerNewTeam("5").setPrefix("§2§lSrB §8|§7 ");
        scoreboard.registerNewTeam("6").setPrefix("§2§lBuild §8|§7 ");
        scoreboard.registerNewTeam("7").setPrefix("§9§lSrSup §8|§7 ");
        scoreboard.registerNewTeam("8").setPrefix("§9§lSup §8|§7 ");
        scoreboard.registerNewTeam("9").setPrefix("§b§lC §8|§7 ");
        scoreboard.registerNewTeam("10").setPrefix("§5§lYT §8|§7 ");
        scoreboard.registerNewTeam("11").setPrefix("§eVIP+ §8|§7 ");
        if (!(coreSpigot.getModuleManager().getServerType().equals(ServerType.CITY_BUILD) || coreSpigot.getModuleManager().getServerType().equals(ServerType.SKY_PVP))) {
            scoreboard.registerNewTeam("12").setPrefix("§bDiamond §8|§7 ");
            scoreboard.registerNewTeam("13").setPrefix("§aEmerald §8|§7 ");
            scoreboard.registerNewTeam("14").setPrefix("§6Gold §8|§7 ");
        } else if (coreSpigot.getModuleManager().getServerType().equals(ServerType.CITY_BUILD)) {
            scoreboard.registerNewTeam("12").setPrefix("§cSupreme §8|§7 ");
            scoreboard.registerNewTeam("13").setPrefix("§bPrime §8|§7 ");
            scoreboard.registerNewTeam("14").setPrefix("§6Premium §8|§7 ");
        } else if (coreSpigot.getModuleManager().getServerType().equals(ServerType.SKY_PVP)) {
            scoreboard.registerNewTeam("12").setPrefix("§cKing §8|§7 ");
            scoreboard.registerNewTeam("13").setPrefix("§dElite §8|§7 ");
            scoreboard.registerNewTeam("14").setPrefix("§bUltra §8|§7 ");
        }
        scoreboard.registerNewTeam("15").setPrefix("§7");
    }

    public void setTabList(Player player) {
        String team = getTeam(player);
        scoreboard.getTeam(team).addEntry(player.getName());
        //String name = scoreboard.getTeam(team).getPrefix() + player.getName() + " ";
        //if (coreSpigot.getNickManager().isDisguised(player))
        //   name = scoreboard.getTeam(team).getPrefix() + coreSpigot.getNickManager().getPlayerName().get(player) + " ";
        player.setDisplayName(scoreboard.getTeam(team).getPrefix().split("§")[1] + player.getName());
        Bukkit.getOnlinePlayers().forEach(all ->
                all.setScoreboard(scoreboard));
    }

    private String getTeam(Player player) {
        String team = "15";
        //if (!coreSpigot.getNickManager().isDisguised(player)) {
        if (!(coreSpigot.getModuleManager().getServerType().equals(ServerType.CITY_BUILD) || coreSpigot.getModuleManager().getServerType().equals(ServerType.SKY_PVP))) {
            if (player.hasPermission("group." + "administrator"))
                return team = "0";
            else if (player.hasPermission("group." + "srmoderator"))
                return team = "1";
            else if (player.hasPermission("group." + "moderator"))
                return team = "2";
            else if (player.hasPermission("group." + "srdeveloper"))
                return team = "3";
            else if (player.hasPermission("group." + "developer"))
                return team = "4";
            else if (player.hasPermission("group." + "srbuilder"))
                return team = "5";
            else if (player.hasPermission("group." + "builder"))
                return team = "6";
            else if (player.hasPermission("group." + "srsupporter"))
                return team = "7";
            else if (player.hasPermission("group." + "supporter"))
                return team = "8";
            else if (player.hasPermission("group." + "content"))
                return team = "9";
            else if (player.hasPermission("group." + "youtuber"))
                return team = "10";
            else if (player.hasPermission("group." + "vip+"))
                return team = "11";
            else if (player.hasPermission("group." + "diamond"))
                return team = "12";
            else if (player.hasPermission("group." + "emerald"))
                return team = "13";
            else if (player.hasPermission("group." + "gold"))
                return team = "14";
        } else if (coreSpigot.getModuleManager().getServerType().equals(ServerType.CITY_BUILD)) {
            if (player.hasPermission("group." + "administrator"))
                return team = "0";
            else if (player.hasPermission("group." + "srmoderator"))
                return team = "1";
            else if (player.hasPermission("group." + "moderator"))
                return team = "2";
            else if (player.hasPermission("group." + "srdeveloper"))
                return team = "3";
            else if (player.hasPermission("group." + "developer"))
                return team = "4";
            else if (player.hasPermission("group." + "srbuilder"))
                return team = "5";
            else if (player.hasPermission("group." + "builder"))
                return team = "6";
            else if (player.hasPermission("group." + "srsupporter"))
                return team = "7";
            else if (player.hasPermission("group." + "supporter"))
                return team = "8";
            else if (player.hasPermission("group." + "content"))
                return team = "9";
            else if (player.hasPermission("group." + "youtuber"))
                return team = "10";
            else if (player.hasPermission("group." + "vip+"))
                return team = "11";
            else if (player.hasPermission("group." + "supreme"))
                return team = "12";
            else if (player.hasPermission("group." + "prime"))
                return team = "13";
            else if (player.hasPermission("group." + "premium"))
                return team = "14";
        } else if (coreSpigot.getModuleManager().getServerType().equals(ServerType.SKY_PVP)) {
            if (player.hasPermission("group." + "administrator"))
                return team = "0";
            else if (player.hasPermission("group." + "srmoderator"))
                return team = "1";
            else if (player.hasPermission("group." + "moderator"))
                return team = "2";
            else if (player.hasPermission("group." + "srdeveloper"))
                return team = "3";
            else if (player.hasPermission("group." + "developer"))
                return team = "4";
            else if (player.hasPermission("group." + "srbuilder"))
                return team = "5";
            else if (player.hasPermission("group." + "builder"))
                return team = "6";
            else if (player.hasPermission("group." + "srsupporter"))
                return team = "7";
            else if (player.hasPermission("group." + "supporter"))
                return team = "8";
            else if (player.hasPermission("group." + "content"))
                return team = "9";
            else if (player.hasPermission("group." + "youtuber"))
                return team = "10";
            else if (player.hasPermission("group." + "vip+"))
                return team = "11";
            else if (player.hasPermission("group." + "king"))
                return team = "12";
            else if (player.hasPermission("group." + "elite"))
                return team = "13";
            else if (player.hasPermission("group." + "ultra"))
                return team = "14";
            else return "15";
        }
        return "15";
        //}
    }
}