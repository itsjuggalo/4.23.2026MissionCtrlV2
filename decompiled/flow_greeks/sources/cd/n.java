package cd;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f3863a = new n("SYNCHRONIZED", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f3864b = new n("PUBLICATION", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f3865c = new n("NONE", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ n[] f3866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ jd.a f3867e;

    static {
        n[] nVarArrA = a();
        f3866d = nVarArrA;
        f3867e = jd.b.a(nVarArrA);
    }

    public n(String str, int i10) {
    }

    public static final /* synthetic */ n[] a() {
        return new n[]{f3863a, f3864b, f3865c};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f3866d.clone();
    }
}
