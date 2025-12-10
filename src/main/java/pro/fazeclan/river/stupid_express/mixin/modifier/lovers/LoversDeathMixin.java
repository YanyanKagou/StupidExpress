package pro.fazeclan.river.stupid_express.mixin.modifier.lovers;

import dev.doctor4t.trainmurdermystery.game.GameFunctions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pro.fazeclan.river.stupid_express.StupidExpress;
import pro.fazeclan.river.stupid_express.modifier.lovers.cca.LoversModifierWorldComponent;

@Mixin(GameFunctions.class)
public class LoversDeathMixin {

    @Inject(
            method = "killPlayer(Lnet/minecraft/world/entity/player/Player;ZLnet/minecraft/world/entity/player/Player;Lnet/minecraft/resources/ResourceLocation;)V",
            at = @At("TAIL")
    )
    private static void stupidexpress$bothLoversDie(Player victim, boolean spawnBody, Player killer, ResourceLocation deathReason, CallbackInfo ci) {

        LoversModifierWorldComponent component = LoversModifierWorldComponent.KEY.get(victim.level());

        if (!component.isLover(victim)) {
            return;
        }

        GameFunctions.killPlayer(
                component.getPartner(victim),
                true,
                killer,
                StupidExpress.id("broken_heart")
        );

    }

}
