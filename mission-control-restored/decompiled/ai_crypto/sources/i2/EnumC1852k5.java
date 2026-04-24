package i2;

/* JADX INFO: renamed from: i2.k5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1852k5 {
    GOOGLE_ANALYTICS(0),
    GOOGLE_SIGNAL(1),
    SGTM(2),
    SGTM_CLIENT(3),
    GOOGLE_SIGNAL_PENDING(4),
    UNKNOWN(99);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15883a;

    EnumC1852k5(int i7) {
        this.f15883a = i7;
    }

    public static EnumC1852k5 a(int i7) {
        for (EnumC1852k5 enumC1852k5 : values()) {
            if (enumC1852k5.f15883a == i7) {
                return enumC1852k5;
            }
        }
        return UNKNOWN;
    }

    public final int zza() {
        return this.f15883a;
    }
}
