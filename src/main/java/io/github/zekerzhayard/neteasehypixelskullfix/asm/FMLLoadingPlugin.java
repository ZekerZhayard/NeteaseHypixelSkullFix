package io.github.zekerzhayard.neteasehypixelskullfix.asm;

import java.util.Map;

import io.github.zekerzhayard.neteasehypixelskullfix.NeteaseHypixelSkullFix;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.Name("NeteaseHypixelSkullFix")
public class FMLLoadingPlugin implements IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        return new String[] {
            ClassTransformer.class.getName()
        };
    }

    @Override
    public String getModContainerClass() {
        return NeteaseHypixelSkullFix.class.getName();
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
