package pro.fazeclan.river.stupid_express;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import pro.fazeclan.river.stupid_express.arsonist.item.LighterItem;

public class ModItems {

    public static final Item JERRY_CAN = register(
            new Item(new Item.Properties().stacksTo(1)),
            "jerry_can"
    );

    public static final Item LIGHTER = register(
            new LighterItem(new Item.Properties().stacksTo(1)),
            "lighter"
    );

    public static Item register(Item item, String id) {
        ResourceLocation rl = ResourceLocation.fromNamespaceAndPath(StupidExpress.MOD_ID, id);
        return Registry.register(
                BuiltInRegistries.ITEM,
                rl,
                item
        );
    }

    public static void init() {}

}
