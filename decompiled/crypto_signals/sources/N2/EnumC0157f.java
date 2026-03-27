package N2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: N2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0157f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0157f f1995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC0157f f1996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC0157f f1997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC0157f f1998d;
    public static final /* synthetic */ EnumC0157f[] e;

    static {
        EnumC0157f enumC0157f = new EnumC0157f("REMOVED", 0);
        f1995a = enumC0157f;
        EnumC0157f enumC0157f2 = new EnumC0157f("ADDED", 1);
        f1996b = enumC0157f2;
        EnumC0157f enumC0157f3 = new EnumC0157f("MODIFIED", 2);
        f1997c = enumC0157f3;
        EnumC0157f enumC0157f4 = new EnumC0157f("METADATA", 3);
        f1998d = enumC0157f4;
        e = new EnumC0157f[]{enumC0157f, enumC0157f2, enumC0157f3, enumC0157f4};
    }

    public static EnumC0157f valueOf(String str) {
        return (EnumC0157f) Enum.valueOf(EnumC0157f.class, str);
    }

    public static EnumC0157f[] values() {
        return (EnumC0157f[]) e.clone();
    }
}
