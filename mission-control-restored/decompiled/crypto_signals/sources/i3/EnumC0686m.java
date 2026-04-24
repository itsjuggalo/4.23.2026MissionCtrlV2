package i3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: i3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0686m implements H2.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC0686m f6983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumC0686m[] f6984c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6985a;

    static {
        EnumC0686m enumC0686m = new EnumC0686m("EVENT_TYPE_UNKNOWN", 0, 0);
        EnumC0686m enumC0686m2 = new EnumC0686m("SESSION_START", 1, 1);
        f6983b = enumC0686m2;
        EnumC0686m[] enumC0686mArr = {enumC0686m, enumC0686m2};
        f6984c = enumC0686mArr;
        s3.D.H(enumC0686mArr);
    }

    public EnumC0686m(String str, int i, int i6) {
        this.f6985a = i6;
    }

    public static EnumC0686m valueOf(String str) {
        return (EnumC0686m) Enum.valueOf(EnumC0686m.class, str);
    }

    public static EnumC0686m[] values() {
        return (EnumC0686m[]) f6984c.clone();
    }

    @Override // H2.f
    public final int a() {
        return this.f6985a;
    }
}
