package wd;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f23917a = new u("PUBLIC", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f23918b = new u("PROTECTED", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f23919c = new u("INTERNAL", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f23920d = new u("PRIVATE", 3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ u[] f23921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ jd.a f23922f;

    static {
        u[] uVarArrA = a();
        f23921e = uVarArrA;
        f23922f = jd.b.a(uVarArrA);
    }

    public u(String str, int i10) {
    }

    public static final /* synthetic */ u[] a() {
        return new u[]{f23917a, f23918b, f23919c, f23920d};
    }

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) f23921e.clone();
    }
}
