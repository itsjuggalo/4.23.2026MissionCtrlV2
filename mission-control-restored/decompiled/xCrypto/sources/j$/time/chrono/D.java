package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class D implements m {
    public static final D BEFORE_ROC;
    public static final D ROC;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ D[] f13135a;

    public static D valueOf(String str) {
        return (D) Enum.valueOf(D.class, str);
    }

    public static D[] values() {
        return (D[]) f13135a.clone();
    }

    static {
        D d4 = new D("BEFORE_ROC", 0);
        BEFORE_ROC = d4;
        D d5 = new D("ROC", 1);
        ROC = d5;
        f13135a = new D[]{d4, d5};
    }

    @Override // j$.time.chrono.m
    public final int p() {
        return ordinal();
    }
}
