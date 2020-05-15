package blue.thejester.badderbaddies.entity.spider;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.spider.RenderMotherSpider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MotherSpider extends EntityMySpider {
    private static final String NAME = "spider_mother";

    public MotherSpider(World worldIn) {
        super(worldIn);
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
    protected float speedMult() {
        return 1f;
    }

    @Override
    protected float sizeChange() {
        return 1.25f;
    }

    @Override
    public void onDeath(DamageSource cause) {
        if (!this.dead)
        {
            if (!this.world.isRemote)
            {
                for(int i = 0; i < 3; i++){
                    EntitySpider spidey = new EntitySpider(world);
                    spidey.setPosition(posX + world.rand.nextFloat()/10 - .05, posY, posZ + world.rand.nextFloat()/10 - .05);
                    world.spawnEntity(spidey);
                }
            }
        }
        super.onDeath(cause);
    }

    //TODO make these also give everyone one
    @Override
    protected ResourceLocation getLootTable() {
        return new ResourceLocation(BadderBaddies.MODID, NAME);
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, MotherSpider.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(MotherSpider.class, RenderMotherSpider.FACTORY);
    }
}
