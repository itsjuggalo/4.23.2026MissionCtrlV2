package com.google.protobuf;

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
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g0 f6976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g0 f6977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g0 f6978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g0 f6979g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g0 f6980h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g0 f6981i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g0 f6982j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final g0 f6983k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final g0 f6984l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final g0 f6985m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ g0[] f6986n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f6987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f6988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6989c;

    static {
        g0 g0Var = new g0("VOID", 0, Void.class, Void.class, null);
        f6976d = g0Var;
        Class cls = Integer.TYPE;
        g0 g0Var2 = new g0("INT", 1, cls, Integer.class, 0);
        f6977e = g0Var2;
        g0 g0Var3 = new g0("LONG", 2, Long.TYPE, Long.class, 0L);
        f6978f = g0Var3;
        g0 g0Var4 = new g0("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f6979g = g0Var4;
        g0 g0Var5 = new g0("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f6980h = g0Var5;
        g0 g0Var6 = new g0("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f6981i = g0Var6;
        g0 g0Var7 = new g0("STRING", 6, String.class, String.class, "");
        f6982j = g0Var7;
        g0 g0Var8 = new g0("BYTE_STRING", 7, i.class, i.class, i.f6998b);
        f6983k = g0Var8;
        g0 g0Var9 = new g0("ENUM", 8, cls, Integer.class, null);
        f6984l = g0Var9;
        g0 g0Var10 = new g0("MESSAGE", 9, Object.class, Object.class, null);
        f6985m = g0Var10;
        f6986n = new g0[]{g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7, g0Var8, g0Var9, g0Var10};
    }

    public g0(String str, int i10, Class cls, Class cls2, Object obj) {
        this.f6987a = cls;
        this.f6988b = cls2;
        this.f6989c = obj;
    }

    public static g0 valueOf(String str) {
        return (g0) Enum.valueOf(g0.class, str);
    }

    public static g0[] values() {
        return (g0[]) f6986n.clone();
    }

    public Class a() {
        return this.f6988b;
    }
}
