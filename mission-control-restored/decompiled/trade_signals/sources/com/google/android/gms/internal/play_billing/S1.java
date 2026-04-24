package com.google.android.gms.internal.play_billing;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'c' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public final class S1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final S1 f15351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final S1 f15352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final S1 f15353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final S1 f15354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final S1 f15355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final S1 f15356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final S1 f15357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final S1 f15358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final S1 f15359j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final S1 f15360k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ S1[] f15361l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f15362a;

    static {
        S1 s12 = new S1("VOID", 0, Void.class, Void.class, null);
        f15351b = s12;
        Class cls = Integer.TYPE;
        S1 s13 = new S1("INT", 1, cls, Integer.class, 0);
        f15352c = s13;
        S1 s14 = new S1("LONG", 2, Long.TYPE, Long.class, 0L);
        f15353d = s14;
        S1 s15 = new S1("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f15354e = s15;
        S1 s16 = new S1("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f15355f = s16;
        S1 s17 = new S1("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f15356g = s17;
        S1 s18 = new S1("STRING", 6, String.class, String.class, "");
        f15357h = s18;
        S1 s19 = new S1("BYTE_STRING", 7, AbstractC1378o1.class, AbstractC1378o1.class, AbstractC1378o1.f15475b);
        f15358i = s19;
        S1 s110 = new S1("ENUM", 8, cls, Integer.class, null);
        f15359j = s110;
        S1 s111 = new S1("MESSAGE", 9, Object.class, Object.class, null);
        f15360k = s111;
        f15361l = new S1[]{s12, s13, s14, s15, s16, s17, s18, s19, s110, s111};
    }

    public S1(String str, int i8, Class cls, Class cls2, Object obj) {
        this.f15362a = cls2;
    }

    public static S1[] values() {
        return (S1[]) f15361l.clone();
    }

    public final Class a() {
        return this.f15362a;
    }
}
