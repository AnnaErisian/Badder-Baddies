package blue.thejester.badderbaddies.core;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.ModEntities;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BadderBaddies.MODID)
public class ClientOnlyProxy extends CommonProxy {

    @Override
    public void preInit() {

        ModEntities.registerRenderers();

        super.preInit();
    }



    @Override
    public boolean isDedicatedServer() {
        return false;
    }

}
