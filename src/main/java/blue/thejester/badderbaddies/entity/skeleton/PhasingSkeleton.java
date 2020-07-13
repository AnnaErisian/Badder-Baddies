package blue.thejester.badderbaddies.entity.skeleton;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.skeleton.RenderPhasingSkeleton;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PhasingSkeleton extends EntityMySkeleton {

    public static final String NAME = "skeleton_phasing";

    private static final DataParameter<Boolean> PHASED = EntityDataManager.<Boolean>createKey(PhasingSkeleton.class, DataSerializers.BOOLEAN);

    public PhasingSkeleton(World worldIn) {
        super(worldIn);
        this.experienceValue += 8;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(PHASED, Boolean.valueOf(false));
    }


    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);

        if (((Boolean)this.dataManager.get(PHASED)).booleanValue())
        {
            compound.setBoolean("phased", true);
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.dataManager.set(PHASED, Boolean.valueOf(compound.getBoolean("phased")));
    }

    public boolean getIsPhased()
    {
        return ((Boolean)this.dataManager.get(PHASED)).booleanValue();
    }

    @Override
    public boolean getIsInvulnerable() {
        return super.getIsInvulnerable() || getIsPhased();
    }

    @Override
    public boolean isEntityInvulnerable(DamageSource source) {
        return getIsPhased() || super.isEntityInvulnerable(source);
    }

    public void setIsPhased(boolean phased)
    {
        this.dataManager.set(PHASED, Boolean.valueOf(phased));
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if(!world.isRemote) {
            switch (ticksExisted % (11 * 20)) {
                case 0:
                    setIsPhased(false);
                    break;
                case 120:
                    setIsPhased(true);
                    break;
            }
        }
    }

    @Override
    protected double healthBoost() {
        return 10;
    }

    @Override
    protected double damageBoost() {
        return 3;
    }

    @Override
    protected int magicDamage() {
        return 2;
    }

    @Override
    protected int firingSpeed() {
        return 10;
    }

    @Override
    protected int firingCount() {
        return 1;
    }

    protected PhasingSkeleton createInstance() {
        return new PhasingSkeleton(this.world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.SKELETON_PHASING;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, PhasingSkeleton.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xababb0, 0x173b3b);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(PhasingSkeleton.class, RenderPhasingSkeleton.FACTORY);
    }
}
