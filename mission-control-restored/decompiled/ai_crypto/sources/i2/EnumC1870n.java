package i2;

/* JADX INFO: renamed from: i2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1870n {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f15930a;

    EnumC1870n(char c7) {
        this.f15930a = c7;
    }

    public static EnumC1870n a(char c7) {
        for (EnumC1870n enumC1870n : values()) {
            if (enumC1870n.f15930a == c7) {
                return enumC1870n;
            }
        }
        return UNSET;
    }

    public final /* synthetic */ char b() {
        return this.f15930a;
    }
}
