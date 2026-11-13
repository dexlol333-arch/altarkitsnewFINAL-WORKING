package com.altarkits;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

/**
 * PlaceholderAPI hook. Only loaded when PlaceholderAPI is installed.
 *   %altarkits_coins%  -> the player's coin balance
 */
public class CoinsExpansion extends PlaceholderExpansion {
    private final KitsPlugin plugin;

    public CoinsExpansion(KitsPlugin plugin) { this.plugin = plugin; }

    @Override public @NotNull String getIdentifier() { return "altarkits"; }
    @Override public @NotNull String getAuthor() { return "AltarKits"; }
    @Override public @NotNull String getVersion() { return plugin.getPluginMeta().getVersion(); }
    @Override public boolean persist() { return true; } // survive /papi reload

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        if (player == null) return "";
        if (params.equalsIgnoreCase("coins")) return String.valueOf(plugin.coins().get(player.getUniqueId()));
        return null;
    }
}
