package blue.thejester.badderbaddies.entity.shulker;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.shulker.RenderDiamondShulker;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DiamondShulker extends EntityMyShulker {

    public static final String NAME = "shulker_diamond";

    public DiamondShulker(World worldIn) {
        super(worldIn);
        this.experienceValue += 16;
    }

    @Override
    protected float magicDamage() {
        return 2;
    }

    @Override
    protected int potionLevel() {
        return 7;
    }

    @Override
    protected int potionTime() {
        return 60;
    }

    @Override
    protected int resistanceLevel() {
        return 1;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.SHULKER_DIAMOND;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, DiamondShulker.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x865d86, 0x335151);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(DiamondShulker.class, RenderDiamondShulker.FACTORY);
    }
}
