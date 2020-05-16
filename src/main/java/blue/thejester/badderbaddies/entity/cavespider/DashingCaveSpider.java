package blue.thejester.badderbaddies.entity.cavespider;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.cavespider.RenderDashingCaveSpider;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DashingCaveSpider extends EntityMyCaveSpider {
    public static final String NAME = "cavespider_dashing";

    public DashingCaveSpider(World worldIn) {
        super(worldIn);
        this.experienceValue += 12;
    }

    @Override
    protected double healthBoost() {
        return 8;
    }

    @Override
    protected int damageBoost() {
        return 2;
    }

    @Override
    protected float magicDamage() {
        return 1;
    }

    @Override
    protected float speedMult() {
        return 1.2f;
    }

    @Override
    protected float sizeChange() {
        return 1f;
    }

    @Override
    protected int poisonLevel() {
        return 0;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.CAVE_SPIDER_DASHING;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, DashingCaveSpider.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(DashingCaveSpider.class, RenderDashingCaveSpider.FACTORY);
    }
}
