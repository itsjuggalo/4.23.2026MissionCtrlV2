package S1;

/* JADX INFO: renamed from: S1.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0630n {
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
    public final char f4771a;

    EnumC0630n(char c4) {
        this.f4771a = c4;
    }

    public static EnumC0630n a(char c4) {
        for (EnumC0630n enumC0630n : values()) {
            if (enumC0630n.f4771a == c4) {
                return enumC0630n;
            }
        }
        return UNSET;
    }

    public final /* synthetic */ char c() {
        return this.f4771a;
    }
}
