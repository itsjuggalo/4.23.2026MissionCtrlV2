package k4;

import com.google.protobuf.AbstractC1229a;
import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.C;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import k4.C2135z;

/* JADX INFO: renamed from: k4.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2134y extends AbstractC1255y implements W {
    public static final int AGGREGATIONS_FIELD_NUMBER = 3;
    private static final C2134y DEFAULT_INSTANCE;
    private static volatile f0 PARSER = null;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 1;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private C.e aggregations_ = AbstractC1255y.A();

    /* JADX INFO: renamed from: k4.y$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18097a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18097a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18097a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18097a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18097a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18097a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18097a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18097a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.y$b */
    public static final class b extends AbstractC1255y implements W {
        public static final int ALIAS_FIELD_NUMBER = 7;
        public static final int AVG_FIELD_NUMBER = 3;
        public static final int COUNT_FIELD_NUMBER = 1;
        private static final b DEFAULT_INSTANCE;
        private static volatile f0 PARSER = null;
        public static final int SUM_FIELD_NUMBER = 2;
        private Object operator_;
        private int operatorCase_ = 0;
        private String alias_ = "";

        /* JADX INFO: renamed from: k4.y$b$a */
        public static final class a extends AbstractC1255y implements W {
            private static final a DEFAULT_INSTANCE;
            public static final int FIELD_FIELD_NUMBER = 1;
            private static volatile f0 PARSER;
            private int bitField0_;
            private C2135z.g field_;

            /* JADX INFO: renamed from: k4.y$b$a$a, reason: collision with other inner class name */
            public static final class C0292a extends AbstractC1255y.a implements W {
                public /* synthetic */ C0292a(a aVar) {
                    this();
                }

                public C0292a w(C2135z.g gVar) {
                    q();
                    ((a) this.f12868b).c0(gVar);
                    return this;
                }

                public C0292a() {
                    super(a.DEFAULT_INSTANCE);
                }
            }

            static {
                a aVar = new a();
                DEFAULT_INSTANCE = aVar;
                AbstractC1255y.V(a.class, aVar);
            }

            public static C0292a b0() {
                return (C0292a) DEFAULT_INSTANCE.u();
            }

            public final void c0(C2135z.g gVar) {
                gVar.getClass();
                this.field_ = gVar;
                this.bitField0_ |= 1;
            }

            @Override // com.google.protobuf.AbstractC1255y
            public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
                a aVar = null;
                switch (a.f18097a[dVar.ordinal()]) {
                    case 1:
                        return new a();
                    case 2:
                        return new C0292a(aVar);
                    case 3:
                        return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "field_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        f0 bVar = PARSER;
                        if (bVar == null) {
                            synchronized (a.class) {
                                try {
                                    bVar = PARSER;
                                    if (bVar == null) {
                                        bVar = new AbstractC1255y.b(DEFAULT_INSTANCE);
                                        PARSER = bVar;
                                    }
                                } finally {
                                }
                                break;
                            }
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

        /* JADX INFO: renamed from: k4.y$b$b, reason: collision with other inner class name */
        public static final class C0293b extends AbstractC1255y.a implements W {
            public /* synthetic */ C0293b(a aVar) {
                this();
            }

            public C0293b w(String str) {
                q();
                ((b) this.f12868b).f0(str);
                return this;
            }

            public C0293b x(a aVar) {
                q();
                ((b) this.f12868b).g0(aVar);
                return this;
            }

            public C0293b y(c cVar) {
                q();
                ((b) this.f12868b).h0(cVar);
                return this;
            }

            public C0293b z(d dVar) {
                q();
                ((b) this.f12868b).i0(dVar);
                return this;
            }

            public C0293b() {
                super(b.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: renamed from: k4.y$b$c */
        public static final class c extends AbstractC1255y implements W {
            private static final c DEFAULT_INSTANCE;
            private static volatile f0 PARSER = null;
            public static final int UP_TO_FIELD_NUMBER = 1;
            private int bitField0_;
            private com.google.protobuf.A upTo_;

            /* JADX INFO: renamed from: k4.y$b$c$a */
            public static final class a extends AbstractC1255y.a implements W {
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
                AbstractC1255y.V(c.class, cVar);
            }

            public static c a0() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.AbstractC1255y
            public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
                a aVar = null;
                switch (a.f18097a[dVar.ordinal()]) {
                    case 1:
                        return new c();
                    case 2:
                        return new a(aVar);
                    case 3:
                        return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "upTo_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        f0 bVar = PARSER;
                        if (bVar == null) {
                            synchronized (c.class) {
                                try {
                                    bVar = PARSER;
                                    if (bVar == null) {
                                        bVar = new AbstractC1255y.b(DEFAULT_INSTANCE);
                                        PARSER = bVar;
                                    }
                                } finally {
                                }
                                break;
                            }
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

        /* JADX INFO: renamed from: k4.y$b$d */
        public static final class d extends AbstractC1255y implements W {
            private static final d DEFAULT_INSTANCE;
            public static final int FIELD_FIELD_NUMBER = 1;
            private static volatile f0 PARSER;
            private int bitField0_;
            private C2135z.g field_;

            /* JADX INFO: renamed from: k4.y$b$d$a */
            public static final class a extends AbstractC1255y.a implements W {
                public /* synthetic */ a(a aVar) {
                    this();
                }

                public a w(C2135z.g gVar) {
                    q();
                    ((d) this.f12868b).c0(gVar);
                    return this;
                }

                public a() {
                    super(d.DEFAULT_INSTANCE);
                }
            }

            static {
                d dVar = new d();
                DEFAULT_INSTANCE = dVar;
                AbstractC1255y.V(d.class, dVar);
            }

            public static a b0() {
                return (a) DEFAULT_INSTANCE.u();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void c0(C2135z.g gVar) {
                gVar.getClass();
                this.field_ = gVar;
                this.bitField0_ |= 1;
            }

            @Override // com.google.protobuf.AbstractC1255y
            public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
                a aVar = null;
                switch (a.f18097a[dVar.ordinal()]) {
                    case 1:
                        return new d();
                    case 2:
                        return new a(aVar);
                    case 3:
                        return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "field_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        f0 bVar = PARSER;
                        if (bVar == null) {
                            synchronized (d.class) {
                                try {
                                    bVar = PARSER;
                                    if (bVar == null) {
                                        bVar = new AbstractC1255y.b(DEFAULT_INSTANCE);
                                        PARSER = bVar;
                                    }
                                } finally {
                                }
                                break;
                            }
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
            AbstractC1255y.V(b.class, bVar);
        }

        public static C0293b e0() {
            return (C0293b) DEFAULT_INSTANCE.u();
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

        @Override // com.google.protobuf.AbstractC1255y
        public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f18097a[dVar.ordinal()]) {
                case 1:
                    return new b();
                case 2:
                    return new C0293b(aVar);
                case 3:
                    return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0007\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0007Ȉ", new Object[]{"operator_", "operatorCase_", c.class, d.class, a.class, "alias_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    f0 bVar = PARSER;
                    if (bVar == null) {
                        synchronized (b.class) {
                            try {
                                bVar = PARSER;
                                if (bVar == null) {
                                    bVar = new AbstractC1255y.b(DEFAULT_INSTANCE);
                                    PARSER = bVar;
                                }
                            } finally {
                            }
                            break;
                        }
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

    /* JADX INFO: renamed from: k4.y$c */
    public static final class c extends AbstractC1255y.a implements W {
        public /* synthetic */ c(a aVar) {
            this();
        }

        public c w(Iterable iterable) {
            q();
            ((C2134y) this.f12868b).c0(iterable);
            return this;
        }

        public c x(C2135z c2135z) {
            q();
            ((C2134y) this.f12868b).f0(c2135z);
            return this;
        }

        public c() {
            super(C2134y.DEFAULT_INSTANCE);
        }
    }

    static {
        C2134y c2134y = new C2134y();
        DEFAULT_INSTANCE = c2134y;
        AbstractC1255y.V(C2134y.class, c2134y);
    }

    public static c e0() {
        return (c) DEFAULT_INSTANCE.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(C2135z c2135z) {
        c2135z.getClass();
        this.queryType_ = c2135z;
        this.queryTypeCase_ = 1;
    }

    public final void c0(Iterable iterable) {
        d0();
        AbstractC1229a.k(iterable, this.aggregations_);
    }

    public final void d0() {
        C.e eVar = this.aggregations_;
        if (eVar.f()) {
            return;
        }
        this.aggregations_ = AbstractC1255y.L(eVar);
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18097a[dVar.ordinal()]) {
            case 1:
                return new C2134y();
            case 2:
                return new c(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0003\u0002\u0000\u0001\u0000\u0001<\u0000\u0003\u001b", new Object[]{"queryType_", "queryTypeCase_", C2135z.class, "aggregations_", b.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2134y.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1255y.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } finally {
                        }
                        break;
                    }
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
