package io.github.zekerzhayard.neteasehypixelskullfix.asm.utils;

import net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;

public class DeobfUtils {
    public static String deobfMethodName(String classMcpName, String methodNotchName, String methodNotchDesc) {
        String classNotchName = FMLDeobfuscatingRemapper.INSTANCE.unmap(classMcpName);
        return FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(classNotchName, methodNotchName, methodNotchDesc);
    }
    
    public static String deobfMethodDesc(String methodNotchDesc) {
        return FMLDeobfuscatingRemapper.INSTANCE.mapMethodDesc(methodNotchDesc);
    }
}
