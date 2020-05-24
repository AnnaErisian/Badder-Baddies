package blue.thejester.badderbaddies.entity.slime;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.BBParticleTypes;
import blue.thejester.badderbaddies.client.render.ParticleSpawner;
import blue.thejester.badderbaddies.client.render.slime.RenderGelatinousSlime;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GelatinousCube extends EntityMySlime {

    public static final String NAME = "slime_gelatinous_cube";

    public GelatinousCube(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost(int size) {
        if(size <= 1) {
            return 5;
        } else if(size <= 2) {
            return 10;
        } else {
            return 20;
        }
    }

    @Override
    protected int damageBoost(int size) {
        if(size <= 1) {
            return 2;
        } else if(size <= 2) {
            return 3;
        } else {
            return 5;
        }
    }

    @Override
    protected float magicDamage(int size) {
        if(size <= 1) {
            return 1;
        } else if(size <= 2) {
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    protected int expBoost(int size) {
        return size+3;
    }

    @Override
    protected EnumParticleTypes getParticleType() {
        return EnumParticleTypes.SLIME;
    }

    protected EntitySlime createInstance() {
        return new GelatinousCube(this.world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return getSlimeSize() == 1 ? LootTables.SLIME_GELATINOUS : null;
    }


    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, GelatinousCube.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x898989, 0x878787);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(GelatinousCube.class, RenderGelatinousSlime.FACTORY);
    }

    @Override
    protected boolean canDamagePlayer() {
        return true;
    }

    @Override
    protected boolean spawnCustomParticles() {
//        int i = this.getSlimeSize();
//        for (int j = 0; j < i * 8; ++j)
//        {
//            float f = this.rand.nextFloat() * ((float)Math.PI * 2F);
//            float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
//            float f2 = MathHelper.sin(f) * (float)i * 0.5F * f1;
//            float f3 = MathHelper.cos(f) * (float)i * 0.5F * f1;
//            World world = this.world;
//            EnumParticleTypes enumparticletypes = this.getParticleType();
//            double d0 = this.posX + (double)f2;
//            double d1 = this.posZ + (double)f3;
//            ParticleSpawner.spawnParticle(BBParticleTypes.SLIME_RED, d0, this.getEntityBoundingBox().minY, d1, 0.0D, 0.0D, 0.0D);
//        }
        return true;
    }
}
