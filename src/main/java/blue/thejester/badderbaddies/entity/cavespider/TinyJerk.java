package blue.thejester.badderbaddies.entity.cavespider;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.cavespider.RenderTinyJerk;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TinyJerk extends EntityMyCaveSpider {
    public static final String NAME = "cavespider_tinyjerk";

    public TinyJerk(World worldIn) {
        super(worldIn);
        this.experienceValue += 36;
    }

    @Override
    protected double healthBoost() {
        return 12;
    }

    @Override
    protected int damageBoost() {
        return 4;
    }

    @Override
    protected float magicDamage() {
        return 4;
    }

    @Override
    protected float speedMult() {
        return 1f;
    }

    @Override
    protected float sizeChange() {
        return 0.5f;
    }

    @Override
    protected int poisonLevel() {
        return 1;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.CAVE_SPIDER_JERK;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, TinyJerk.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(TinyJerk.class, RenderTinyJerk.FACTORY);
    }
}
