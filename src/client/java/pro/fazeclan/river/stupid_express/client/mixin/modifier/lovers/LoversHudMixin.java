package pro.fazeclan.river.stupid_express.client.mixin.modifier.lovers;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pro.fazeclan.river.stupid_express.StupidExpress;
import pro.fazeclan.river.stupid_express.modifier.lovers.cca.LoversModifierWorldComponent;

@Mixin(Gui.class)
public abstract class LoversHudMixin {

    @Shadow
    public abstract Font getFont();

    @Inject(method = "render", at = @At("TAIL"))
    private void stupidexpress$loversHud(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {
        LoversModifierWorldComponent component = LoversModifierWorldComponent.KEY.get(Minecraft.getInstance().level);
        if (component.isLover(Minecraft.getInstance().player)) {
            var text = Component.translatable("tip.lovers.partner", component.getPartner(Minecraft.getInstance().player).getName());

            var drawY = guiGraphics.guiHeight();
            drawY -= getFont().wordWrapHeight(text, 999999);

            guiGraphics.drawString(getFont(), text, getFont().width(text), drawY, StupidExpress.LOVERS_COLOR);
        }
    }

}
