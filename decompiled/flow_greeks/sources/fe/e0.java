package fe;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f9461b = new e0("FINAL", 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e0 f9462c = new e0("SEALED", 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e0 f9463d = new e0("OPEN", 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e0 f9464e = new e0("ABSTRACT", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ e0[] f9465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ jd.a f9466g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final e0 a(boolean z10, boolean z11, boolean z12) {
            return z10 ? e0.f9462c : z11 ? e0.f9464e : z12 ? e0.f9463d : e0.f9461b;
        }

        public a() {
        }
    }

    static {
        e0[] e0VarArrA = a();
        f9465f = e0VarArrA;
        f9466g = jd.b.a(e0VarArrA);
        f9460a = new a(null);
    }

    public e0(String str, int i10) {
    }

    public static final /* synthetic */ e0[] a() {
        return new e0[]{f9461b, f9462c, f9463d, f9464e};
    }

    public static e0 valueOf(String str) {
        return (e0) Enum.valueOf(e0.class, str);
    }

    public static e0[] values() {
        return (e0[]) f9465f.clone();
    }
}
