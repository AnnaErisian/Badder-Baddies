package blue.thejester.badderbaddies.entity.spider;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.spider.RenderDashingSpider;
import blue.thejester.badderbaddies.entity.ai.EntityAIBigLeapAtTarget;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DashingSpider extends EntityMySpider {
    private static final String NAME = "spider_dashing";

    public DashingSpider(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost() {
        return 4;
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

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, DashingSpider.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(DashingSpider.class, RenderDashingSpider.FACTORY);
    }
}
