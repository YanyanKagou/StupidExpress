package pro.fazeclan.river.stupid_express.cca;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import pro.fazeclan.river.stupid_express.StupidExpress;

public class SEConfig implements AutoSyncedComponent {

    public static final ComponentKey<SEConfig> KEY =
            ComponentRegistry.getOrCreate(StupidExpress.id("config"), SEConfig.class);
    private final Level level;

    public void sync() {
        SEConfig.KEY.sync(this.level);
    }

    @Getter
    @Setter
    private boolean necromancerHasShop = false;

    @Getter
    @Setter
    private boolean arsonistKeepsGameGoing = false;

    public SEConfig(Level level) {
        this.level = level;
    }

    @Override
    public void readFromNbt(CompoundTag tag, HolderLookup.Provider registryLookup) {
        this.necromancerHasShop = tag.contains("necromancer_has_shop") && tag.getBoolean("necromancer_has_shop");
        this.arsonistKeepsGameGoing = tag.contains("arsonist_keep_alive") && tag.getBoolean("arsonist_keep_alive");
    }

    @Override
    public void writeToNbt(CompoundTag tag, HolderLookup.Provider registryLookup) {
        tag.putBoolean("necromancer_has_shop", this.necromancerHasShop);
        tag.putBoolean("arsonist_keep_alive", this.arsonistKeepsGameGoing);
    }
}
