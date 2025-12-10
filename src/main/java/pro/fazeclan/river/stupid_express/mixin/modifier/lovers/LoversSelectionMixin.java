package pro.fazeclan.river.stupid_express.mixin.modifier.lovers;

import dev.doctor4t.trainmurdermystery.cca.GameWorldComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.agmas.harpymodloader.modded_murder.ModdedMurderGameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pro.fazeclan.river.stupid_express.modifier.lovers.cca.LoversModifierWorldComponent;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Mixin(ModdedMurderGameMode.class)
public class LoversSelectionMixin {

    @Inject(
            method = "initializeGame",
            at = @At("TAIL")
    )
    private void stupidexpress$assignLovers(ServerLevel serverWorld, GameWorldComponent gameWorldComponent, List<ServerPlayer> players, CallbackInfo ci) {

        var component = LoversModifierWorldComponent.KEY.get(serverWorld);
        component.reset();

        var innocentPlayers = players.stream().filter(gameWorldComponent::isInnocent).toList();

        var loverOne = players.get(ThreadLocalRandom.current().nextInt(players.size() - 1));
        var loverTwo = players.getFirst();

        do {
            loverTwo = innocentPlayers.get(ThreadLocalRandom.current().nextInt(innocentPlayers.size() - 1));
        } while (loverTwo.getUUID() == loverOne.getUUID());

        component.setLoverOne(loverOne);
        component.setLoverTwo(loverTwo);

    }

}
