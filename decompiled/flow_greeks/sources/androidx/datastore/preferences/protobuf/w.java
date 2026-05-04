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
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final w f1926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final w f1927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final w f1928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final w f1929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final w f1930h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final w f1931i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final w f1932j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final w f1933k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final w f1934l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final w f1935m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ w[] f1936n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f1937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f1938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1939c;

    static {
        w wVar = new w("VOID", 0, Void.class, Void.class, null);
        f1926d = wVar;
        Class cls = Integer.TYPE;
        w wVar2 = new w("INT", 1, cls, Integer.class, 0);
        f1927e = wVar2;
        w wVar3 = new w("LONG", 2, Long.TYPE, Long.class, 0L);
        f1928f = wVar3;
        w wVar4 = new w("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f1929g = wVar4;
        w wVar5 = new w("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f1930h = wVar5;
        w wVar6 = new w("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f1931i = wVar6;
        w wVar7 = new w("STRING", 6, String.class, String.class, "");
        f1932j = wVar7;
        w wVar8 = new w("BYTE_STRING", 7, f.class, f.class, f.f1682b);
        f1933k = wVar8;
        w wVar9 = new w("ENUM", 8, cls, Integer.class, null);
        f1934l = wVar9;
        w wVar10 = new w("MESSAGE", 9, Object.class, Object.class, null);
        f1935m = wVar10;
        f1936n = new w[]{wVar, wVar2, wVar3, wVar4, wVar5, wVar6, wVar7, wVar8, wVar9, wVar10};
    }

    public w(String str, int i10, Class cls, Class cls2, Object obj) {
        this.f1937a = cls;
        this.f1938b = cls2;
        this.f1939c = obj;
    }

    public static w valueOf(String str) {
        return (w) Enum.valueOf(w.class, str);
    }

    public static w[] values() {
        return (w[]) f1936n.clone();
    }

    public Class a() {
        return this.f1938b;
    }
}
