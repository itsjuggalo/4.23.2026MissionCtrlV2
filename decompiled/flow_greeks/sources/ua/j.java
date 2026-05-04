package ua;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements a9.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f22591b = new j("EVENT_TYPE_UNKNOWN", 0, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f22592c = new j("SESSION_START", 1, 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ j[] f22593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ jd.a f22594e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22595a;

    static {
        j[] jVarArrA = a();
        f22593d = jVarArrA;
        f22594e = jd.b.a(jVarArrA);
    }

    public j(String str, int i10, int i11) {
        this.f22595a = i11;
    }

    public static final /* synthetic */ j[] a() {
        return new j[]{f22591b, f22592c};
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f22593d.clone();
    }

    @Override // a9.f
    public int d() {
        return this.f22595a;
    }
}
