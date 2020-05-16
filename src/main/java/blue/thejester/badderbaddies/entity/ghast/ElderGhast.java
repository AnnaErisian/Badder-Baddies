package blue.thejester.badderbaddies.entity.ghast;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.ghast.RenderElderGhast;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ElderGhast extends EntityMyGhast {
    public static final String NAME = "ghast_elder";

    public ElderGhast(World worldIn) {
        super(worldIn);
        this.experienceValue += 15;
    }

    @Override
    protected double healthBoost() {
        return 16;
    }

    @Override
    protected void fireballs(EntityLivingBase entitylivingbase, World world) {
        double d1 = 4.0D;
        Vec3d vec3d = this.getLook(1.0F);
        double d2 = entitylivingbase.posX - (this.posX + vec3d.x * 4.0D);
        double d3 = entitylivingbase.getEntityBoundingBox().minY + (double)(entitylivingbase.height / 2.0F) - (0.5D + this.posY + (double)(this.height / 2.0F));
        double d4 = entitylivingbase.posZ - (this.posZ + vec3d.z * 4.0D);
        world.playEvent((EntityPlayer)null, 1016, new BlockPos(this), 0);
        EntityCreeperFireball entitylargefireball = new EntityCreeperFireball(world, this, d2, d3, d4, 3);
        entitylargefireball.posX = this.posX + vec3d.x * 4.0D;
        entitylargefireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
        entitylargefireball.posZ = this.posZ + vec3d.z * 4.0D;
        world.spawnEntity(entitylargefireball);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.GHAST_ELDER;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, ElderGhast.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(ElderGhast.class, RenderElderGhast.FACTORY);
    }
}
