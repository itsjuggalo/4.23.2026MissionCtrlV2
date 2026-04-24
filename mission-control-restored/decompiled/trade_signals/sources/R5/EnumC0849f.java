package R5;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: R5.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC0849f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC0849f f7234b = new EnumC0849f("CLASS", 0, "class");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC0849f f7235c = new EnumC0849f("INTERFACE", 1, "interface");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC0849f f7236d = new EnumC0849f("ENUM_CLASS", 2, "enum class");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC0849f f7237e = new EnumC0849f("ENUM_ENTRY", 3, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnumC0849f f7238f = new EnumC0849f("ANNOTATION_CLASS", 4, "annotation class");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final EnumC0849f f7239g = new EnumC0849f("OBJECT", 5, "object");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ EnumC0849f[] f7240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f7241i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7242a;

    static {
        EnumC0849f[] enumC0849fArrA = a();
        f7240h = enumC0849fArrA;
        f7241i = AbstractC2875b.a(enumC0849fArrA);
    }

    public EnumC0849f(String str, int i8, String str2) {
        this.f7242a = str2;
    }

    public static final /* synthetic */ EnumC0849f[] a() {
        return new EnumC0849f[]{f7234b, f7235c, f7236d, f7237e, f7238f, f7239g};
    }

    public static EnumC0849f valueOf(String str) {
        return (EnumC0849f) Enum.valueOf(EnumC0849f.class, str);
    }

    public static EnumC0849f[] values() {
        return (EnumC0849f[]) f7240h.clone();
    }

    public final boolean b() {
        return this == f7239g || this == f7237e;
    }
}
