package t2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f20661a = new j("STRICT", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f20662b = new j("LOG", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f20663c = new j("QUIET", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ j[] f20664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ jd.a f20665e;

    static {
        j[] jVarArrA = a();
        f20664d = jVarArrA;
        f20665e = jd.b.a(jVarArrA);
    }

    public j(String str, int i10) {
    }

    public static final /* synthetic */ j[] a() {
        return new j[]{f20661a, f20662b, f20663c};
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f20664d.clone();
    }
}
