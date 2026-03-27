package u4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: u4.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1242y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC1242y f10491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC1242y f10492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC1242y f10493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumC1242y[] f10494d;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC1242y EF0;

    static {
        EnumC1242y enumC1242y = new EnumC1242y("CT_UNKNOWN", 0);
        EnumC1242y enumC1242y2 = new EnumC1242y("CT_INFO", 1);
        f10491a = enumC1242y2;
        EnumC1242y enumC1242y3 = new EnumC1242y("CT_WARNING", 2);
        f10492b = enumC1242y3;
        EnumC1242y enumC1242y4 = new EnumC1242y("CT_ERROR", 3);
        f10493c = enumC1242y4;
        f10494d = new EnumC1242y[]{enumC1242y, enumC1242y2, enumC1242y3, enumC1242y4};
    }

    public static EnumC1242y valueOf(String str) {
        return (EnumC1242y) Enum.valueOf(EnumC1242y.class, str);
    }

    public static EnumC1242y[] values() {
        return (EnumC1242y[]) f10494d.clone();
    }
}
