package blue.thejester.badderbaddies.entity.witch;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.witch.RenderBattyWitch;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BattyWitch extends EntityMyWitch{
    public static final String NAME = "witch_batty";

    public BattyWitch(World worldIn) {
        super(worldIn);
        this.experienceValue += 16;
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

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.WITCH_BATTY;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, BattyWitch.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x000000, 0x141414);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(BattyWitch.class, RenderBattyWitch.FACTORY);
    }
}
