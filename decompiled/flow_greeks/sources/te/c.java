package te;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f21902a = new c("INFLEXIBLE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f21903b = new c("FLEXIBLE_UPPER_BOUND", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f21904c = new c("FLEXIBLE_LOWER_BOUND", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ c[] f21905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ jd.a f21906e;

    static {
        c[] cVarArrA = a();
        f21905d = cVarArrA;
        f21906e = jd.b.a(cVarArrA);
    }

    public c(String str, int i10) {
    }

    public static final /* synthetic */ c[] a() {
        return new c[]{f21902a, f21903b, f21904c};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f21905d.clone();
    }
}
