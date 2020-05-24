package blue.thejester.badderbaddies.entity.magmacube;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.BBParticleTypes;
import blue.thejester.badderbaddies.client.render.ParticleSpawner;
import blue.thejester.badderbaddies.client.render.magmacube.RenderArgentCube;
import blue.thejester.badderbaddies.client.render.magmacube.RenderSolarCube;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArgentCube extends EntityMyMagmaCube {

    public static final String NAME = "magmacube_argent";

    public ArgentCube(World worldIn) {
        super(worldIn);
    }

    @Override
    protected double healthBoost(int size) {
        if(size <= 1) {
            return 6;
        } else if(size <= 2) {
            return 10;
        } else {
            return 14;
        }
    }

    @Override
    protected int damageBoost(int size) {
        if(size <= 1) {
            return 2;
        } else if(size <= 2) {
            return 2;
        } else {
            return 4;
        }
    }

    @Override
    protected float magicDamage(int size) {
        if(size <= 1) {
            return 1;
        } else if(size <= 2) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    protected int expBonus(int size) {
        return size+2;
    }

    @Override
    public boolean isImmuneToExplosions() {
        return true;
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        if(!world.isRemote && !isSmallSlime()) {
            boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this);
            this.dead = true;
            this.world.createExplosion(this, this.posX, this.posY, this.posZ, getSlimeSize(), flag);
        }
    }

    protected EntitySlime createInstance() {
        return new ArgentCube(this.world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.MAGMA_CUBE_ARGENT;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, ArgentCube.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x310000, 0xff0000);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(ArgentCube.class, RenderArgentCube.FACTORY);
    }

    @Override
    protected boolean canDamagePlayer() {
        return true;
    }

    protected void setSlimeSize(int size, boolean resetHealth)
    {
        super.setSlimeSize(size, resetHealth);
        if(size <= 1) {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)(size * size + 2));
        } else if(size <= 2) {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)(size * size + 4));
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)(size * size + 8));
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
    protected int getAttackStrength() {
        int size = this.getSlimeSize();
        if (size <= 1) {
            return size + 1;
        } else if (size <= 2) {
            return size + 2;
        } else {
            return size + 3;
        }
    }

}
