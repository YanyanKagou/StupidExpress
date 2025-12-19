package pro.fazeclan.river.stupid_express.mixin.role.neutral;

import dev.doctor4t.wathe.game.GameFunctions;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pro.fazeclan.river.stupid_express.role.neutral.NeutralRoleWorldComponent;

@Mixin(GameFunctions.class)
public class NeutralGameFunctionsMixin {

    @Inject(method = "initializeGame", at = @At("HEAD"))
    private static void initializeGame(ServerLevel serverWorld, CallbackInfo ci) {
        NeutralRoleWorldComponent component = NeutralRoleWorldComponent.KEY.get(serverWorld);
        component.reset();
        component.sync();
    }

}
