package blue.thejester.badderbaddies.entity.husk;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.husk.RenderMummy;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Mummy extends EntityMyHusk {
    public static final String NAME = "husk_mummy";

    public Mummy(World worldIn) {
        super(worldIn);
        this.experienceValue += 24;
    }

    @Override
    protected double healthBoost() {
        return 24;
    }

    @Override
    protected int damageBoost() {
        return 8;
    }

    @Override
    protected float magicDamage() {
        return 4;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.HUSK_MUMMY;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);
        if(flag && entityIn instanceof EntityLivingBase) {
            float f = this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();
            int hungerDur = 140 * (int)f;
            ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.HUNGER, hungerDur, 9));
            ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.HUNGER, 80, 2));
        }
        return flag;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, Mummy.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xb6b7ab, 0x8d8f77);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(Mummy.class, RenderMummy.FACTORY);
    }
}
