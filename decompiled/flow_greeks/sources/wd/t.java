package wd;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f23912a = new t("INVARIANT", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f23913b = new t("IN", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f23914c = new t("OUT", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ t[] f23915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ jd.a f23916e;

    static {
        t[] tVarArrA = a();
        f23915d = tVarArrA;
        f23916e = jd.b.a(tVarArrA);
    }

    public t(String str, int i10) {
    }

    public static final /* synthetic */ t[] a() {
        return new t[]{f23912a, f23913b, f23914c};
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f23915d.clone();
    }
}
