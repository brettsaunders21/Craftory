package studio.craftory

import studio.craftory.registry.Blocks
import xyz.xenondevs.nova.addon.Addon
import java.util.logging.Logger

lateinit var LOGGER: Logger

object Craftory : Addon() {
    
    override fun init() {
        // Called when the addon is initialized.
        // Register NovaMaterials, RecipeTypes, etc. here
        LOGGER = logger
    
        Blocks.init()
    }
    
    override fun onEnable() = Unit
    
    override fun onDisable() = Unit
    
}