package ge;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f10572a = new q("RUNTIME", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f10573b = new q("BINARY", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f10574c = new q("SOURCE", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ q[] f10575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ jd.a f10576e;

    static {
        q[] qVarArrA = a();
        f10575d = qVarArrA;
        f10576e = jd.b.a(qVarArrA);
    }

    public q(String str, int i10) {
    }

    public static final /* synthetic */ q[] a() {
        return new q[]{f10572a, f10573b, f10574c};
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f10575d.clone();
    }
}
