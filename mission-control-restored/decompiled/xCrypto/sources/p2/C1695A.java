package p2;

import com.google.protobuf.AbstractC1062i;
import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.C1078z;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import com.google.protobuf.u0;
import p2.z;

/* JADX INFO: renamed from: p2.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1695A extends AbstractC1077y implements X {
    private static final C1695A DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 3;
    public static final int EXPECTED_COUNT_FIELD_NUMBER = 12;
    public static final int ONCE_FIELD_NUMBER = 6;
    private static volatile g0 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 2;
    public static final int READ_TIME_FIELD_NUMBER = 11;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_ID_FIELD_NUMBER = 5;
    private int bitField0_;
    private C1078z expectedCount_;
    private boolean once_;
    private Object resumeType_;
    private int targetId_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private int resumeTypeCase_ = 0;

    /* JADX INFO: renamed from: p2.A$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13995a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f13995a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13995a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13995a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13995a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13995a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13995a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13995a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: p2.A$b */
    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b f(c cVar) {
            copyOnWrite();
            ((C1695A) this.instance).setDocuments(cVar);
            return this;
        }

        public b g(C1078z.b bVar) {
            copyOnWrite();
            ((C1695A) this.instance).r((C1078z) bVar.build());
            return this;
        }

        public b h(d dVar) {
            copyOnWrite();
            ((C1695A) this.instance).setQuery(dVar);
            return this;
        }

        public b i(u0 u0Var) {
            copyOnWrite();
            ((C1695A) this.instance).setReadTime(u0Var);
            return this;
        }

        public b j(AbstractC1062i abstractC1062i) {
            copyOnWrite();
            ((C1695A) this.instance).setResumeToken(abstractC1062i);
            return this;
        }

        public b k(int i4) {
            copyOnWrite();
            ((C1695A) this.instance).setTargetId(i4);
            return this;
        }

        public b() {
            super(C1695A.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: p2.A$c */
    public static final class c extends AbstractC1077y implements X {
        private static final c DEFAULT_INSTANCE;
        public static final int DOCUMENTS_FIELD_NUMBER = 2;
        private static volatile g0 PARSER;
        private C.i documents_ = AbstractC1077y.emptyProtobufList();

        /* JADX INFO: renamed from: p2.A$c$a */
        public static final class a extends AbstractC1077y.a implements X {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a f(String str) {
                copyOnWrite();
                ((c) this.instance).l(str);
                return this;
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

        /* JADX INFO: Access modifiers changed from: private */
        public void l(String str) {
            str.getClass();
            m();
            this.documents_.add(str);
        }

        private void m() {
            C.i iVar = this.documents_;
            if (iVar.e()) {
                return;
            }
            this.documents_ = AbstractC1077y.mutableCopy(iVar);
        }

        public static c n() {
            return DEFAULT_INSTANCE;
        }

        public static a q() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        public static a r(c cVar) {
            return (a) DEFAULT_INSTANCE.createBuilder(cVar);
        }

        @Override // com.google.protobuf.AbstractC1077y
        public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
            g0 bVar;
            a aVar = null;
            switch (a.f13995a[eVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002Ț", new Object[]{"documents_"});
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

        public String o(int i4) {
            return (String) this.documents_.get(i4);
        }

        public int p() {
            return this.documents_.size();
        }
    }

    /* JADX INFO: renamed from: p2.A$d */
    public static final class d extends AbstractC1077y implements X {
        private static final d DEFAULT_INSTANCE;
        public static final int PARENT_FIELD_NUMBER = 1;
        private static volatile g0 PARSER = null;
        public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
        private Object queryType_;
        private int queryTypeCase_ = 0;
        private String parent_ = "";

        /* JADX INFO: renamed from: p2.A$d$a */
        public static final class a extends AbstractC1077y.a implements X {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a f(String str) {
                copyOnWrite();
                ((d) this.instance).r(str);
                return this;
            }

            public a g(z.b bVar) {
                copyOnWrite();
                ((d) this.instance).s((z) bVar.build());
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

        public static d m() {
            return DEFAULT_INSTANCE;
        }

        public static a p() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        public static a q(d dVar) {
            return (a) DEFAULT_INSTANCE.createBuilder(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(String str) {
            str.getClass();
            this.parent_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(z zVar) {
            zVar.getClass();
            this.queryType_ = zVar;
            this.queryTypeCase_ = 2;
        }

        @Override // com.google.protobuf.AbstractC1077y
        public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
            g0 bVar;
            a aVar = null;
            switch (a.f13995a[eVar.ordinal()]) {
                case 1:
                    return new d();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000", new Object[]{"queryType_", "queryTypeCase_", "parent_", z.class});
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

        public String n() {
            return this.parent_;
        }

        public z o() {
            return this.queryTypeCase_ == 2 ? (z) this.queryType_ : z.u();
        }
    }

    static {
        C1695A c1695a = new C1695A();
        DEFAULT_INSTANCE = c1695a;
        AbstractC1077y.registerDefaultInstance(C1695A.class, c1695a);
    }

    public static b q() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f13995a[eVar.ordinal()]) {
            case 1:
                return new C1695A();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0002\u0001\u0002\f\u0007\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004=\u0001\u0005\u0004\u0006\u0007\u000b<\u0001\fဉ\u0000", new Object[]{"targetType_", "targetTypeCase_", "resumeType_", "resumeTypeCase_", "bitField0_", d.class, c.class, "targetId_", "once_", u0.class, "expectedCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1695A.class) {
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

    public final void r(C1078z c1078z) {
        c1078z.getClass();
        this.expectedCount_ = c1078z;
        this.bitField0_ |= 1;
    }

    public final void setDocuments(c cVar) {
        cVar.getClass();
        this.targetType_ = cVar;
        this.targetTypeCase_ = 3;
    }

    public final void setQuery(d dVar) {
        dVar.getClass();
        this.targetType_ = dVar;
        this.targetTypeCase_ = 2;
    }

    public final void setReadTime(u0 u0Var) {
        u0Var.getClass();
        this.resumeType_ = u0Var;
        this.resumeTypeCase_ = 11;
    }

    public final void setResumeToken(AbstractC1062i abstractC1062i) {
        abstractC1062i.getClass();
        this.resumeTypeCase_ = 4;
        this.resumeType_ = abstractC1062i;
    }

    public final void setTargetId(int i4) {
        this.targetId_ = i4;
    }
}
