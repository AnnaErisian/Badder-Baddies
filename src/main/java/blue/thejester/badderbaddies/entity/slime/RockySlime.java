package blue.thejester.badderbaddies.entity.slime;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.BBParticleTypes;
import blue.thejester.badderbaddies.client.render.ParticleSpawner;
import blue.thejester.badderbaddies.client.render.slime.RenderRockySlime;
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

public class RockySlime extends EntityMySlime {

    public static final String NAME = "slime_rocky";

    public RockySlime(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost(int size) {
        if(size <= 1) {
            return 0;
        } else if(size <= 2) {
            return 2;
        } else {
            return 4;
        }
    }

    @Override
    protected int damageBoost(int size) {
        if(size <= 1) {
            return 1;
        } else if(size <= 2) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    protected float magicDamage(int size) {
        return 0;
    }

    @Override
    protected int expBoost(int size) {
        return size;
    }

    @Override
    protected EnumParticleTypes getParticleType() {
        return EnumParticleTypes.SLIME;
    }

    protected EntitySlime createInstance() {
        return new RockySlime(this.world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return getSlimeSize() == 1 ? LootTables.SLIME_ROCKY : null;
    }


    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, RockySlime.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(RockySlime.class, RenderRockySlime.FACTORY);
    }

    @Override
    protected boolean canDamagePlayer() {
        return true;
    }

    protected void setSlimeSize(int size, boolean resetHealth)
    {
        super.setSlimeSize(size, resetHealth);
        if(size <= 1) {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)(size * size));
        } else if(size <= 2) {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)(size * size + 2));
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)(size * size + 4));
        }

        if (resetHealth)
        {
            this.setHealth(this.getMaxHealth());
        }

        this.experienceValue = size;
    }

    /**
     * Gets the amount of damage dealt to the player when "attacked" by the slime.
     */
    protected int getAttackStrength()
    {
        int size = this.getSlimeSize();
        if(size <= 1) {
            return size + 1;
        } else if(size <= 2) {
            return size + 1;
        } else {
            return size + 2;
        }
    }

    @Override
    protected boolean spawnCustomParticles() {
        int i = this.getSlimeSize();
        for (int j = 0; j < i * 8; ++j)
        {
            float f = this.rand.nextFloat() * ((float)Math.PI * 2F);
            float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
            float f2 = MathHelper.sin(f) * (float)i * 0.5F * f1;
            float f3 = MathHelper.cos(f) * (float)i * 0.5F * f1;
            World world = this.world;
            EnumParticleTypes enumparticletypes = this.getParticleType();
            double d0 = this.posX + (double)f2;
            double d1 = this.posZ + (double)f3;
            ParticleSpawner.spawnParticle(BBParticleTypes.SLIME_DARK_GREY, d0, this.getEntityBoundingBox().minY, d1, 0.0D, 0.0D, 0.0D);
        }
        return true;
    }
}
