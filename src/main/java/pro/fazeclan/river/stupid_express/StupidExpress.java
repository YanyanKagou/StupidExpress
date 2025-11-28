package pro.fazeclan.river.stupid_express;

import dev.doctor4t.trainmurdermystery.api.Role;
import dev.doctor4t.trainmurdermystery.api.TMMRoles;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.agmas.harpymodloader.Harpymodloader;

public class StupidExpress implements ModInitializer {

    public static String MOD_ID = "stupid_express";

    public static ResourceLocation DREAM_EATER_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "dream_eater");

    public static Role DREAM_EATER = TMMRoles.registerRole(new Role(
            DREAM_EATER_ID,
            0xa366ff,
            true,
            false,
            Role.MoodType.REAL,
            -1,
            true
    ));
    /*
    Although the mood type is shown as "REAL" for the DREAM_EATER, they will not be able to complete any "tasks"
    the game provides. I gotta make another way for the DREAM_EATER to not be able to complete tasks and have their
    "malice" fill up by depleting sanity.
     */

    @Override
    public void onInitialize() {

        Harpymodloader.setRoleMaximum(DREAM_EATER, 1);

    }
}
