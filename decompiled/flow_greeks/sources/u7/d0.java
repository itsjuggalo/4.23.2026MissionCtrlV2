package u7;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public enum d0 {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22251a;

    d0(int i10) {
        this.f22251a = i10;
    }

    public static d0 b(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    public int c() {
        return this.f22251a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f22251a);
    }
}
