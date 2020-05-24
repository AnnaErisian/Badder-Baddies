package blue.thejester.badderbaddies.entity.enderman;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.creeper.RenderAngryCreeper;
import blue.thejester.badderbaddies.client.render.enderman.RenderBlenderman;
import blue.thejester.badderbaddies.entity.LootTables;
import blue.thejester.badderbaddies.entity.creeper.EntityMyCreeper;
import com.google.common.base.Predicates;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Blenderman extends EntityMyEnderman {

    public static final String NAME = "enderman_blenderman";
    private double RANGE = 5;

    public Blenderman(World worldIn) {
        super(worldIn);
        this.experienceValue += 6;
    }

    @Override
    protected double healthBoost() {
        return 20;
    }

    @Override
    protected int damageBoost() {
        return 4;
    }

    @Override
    protected float magicDamage() {
        return 3;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if(!world.isRemote && world.getTotalWorldTime() % 20 == 0) {
            for(EntityPlayer ep : world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(posX - RANGE, posY - RANGE, posZ - RANGE, posX + RANGE, posY + RANGE, posZ + RANGE), Predicates.instanceOf(EntityPlayer.class))) {
                ep.attackEntityFrom(DamageSource.causeMobDamage(this), 1);
            }
        }
    }

    protected Blenderman createInstance() {
        return new Blenderman(this.world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.ENDERMAN_BLENDERMAN;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, Blenderman.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x080808, 0x000000);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(Blenderman.class, RenderBlenderman.FACTORY);
    }
}
