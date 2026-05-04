package bb;

import bb.z;
import com.google.protobuf.c0;
import com.google.protobuf.e1;
import com.google.protobuf.v0;
import com.google.protobuf.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class y extends com.google.protobuf.y implements v0 {
    public static final int AGGREGATIONS_FIELD_NUMBER = 3;
    private static final y DEFAULT_INSTANCE;
    private static volatile e1 PARSER = null;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 1;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private c0.e aggregations_ = com.google.protobuf.y.A();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3252a;

        static {
            int[] iArr = new int[y.d.values().length];
            f3252a = iArr;
            try {
                iArr[y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3252a[y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3252a[y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3252a[y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3252a[y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3252a[y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3252a[y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends com.google.protobuf.y implements v0 {
        public static final int ALIAS_FIELD_NUMBER = 7;
        public static final int AVG_FIELD_NUMBER = 3;
        public static final int COUNT_FIELD_NUMBER = 1;
        private static final b DEFAULT_INSTANCE;
        private static volatile e1 PARSER = null;
        public static final int SUM_FIELD_NUMBER = 2;
        private Object operator_;
        private int operatorCase_ = 0;
        private String alias_ = "";

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends com.google.protobuf.y implements v0 {
            private static final a DEFAULT_INSTANCE;
            public static final int FIELD_FIELD_NUMBER = 1;
            private static volatile e1 PARSER;
            private int bitField0_;
            private z.g field_;

            /* JADX INFO: renamed from: bb.y$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class C0057a extends y.a implements v0 {
                public /* synthetic */ C0057a(a aVar) {
                    this();
                }

                public C0057a x(z.g gVar) {
                    q();
                    ((a) this.f7244b).c0(gVar);
                    return this;
                }

                public C0057a() {
                    super(a.DEFAULT_INSTANCE);
                }
            }

            static {
                a aVar = new a();
                DEFAULT_INSTANCE = aVar;
                com.google.protobuf.y.V(a.class, aVar);
            }

            public static C0057a b0() {
                return (C0057a) DEFAULT_INSTANCE.u();
            }

            public final void c0(z.g gVar) {
                gVar.getClass();
                this.field_ = gVar;
                this.bitField0_ |= 1;
            }

            @Override // com.google.protobuf.y
            public final Object y(y.d dVar, Object obj, Object obj2) {
                e1 bVar;
                a aVar = null;
                switch (a.f3252a[dVar.ordinal()]) {
                    case 1:
                        return new a();
                    case 2:
                        return new C0057a(aVar);
                    case 3:
                        return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "field_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        e1 e1Var = PARSER;
                        if (e1Var != null) {
                            return e1Var;
                        }
                        synchronized (a.class) {
                            try {
                                bVar = PARSER;
                                if (bVar == null) {
                                    bVar = new y.b(DEFAULT_INSTANCE);
                                    PARSER = bVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        return bVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* JADX INFO: renamed from: bb.y$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0058b extends y.a implements v0 {
            public /* synthetic */ C0058b(a aVar) {
                this();
            }

            public C0058b A(d dVar) {
                q();
                ((b) this.f7244b).i0(dVar);
                return this;
            }

            public C0058b x(String str) {
                q();
                ((b) this.f7244b).f0(str);
                return this;
            }

            public C0058b y(a aVar) {
                q();
                ((b) this.f7244b).g0(aVar);
                return this;
            }

            public C0058b z(c cVar) {
                q();
                ((b) this.f7244b).h0(cVar);
                return this;
            }

            public C0058b() {
                super(b.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class c extends com.google.protobuf.y implements v0 {
            private static final c DEFAULT_INSTANCE;
            private static volatile e1 PARSER = null;
            public static final int UP_TO_FIELD_NUMBER = 1;
            private int bitField0_;
            private com.google.protobuf.a0 upTo_;

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class a extends y.a implements v0 {
                public /* synthetic */ a(a aVar) {
                    this();
                }

                public a() {
                    super(c.DEFAULT_INSTANCE);
                }
            }

            static {
                c cVar = new c();
                DEFAULT_INSTANCE = cVar;
                com.google.protobuf.y.V(c.class, cVar);
            }

            public static c a0() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.y
            public final Object y(y.d dVar, Object obj, Object obj2) {
                e1 bVar;
                a aVar = null;
                switch (a.f3252a[dVar.ordinal()]) {
                    case 1:
                        return new c();
                    case 2:
                        return new a(aVar);
                    case 3:
                        return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "upTo_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        e1 e1Var = PARSER;
                        if (e1Var != null) {
                            return e1Var;
                        }
                        synchronized (c.class) {
                            try {
                                bVar = PARSER;
                                if (bVar == null) {
                                    bVar = new y.b(DEFAULT_INSTANCE);
                                    PARSER = bVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        return bVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class d extends com.google.protobuf.y implements v0 {
            private static final d DEFAULT_INSTANCE;
            public static final int FIELD_FIELD_NUMBER = 1;
            private static volatile e1 PARSER;
            private int bitField0_;
            private z.g field_;

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class a extends y.a implements v0 {
                public /* synthetic */ a(a aVar) {
                    this();
                }

                public a x(z.g gVar) {
                    q();
                    ((d) this.f7244b).c0(gVar);
                    return this;
                }

                public a() {
                    super(d.DEFAULT_INSTANCE);
                }
            }

            static {
                d dVar = new d();
                DEFAULT_INSTANCE = dVar;
                com.google.protobuf.y.V(d.class, dVar);
            }

            public static a b0() {
                return (a) DEFAULT_INSTANCE.u();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void c0(z.g gVar) {
                gVar.getClass();
                this.field_ = gVar;
                this.bitField0_ |= 1;
            }

            @Override // com.google.protobuf.y
            public final Object y(y.d dVar, Object obj, Object obj2) {
                e1 bVar;
                a aVar = null;
                switch (a.f3252a[dVar.ordinal()]) {
                    case 1:
                        return new d();
                    case 2:
                        return new a(aVar);
                    case 3:
                        return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "field_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        e1 e1Var = PARSER;
                        if (e1Var != null) {
                            return e1Var;
                        }
                        synchronized (d.class) {
                            try {
                                bVar = PARSER;
                                if (bVar == null) {
                                    bVar = new y.b(DEFAULT_INSTANCE);
                                    PARSER = bVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        return bVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        static {
            b bVar = new b();
            DEFAULT_INSTANCE = bVar;
            com.google.protobuf.y.V(b.class, bVar);
        }

        public static C0058b e0() {
            return (C0058b) DEFAULT_INSTANCE.u();
        }

        public final void f0(String str) {
            str.getClass();
            this.alias_ = str;
        }

        public final void g0(a aVar) {
            aVar.getClass();
            this.operator_ = aVar;
            this.operatorCase_ = 3;
        }

        public final void h0(c cVar) {
            cVar.getClass();
            this.operator_ = cVar;
            this.operatorCase_ = 1;
        }

        public final void i0(d dVar) {
            dVar.getClass();
            this.operator_ = dVar;
            this.operatorCase_ = 2;
        }

        @Override // com.google.protobuf.y
        public final Object y(y.d dVar, Object obj, Object obj2) {
            e1 bVar;
            a aVar = null;
            switch (a.f3252a[dVar.ordinal()]) {
                case 1:
                    return new b();
                case 2:
                    return new C0058b(aVar);
                case 3:
                    return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0007\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0007Ȉ", new Object[]{"operator_", "operatorCase_", c.class, d.class, a.class, "alias_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    e1 e1Var = PARSER;
                    if (e1Var != null) {
                        return e1Var;
                    }
                    synchronized (b.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new y.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return bVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends y.a implements v0 {
        public /* synthetic */ c(a aVar) {
            this();
        }

        public c x(Iterable iterable) {
            q();
            ((y) this.f7244b).c0(iterable);
            return this;
        }

        public c y(z zVar) {
            q();
            ((y) this.f7244b).f0(zVar);
            return this;
        }

        public c() {
            super(y.DEFAULT_INSTANCE);
        }
    }

    static {
        y yVar = new y();
        DEFAULT_INSTANCE = yVar;
        com.google.protobuf.y.V(y.class, yVar);
    }

    public static c e0() {
        return (c) DEFAULT_INSTANCE.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(z zVar) {
        zVar.getClass();
        this.queryType_ = zVar;
        this.queryTypeCase_ = 1;
    }

    public final void c0(Iterable iterable) {
        d0();
        com.google.protobuf.a.k(iterable, this.aggregations_);
    }

    public final void d0() {
        c0.e eVar = this.aggregations_;
        if (eVar.m()) {
            return;
        }
        this.aggregations_ = com.google.protobuf.y.L(eVar);
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        a aVar = null;
        switch (a.f3252a[dVar.ordinal()]) {
            case 1:
                return new y();
            case 2:
                return new c(aVar);
            case 3:
                return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0003\u0002\u0000\u0001\u0000\u0001<\u0000\u0003\u001b", new Object[]{"queryType_", "queryTypeCase_", z.class, "aggregations_", b.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (y.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new y.b(DEFAULT_INSTANCE);
                            PARSER = bVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
