package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: androidx.lifecycle.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0356m {
    private static final /* synthetic */ EnumC0356m[] $VALUES;
    public static final C0354k Companion;
    public static final EnumC0356m ON_ANY;
    public static final EnumC0356m ON_CREATE;
    public static final EnumC0356m ON_DESTROY;
    public static final EnumC0356m ON_PAUSE;
    public static final EnumC0356m ON_RESUME;
    public static final EnumC0356m ON_START;
    public static final EnumC0356m ON_STOP;

    static {
        EnumC0356m enumC0356m = new EnumC0356m("ON_CREATE", 0);
        ON_CREATE = enumC0356m;
        EnumC0356m enumC0356m2 = new EnumC0356m("ON_START", 1);
        ON_START = enumC0356m2;
        EnumC0356m enumC0356m3 = new EnumC0356m("ON_RESUME", 2);
        ON_RESUME = enumC0356m3;
        EnumC0356m enumC0356m4 = new EnumC0356m("ON_PAUSE", 3);
        ON_PAUSE = enumC0356m4;
        EnumC0356m enumC0356m5 = new EnumC0356m("ON_STOP", 4);
        ON_STOP = enumC0356m5;
        EnumC0356m enumC0356m6 = new EnumC0356m("ON_DESTROY", 5);
        ON_DESTROY = enumC0356m6;
        EnumC0356m enumC0356m7 = new EnumC0356m("ON_ANY", 6);
        ON_ANY = enumC0356m7;
        $VALUES = new EnumC0356m[]{enumC0356m, enumC0356m2, enumC0356m3, enumC0356m4, enumC0356m5, enumC0356m6, enumC0356m7};
        Companion = new C0354k();
    }

    public static EnumC0356m valueOf(String str) {
        return (EnumC0356m) Enum.valueOf(EnumC0356m.class, str);
    }

    public static EnumC0356m[] values() {
        return (EnumC0356m[]) $VALUES.clone();
    }

    public final EnumC0357n a() {
        switch (AbstractC0355l.f4680a[ordinal()]) {
            case 1:
            case 2:
                return EnumC0357n.f4683c;
            case 3:
            case 4:
                return EnumC0357n.f4684d;
            case 5:
                return EnumC0357n.e;
            case 6:
                return EnumC0357n.f4681a;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
