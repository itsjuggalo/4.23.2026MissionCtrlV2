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
/* JADX INFO: loaded from: classes.dex */
public final class G {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final G f10937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final G f10938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final G f10939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final G f10940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final G f10941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final G f10942i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final G f10943j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final G f10944k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final G f10945l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final G f10946m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ G[] f10947n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f10948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f10949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f10950c;

    static {
        G g4 = new G("VOID", 0, Void.class, Void.class, null);
        f10937d = g4;
        Class cls = Integer.TYPE;
        G g5 = new G("INT", 1, cls, Integer.class, 0);
        f10938e = g5;
        G g6 = new G("LONG", 2, Long.TYPE, Long.class, 0L);
        f10939f = g6;
        G g7 = new G("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f10940g = g7;
        G g8 = new G("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f10941h = g8;
        G g9 = new G("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f10942i = g9;
        G g10 = new G("STRING", 6, String.class, String.class, "");
        f10943j = g10;
        G g11 = new G("BYTE_STRING", 7, AbstractC1062i.class, AbstractC1062i.class, AbstractC1062i.f11025b);
        f10944k = g11;
        G g12 = new G("ENUM", 8, cls, Integer.class, null);
        f10945l = g12;
        G g13 = new G("MESSAGE", 9, Object.class, Object.class, null);
        f10946m = g13;
        f10947n = new G[]{g4, g5, g6, g7, g8, g9, g10, g11, g12, g13};
    }

    public G(String str, int i4, Class cls, Class cls2, Object obj) {
        this.f10948a = cls;
        this.f10949b = cls2;
        this.f10950c = obj;
    }

    public static G valueOf(String str) {
        return (G) Enum.valueOf(G.class, str);
    }

    public static G[] values() {
        return (G[]) f10947n.clone();
    }

    public Class a() {
        return this.f10949b;
    }
}
