package we;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f23992a = new k("FORCE_FLEXIBILITY", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f23993b = new k("NULLABLE", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f23994c = new k("NOT_NULL", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ k[] f23995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ jd.a f23996e;

    static {
        k[] kVarArrA = a();
        f23995d = kVarArrA;
        f23996e = jd.b.a(kVarArrA);
    }

    public k(String str, int i10) {
    }

    public static final /* synthetic */ k[] a() {
        return new k[]{f23992a, f23993b, f23994c};
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f23995d.clone();
    }
}
