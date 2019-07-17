import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import org.apache.commons.lang3.StringUtils;

public class NeteaseHypixelSkullFixHooks {
    public static NBTTagCompound writeGameProfile(NBTTagCompound nbtTagCompound, String key) {
        NBTTagCompound skullOwner = nbtTagCompound.getCompoundTag(key);
        if (skullOwner.hasKey("Name", 8) || StringUtils.isNoneBlank(skullOwner.getCompoundTag("Properties").getTagList("textures", 10).getCompoundTagAt(0).getString("Value"))) {
            return skullOwner;
        }
        skullOwner.setString("Name", EnumChatFormatting.getTextWithoutFormattingCodes(StringUtils.substringAfterLast(" " + nbtTagCompound.getCompoundTag("display").getString("Name"), " ")));
        return skullOwner;
    }
}
