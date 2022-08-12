package studio.craftory.registry

import org.bukkit.Material
import org.bukkit.Sound
import studio.craftory.Craftory
import studio.craftory.tileentity.DiamondEnergyCell
import studio.craftory.tileentity.EmeraldEnergyCell
import studio.craftory.tileentity.GoldEnergyCell
import studio.craftory.tileentity.IronEnergyCell
import xyz.xenondevs.nova.material.BlockOptions
import xyz.xenondevs.nova.util.SoundEffect
import xyz.xenondevs.nova.util.item.ToolCategory
import xyz.xenondevs.nova.util.item.ToolLevel
import xyz.xenondevs.nova.material.NovaMaterialRegistry.registerBlock
import xyz.xenondevs.nova.material.NovaMaterialRegistry.registerTileEntity

object Blocks {
    
    private val LIGHT_METAL = BlockOptions(0.5, ToolCategory.PICKAXE, ToolLevel.WOODEN, false, SoundEffect(Sound.BLOCK_METAL_PLACE), SoundEffect(Sound.BLOCK_METAL_BREAK), Material.IRON_BLOCK)
    
    var IRON_ENERGY_CELL = registerTileEntity(Craftory, "iron_energy_cell", LIGHT_METAL, ::IronEnergyCell)
    var GOLD_ENERGY_CELL = registerTileEntity(Craftory, "gold_energy_cell", LIGHT_METAL, ::GoldEnergyCell)
    var DIAMOND_ENERGY_CELL = registerTileEntity(Craftory, "diamond_energy_cell", LIGHT_METAL, ::DiamondEnergyCell)
    var EMERALD_ENERGY_CELL = registerTileEntity(Craftory, "emerald_energy_cell", LIGHT_METAL, ::EmeraldEnergyCell)
    
    fun init() = Unit
}