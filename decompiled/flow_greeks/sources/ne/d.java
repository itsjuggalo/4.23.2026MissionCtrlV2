package ne;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f17034a = new d("FROM_IDE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f17035b = new d("FROM_BACKEND", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f17036c = new d("FROM_TEST", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f17037d = new d("FROM_BUILTINS", 3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f17038e = new d("WHEN_CHECK_DECLARATION_CONFLICTS", 4);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f17039f = new d("WHEN_CHECK_OVERRIDES", 5);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f17040g = new d("FOR_SCRIPT", 6);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f17041h = new d("FROM_REFLECTION", 7);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f17042i = new d("WHEN_RESOLVE_DECLARATION", 8);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f17043j = new d("WHEN_GET_DECLARATION_SCOPE", 9);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d f17044k = new d("WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS", 10);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f17045l = new d("FOR_ALREADY_TRACKED", 11);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f17046m = new d("WHEN_GET_ALL_DESCRIPTORS", 12);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f17047n = new d("WHEN_TYPING", 13);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f17048o = new d("WHEN_GET_SUPER_MEMBERS", 14);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f17049p = new d("FOR_NON_TRACKED_SCOPE", 15);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final d f17050q = new d("FROM_SYNTHETIC_SCOPE", 16);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f17051r = new d("FROM_DESERIALIZATION", 17);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final d f17052s = new d("FROM_JAVA_LOADER", 18);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final d f17053t = new d("WHEN_GET_LOCAL_VARIABLE", 19);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f17054u = new d("WHEN_FIND_BY_FQNAME", 20);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f17055v = new d("WHEN_GET_COMPANION_OBJECT", 21);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f17056w = new d("FOR_DEFAULT_IMPORTS", 22);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ d[] f17057x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ jd.a f17058y;

    static {
        d[] dVarArrB = b();
        f17057x = dVarArrB;
        f17058y = jd.b.a(dVarArrB);
    }

    public d(String str, int i10) {
    }

    public static final /* synthetic */ d[] b() {
        return new d[]{f17034a, f17035b, f17036c, f17037d, f17038e, f17039f, f17040g, f17041h, f17042i, f17043j, f17044k, f17045l, f17046m, f17047n, f17048o, f17049p, f17050q, f17051r, f17052s, f17053t, f17054u, f17055v, f17056w};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f17057x.clone();
    }

    @Override // ne.b
    public a a() {
        return null;
    }
}
