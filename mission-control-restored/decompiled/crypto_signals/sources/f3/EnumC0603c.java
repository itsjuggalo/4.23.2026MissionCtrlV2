package f3;

/* JADX INFO: renamed from: f3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0603c implements I2.c {
    /* JADX INFO: Fake field, exist only in values array */
    UNKNOWN_OS(0),
    ANDROID(1),
    /* JADX INFO: Fake field, exist only in values array */
    IOS(2),
    /* JADX INFO: Fake field, exist only in values array */
    WEB(3);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6448a;

    EnumC0603c(int i) {
        this.f6448a = i;
    }

    @Override // I2.c
    public final int a() {
        return this.f6448a;
    }
}
