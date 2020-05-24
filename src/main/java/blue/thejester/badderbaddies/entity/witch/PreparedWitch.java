package blue.thejester.badderbaddies.entity.witch;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.witch.RenderPreparedWitch;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PreparedWitch extends EntityMyWitch{
    public static final String NAME = "witch_prepared";

    public PreparedWitch(World worldIn) {
        super(worldIn);
        this.experienceValue += 8;
    }

    @Override
    protected int getAbsorptionLevel() {
        return 2;
    }

    @Override
    protected float getSpeedMult() {
        return 1.2f;
    }

    @Override
    protected int getResistanceLevel() {
        return 1;
    }

    @Override
    protected boolean hasFireResistance() {
        return false;
    }

    @Override
    protected int thrownPotionLevel() {
        return 0;
    }

    @Override
    protected int healingPotionLevel() {
        return 0;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.WITCH_PREPARED;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, PreparedWitch.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x290000, 0x267d13);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(PreparedWitch.class, RenderPreparedWitch.FACTORY);
    }
}
