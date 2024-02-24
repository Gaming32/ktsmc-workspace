logger.info { "Hello world from sample KtsMC script!" }

val customBlock = block("custom_block") {
    friction(0.99f)
}
val customItem = item(customBlock)

afterRegistration {
    logger.info { "My custom block: ${customBlock.value}" }
    logger.info { "My custom item: ${customItem.value}" }
}

serverCommands {
    "echo" {
        greedyString("message") { message ->
            executes {
                source.sendSystemMessage(message().toComponent())
            }
        }
    }
}

onPlayerChat {
    player.sendSystemMessage("You sent: ".toComponent().append(message))
    message += " (modified)"
}

modifyRecipe("acacia_stairs") {
    result {
        count = 24
    }
}

modifyAdvancement("adventure/sleep_in_bed") {
    display {
        icon {
            item = "minecraft:lime_bed"
        }
    }
}

modifyLootTable("gameplay/piglin_bartering") {
    pools?.forEach { pool ->
        pool.entries?.forEach { entry ->
            if (entry.name != null) {
                entry.name = "minecraft:ender_pearl"
            }
        }
    }
}

modifyBlockModel("block/fence_post") {
    elements!![0] {
        to!![1] = 24.0
    }
}

advancement("root") {
    display {
        icon(Items.COOKED_BEEF)
        title("Sample Root Advancement")
        description("Where does this even show up? Should I default this to an empty component? Ah, that's where it shows up.")
        customBackground("bricks.png")
        hideToast()
        hideFromChat()
    }

    addManuallyTriggeredCriterion("join") {
        onPlayerJoin {
            if (player.awardCriterion()) {
                player.sendSystemMessage("Welcome to KtsMC!".toComponent())
            }
        }
    }

    advancement("ride_strider") {
        display {
            icon(Items.WARPED_FUNGUS_ON_A_STICK)
            title("Ride a Strider")
            description("Mount a Strider with a Saddle")
        }

        addCriterion("mount", StartRidingTrigger.TriggerInstance.playerStartsRiding(
            EntityPredicate.Builder.entity()
                .vehicle(EntityPredicate.Builder.entity().of(getEntityType("strider")))
        ))
    }
}
