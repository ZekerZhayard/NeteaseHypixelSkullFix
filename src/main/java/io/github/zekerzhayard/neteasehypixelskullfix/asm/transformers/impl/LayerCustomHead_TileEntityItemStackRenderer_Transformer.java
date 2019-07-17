package io.github.zekerzhayard.neteasehypixelskullfix.asm.transformers.impl;

import io.github.zekerzhayard.neteasehypixelskullfix.asm.transformers.AbstractClassTransformer;
import io.github.zekerzhayard.neteasehypixelskullfix.asm.transformers.AbstractInsnTransformer;
import io.github.zekerzhayard.neteasehypixelskullfix.asm.transformers.AbstractMethodTransformer;
import io.github.zekerzhayard.neteasehypixelskullfix.asm.utils.DeobfUtils;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class LayerCustomHead_TileEntityItemStackRenderer_Transformer extends AbstractClassTransformer {
    @Override
    public boolean isTargetClassName(String className) {
        return className.equals("net.minecraft.client.renderer.entity.layers.LayerCustomHead") || className.equals("net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer");
    }

    @Override
    public AbstractMethodTransformer[] getMethodTransformers() {
        return new AbstractMethodTransformer[] {
            new AbstractMethodTransformer() {
                @Override
                public boolean isTargetMethod(String methodName, String methodDesc) {
                    return (methodName.equals("func_177141_a") && methodDesc.equals("(Lnet/minecraft/entity/EntityLivingBase;FFFFFFF)V")) || (methodName.equals("func_179022_a") && methodDesc.equals("(Lnet/minecraft/item/ItemStack;)V"));
                }

                @Override
                public AbstractInsnTransformer[] getInsnTransformers() {
                    return new AbstractInsnTransformer[] {
                        new AbstractInsnTransformer() {
                            @Override
                            public boolean isTargetInsn(AbstractInsnNode ain) {
                                if (ain.getOpcode() == Opcodes.INVOKEVIRTUAL) {
                                    MethodInsnNode min = (MethodInsnNode) ain;
                                    return DeobfUtils.deobfMethodName("net/minecraft/nbt/NBTTagCompound", min.name, min.desc).equals("func_74775_l") && DeobfUtils.deobfMethodDesc(min.desc).equals("(Ljava/lang/String;)Lnet/minecraft/nbt/NBTTagCompound;");
                                }
                                return false;
                            }
                            
                            @Override
                            public void transform(MethodNode mn, AbstractInsnNode ain) {
                                mn.instructions.set(ain, new MethodInsnNode(Opcodes.INVOKESTATIC, "NeteaseHypixelSkullFixHooks", "writeGameProfile", "(Lnet/minecraft/nbt/NBTTagCompound;Ljava/lang/String;)Lnet/minecraft/nbt/NBTTagCompound;", false));
                            }
                        }
                    };
                }
            }
        };
    }
}
