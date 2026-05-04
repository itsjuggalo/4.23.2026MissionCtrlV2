package we;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f23983a = new i("READ_ONLY", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f23984b = new i("MUTABLE", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ i[] f23985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ jd.a f23986d;

    static {
        i[] iVarArrA = a();
        f23985c = iVarArrA;
        f23986d = jd.b.a(iVarArrA);
    }

    public i(String str, int i10) {
    }

    public static final /* synthetic */ i[] a() {
        return new i[]{f23983a, f23984b};
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) f23985c.clone();
    }
}
