package pro.fazeclan.river.stupid_express.role.necromancer.cca;

import lombok.Getter;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import pro.fazeclan.river.stupid_express.StupidExpress;

public class NecromancerComponent implements AutoSyncedComponent {

    public static final ComponentKey<NecromancerComponent> KEY =
            ComponentRegistry.getOrCreate(
                    StupidExpress.id("necromancer"),
                    NecromancerComponent.class
            );

    private final Player player;

    @Getter
    private int deadKillers;

    public NecromancerComponent(Player player) {
        this.player = player;
    }

    public void sync() {
        KEY.sync(this.player);
    }

    public void reset() {
        this.deadKillers = 0;
        sync();
    }

    public void increaseDeadKillers() {
        this.deadKillers++;
    }

    @Override
    public void readFromNbt(CompoundTag tag, HolderLookup.Provider registryLookup) {
        this.deadKillers = tag.contains("dead_killer_count") ? tag.getInt("dead_killer_count") : 0;
    }

    @Override
    public void writeToNbt(CompoundTag tag, HolderLookup.Provider registryLookup) {
        tag.putInt("dead_killer_count", this.deadKillers);
    }
}
