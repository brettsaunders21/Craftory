package studio.craftory.tileentity

import de.studiocode.invui.gui.GUI
import de.studiocode.invui.gui.builder.GUIBuilder
import de.studiocode.invui.gui.builder.guitype.GUIType
import studio.craftory.registry.Blocks
import xyz.xenondevs.nova.data.config.NovaConfig
import xyz.xenondevs.nova.data.config.Reloadable
import xyz.xenondevs.nova.data.config.ValueReloadable
import xyz.xenondevs.nova.data.config.configReloadable
import xyz.xenondevs.nova.tileentity.NetworkedTileEntity
import xyz.xenondevs.nova.data.world.block.state.NovaTileEntityState
import xyz.xenondevs.nova.tileentity.network.NetworkConnectionType
import xyz.xenondevs.nova.tileentity.network.energy.holder.BufferEnergyHolder
import xyz.xenondevs.nova.ui.EnergyBar
import xyz.xenondevs.nova.ui.config.side.OpenSideConfigItem
import xyz.xenondevs.nova.ui.config.side.SideConfigGUI

open class EnergyCell(creative: Boolean,
                      maxEnergy: ValueReloadable<Long>,
                      blockState: NovaTileEntityState) : NetworkedTileEntity(blockState), Reloadable {
    
    final override val energyHolder = BufferEnergyHolder(this, maxEnergy, creative) { createSideConfig(NetworkConnectionType.BUFFER) }
    override fun handleTick() = Unit
    override val gui = lazy(::EnergyCellGUI)
    
    inner class EnergyCellGUI : TileEntityGUI() {
        
        private val sideConfigGUI = SideConfigGUI(this@EnergyCell, ::openWindow)
        
        override val gui: GUI = GUIBuilder(GUIType.NORMAL)
            .setStructure(
                "1 - - - - - - - 2",
                "| s # # e # # # |",
                "| # # # e # # # |",
                "| # # # e # # # |",
                "3 - - - - - - - 4")
            .addIngredient('s', OpenSideConfigItem(sideConfigGUI))
            .addIngredient('e', EnergyBar(3, energyHolder))
            .build()
        
    }
}

private val IRON_CAPACITY = configReloadable { NovaConfig[Blocks.IRON_ENERGY_CELL].getLong("capacity") }
private val GOLD_CAPACITY = configReloadable { NovaConfig[Blocks.GOLD_ENERGY_CELL].getLong("capacity") }
private val DIAMOND_CAPACITY = configReloadable { NovaConfig[Blocks.DIAMOND_ENERGY_CELL].getLong("capacity") }
private val EMERALD_CAPACITY = configReloadable { NovaConfig[Blocks.EMERALD_ENERGY_CELL].getLong("capacity") }

class IronEnergyCell(blockState: NovaTileEntityState) : EnergyCell(
    false,
    IRON_CAPACITY,
    blockState
)

class GoldEnergyCell(blockState: NovaTileEntityState) : EnergyCell(
    false,
    GOLD_CAPACITY,
    blockState
)

class DiamondEnergyCell(blockState: NovaTileEntityState) : EnergyCell(
    false,
    DIAMOND_CAPACITY,
    blockState
)

class EmeraldEnergyCell(blockState: NovaTileEntityState) : EnergyCell(
    false,
    EMERALD_CAPACITY,
    blockState
)