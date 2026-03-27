package s3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: s3.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1037n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC1037n0 f9613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC1037n0 f9614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC1037n0 f9615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC1037n0 f9616d;
    public static final /* synthetic */ EnumC1037n0[] e;

    static {
        EnumC1037n0 enumC1037n0 = new EnumC1037n0("COMPOSITE_FILTER", 0);
        f9613a = enumC1037n0;
        EnumC1037n0 enumC1037n02 = new EnumC1037n0("FIELD_FILTER", 1);
        f9614b = enumC1037n02;
        EnumC1037n0 enumC1037n03 = new EnumC1037n0("UNARY_FILTER", 2);
        f9615c = enumC1037n03;
        EnumC1037n0 enumC1037n04 = new EnumC1037n0("FILTERTYPE_NOT_SET", 3);
        f9616d = enumC1037n04;
        e = new EnumC1037n0[]{enumC1037n0, enumC1037n02, enumC1037n03, enumC1037n04};
    }

    public static EnumC1037n0 valueOf(String str) {
        return (EnumC1037n0) Enum.valueOf(EnumC1037n0.class, str);
    }

    public static EnumC1037n0[] values() {
        return (EnumC1037n0[]) e.clone();
    }
}
