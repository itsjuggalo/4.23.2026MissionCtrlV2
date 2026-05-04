package ef;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f8870a = new k("BEGINNING", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f8871b = new k("MIDDLE", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f8872c = new k("AFTER_DOT", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ k[] f8873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ jd.a f8874e;

    static {
        k[] kVarArrA = a();
        f8873d = kVarArrA;
        f8874e = jd.b.a(kVarArrA);
    }

    public k(String str, int i10) {
    }

    public static final /* synthetic */ k[] a() {
        return new k[]{f8870a, f8871b, f8872c};
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f8873d.clone();
    }
}
