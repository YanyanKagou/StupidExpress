package pro.fazeclan.river.stupid_express.client.mixin.role.neutral;

import dev.doctor4t.trainmurdermystery.client.gui.RoundTextRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import pro.fazeclan.river.stupid_express.role.neutral.NeutralRoleWorldComponent;

@Mixin(RoundTextRenderer.class)
public class NeutralRoleTextRendering {

    @ModifyVariable(
            method = "renderHud",
            at = @At(value = "STORE"),
            name = "winMessage"
    )
    private static MutableComponent renderHud(MutableComponent winMessage) {
        Level level = Minecraft.getInstance().level;
        if (level == null) {
            return winMessage;
        }
        NeutralRoleWorldComponent component = NeutralRoleWorldComponent.KEY.get(level);
        if (!component.hasNeutralWinner()) {
            return winMessage;
        }
        var role = component.getWinningRole();
        return Component.translatable("game.win." + role.identifier().getPath());
    }

}
