package ve;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f23406a = new d0("SOURCE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0 f23407b = new d0("BINARY", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ d0[] f23408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ jd.a f23409d;

    static {
        d0[] d0VarArrA = a();
        f23408c = d0VarArrA;
        f23409d = jd.b.a(d0VarArrA);
    }

    public d0(String str, int i10) {
    }

    public static final /* synthetic */ d0[] a() {
        return new d0[]{f23406a, f23407b};
    }

    public static d0 valueOf(String str) {
        return (d0) Enum.valueOf(d0.class, str);
    }

    public static d0[] values() {
        return (d0[]) f23408c.clone();
    }
}
