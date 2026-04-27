package p2;

import com.google.protobuf.AbstractC1050a;
import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import java.util.List;
import p2.z;

/* JADX INFO: loaded from: classes.dex */
public final class y extends AbstractC1077y implements X {
    public static final int AGGREGATIONS_FIELD_NUMBER = 3;
    private static final y DEFAULT_INSTANCE;
    private static volatile g0 PARSER = null;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 1;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private C.i aggregations_ = AbstractC1077y.emptyProtobufList();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14098a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14098a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14098a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14098a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14098a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14098a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14098a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14098a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1077y implements X {
        public static final int ALIAS_FIELD_NUMBER = 7;
        public static final int AVG_FIELD_NUMBER = 3;
        public static final int COUNT_FIELD_NUMBER = 1;
        private static final b DEFAULT_INSTANCE;
        private static volatile g0 PARSER = null;
        public static final int SUM_FIELD_NUMBER = 2;
        private Object operator_;
        private int operatorCase_ = 0;
        private String alias_ = "";

        public static final class a extends AbstractC1077y implements X {
            private static final a DEFAULT_INSTANCE;
            public static final int FIELD_FIELD_NUMBER = 1;
            private static volatile g0 PARSER;
            private int bitField0_;
            private z.g field_;

            /* JADX INFO: renamed from: p2.y$b$a$a, reason: collision with other inner class name */
            public static final class C0226a extends AbstractC1077y.a implements X {
                public /* synthetic */ C0226a(a aVar) {
                    this();
                }

                public C0226a f(z.g gVar) {
                    copyOnWrite();
                    ((a) this.instance).m(gVar);
                    return this;
                }

                public C0226a() {
                    super(a.DEFAULT_INSTANCE);
                }
            }

            static {
                a aVar = new a();
                DEFAULT_INSTANCE = aVar;
                AbstractC1077y.registerDefaultInstance(a.class, aVar);
            }

            public static C0226a l() {
                return (C0226a) DEFAULT_INSTANCE.createBuilder();
            }

            @Override // com.google.protobuf.AbstractC1077y
            public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
                g0 bVar;
                a aVar = null;
                switch (a.f14098a[eVar.ordinal()]) {
                    case 1:
                        return new a();
                    case 2:
                        return new C0226a(aVar);
                    case 3:
                        return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "field_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        g0 g0Var = PARSER;
                        if (g0Var != null) {
                            return g0Var;
                        }
                        synchronized (a.class) {
                            try {
                                bVar = PARSER;
                                if (bVar == null) {
                                    bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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

            public final void m(z.g gVar) {
                gVar.getClass();
                this.field_ = gVar;
                this.bitField0_ |= 1;
            }
        }

        /* JADX INFO: renamed from: p2.y$b$b, reason: collision with other inner class name */
        public static final class C0227b extends AbstractC1077y.a implements X {
            public /* synthetic */ C0227b(a aVar) {
                this();
            }

            public C0227b f(String str) {
                copyOnWrite();
                ((b) this.instance).p(str);
                return this;
            }

            public C0227b g(a aVar) {
                copyOnWrite();
                ((b) this.instance).q(aVar);
                return this;
            }

            public C0227b h(c cVar) {
                copyOnWrite();
                ((b) this.instance).r(cVar);
                return this;
            }

            public C0227b i(d dVar) {
                copyOnWrite();
                ((b) this.instance).s(dVar);
                return this;
            }

            public C0227b() {
                super(b.DEFAULT_INSTANCE);
            }
        }

        public static final class c extends AbstractC1077y implements X {
            private static final c DEFAULT_INSTANCE;
            private static volatile g0 PARSER = null;
            public static final int UP_TO_FIELD_NUMBER = 1;
            private int bitField0_;
            private com.google.protobuf.A upTo_;

            public static final class a extends AbstractC1077y.a implements X {
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
                AbstractC1077y.registerDefaultInstance(c.class, cVar);
            }

            public static c k() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.AbstractC1077y
            public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
                g0 bVar;
                a aVar = null;
                switch (a.f14098a[eVar.ordinal()]) {
                    case 1:
                        return new c();
                    case 2:
                        return new a(aVar);
                    case 3:
                        return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "upTo_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        g0 g0Var = PARSER;
                        if (g0Var != null) {
                            return g0Var;
                        }
                        synchronized (c.class) {
                            try {
                                bVar = PARSER;
                                if (bVar == null) {
                                    bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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

        public static final class d extends AbstractC1077y implements X {
            private static final d DEFAULT_INSTANCE;
            public static final int FIELD_FIELD_NUMBER = 1;
            private static volatile g0 PARSER;
            private int bitField0_;
            private z.g field_;

            public static final class a extends AbstractC1077y.a implements X {
                public /* synthetic */ a(a aVar) {
                    this();
                }

                public a f(z.g gVar) {
                    copyOnWrite();
                    ((d) this.instance).m(gVar);
                    return this;
                }

                public a() {
                    super(d.DEFAULT_INSTANCE);
                }
            }

            static {
                d dVar = new d();
                DEFAULT_INSTANCE = dVar;
                AbstractC1077y.registerDefaultInstance(d.class, dVar);
            }

            public static a l() {
                return (a) DEFAULT_INSTANCE.createBuilder();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m(z.g gVar) {
                gVar.getClass();
                this.field_ = gVar;
                this.bitField0_ |= 1;
            }

            @Override // com.google.protobuf.AbstractC1077y
            public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
                g0 bVar;
                a aVar = null;
                switch (a.f14098a[eVar.ordinal()]) {
                    case 1:
                        return new d();
                    case 2:
                        return new a(aVar);
                    case 3:
                        return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "field_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        g0 g0Var = PARSER;
                        if (g0Var != null) {
                            return g0Var;
                        }
                        synchronized (d.class) {
                            try {
                                bVar = PARSER;
                                if (bVar == null) {
                                    bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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
            AbstractC1077y.registerDefaultInstance(b.class, bVar);
        }

        public static C0227b o() {
            return (C0227b) DEFAULT_INSTANCE.createBuilder();
        }

        @Override // com.google.protobuf.AbstractC1077y
        public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
            g0 bVar;
            a aVar = null;
            switch (a.f14098a[eVar.ordinal()]) {
                case 1:
                    return new b();
                case 2:
                    return new C0227b(aVar);
                case 3:
                    return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0007\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0007Ȉ", new Object[]{"operator_", "operatorCase_", c.class, d.class, a.class, "alias_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g0 g0Var = PARSER;
                    if (g0Var != null) {
                        return g0Var;
                    }
                    synchronized (b.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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

        public final void p(String str) {
            str.getClass();
            this.alias_ = str;
        }

        public final void q(a aVar) {
            aVar.getClass();
            this.operator_ = aVar;
            this.operatorCase_ = 3;
        }

        public final void r(c cVar) {
            cVar.getClass();
            this.operator_ = cVar;
            this.operatorCase_ = 1;
        }

        public final void s(d dVar) {
            dVar.getClass();
            this.operator_ = dVar;
            this.operatorCase_ = 2;
        }
    }

    public static final class c extends AbstractC1077y.a implements X {
        public /* synthetic */ c(a aVar) {
            this();
        }

        public c f(Iterable iterable) {
            copyOnWrite();
            ((y) this.instance).m(iterable);
            return this;
        }

        public c g(z zVar) {
            copyOnWrite();
            ((y) this.instance).p(zVar);
            return this;
        }

        public c() {
            super(y.DEFAULT_INSTANCE);
        }
    }

    static {
        y yVar = new y();
        DEFAULT_INSTANCE = yVar;
        AbstractC1077y.registerDefaultInstance(y.class, yVar);
    }

    public static c o() {
        return (c) DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(z zVar) {
        zVar.getClass();
        this.queryType_ = zVar;
        this.queryTypeCase_ = 1;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14098a[eVar.ordinal()]) {
            case 1:
                return new y();
            case 2:
                return new c(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0003\u0002\u0000\u0001\u0000\u0001<\u0000\u0003\u001b", new Object[]{"queryType_", "queryTypeCase_", z.class, "aggregations_", b.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (y.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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

    public final void m(Iterable iterable) {
        n();
        AbstractC1050a.addAll(iterable, (List) this.aggregations_);
    }

    public final void n() {
        C.i iVar = this.aggregations_;
        if (iVar.e()) {
            return;
        }
        this.aggregations_ = AbstractC1077y.mutableCopy(iVar);
    }
}
