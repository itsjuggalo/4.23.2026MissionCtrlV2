package w4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: w4.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1375u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC1375u f11403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC1375u f11404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC1375u f11405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC1375u f11406d;
    public static final /* synthetic */ EnumC1375u[] e;

    static {
        EnumC1375u enumC1375u = new EnumC1375u("PROCESSED", 0);
        f11403a = enumC1375u;
        EnumC1375u enumC1375u2 = new EnumC1375u("REFUSED", 1);
        f11404b = enumC1375u2;
        EnumC1375u enumC1375u3 = new EnumC1375u("DROPPED", 2);
        f11405c = enumC1375u3;
        EnumC1375u enumC1375u4 = new EnumC1375u("MISCARRIED", 3);
        f11406d = enumC1375u4;
        e = new EnumC1375u[]{enumC1375u, enumC1375u2, enumC1375u3, enumC1375u4};
    }

    public static EnumC1375u valueOf(String str) {
        return (EnumC1375u) Enum.valueOf(EnumC1375u.class, str);
    }

    public static EnumC1375u[] values() {
        return (EnumC1375u[]) e.clone();
    }
}
