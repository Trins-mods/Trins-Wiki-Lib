package trinsdar.trins_wiki_lib;

import ic2.core.platform.events.impl.WikiEvent;
import ic2.core.wiki.components.builders.CategoryObj;
import ic2.core.wiki.components.builders.IWikiObj;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class WikiEvents {
    @SubscribeEvent
    public static void onWikiEvent(WikiEvent event){
        if (event instanceof WikiEvent.AddonSetupEvent setupEvent) setupEvent.enableAddons();
        if (event instanceof WikiEvent.AddonPageEvent setupEvent){
            List<IWikiObj> pageList = new ArrayList<>();
            if (ModList.get().isLoaded("gravisuit")) {
                pageList.add(new CategoryObj("wiki.gravisuit.category.main", new CategoryObj.Link(getItem("gravisuit", "gravitool"), "gravisuit:tools").with("wiki.gravisuit.header.tools"), new CategoryObj.Link(getItem("gravisuit", "advanced_electric_jetpack"), "gravisuit:armor").with("wiki.gravisuit.header.armor")));
            }
            if (ModList.get().isLoaded("advanced_solars")) {
                pageList.add(new CategoryObj("wiki.advanced_solars.category", new CategoryObj.Link(getItem("advanced_solars", "advanced_solar_panel"), "advanced_solars:items").with("wiki.advanced_solars.header.main")));
            }
            setupEvent.registerChapters(pageList.toArray(IWikiObj[]::new));
        }
    }

    private static Item getItem(String domain, String name) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(domain, name));
    }
}
