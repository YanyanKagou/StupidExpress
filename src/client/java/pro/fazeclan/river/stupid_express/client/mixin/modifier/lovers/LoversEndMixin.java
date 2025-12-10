package pro.fazeclan.river.stupid_express.client.mixin.modifier.lovers;

import dev.doctor4t.trainmurdermystery.client.gui.RoleAnnouncementTexts;
import dev.doctor4t.trainmurdermystery.game.GameFunctions;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pro.fazeclan.river.stupid_express.StupidExpress;
import pro.fazeclan.river.stupid_express.modifier.lovers.cca.LoversModifierWorldComponent;

@Mixin(value = RoleAnnouncementTexts.RoleAnnouncementText.class, priority = 500)
public class LoversEndMixin {

    @Inject(
            method = "getEndText",
            at = @At("HEAD"),
            cancellable = true)
    private void stupidexpress$getEndText(GameFunctions.WinStatus status, Component winner, CallbackInfoReturnable<Component> cir) {
        Level level = Minecraft.getInstance().level;
        if (level == null) {
            return;
        }
        var component = LoversModifierWorldComponent.KEY.get(level);
        if (!component.isWon()) {
            return;
        }
        cir.setReturnValue(Component.translatable("announcement.win.lovers").withColor(StupidExpress.LOVERS_COLOR));
        cir.cancel();
    }

}
