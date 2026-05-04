package bg;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f3357b = new t("IN", 0, "in");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f3358c = new t("OUT", 1, "out");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final t f3359d = new t("INV", 2, "");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ t[] f3360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ jd.a f3361f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3362a;

    static {
        t[] tVarArrA = a();
        f3360e = tVarArrA;
        f3361f = jd.b.a(tVarArrA);
    }

    public t(String str, int i10, String str2) {
        this.f3362a = str2;
    }

    public static final /* synthetic */ t[] a() {
        return new t[]{f3357b, f3358c, f3359d};
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f3360e.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f3362a;
    }
}
