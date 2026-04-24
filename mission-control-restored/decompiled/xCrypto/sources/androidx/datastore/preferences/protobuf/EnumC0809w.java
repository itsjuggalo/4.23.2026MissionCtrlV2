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
public final class EnumC0809w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC0809w f7215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC0809w f7216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnumC0809w f7217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final EnumC0809w f7218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final EnumC0809w f7219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final EnumC0809w f7220i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final EnumC0809w f7221j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final EnumC0809w f7222k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final EnumC0809w f7223l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final EnumC0809w f7224m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ EnumC0809w[] f7225n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f7226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f7227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f7228c;

    static {
        EnumC0809w enumC0809w = new EnumC0809w("VOID", 0, Void.class, Void.class, null);
        f7215d = enumC0809w;
        Class cls = Integer.TYPE;
        EnumC0809w enumC0809w2 = new EnumC0809w("INT", 1, cls, Integer.class, 0);
        f7216e = enumC0809w2;
        EnumC0809w enumC0809w3 = new EnumC0809w("LONG", 2, Long.TYPE, Long.class, 0L);
        f7217f = enumC0809w3;
        EnumC0809w enumC0809w4 = new EnumC0809w("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f7218g = enumC0809w4;
        EnumC0809w enumC0809w5 = new EnumC0809w("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f7219h = enumC0809w5;
        EnumC0809w enumC0809w6 = new EnumC0809w("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f7220i = enumC0809w6;
        EnumC0809w enumC0809w7 = new EnumC0809w("STRING", 6, String.class, String.class, "");
        f7221j = enumC0809w7;
        EnumC0809w enumC0809w8 = new EnumC0809w("BYTE_STRING", 7, AbstractC0793f.class, AbstractC0793f.class, AbstractC0793f.f6994b);
        f7222k = enumC0809w8;
        EnumC0809w enumC0809w9 = new EnumC0809w("ENUM", 8, cls, Integer.class, null);
        f7223l = enumC0809w9;
        EnumC0809w enumC0809w10 = new EnumC0809w("MESSAGE", 9, Object.class, Object.class, null);
        f7224m = enumC0809w10;
        f7225n = new EnumC0809w[]{enumC0809w, enumC0809w2, enumC0809w3, enumC0809w4, enumC0809w5, enumC0809w6, enumC0809w7, enumC0809w8, enumC0809w9, enumC0809w10};
    }

    public EnumC0809w(String str, int i4, Class cls, Class cls2, Object obj) {
        this.f7226a = cls;
        this.f7227b = cls2;
        this.f7228c = obj;
    }

    public static EnumC0809w valueOf(String str) {
        return (EnumC0809w) Enum.valueOf(EnumC0809w.class, str);
    }

    public static EnumC0809w[] values() {
        return (EnumC0809w[]) f7225n.clone();
    }

    public Class a() {
        return this.f7227b;
    }
}
