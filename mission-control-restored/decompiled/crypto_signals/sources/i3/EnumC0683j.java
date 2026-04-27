package i3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: i3.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0683j implements H2.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC0683j f6971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC0683j f6972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC0683j f6973d;
    public static final /* synthetic */ EnumC0683j[] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6974a;

    static {
        EnumC0683j enumC0683j = new EnumC0683j("COLLECTION_UNKNOWN", 0, 0);
        EnumC0683j enumC0683j2 = new EnumC0683j("COLLECTION_SDK_NOT_INSTALLED", 1, 1);
        f6971b = enumC0683j2;
        EnumC0683j enumC0683j3 = new EnumC0683j("COLLECTION_ENABLED", 2, 2);
        f6972c = enumC0683j3;
        EnumC0683j enumC0683j4 = new EnumC0683j("COLLECTION_DISABLED", 3, 3);
        f6973d = enumC0683j4;
        EnumC0683j[] enumC0683jArr = {enumC0683j, enumC0683j2, enumC0683j3, enumC0683j4, new EnumC0683j("COLLECTION_DISABLED_REMOTE", 4, 4), new EnumC0683j("COLLECTION_SAMPLED", 5, 5)};
        e = enumC0683jArr;
        s3.D.H(enumC0683jArr);
    }

    public EnumC0683j(String str, int i, int i6) {
        this.f6974a = i6;
    }

    public static EnumC0683j valueOf(String str) {
        return (EnumC0683j) Enum.valueOf(EnumC0683j.class, str);
    }

    public static EnumC0683j[] values() {
        return (EnumC0683j[]) e.clone();
    }

    @Override // H2.f
    public final int a() {
        return this.f6974a;
    }
}
