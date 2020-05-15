package blue.thejester.badderbaddies.entity.witch;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.witch.RenderBattyWitch;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BattyWitch extends EntityMyWitch{
    private static final String NAME = "witch_batty";

    public BattyWitch(World worldIn) {
        super(worldIn);
    }

    @Override
    protected int getAbsorptionLevel() {
        return 4;
    }

    @Override
    protected float getSpeedMult() {
        return 1.4f;
    }

    @Override
    protected int getResistanceLevel() {
        return 3;
    }

    @Override
    protected boolean hasFireResistance() {
        return true;
    }

    @Override
    protected int thrownPotionLevel() {
        return 0;
    }

    @Override
    protected int healingPotionLevel() {
        return 0;
    }

    //TODO make these also give everyone one
    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(BadderBaddies.MODID, NAME);
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, BattyWitch.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(BattyWitch.class, RenderBattyWitch.FACTORY);
    }
}
