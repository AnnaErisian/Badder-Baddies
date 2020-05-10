package blue.thejester.badderbaddies.client.render;

import blue.thejester.badderbaddies.client.render.slime.ParticleSlimeColored;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;

public class ParticleSpawner
{
	private static Minecraft mc = Minecraft.getMinecraft();
	
	public static Particle spawnParticle(BBParticleTypes type, double posX, double posY, double posZ, double xVel, double yVel, double zVel)
	{
		if (mc != null && mc.getRenderViewEntity() != null && mc.effectRenderer != null)
		{
			int particleSetting = mc.gameSettings.particleSetting;

			if (particleSetting == 1 && mc.world.rand.nextInt(3) == 0)
			{
				particleSetting = 2;
			}

			double var15 = mc.getRenderViewEntity().posX - posX;
			double var17 = mc.getRenderViewEntity().posY - posY;
			double var19 = mc.getRenderViewEntity().posZ - posZ;
			Particle var21 = null;
			double var22 = 16.0D;

			if (var15 * var15 + var17 * var17 + var19 * var19 > var22 * var22)
			{
				return null;
			}
			else if (particleSetting > 1)
			{
				return null;
			}
			else
			{
				if (type == BBParticleTypes.SLIME_DARK_GREY) {
					var21 = new ParticleSlimeColored(mc.world, posX, posY, posZ, xVel, yVel, zVel, 0.3f, 0.3f, 0.3f);
				} else if (type == BBParticleTypes.SLIME_GREY) {
					var21 = new ParticleSlimeColored(mc.world, posX, posY, posZ, xVel, yVel, zVel, 0.8f, 0.8f, 0.8f);
				} else if (type == BBParticleTypes.SLIME_RED) {
					var21 = new ParticleSlimeColored(mc.world, posX, posY, posZ, xVel, yVel, zVel, 1.0f, 0.2f, 0.2f);
				} else if (type == BBParticleTypes.SLIME_YELLOW) {
					var21 = new ParticleSlimeColored(mc.world, posX, posY, posZ, xVel, yVel, zVel, 1.0f, 1.0f, 0.2f);
				} else if (type == BBParticleTypes.SLIME_MAGENTA) {
					var21 = new ParticleSlimeColored(mc.world, posX, posY, posZ, xVel, yVel, zVel, 1.0f, 0.2f, 0.8f);
				}

				mc.effectRenderer.addEffect(var21);
				return var21;
			}
		}
		return null;
	}
}