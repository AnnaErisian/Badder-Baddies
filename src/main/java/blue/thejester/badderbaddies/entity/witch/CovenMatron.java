package blue.thejester.badderbaddies.entity.witch;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.witch.RenderCovenMatron;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CovenMatron extends EntityMyWitch{
    public static final String NAME = "witch_coven_matron";

    public CovenMatron(World worldIn) {
        super(worldIn);
        this.experienceValue += 40;
    }

    @Override
    protected int getAbsorptionLevel() {
        return 6;
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
        return 2;
    }

    @Override
    protected int healingPotionLevel() {
        return 2;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.WITCH_MATRON;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, CovenMatron.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(CovenMatron.class, RenderCovenMatron.FACTORY);
    }
}
