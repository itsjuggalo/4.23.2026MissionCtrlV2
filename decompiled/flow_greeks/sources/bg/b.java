package bg;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f3351a = new b("FOR_SUBTYPING", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f3352b = new b("FOR_INCORPORATION", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f3353c = new b("FROM_EXPRESSION", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ b[] f3354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ jd.a f3355e;

    static {
        b[] bVarArrA = a();
        f3354d = bVarArrA;
        f3355e = jd.b.a(bVarArrA);
    }

    public b(String str, int i10) {
    }

    public static final /* synthetic */ b[] a() {
        return new b[]{f3351a, f3352b, f3353c};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f3354d.clone();
    }
}
