package pro.fazeclan.river.stupid_express.client.mixin.modifier.lovers;

import dev.doctor4t.trainmurdermystery.client.gui.RoundTextRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import pro.fazeclan.river.stupid_express.StupidExpress;
import pro.fazeclan.river.stupid_express.modifier.lovers.cca.LoversModifierWorldComponent;

@Mixin(RoundTextRenderer.class)
public class LoversRoleTextRendering {

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
        var component = LoversModifierWorldComponent.KEY.get(level);
        if (!component.isWon()) {
            return winMessage;
        }
        return Component.translatable("game.win.lovers").withColor(StupidExpress.LOVERS_COLOR);
    }

}
