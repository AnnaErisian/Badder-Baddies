package blue.thejester.badderbaddies.entity.silverfish;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.silverfish.RenderGoldenfish;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Goldenfish extends EntityMySilverfish {

    public static final String NAME = "silverfish_gold";

    public Goldenfish(World worldIn) {
        super(worldIn);
        this.experienceValue += 10;
    }

    @Override
    protected double healthBoost() {
        return 2;
    }

    @Override
    protected int damageBoost() {
        return 2;
    }

    @Override
    protected float magicDamage() {
        return 0;
    }

    @Override
    protected float speedMult() {
        return 1.2f;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.SILVERFISH_GOLDENFISH;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, Goldenfish.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x5e624a, 0x212408);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(Goldenfish.class, RenderGoldenfish.FACTORY);
    }
}
