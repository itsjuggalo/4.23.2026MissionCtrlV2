package we;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o1 f24024a = new o1("FLEXIBLE_LOWER", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o1 f24025b = new o1("FLEXIBLE_UPPER", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o1 f24026c = new o1("INFLEXIBLE", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ o1[] f24027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ jd.a f24028e;

    static {
        o1[] o1VarArrA = a();
        f24027d = o1VarArrA;
        f24028e = jd.b.a(o1VarArrA);
    }

    public o1(String str, int i10) {
    }

    public static final /* synthetic */ o1[] a() {
        return new o1[]{f24024a, f24025b, f24026c};
    }

    public static o1 valueOf(String str) {
        return (o1) Enum.valueOf(o1.class, str);
    }

    public static o1[] values() {
        return (o1[]) f24027d.clone();
    }
}
