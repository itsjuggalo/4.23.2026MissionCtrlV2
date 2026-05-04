package fe;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f9473b = new f("CLASS", 0, "class");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f9474c = new f("INTERFACE", 1, "interface");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f9475d = new f("ENUM_CLASS", 2, "enum class");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f9476e = new f("ENUM_ENTRY", 3, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f9477f = new f("ANNOTATION_CLASS", 4, "annotation class");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f9478g = new f("OBJECT", 5, "object");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ f[] f9479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ jd.a f9480i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9481a;

    static {
        f[] fVarArrA = a();
        f9479h = fVarArrA;
        f9480i = jd.b.a(fVarArrA);
    }

    public f(String str, int i10, String str2) {
        this.f9481a = str2;
    }

    public static final /* synthetic */ f[] a() {
        return new f[]{f9473b, f9474c, f9475d, f9476e, f9477f, f9478g};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f9479h.clone();
    }

    public final boolean b() {
        return this == f9478g || this == f9476e;
    }
}
