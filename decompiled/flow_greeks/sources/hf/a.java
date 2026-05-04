package hf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f11304c = new a("NO_ARGUMENTS", 0, false, false, 3, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f11305d = new a("UNLESS_EMPTY", 1, true, false, 2, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f11306e = new a("ALWAYS_PARENTHESIZED", 2, true, true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ a[] f11307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ jd.a f11308g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11310b;

    static {
        a[] aVarArrA = a();
        f11307f = aVarArrA;
        f11308g = jd.b.a(aVarArrA);
    }

    public a(String str, int i10, boolean z10, boolean z11) {
        this.f11309a = z10;
        this.f11310b = z11;
    }

    public static final /* synthetic */ a[] a() {
        return new a[]{f11304c, f11305d, f11306e};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f11307f.clone();
    }

    public final boolean b() {
        return this.f11309a;
    }

    public final boolean c() {
        return this.f11310b;
    }

    public /* synthetic */ a(String str, int i10, boolean z10, boolean z11, int i11, kotlin.jvm.internal.k kVar) {
        this(str, i10, (i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? false : z11);
    }
}
