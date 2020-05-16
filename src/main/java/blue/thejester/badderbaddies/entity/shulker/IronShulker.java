package blue.thejester.badderbaddies.entity.shulker;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.shulker.RenderIronShulker;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class IronShulker extends EntityMyShulker {

    public static final String NAME = "shulker_iron";

    public IronShulker(World worldIn) {
        super(worldIn);
        this.experienceValue += 6;
    }

    @Override
    protected float magicDamage() {
        return 2;
    }

    @Override
    protected int potionLevel() {
        return 0;
    }

    @Override
    protected int potionTime() {
        return 200;
    }

    @Override
    protected int resistanceLevel() {
        return 0;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.SHULKER_IRON;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, IronShulker.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0xb570d3);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(IronShulker.class, RenderIronShulker.FACTORY);
    }
}
