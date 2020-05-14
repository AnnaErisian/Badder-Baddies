package blue.thejester.badderbaddies.entity.spider;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.spider.RenderNeurovenomSpider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NeurovenomSpider extends EntityMySpider {
    private static final String NAME = "spider_neurovenom";

    public NeurovenomSpider(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost() {
        return 20;
    }

    @Override
    protected int damageBoost() {
        return 8;
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
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);
        if(flag && entityIn instanceof EntityLivingBase) {
            int i = 0;

            if (this.world.getDifficulty() == EnumDifficulty.NORMAL)
            {
                i = 7;
            }
            else if (this.world.getDifficulty() == EnumDifficulty.HARD)
            {
                i = 15;
            }

            if (i > 0)
            {
                ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, i * 20, 0));
                ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, i * 20, 1));
                ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, i * 20, 2));
            }
        }
        return flag;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, NeurovenomSpider.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(NeurovenomSpider.class, RenderNeurovenomSpider.FACTORY);
    }
}
