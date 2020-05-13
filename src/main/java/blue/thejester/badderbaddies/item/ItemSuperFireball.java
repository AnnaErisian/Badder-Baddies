package blue.thejester.badderbaddies.item;

import blue.thejester.badderbaddies.BadderBaddies;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;


@Mod.EventBusSubscriber
public class ItemSuperFireball extends Item {

    private static final String NAME = "super_fireball";
    public static ItemSuperFireball item;

    public ItemSuperFireball() {

    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> registry = event.getRegistry();
        item = new ItemSuperFireball();
        item.setRegistryName(BadderBaddies.MODID, NAME);
        item.setTranslationKey(item.getRegistryName().toString());
        registry.register(item);
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( BadderBaddies.MODID + ":" + NAME, "inventory"));
    }

}
