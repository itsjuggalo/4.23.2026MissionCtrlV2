package u4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: u4.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1229k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC1229k f10449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC1229k f10450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC1229k f10451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC1229k f10452d;
    public static final EnumC1229k e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumC1229k[] f10453f;

    static {
        EnumC1229k enumC1229k = new EnumC1229k("CONNECTING", 0);
        f10449a = enumC1229k;
        EnumC1229k enumC1229k2 = new EnumC1229k("READY", 1);
        f10450b = enumC1229k2;
        EnumC1229k enumC1229k3 = new EnumC1229k("TRANSIENT_FAILURE", 2);
        f10451c = enumC1229k3;
        EnumC1229k enumC1229k4 = new EnumC1229k("IDLE", 3);
        f10452d = enumC1229k4;
        EnumC1229k enumC1229k5 = new EnumC1229k("SHUTDOWN", 4);
        e = enumC1229k5;
        f10453f = new EnumC1229k[]{enumC1229k, enumC1229k2, enumC1229k3, enumC1229k4, enumC1229k5};
    }

    public static EnumC1229k valueOf(String str) {
        return (EnumC1229k) Enum.valueOf(EnumC1229k.class, str);
    }

    public static EnumC1229k[] values() {
        return (EnumC1229k[]) f10453f.clone();
    }
}
