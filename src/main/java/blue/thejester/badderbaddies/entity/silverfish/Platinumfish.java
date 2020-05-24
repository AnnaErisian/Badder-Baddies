package blue.thejester.badderbaddies.entity.silverfish;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.silverfish.RenderPlatinumfish;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Platinumfish extends EntityMySilverfish {

    public static final String NAME = "silverfish_platinum";

    public Platinumfish(World worldIn) {
        super(worldIn);
        this.experienceValue += 15;
    }

    @Override
    protected double healthBoost() {
        return 20;
    }

    @Override
    protected int damageBoost() {
        return 2;
    }

    @Override
    protected float magicDamage() {
        return 2;
    }

    @Override
    protected float speedMult() {
        return 1.4f;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.SILVERFISH_PLATINUMFISH;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, Platinumfish.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x385151, 0x082124);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(Platinumfish.class, RenderPlatinumfish.FACTORY);
    }
}
