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
/* JADX INFO: renamed from: com.google.protobuf.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1483w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC1483w f16595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC1483w f16596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnumC1483w f16597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final EnumC1483w f16598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final EnumC1483w f16599h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final EnumC1483w f16600i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final EnumC1483w f16601j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final EnumC1483w f16602k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final EnumC1483w f16603l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final EnumC1483w f16604m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ EnumC1483w[] f16605n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f16606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f16607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f16608c;

    static {
        EnumC1483w enumC1483w = new EnumC1483w("VOID", 0, Void.class, Void.class, null);
        f16595d = enumC1483w;
        Class cls = Integer.TYPE;
        EnumC1483w enumC1483w2 = new EnumC1483w("INT", 1, cls, Integer.class, 0);
        f16596e = enumC1483w2;
        EnumC1483w enumC1483w3 = new EnumC1483w("LONG", 2, Long.TYPE, Long.class, 0L);
        f16597f = enumC1483w3;
        EnumC1483w enumC1483w4 = new EnumC1483w("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f16598g = enumC1483w4;
        EnumC1483w enumC1483w5 = new EnumC1483w("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f16599h = enumC1483w5;
        EnumC1483w enumC1483w6 = new EnumC1483w("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f16600i = enumC1483w6;
        EnumC1483w enumC1483w7 = new EnumC1483w("STRING", 6, String.class, String.class, "");
        f16601j = enumC1483w7;
        EnumC1483w enumC1483w8 = new EnumC1483w("BYTE_STRING", 7, AbstractC1467f.class, AbstractC1467f.class, AbstractC1467f.f16361b);
        f16602k = enumC1483w8;
        EnumC1483w enumC1483w9 = new EnumC1483w("ENUM", 8, cls, Integer.class, null);
        f16603l = enumC1483w9;
        EnumC1483w enumC1483w10 = new EnumC1483w("MESSAGE", 9, Object.class, Object.class, null);
        f16604m = enumC1483w10;
        f16605n = new EnumC1483w[]{enumC1483w, enumC1483w2, enumC1483w3, enumC1483w4, enumC1483w5, enumC1483w6, enumC1483w7, enumC1483w8, enumC1483w9, enumC1483w10};
    }

    public EnumC1483w(String str, int i8, Class cls, Class cls2, Object obj) {
        this.f16606a = cls;
        this.f16607b = cls2;
        this.f16608c = obj;
    }

    public static EnumC1483w valueOf(String str) {
        return (EnumC1483w) Enum.valueOf(EnumC1483w.class, str);
    }

    public static EnumC1483w[] values() {
        return (EnumC1483w[]) f16605n.clone();
    }

    public Class a() {
        return this.f16607b;
    }
}
