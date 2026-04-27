package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class A {
    public static final A FULL;
    public static final A FULL_STANDALONE;
    public static final A NARROW;
    public static final A NARROW_STANDALONE;
    public static final A SHORT;
    public static final A SHORT_STANDALONE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ A[] f17155a;

    public static A valueOf(String str) {
        return (A) Enum.valueOf(A.class, str);
    }

    public static A[] values() {
        return (A[]) f17155a.clone();
    }

    static {
        A a7 = new A("FULL", 0);
        FULL = a7;
        A a8 = new A("FULL_STANDALONE", 1);
        FULL_STANDALONE = a8;
        A a9 = new A("SHORT", 2);
        SHORT = a9;
        A a10 = new A("SHORT_STANDALONE", 3);
        SHORT_STANDALONE = a10;
        A a11 = new A("NARROW", 4);
        NARROW = a11;
        A a12 = new A("NARROW_STANDALONE", 5);
        NARROW_STANDALONE = a12;
        f17155a = new A[]{a7, a8, a9, a10, a11, a12};
    }
}
