package P2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final B f2352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final B f2353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final B f2354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final B f2355d;
    public static final /* synthetic */ B[] e;

    static {
        B b3 = new B("LISTEN", 0);
        f2352a = b3;
        B b6 = new B("EXISTENCE_FILTER_MISMATCH", 1);
        f2353b = b6;
        B b7 = new B("EXISTENCE_FILTER_MISMATCH_BLOOM", 2);
        f2354c = b7;
        B b8 = new B("LIMBO_RESOLUTION", 3);
        f2355d = b8;
        e = new B[]{b3, b6, b7, b8};
    }

    public static B valueOf(String str) {
        return (B) Enum.valueOf(B.class, str);
    }

    public static B[] values() {
        return (B[]) e.clone();
    }
}
