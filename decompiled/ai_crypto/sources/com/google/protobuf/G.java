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
    public static final G f12565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final G f12566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final G f12567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final G f12568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final G f12569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final G f12570i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final G f12571j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final G f12572k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final G f12573l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final G f12574m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ G[] f12575n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f12576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f12577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12578c;

    static {
        G g7 = new G("VOID", 0, Void.class, Void.class, null);
        f12565d = g7;
        Class cls = Integer.TYPE;
        G g8 = new G("INT", 1, cls, Integer.class, 0);
        f12566e = g8;
        G g9 = new G("LONG", 2, Long.TYPE, Long.class, 0L);
        f12567f = g9;
        G g10 = new G("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f12568g = g10;
        G g11 = new G("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f12569h = g11;
        G g12 = new G("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f12570i = g12;
        G g13 = new G("STRING", 6, String.class, String.class, "");
        f12571j = g13;
        G g14 = new G("BYTE_STRING", 7, AbstractC1240i.class, AbstractC1240i.class, AbstractC1240i.f12650b);
        f12572k = g14;
        G g15 = new G("ENUM", 8, cls, Integer.class, null);
        f12573l = g15;
        G g16 = new G("MESSAGE", 9, Object.class, Object.class, null);
        f12574m = g16;
        f12575n = new G[]{g7, g8, g9, g10, g11, g12, g13, g14, g15, g16};
    }

    public G(String str, int i7, Class cls, Class cls2, Object obj) {
        this.f12576a = cls;
        this.f12577b = cls2;
        this.f12578c = obj;
    }

    public static G valueOf(String str) {
        return (G) Enum.valueOf(G.class, str);
    }

    public static G[] values() {
        return (G[]) f12575n.clone();
    }

    public Class a() {
        return this.f12577b;
    }
}
