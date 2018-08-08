package trolio.morethings.worldgen;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import trolio.morethings.blocks.ore.CopperOre;
import trolio.morethings.blocks.ore.SilverOre;
import trolio.morethings.blocks.ore.TinOre;
import trolio.morethings.init.ModBlocks;
import trolio.morethings.util.handlers.EnumHandler.OreType;

public class OreGen implements IWorldGenerator
{
	private WorldGenerator copper_overworld;
	private WorldGenerator tin_overworld;
	private WorldGenerator silver_overworld;
	public OreGen()
	{
		copper_overworld = new WorldGenMinable(ModBlocks.oreCopper.getDefaultState().withProperty(CopperOre.TYPE, OreType.OVERWORLD), 8);
		tin_overworld = new WorldGenMinable(ModBlocks.oreTin.getDefaultState().withProperty(TinOre.TYPE, OreType.OVERWORLD), 8);
		silver_overworld = new WorldGenMinable(ModBlocks.oreSilver.getDefaultState().withProperty(SilverOre.TYPE, OreType.OVERWORLD), 8);
	}
	
	private void runGenerator (WorldGenerator generator, World world, Random rand, int ChunkX, int ChunkZ, int chancesToSpawn, int minHeight, int maxHeight)
	{
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
		{
			throw new IllegalArgumentException("Illegal Height Arguments for World Generator!");
		}
		int heightDiff = maxHeight - minHeight + 1;
		
		for (int i = 0; i < chancesToSpawn; i++)
		{
			int x = ChunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = ChunkZ * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenorator, IChunkProvider chunkProvider)
	{
		switch (world.provider.getDimension())
		{
		case 0:
			runGenerator(copper_overworld, world, random, chunkX, chunkZ, 20, 0, 64);
		case 1:
			runGenerator(tin_overworld, world, random, chunkX, chunkZ, 20, 0, 64);
		case 2:
			runGenerator(silver_overworld, world, random, chunkX, chunkZ, 20, 0, 64);
		}
	}
}
