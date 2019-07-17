package io.github.zekerzhayard.neteasehypixelskullfix;

import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.ModMetadata;

public class NeteaseHypixelSkullFix extends DummyModContainer {
    public NeteaseHypixelSkullFix() {
        super(new ModMetadata());
        ModMetadata md = this.getMetadata();
        md.modId = "neteasehypixelskullfix";
        md.name = "NeteaseHypixelSkullFix";
        md.version = "@VERSION@";
    }
}
