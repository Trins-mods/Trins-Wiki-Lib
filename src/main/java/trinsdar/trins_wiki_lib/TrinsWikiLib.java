package trinsdar.trins_wiki_lib;

import ic2.core.IC2;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(TrinsWikiLib.MODID)
public class TrinsWikiLib {
    public static final String MODID = "trins_wiki_lib";
    public TrinsWikiLib(){
        IC2.EVENT_BUS.register(WikiEvents.class);
        if (!FMLEnvironment.production){
            System.setProperty("ic2workspace", "true");
        }
    }
}
