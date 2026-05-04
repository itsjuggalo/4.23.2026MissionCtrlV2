package fh;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d1 f9556c = new d1("OBJ", 0, '{', '}');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d1 f9557d = new d1("LIST", 1, '[', ']');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d1 f9558e = new d1("MAP", 2, '{', '}');

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d1 f9559f = new d1("POLY_OBJ", 3, '[', ']');

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ d1[] f9560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ jd.a f9561h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f9562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f9563b;

    static {
        d1[] d1VarArrA = a();
        f9560g = d1VarArrA;
        f9561h = jd.b.a(d1VarArrA);
    }

    public d1(String str, int i10, char c10, char c11) {
        this.f9562a = c10;
        this.f9563b = c11;
    }

    public static final /* synthetic */ d1[] a() {
        return new d1[]{f9556c, f9557d, f9558e, f9559f};
    }

    public static jd.a b() {
        return f9561h;
    }

    public static d1 valueOf(String str) {
        return (d1) Enum.valueOf(d1.class, str);
    }

    public static d1[] values() {
        return (d1[]) f9560g.clone();
    }
}
