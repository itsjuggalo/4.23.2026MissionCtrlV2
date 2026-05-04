package xf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m2 f25015e = new m2("INVARIANT", 0, "", true, true, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m2 f25016f = new m2("IN_VARIANCE", 1, "in", true, false, -1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final m2 f25017g = new m2("OUT_VARIANCE", 2, "out", false, true, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ m2[] f25018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ jd.a f25019i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f25021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f25022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f25023d;

    static {
        m2[] m2VarArrA = a();
        f25018h = m2VarArrA;
        f25019i = jd.b.a(m2VarArrA);
    }

    public m2(String str, int i10, String str2, boolean z10, boolean z11, int i11) {
        this.f25020a = str2;
        this.f25021b = z10;
        this.f25022c = z11;
        this.f25023d = i11;
    }

    public static final /* synthetic */ m2[] a() {
        return new m2[]{f25015e, f25016f, f25017g};
    }

    public static m2 valueOf(String str) {
        return (m2) Enum.valueOf(m2.class, str);
    }

    public static m2[] values() {
        return (m2[]) f25018h.clone();
    }

    public final boolean b() {
        return this.f25022c;
    }

    public final String c() {
        return this.f25020a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f25020a;
    }
}
