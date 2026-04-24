package S2;

/* JADX INFO: loaded from: classes.dex */
public enum F {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7486a;

    F(int i8) {
        this.f7486a = i8;
    }

    public static F b(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    public int g() {
        return this.f7486a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f7486a);
    }
}
