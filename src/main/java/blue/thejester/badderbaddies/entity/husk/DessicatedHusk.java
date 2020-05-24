package blue.thejester.badderbaddies.entity.husk;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.husk.RenderDessicatedHusk;
import blue.thejester.badderbaddies.client.render.spider.RenderDashingSpider;
import blue.thejester.badderbaddies.entity.LootTables;
import blue.thejester.badderbaddies.entity.spider.EntityMySpider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DessicatedHusk extends EntityMyHusk {
    public static final String NAME = "husk_dessicated";

    public DessicatedHusk(World worldIn) {
        super(worldIn);
        this.experienceValue += 12;
    }

    @Override
    protected double healthBoost() {
        return 10;
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
    protected ResourceLocation getLootTable() {
        return LootTables.HUSK_DESSICATED;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);
        if(flag && entityIn instanceof EntityLivingBase) {
            float f = this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();
            int hungerDur = 140 * (int)f;
            ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.HUNGER, hungerDur, 1));
        }
        return flag;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, DessicatedHusk.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x747470, 0x8c896b);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(DessicatedHusk.class, RenderDessicatedHusk.FACTORY);
    }
}
