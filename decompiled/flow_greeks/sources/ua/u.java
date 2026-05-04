package ua;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements a9.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f22699b = new u("LOG_ENVIRONMENT_UNKNOWN", 0, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f22700c = new u("LOG_ENVIRONMENT_AUTOPUSH", 1, 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f22701d = new u("LOG_ENVIRONMENT_STAGING", 2, 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final u f22702e = new u("LOG_ENVIRONMENT_PROD", 3, 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ u[] f22703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ jd.a f22704g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22705a;

    static {
        u[] uVarArrA = a();
        f22703f = uVarArrA;
        f22704g = jd.b.a(uVarArrA);
    }

    public u(String str, int i10, int i11) {
        this.f22705a = i11;
    }

    public static final /* synthetic */ u[] a() {
        return new u[]{f22699b, f22700c, f22701d, f22702e};
    }

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) f22703f.clone();
    }

    @Override // a9.f
    public int d() {
        return this.f22705a;
    }
}
