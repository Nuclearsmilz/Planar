package nuke.planar.reg;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.item.*;
import nuke.planar.block.base.*;
import nuke.planar.item.base.*;

public class PlanarContent {
	public static ArrayList<Item> items = new ArrayList<Item>();
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	
	public static Item item_test;

	public static Block block_test;

	public static void init() {
		items.add(item_test = new PlanarItemBase("item_test", true));

		blocks.add(block_test = (new PlanarBlockBase(Material.ROCK, "block_test", "pickaxe", 1, 1.0F, 11.0F,
		        SoundType.STONE, true).setIsFullCube(true).setIsOpaqueCube(true).setLightOpacity(16)));
	}

	public static void regRenders() {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof IModeledItem) {
				((IModeledItem) items.get(i)).initModel();
			}
		}

		for (int i = 0; i < blocks.size(); i++) {
			if (blocks.get(i) instanceof IModeledBlock) {
				((IModeledBlock) blocks.get(i)).initModel();
			}
		}

	}
}