package hf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f11318a = new c0("RENDER_OVERRIDE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0 f11319b = new c0("RENDER_OPEN", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c0 f11320c = new c0("RENDER_OPEN_OVERRIDE", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ c0[] f11321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ jd.a f11322e;

    static {
        c0[] c0VarArrA = a();
        f11321d = c0VarArrA;
        f11322e = jd.b.a(c0VarArrA);
    }

    public c0(String str, int i10) {
    }

    public static final /* synthetic */ c0[] a() {
        return new c0[]{f11318a, f11319b, f11320c};
    }

    public static c0 valueOf(String str) {
        return (c0) Enum.valueOf(c0.class, str);
    }

    public static c0[] values() {
        return (c0[]) f11321d.clone();
    }
}
