package i3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: i3.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0672A implements H2.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC0672A f6824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumC0672A[] f6825c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6826a;

    static {
        EnumC0672A enumC0672A = new EnumC0672A("LOG_ENVIRONMENT_UNKNOWN", 0, 0);
        EnumC0672A enumC0672A2 = new EnumC0672A("LOG_ENVIRONMENT_AUTOPUSH", 1, 1);
        EnumC0672A enumC0672A3 = new EnumC0672A("LOG_ENVIRONMENT_STAGING", 2, 2);
        EnumC0672A enumC0672A4 = new EnumC0672A("LOG_ENVIRONMENT_PROD", 3, 3);
        f6824b = enumC0672A4;
        EnumC0672A[] enumC0672AArr = {enumC0672A, enumC0672A2, enumC0672A3, enumC0672A4};
        f6825c = enumC0672AArr;
        s3.D.H(enumC0672AArr);
    }

    public EnumC0672A(String str, int i, int i6) {
        this.f6826a = i6;
    }

    public static EnumC0672A valueOf(String str) {
        return (EnumC0672A) Enum.valueOf(EnumC0672A.class, str);
    }

    public static EnumC0672A[] values() {
        return (EnumC0672A[]) f6825c.clone();
    }

    @Override // H2.f
    public final int a() {
        return this.f6826a;
    }
}
