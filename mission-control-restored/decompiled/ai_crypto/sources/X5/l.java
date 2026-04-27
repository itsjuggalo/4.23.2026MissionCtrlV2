package X5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f5499a = new l("PUBLIC", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f5500b = new l("PROTECTED", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f5501c = new l("INTERNAL", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f5502d = new l("PRIVATE", 3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ l[] f5503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ K5.a f5504f;

    static {
        l[] lVarArrA = a();
        f5503e = lVarArrA;
        f5504f = K5.b.a(lVarArrA);
    }

    public l(String str, int i7) {
    }

    public static final /* synthetic */ l[] a() {
        return new l[]{f5499a, f5500b, f5501c, f5502d};
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f5503e.clone();
    }
}
