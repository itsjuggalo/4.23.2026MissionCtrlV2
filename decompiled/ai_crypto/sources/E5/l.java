package E5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f1674a = new l("SYNCHRONIZED", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f1675b = new l("PUBLICATION", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f1676c = new l("NONE", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ l[] f1677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ K5.a f1678e;

    static {
        l[] lVarArrA = a();
        f1677d = lVarArrA;
        f1678e = K5.b.a(lVarArrA);
    }

    public l(String str, int i7) {
    }

    public static final /* synthetic */ l[] a() {
        return new l[]{f1674a, f1675b, f1676c};
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f1677d.clone();
    }
}
