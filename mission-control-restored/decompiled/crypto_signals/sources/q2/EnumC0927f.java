package q2;

import java.util.HashMap;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: q2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0927f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0927f f9175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f9176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumC0927f[] f9177c;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0927f EF0;

    static {
        EnumC0927f enumC0927f = new EnumC0927f("X86_32", 0);
        EnumC0927f enumC0927f2 = new EnumC0927f("X86_64", 1);
        EnumC0927f enumC0927f3 = new EnumC0927f("ARM_UNKNOWN", 2);
        EnumC0927f enumC0927f4 = new EnumC0927f("PPC", 3);
        EnumC0927f enumC0927f5 = new EnumC0927f("PPC64", 4);
        EnumC0927f enumC0927f6 = new EnumC0927f("ARMV6", 5);
        EnumC0927f enumC0927f7 = new EnumC0927f("ARMV7", 6);
        EnumC0927f enumC0927f8 = new EnumC0927f("UNKNOWN", 7);
        f9175a = enumC0927f8;
        EnumC0927f enumC0927f9 = new EnumC0927f("ARMV7S", 8);
        EnumC0927f enumC0927f10 = new EnumC0927f("ARM64", 9);
        f9177c = new EnumC0927f[]{enumC0927f, enumC0927f2, enumC0927f3, enumC0927f4, enumC0927f5, enumC0927f6, enumC0927f7, enumC0927f8, enumC0927f9, enumC0927f10};
        HashMap map = new HashMap(4);
        f9176b = map;
        map.put("armeabi-v7a", enumC0927f7);
        map.put("armeabi", enumC0927f6);
        map.put("arm64-v8a", enumC0927f10);
        map.put("x86", enumC0927f);
    }

    public static EnumC0927f valueOf(String str) {
        return (EnumC0927f) Enum.valueOf(EnumC0927f.class, str);
    }

    public static EnumC0927f[] values() {
        return (EnumC0927f[]) f9177c.clone();
    }
}
