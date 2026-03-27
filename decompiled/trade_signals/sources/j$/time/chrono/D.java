package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class D implements m {
    public static final D BEFORE_ROC;
    public static final D ROC;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ D[] f19669a;

    static {
        D d8 = new D("BEFORE_ROC", 0);
        BEFORE_ROC = d8;
        D d9 = new D("ROC", 1);
        ROC = d9;
        f19669a = new D[]{d8, d9};
    }

    public static D valueOf(String str) {
        return (D) Enum.valueOf(D.class, str);
    }

    public static D[] values() {
        return (D[]) f19669a.clone();
    }

    @Override // j$.time.chrono.m
    public final int o() {
        return ordinal();
    }
}
