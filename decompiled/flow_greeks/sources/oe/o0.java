package oe;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f18045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o0 f18046c = new o0("IGNORE", 0, "ignore");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o0 f18047d = new o0("WARN", 1, "warn");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final o0 f18048e = new o0("STRICT", 2, "strict");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ o0[] f18049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ jd.a f18050g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18051a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    static {
        o0[] o0VarArrA = a();
        f18049f = o0VarArrA;
        f18050g = jd.b.a(o0VarArrA);
        f18045b = new a(null);
    }

    public o0(String str, int i10, String str2) {
        this.f18051a = str2;
    }

    public static final /* synthetic */ o0[] a() {
        return new o0[]{f18046c, f18047d, f18048e};
    }

    public static o0 valueOf(String str) {
        return (o0) Enum.valueOf(o0.class, str);
    }

    public static o0[] values() {
        return (o0[]) f18049f.clone();
    }

    public final String b() {
        return this.f18051a;
    }

    public final boolean c() {
        return this == f18046c;
    }

    public final boolean h() {
        return this == f18047d;
    }
}
