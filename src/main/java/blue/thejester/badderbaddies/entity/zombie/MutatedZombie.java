package blue.thejester.badderbaddies.entity.zombie;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.zombie.RenderMutatedZombie;
import blue.thejester.badderbaddies.client.render.zombie.RenderPlagueZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MutatedZombie extends EntityMyZombie {
    private static final String NAME = "zombie_mutated";

    public MutatedZombie(World worldIn) {
        super(worldIn);
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
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);
        if(flag && entityIn instanceof EntityLivingBase) {
            ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, 80, 1));
        }
        return flag;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, MutatedZombie.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(MutatedZombie.class, RenderMutatedZombie.FACTORY);
    }
}
