package xf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h2 f24978a = new h2("SUPERTYPE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h2 f24979b = new h2("COMMON", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ h2[] f24980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ jd.a f24981d;

    static {
        h2[] h2VarArrA = a();
        f24980c = h2VarArrA;
        f24981d = jd.b.a(h2VarArrA);
    }

    public h2(String str, int i10) {
    }

    public static final /* synthetic */ h2[] a() {
        return new h2[]{f24978a, f24979b};
    }

    public static h2 valueOf(String str) {
        return (h2) Enum.valueOf(h2.class, str);
    }

    public static h2[] values() {
        return (h2[]) f24980c.clone();
    }
}
