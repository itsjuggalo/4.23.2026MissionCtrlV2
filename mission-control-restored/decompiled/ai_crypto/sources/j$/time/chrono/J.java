package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class J implements m {
    public static final J BE;
    public static final J BEFORE_BE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ J[] f17101a;

    public static J valueOf(String str) {
        return (J) Enum.valueOf(J.class, str);
    }

    public static J[] values() {
        return (J[]) f17101a.clone();
    }

    static {
        J j7 = new J("BEFORE_BE", 0);
        BEFORE_BE = j7;
        J j8 = new J("BE", 1);
        BE = j8;
        f17101a = new J[]{j7, j8};
    }

    @Override // j$.time.chrono.m
    public final int p() {
        return ordinal();
    }
}
