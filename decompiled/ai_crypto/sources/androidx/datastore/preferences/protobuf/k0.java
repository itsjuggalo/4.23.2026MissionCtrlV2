package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7483a = c(1, 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7484b = c(1, 4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7485c = c(2, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7486d = c(3, 2);

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
        public static final b f7487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f7488d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f7489e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f7490f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f7491g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f7492h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f7493i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f7494j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final b f7495k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final b f7496l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final b f7497m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final b f7498n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final b f7499o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final b f7500p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final b f7501q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final b f7502r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final b f7503s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final b f7504t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final /* synthetic */ b[] f7505u;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f7506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7507b;

        public enum a extends b {
            public a(String str, int i7, c cVar, int i8) {
                super(str, i7, cVar, i8);
            }
        }

        /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.k0$b$b, reason: collision with other inner class name */
        public enum C0124b extends b {
            public C0124b(String str, int i7, c cVar, int i8) {
                super(str, i7, cVar, i8);
            }
        }

        public enum c extends b {
            public c(String str, int i7, c cVar, int i8) {
                super(str, i7, cVar, i8);
            }
        }

        public enum d extends b {
            public d(String str, int i7, c cVar, int i8) {
                super(str, i7, cVar, i8);
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            f7487c = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            f7488d = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            f7489e = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            f7490f = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            f7491g = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            f7492h = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            f7493i = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            f7494j = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            f7495k = aVar;
            c cVar3 = c.MESSAGE;
            C0124b c0124b = new C0124b("GROUP", 9, cVar3, 3);
            f7496l = c0124b;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            f7497m = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            f7498n = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            f7499o = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            f7500p = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            f7501q = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            f7502r = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            f7503s = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            f7504t = bVar14;
            f7505u = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c0124b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f7505u.clone();
        }

        public c a() {
            return this.f7506a;
        }

        public int b() {
            return this.f7507b;
        }

        public b(String str, int i7, c cVar, int i8) {
            this.f7506a = cVar;
            this.f7507b = i8;
        }
    }

    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(AbstractC0935f.f7402b),
        ENUM(null),
        MESSAGE(null);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f7518a;

        c(Object obj) {
            this.f7518a = obj;
        }
    }

    public static int a(int i7) {
        return i7 >>> 3;
    }

    public static int b(int i7) {
        return i7 & 7;
    }

    public static int c(int i7, int i8) {
        return (i7 << 3) | i8;
    }
}
