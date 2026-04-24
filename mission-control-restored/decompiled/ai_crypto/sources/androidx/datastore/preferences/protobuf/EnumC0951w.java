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
public final class EnumC0951w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC0951w f7623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC0951w f7624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnumC0951w f7625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final EnumC0951w f7626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final EnumC0951w f7627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final EnumC0951w f7628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final EnumC0951w f7629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final EnumC0951w f7630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final EnumC0951w f7631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final EnumC0951w f7632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ EnumC0951w[] f7633n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f7634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f7635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f7636c;

    static {
        EnumC0951w enumC0951w = new EnumC0951w("VOID", 0, Void.class, Void.class, null);
        f7623d = enumC0951w;
        Class cls = Integer.TYPE;
        EnumC0951w enumC0951w2 = new EnumC0951w("INT", 1, cls, Integer.class, 0);
        f7624e = enumC0951w2;
        EnumC0951w enumC0951w3 = new EnumC0951w("LONG", 2, Long.TYPE, Long.class, 0L);
        f7625f = enumC0951w3;
        EnumC0951w enumC0951w4 = new EnumC0951w("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f7626g = enumC0951w4;
        EnumC0951w enumC0951w5 = new EnumC0951w("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f7627h = enumC0951w5;
        EnumC0951w enumC0951w6 = new EnumC0951w("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f7628i = enumC0951w6;
        EnumC0951w enumC0951w7 = new EnumC0951w("STRING", 6, String.class, String.class, "");
        f7629j = enumC0951w7;
        EnumC0951w enumC0951w8 = new EnumC0951w("BYTE_STRING", 7, AbstractC0935f.class, AbstractC0935f.class, AbstractC0935f.f7402b);
        f7630k = enumC0951w8;
        EnumC0951w enumC0951w9 = new EnumC0951w("ENUM", 8, cls, Integer.class, null);
        f7631l = enumC0951w9;
        EnumC0951w enumC0951w10 = new EnumC0951w("MESSAGE", 9, Object.class, Object.class, null);
        f7632m = enumC0951w10;
        f7633n = new EnumC0951w[]{enumC0951w, enumC0951w2, enumC0951w3, enumC0951w4, enumC0951w5, enumC0951w6, enumC0951w7, enumC0951w8, enumC0951w9, enumC0951w10};
    }

    public EnumC0951w(String str, int i7, Class cls, Class cls2, Object obj) {
        this.f7634a = cls;
        this.f7635b = cls2;
        this.f7636c = obj;
    }

    public static EnumC0951w valueOf(String str) {
        return (EnumC0951w) Enum.valueOf(EnumC0951w.class, str);
    }

    public static EnumC0951w[] values() {
        return (EnumC0951w[]) f7633n.clone();
    }

    public Class a() {
        return this.f7635b;
    }
}
