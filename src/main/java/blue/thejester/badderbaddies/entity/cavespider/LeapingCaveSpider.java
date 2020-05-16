package blue.thejester.badderbaddies.entity.cavespider;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.cavespider.RenderLeapingCaveSpider;
import blue.thejester.badderbaddies.entity.LootTables;
import blue.thejester.badderbaddies.entity.ai.EntityAIBigLeapAtTarget;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LeapingCaveSpider extends EntityMyCaveSpider {
    public static final String NAME = "cavespider_leaping";

    public LeapingCaveSpider(World worldIn) {
        super(worldIn);
        this.experienceValue += 18;
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
        super.fall(distance, 0);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(2, new EntityAIBigLeapAtTarget(this, 0.6F));
    }

    @Override
    protected double healthBoost() {
        return 16;
    }

    @Override
    protected int damageBoost() {
        return 4;
    }

    @Override
    protected float magicDamage() {
        return 2;
    }

    @Override
    protected float speedMult() {
        return 1f;
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
        return LootTables.CAVE_SPIDER_LEAPING;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, LeapingCaveSpider.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(LeapingCaveSpider.class, RenderLeapingCaveSpider.FACTORY);
    }
}
