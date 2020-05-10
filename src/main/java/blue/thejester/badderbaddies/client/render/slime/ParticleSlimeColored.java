package blue.thejester.badderbaddies.client.render.slime;

import net.minecraft.client.particle.ParticleBreaking;
import net.minecraft.client.particle.ParticleBubble;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ParticleSlimeColored extends ParticleBreaking {
    public ParticleSlimeColored(World worldIn, double posXIn, double posYIn, double posZIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, float red, float green, float blue) {
        super(worldIn, posXIn, posYIn, posZIn, xSpeedIn, ySpeedIn, zSpeedIn, Items.CLAY_BALL, 0);
        particleRed = red;
        particleGreen = green;
        particleBlue = blue;
    }
}
