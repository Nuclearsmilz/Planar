package nuke.planar.common.block.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.client.model.*;
import net.minecraftforge.fml.common.registry.*;
import net.minecraftforge.fml.relauncher.*;
import nuke.planar.*;
import nuke.planar.core.*;

public class PlanarBlockBase extends Block implements IModeledBlock {
	public boolean isOpaqueCube = true, isFullCube = true, isBeaconBase = false;
	public BlockRenderLayer brlayer = BlockRenderLayer.SOLID;
	public Item itemBlock = null;

	/**
	 * @param mat i.e. Material.ROCK
	 * @param name i.e. "test_block"
	 * @param toolUsed i.e. "pickaxe"
	 * @param toolStrength i.e. Wood: 0, Stone: 1, Iron: 2, Diamond: 3, Gold: 0
	 * @param hardness i.e. 1.0F
	 * @param resistance i.e. 10.0F
	 * @param sound i.e SoundType.GROUND
	 * @param addToTab i.e. true
	 */
	public PlanarBlockBase(Material mat, String name, String toolUsed, int toolStrength, float hardness,
	        float resistance, SoundType sound, boolean addToTab)
	{
		super(mat);
		setUnlocalizedName(name);
		setRegistryName(Planar.prependModID(name));
		setHarvestLevel(toolUsed, toolStrength);
		setHardness(hardness);
		setResistance(resistance);
		setSoundType(sound);
		if (addToTab) setCreativeTab(Planar.proxy.PLANAR_TAB);

		GameRegistry.register(this);
		GameRegistry.register(itemBlock = (new ItemBlock(this).setRegistryName(this.getRegistryName())));
	}

	/**
	 * @param mat i.e. Material.ROCK
	 * @param name i.e. "test_block"
	 * @param toolUsed i.e. "pickaxe"
	 * @param toolStrength i.e. Wood: 0, Stone: 1, Iron: 2, Diamond: 3, Gold: 0
	 * @param hardness i.e. 1.0F
	 * @param resistance i.e. 10.0F
	 * @param sound i.e SoundType.GROUND
	 * @param slippery i.e. true
	 * @param addToTab i.e. true
	 */
	public PlanarBlockBase(Material mat, String name, String toolUsed, int toolStrength, float hardness,
	        float resistance, SoundType sound, boolean addToTab, boolean slippery)
	{
		super(mat);
		setUnlocalizedName(name);
		setRegistryName(Planar.prependModID(name));
		setHarvestLevel(toolUsed, toolStrength);
		setHardness(hardness);
		setResistance(resistance);
		setSoundType(sound);
		if (addToTab) setCreativeTab(Planar.proxy.PLANAR_TAB);
		if (slippery) this.slipperiness = 0.98F;

		GameRegistry.register(this);
		GameRegistry.register(itemBlock = (new ItemBlock(this).setRegistryName(this.getRegistryName())));
	}

	/**
	 * @param mat i.e. Material.ROCK
	 * @param name i.e. "test_block"
	 * @param hardness i.e. 1.0F
	 * @param resistance i.e. 10.0F
	 * @param sound i.e SoundType.GROUND
	 * @param addToTab i.e. true
	 */
	public PlanarBlockBase(Material mat, String name, float hardness, float resistance, SoundType sound,
	        boolean addToTab)
	{
		super(mat);
		setUnlocalizedName(name);
		setRegistryName(Planar.prependModID(name));
		setHardness(hardness);
		setResistance(resistance);
		setSoundType(sound);
		if (addToTab) setCreativeTab(Planar.proxy.PLANAR_TAB);

		GameRegistry.register(this);
		GameRegistry.register(itemBlock = (new ItemBlock(this).setRegistryName(this.getRegistryName())));
	}

	public PlanarBlockBase setIsOpaqueCube( boolean bool ) {
		isOpaqueCube = bool;
		return this;
	}

	public PlanarBlockBase setIsFullCube( boolean bool ) {
		isFullCube = bool;
		return this;
	}

	public PlanarBlockBase setBeaconBase( boolean bool ) {
		isBeaconBase = bool;
		return this;
	}

	@Override
	public boolean isBeaconBase( IBlockAccess world, BlockPos pos, BlockPos beacon ) {
		return isBeaconBase;
	}

	@Override
	public boolean isOpaqueCube( IBlockState ibs ) {
		return isOpaqueCube;
	}

	@Override
	public boolean isFullCube( IBlockState ibs ) {
		return isFullCube;
	}

	@Override
	public boolean isFullBlock( IBlockState ibs ) {
		return isFullCube;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return brlayer;
	}

	@Override
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
		        new ModelResourceLocation(getRegistryName().toString(), "inventory"));
	}
}