package h3;

/* JADX INFO: renamed from: h3.J, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1679J {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14764a;

    EnumC1679J(int i7) {
        this.f14764a = i7;
    }

    public static EnumC1679J b(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    public int c() {
        return this.f14764a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f14764a);
    }
}
