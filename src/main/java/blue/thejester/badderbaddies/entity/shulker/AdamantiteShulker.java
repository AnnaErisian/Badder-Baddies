package blue.thejester.badderbaddies.entity.shulker;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.shulker.RenderAdamantiteShulker;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AdamantiteShulker extends EntityMyShulker {

    public static String NAME = "shulker_adamantite";

    public AdamantiteShulker(World worldIn) {
        super(worldIn);
    }

    @Override
    protected float magicDamage() {
        return 3;
    }

    @Override
    protected int potionLevel() {
        return 14;
    }

    @Override
    protected int potionTime() {
        return 20;
    }

    @Override
    protected int resistanceLevel() {
        return 3;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(BadderBaddies.MODID, NAME);
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, AdamantiteShulker.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(AdamantiteShulker.class, RenderAdamantiteShulker.FACTORY);
    }
}
