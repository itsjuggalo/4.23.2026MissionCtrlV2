package vf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f23488a = new r("STABLE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f23489b = new r("UNSTABLE", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ r[] f23490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ jd.a f23491d;

    static {
        r[] rVarArrA = a();
        f23490c = rVarArrA;
        f23491d = jd.b.a(rVarArrA);
    }

    public r(String str, int i10) {
    }

    public static final /* synthetic */ r[] a() {
        return new r[]{f23488a, f23489b};
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f23490c.clone();
    }
}
