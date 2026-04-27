package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class A {
    public static final A FULL;
    public static final A FULL_STANDALONE;
    public static final A NARROW;
    public static final A NARROW_STANDALONE;
    public static final A SHORT;
    public static final A SHORT_STANDALONE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ A[] f7440a;

    public static A valueOf(String str) {
        return (A) Enum.valueOf(A.class, str);
    }

    public static A[] values() {
        return (A[]) f7440a.clone();
    }

    static {
        A a6 = new A("FULL", 0);
        FULL = a6;
        A a7 = new A("FULL_STANDALONE", 1);
        FULL_STANDALONE = a7;
        A a8 = new A("SHORT", 2);
        SHORT = a8;
        A a9 = new A("SHORT_STANDALONE", 3);
        SHORT_STANDALONE = a9;
        A a10 = new A("NARROW", 4);
        NARROW = a10;
        A a11 = new A("NARROW_STANDALONE", 5);
        NARROW_STANDALONE = a11;
        f7440a = new A[]{a6, a7, a8, a9, a10, a11};
    }
}
