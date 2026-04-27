package T2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: T2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0246j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0246j f2966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC0246j f2967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumC0246j[] f2968c;

    static {
        EnumC0246j enumC0246j = new EnumC0246j("UNREACHABLE", 0);
        f2966a = enumC0246j;
        EnumC0246j enumC0246j2 = new EnumC0246j("REACHABLE", 1);
        f2967b = enumC0246j2;
        f2968c = new EnumC0246j[]{enumC0246j, enumC0246j2};
    }

    public static EnumC0246j valueOf(String str) {
        return (EnumC0246j) Enum.valueOf(EnumC0246j.class, str);
    }

    public static EnumC0246j[] values() {
        return (EnumC0246j[]) f2968c.clone();
    }
}
