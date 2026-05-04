package ua;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements a9.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f22559b = new d("COLLECTION_UNKNOWN", 0, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f22560c = new d("COLLECTION_SDK_NOT_INSTALLED", 1, 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f22561d = new d("COLLECTION_ENABLED", 2, 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f22562e = new d("COLLECTION_DISABLED", 3, 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f22563f = new d("COLLECTION_DISABLED_REMOTE", 4, 4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f22564g = new d("COLLECTION_SAMPLED", 5, 5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ d[] f22565h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ jd.a f22566i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22567a;

    static {
        d[] dVarArrA = a();
        f22565h = dVarArrA;
        f22566i = jd.b.a(dVarArrA);
    }

    public d(String str, int i10, int i11) {
        this.f22567a = i11;
    }

    public static final /* synthetic */ d[] a() {
        return new d[]{f22559b, f22560c, f22561d, f22562e, f22563f, f22564g};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f22565h.clone();
    }

    @Override // a9.f
    public int d() {
        return this.f22567a;
    }
}
