package ge;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f10539b = new e("FIELD", 0, null, 1, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f10540c = new e("FILE", 1, null, 1, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f10541d = new e("PROPERTY", 2, null, 1, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f10542e = new e("PROPERTY_GETTER", 3, com.amazon.a.a.o.b.au);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f10543f = new e("PROPERTY_SETTER", 4, "set");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f10544g = new e("RECEIVER", 5, 0 == true ? 1 : 0, 1, null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f10545h = new e("CONSTRUCTOR_PARAMETER", 6, "param");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f10546i = new e("SETTER_PARAMETER", 7, "setparam");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f10547j = new e("PROPERTY_DELEGATE_FIELD", 8, "delegate");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ e[] f10548k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ jd.a f10549l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10550a;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        e[] eVarArrA = a();
        f10548k = eVarArrA;
        f10549l = jd.b.a(eVarArrA);
    }

    public e(String str, int i10, String str2) {
        this.f10550a = str2 == null ? fg.a.f(name()) : str2;
    }

    public static final /* synthetic */ e[] a() {
        return new e[]{f10539b, f10540c, f10541d, f10542e, f10543f, f10544g, f10545h, f10546i, f10547j};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f10548k.clone();
    }

    public final String b() {
        return this.f10550a;
    }

    public /* synthetic */ e(String str, int i10, String str2, int i11, kotlin.jvm.internal.k kVar) {
        this(str, i10, (i11 & 1) != 0 ? null : str2);
    }
}
