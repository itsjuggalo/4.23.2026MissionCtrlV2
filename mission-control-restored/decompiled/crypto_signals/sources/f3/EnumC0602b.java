package f3;

/* JADX INFO: renamed from: f3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0602b implements I2.c {
    /* JADX INFO: Fake field, exist only in values array */
    UNKNOWN(0),
    DATA_MESSAGE(1),
    /* JADX INFO: Fake field, exist only in values array */
    TOPIC(2),
    DISPLAY_NOTIFICATION(3);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6445a;

    EnumC0602b(int i) {
        this.f6445a = i;
    }

    @Override // I2.c
    public final int a() {
        return this.f6445a;
    }
}
