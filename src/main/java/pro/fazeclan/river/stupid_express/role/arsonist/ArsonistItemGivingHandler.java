package pro.fazeclan.river.stupid_express.role.arsonist;

import org.agmas.harpymodloader.events.ModdedRoleAssigned;
import pro.fazeclan.river.stupid_express.ModItems;
import pro.fazeclan.river.stupid_express.StupidExpress;

public class ArsonistItemGivingHandler {

    public static void init() {
        ModdedRoleAssigned.EVENT.register(((player, role) -> {
            if (role.equals(StupidExpress.ARSONIST)) {
                player.addItem(ModItems.JERRY_CAN.getDefaultInstance());
                player.addItem(ModItems.LIGHTER.getDefaultInstance());
            }
        }));
    }

}
