package I5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3043a = new a("COROUTINE_SUSPENDED", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3044b = new a("UNDECIDED", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f3045c = new a("RESUMED", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ a[] f3046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ K5.a f3047e;

    static {
        a[] aVarArrA = a();
        f3046d = aVarArrA;
        f3047e = K5.b.a(aVarArrA);
    }

    public a(String str, int i7) {
    }

    public static final /* synthetic */ a[] a() {
        return new a[]{f3043a, f3044b, f3045c};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f3046d.clone();
    }
}
