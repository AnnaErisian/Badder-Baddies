package blue.thejester.badderbaddies.entity.creeper;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.creeper.RenderAngryCreeper;
import blue.thejester.badderbaddies.client.render.skeleton.RenderSwiftarmSkeleton;
import blue.thejester.badderbaddies.entity.skeleton.EntityMySkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AngryCreeper extends EntityMyCreeper {

    public static String NAME = "creeper_angry";

    public AngryCreeper(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost() {
        return 4;
    }

    @Override
    protected int fuseTimer() {
        return 22;
    }

    protected AngryCreeper createInstance() {
        return new AngryCreeper(this.world);
    }

    //TODO make these also give everyone one
    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(BadderBaddies.MODID, NAME);
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, AngryCreeper.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(AngryCreeper.class, RenderAngryCreeper.FACTORY);
    }
}
