package com.google.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6897a = c(1, 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6898b = c(1, 4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6899c = c(2, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6900d = c(3, 2);

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
    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f6901c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f6902d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f6903e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f6904f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f6905g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f6906h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f6907i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f6908j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final b f6909k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final b f6910l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final b f6911m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final b f6912n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final b f6913o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final b f6914p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final b f6915q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final b f6916r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final b f6917s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final b f6918t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final /* synthetic */ b[] f6919u;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f6920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6921b;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum a extends b {
            public a(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }
        }

        /* JADX INFO: renamed from: com.google.protobuf.a2$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum C0114b extends b {
            public C0114b(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum c extends b {
            public c(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum d extends b {
            public d(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            f6901c = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            f6902d = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            f6903e = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            f6904f = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            f6905g = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            f6906h = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            f6907i = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            f6908j = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            f6909k = aVar;
            c cVar3 = c.MESSAGE;
            C0114b c0114b = new C0114b("GROUP", 9, cVar3, 3);
            f6910l = c0114b;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            f6911m = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            f6912n = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            f6913o = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            f6914p = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            f6915q = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            f6916r = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            f6917s = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            f6918t = bVar14;
            f6919u = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c0114b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f6919u.clone();
        }

        public c a() {
            return this.f6920a;
        }

        public int b() {
            return this.f6921b;
        }

        public b(String str, int i10, c cVar, int i11) {
            this.f6920a = cVar;
            this.f6921b = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(i.f6998b),
        ENUM(null),
        MESSAGE(null);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f6932a;

        c(Object obj) {
            this.f6932a = obj;
        }
    }

    public static int a(int i10) {
        return i10 >>> 3;
    }

    public static int b(int i10) {
        return i10 & 7;
    }

    public static int c(int i10, int i11) {
        return (i10 << 3) | i11;
    }
}
