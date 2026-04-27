package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7075a = c(1, 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7076b = c(1, 4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7077c = c(2, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7078d = c(3, 2);

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
    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f7079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f7080d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f7081e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f7082f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f7083g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f7084h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f7085i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f7086j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final b f7087k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final b f7088l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final b f7089m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final b f7090n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final b f7091o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final b f7092p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final b f7093q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final b f7094r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final b f7095s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final b f7096t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final /* synthetic */ b[] f7097u;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f7098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7099b;

        public enum a extends b {
            public a(String str, int i4, c cVar, int i5) {
                super(str, i4, cVar, i5);
            }
        }

        /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.k0$b$b, reason: collision with other inner class name */
        public enum C0102b extends b {
            public C0102b(String str, int i4, c cVar, int i5) {
                super(str, i4, cVar, i5);
            }
        }

        public enum c extends b {
            public c(String str, int i4, c cVar, int i5) {
                super(str, i4, cVar, i5);
            }
        }

        public enum d extends b {
            public d(String str, int i4, c cVar, int i5) {
                super(str, i4, cVar, i5);
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            f7079c = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            f7080d = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            f7081e = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            f7082f = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            f7083g = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            f7084h = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            f7085i = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            f7086j = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            f7087k = aVar;
            c cVar3 = c.MESSAGE;
            C0102b c0102b = new C0102b("GROUP", 9, cVar3, 3);
            f7088l = c0102b;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            f7089m = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            f7090n = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            f7091o = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            f7092p = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            f7093q = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            f7094r = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            f7095s = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            f7096t = bVar14;
            f7097u = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c0102b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f7097u.clone();
        }

        public c a() {
            return this.f7098a;
        }

        public int c() {
            return this.f7099b;
        }

        public b(String str, int i4, c cVar, int i5) {
            this.f7098a = cVar;
            this.f7099b = i5;
        }
    }

    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(AbstractC0793f.f6994b),
        ENUM(null),
        MESSAGE(null);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f7110a;

        c(Object obj) {
            this.f7110a = obj;
        }
    }

    public static int a(int i4) {
        return i4 >>> 3;
    }

    public static int b(int i4) {
        return i4 & 7;
    }

    public static int c(int i4, int i5) {
        return (i4 << 3) | i5;
    }
}
