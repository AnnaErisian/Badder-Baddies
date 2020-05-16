package blue.thejester.badderbaddies.entity.witch;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.witch.RenderHighAlchemist;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HighAlchemist extends EntityMyWitch{
    public static final String NAME = "witch_high_alchemist";

    public HighAlchemist(World worldIn) {
        super(worldIn);
        this.experienceValue += 24;
    }

    @Override
    protected int getAbsorptionLevel() {
        return 5;
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
        return 1;
    }

    @Override
    protected int healingPotionLevel() {
        return 0;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.WITCH_ALCHEMIST;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, HighAlchemist.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(HighAlchemist.class, RenderHighAlchemist.FACTORY);
    }
}
