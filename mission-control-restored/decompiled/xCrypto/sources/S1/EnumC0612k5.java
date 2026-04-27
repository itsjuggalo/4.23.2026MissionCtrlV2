package S1;

/* JADX INFO: renamed from: S1.k5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0612k5 {
    GOOGLE_ANALYTICS(0),
    GOOGLE_SIGNAL(1),
    SGTM(2),
    SGTM_CLIENT(3),
    GOOGLE_SIGNAL_PENDING(4),
    UNKNOWN(99);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4724a;

    EnumC0612k5(int i4) {
        this.f4724a = i4;
    }

    public static EnumC0612k5 a(int i4) {
        for (EnumC0612k5 enumC0612k5 : values()) {
            if (enumC0612k5.f4724a == i4) {
                return enumC0612k5;
            }
        }
        return UNKNOWN;
    }

    public final int zza() {
        return this.f4724a;
    }
}
