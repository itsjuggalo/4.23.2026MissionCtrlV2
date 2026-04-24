package p7;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: p7.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC2608a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC2608a f22434a = new EnumC2608a("NONE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC2608a f22435b = new EnumC2608a("ALL_JSON_OBJECTS", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC2608a f22436c = new EnumC2608a("POLYMORPHIC", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumC2608a[] f22437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f22438e;

    static {
        EnumC2608a[] enumC2608aArrA = a();
        f22437d = enumC2608aArrA;
        f22438e = AbstractC2875b.a(enumC2608aArrA);
    }

    public EnumC2608a(String str, int i8) {
    }

    public static final /* synthetic */ EnumC2608a[] a() {
        return new EnumC2608a[]{f22434a, f22435b, f22436c};
    }

    public static EnumC2608a valueOf(String str) {
        return (EnumC2608a) Enum.valueOf(EnumC2608a.class, str);
    }

    public static EnumC2608a[] values() {
        return (EnumC2608a[]) f22437d.clone();
    }
}
