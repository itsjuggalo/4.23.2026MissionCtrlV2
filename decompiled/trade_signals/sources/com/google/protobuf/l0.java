package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16455a = c(1, 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16456b = c(1, 4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16457c = c(2, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16458d = c(3, 2);

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
        public static final b f16459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f16460d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f16461e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f16462f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f16463g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f16464h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f16465i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f16466j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final b f16467k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final b f16468l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final b f16469m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final b f16470n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final b f16471o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final b f16472p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final b f16473q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final b f16474r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final b f16475s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final b f16476t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final /* synthetic */ b[] f16477u;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f16478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f16479b;

        public enum a extends b {
            public a(String str, int i8, c cVar, int i9) {
                super(str, i8, cVar, i9);
            }
        }

        /* JADX INFO: renamed from: com.google.protobuf.l0$b$b, reason: collision with other inner class name */
        public enum C0265b extends b {
            public C0265b(String str, int i8, c cVar, int i9) {
                super(str, i8, cVar, i9);
            }
        }

        public enum c extends b {
            public c(String str, int i8, c cVar, int i9) {
                super(str, i8, cVar, i9);
            }
        }

        public enum d extends b {
            public d(String str, int i8, c cVar, int i9) {
                super(str, i8, cVar, i9);
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            f16459c = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            f16460d = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            f16461e = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            f16462f = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            f16463g = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            f16464h = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            f16465i = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            f16466j = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            f16467k = aVar;
            c cVar3 = c.MESSAGE;
            C0265b c0265b = new C0265b("GROUP", 9, cVar3, 3);
            f16468l = c0265b;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            f16469m = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            f16470n = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            f16471o = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            f16472p = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            f16473q = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            f16474r = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            f16475s = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            f16476t = bVar14;
            f16477u = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c0265b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        public b(String str, int i8, c cVar, int i9) {
            this.f16478a = cVar;
            this.f16479b = i9;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f16477u.clone();
        }

        public c a() {
            return this.f16478a;
        }

        public int b() {
            return this.f16479b;
        }
    }

    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(AbstractC1467f.f16361b),
        ENUM(null),
        MESSAGE(null);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f16490a;

        c(Object obj) {
            this.f16490a = obj;
        }
    }

    public static int a(int i8) {
        return i8 >>> 3;
    }

    public static int b(int i8) {
        return i8 & 7;
    }

    public static int c(int i8, int i9) {
        return (i8 << 3) | i9;
    }
}
