package pro.fazeclan.river.stupid_express;

import dev.doctor4t.wathe.api.Role;
import dev.doctor4t.wathe.api.WatheRoles;
import dev.doctor4t.wathe.cca.GameWorldComponent;
import dev.doctor4t.wathe.cca.PlayerPoisonComponent;
import dev.doctor4t.wathe.client.gui.RoleAnnouncementTexts;
import dev.doctor4t.wathe.api.event.AllowPlayerDeath;
import dev.doctor4t.wathe.index.WatheSounds;
import dev.doctor4t.wathe.util.AnnounceWelcomePayload;
import lombok.Getter;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import org.agmas.harpymodloader.Harpymodloader;
import org.agmas.harpymodloader.events.ModdedRoleAssigned;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pro.fazeclan.river.stupid_express.modifier.allergic.cca.AllergicComponent;
import pro.fazeclan.river.stupid_express.role.amnesiac.RoleSelectionHandler;
import pro.fazeclan.river.stupid_express.role.arsonist.ArsonistItemGivingHandler;
import pro.fazeclan.river.stupid_express.role.arsonist.OilDousingHandler;
import pro.fazeclan.river.stupid_express.role.avaricious.AvariciousGoldHandler;
import pro.fazeclan.river.stupid_express.role.necromancer.RevivalSelectionHandler;

import java.util.HashMap;

public class StupidExpress implements ModInitializer {

    public static String MOD_ID = "stupid_express";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Getter
    private static final HashMap<String, Role> ROLES = new HashMap<>();

    @Override
    public void onInitialize() {

        SERoles.init();

        // mod stuff
        SEItems.init();

        SECommands.registerCommands();

    }

    public static ResourceLocation id(String key) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, key);
    }

}
