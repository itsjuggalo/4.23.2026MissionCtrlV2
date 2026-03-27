package androidx.datastore.preferences.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1120w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC1120w f11435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC1120w f11436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnumC1120w f11437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final EnumC1120w f11438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final EnumC1120w f11439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final EnumC1120w f11440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final EnumC1120w f11441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final EnumC1120w f11442k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final EnumC1120w f11443l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final EnumC1120w f11444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ EnumC1120w[] f11445n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f11446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f11447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11448c;

    static {
        EnumC1120w enumC1120w = new EnumC1120w("VOID", 0, Void.class, Void.class, null);
        f11435d = enumC1120w;
        Class cls = Integer.TYPE;
        EnumC1120w enumC1120w2 = new EnumC1120w("INT", 1, cls, Integer.class, 0);
        f11436e = enumC1120w2;
        EnumC1120w enumC1120w3 = new EnumC1120w("LONG", 2, Long.TYPE, Long.class, 0L);
        f11437f = enumC1120w3;
        EnumC1120w enumC1120w4 = new EnumC1120w("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f11438g = enumC1120w4;
        EnumC1120w enumC1120w5 = new EnumC1120w("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f11439h = enumC1120w5;
        EnumC1120w enumC1120w6 = new EnumC1120w("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f11440i = enumC1120w6;
        EnumC1120w enumC1120w7 = new EnumC1120w("STRING", 6, String.class, String.class, "");
        f11441j = enumC1120w7;
        EnumC1120w enumC1120w8 = new EnumC1120w("BYTE_STRING", 7, AbstractC1104f.class, AbstractC1104f.class, AbstractC1104f.f11214b);
        f11442k = enumC1120w8;
        EnumC1120w enumC1120w9 = new EnumC1120w("ENUM", 8, cls, Integer.class, null);
        f11443l = enumC1120w9;
        EnumC1120w enumC1120w10 = new EnumC1120w("MESSAGE", 9, Object.class, Object.class, null);
        f11444m = enumC1120w10;
        f11445n = new EnumC1120w[]{enumC1120w, enumC1120w2, enumC1120w3, enumC1120w4, enumC1120w5, enumC1120w6, enumC1120w7, enumC1120w8, enumC1120w9, enumC1120w10};
    }

    public EnumC1120w(String str, int i8, Class cls, Class cls2, Object obj) {
        this.f11446a = cls;
        this.f11447b = cls2;
        this.f11448c = obj;
    }

    public static EnumC1120w valueOf(String str) {
        return (EnumC1120w) Enum.valueOf(EnumC1120w.class, str);
    }

    public static EnumC1120w[] values() {
        return (EnumC1120w[]) f11445n.clone();
    }

    public Class a() {
        return this.f11447b;
    }
}
