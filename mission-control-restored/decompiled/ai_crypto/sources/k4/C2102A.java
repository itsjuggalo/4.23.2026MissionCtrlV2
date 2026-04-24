package k4;

import com.google.protobuf.AbstractC1240i;
import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.C;
import com.google.protobuf.C1256z;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import com.google.protobuf.t0;
import k4.C2135z;

/* JADX INFO: renamed from: k4.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2102A extends AbstractC1255y implements W {
    private static final C2102A DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 3;
    public static final int EXPECTED_COUNT_FIELD_NUMBER = 12;
    public static final int ONCE_FIELD_NUMBER = 6;
    private static volatile f0 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 2;
    public static final int READ_TIME_FIELD_NUMBER = 11;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_ID_FIELD_NUMBER = 5;
    private int bitField0_;
    private C1256z expectedCount_;
    private boolean once_;
    private Object resumeType_;
    private int targetId_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private int resumeTypeCase_ = 0;

    /* JADX INFO: renamed from: k4.A$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17994a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f17994a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17994a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17994a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17994a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17994a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17994a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17994a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.A$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b A(AbstractC1240i abstractC1240i) {
            q();
            ((C2102A) this.f12868b).l0(abstractC1240i);
            return this;
        }

        public b B(int i7) {
            q();
            ((C2102A) this.f12868b).m0(i7);
            return this;
        }

        public b w(c cVar) {
            q();
            ((C2102A) this.f12868b).h0(cVar);
            return this;
        }

        public b x(C1256z.b bVar) {
            q();
            ((C2102A) this.f12868b).i0((C1256z) bVar.n());
            return this;
        }

        public b y(d dVar) {
            q();
            ((C2102A) this.f12868b).j0(dVar);
            return this;
        }

        public b z(t0 t0Var) {
            q();
            ((C2102A) this.f12868b).k0(t0Var);
            return this;
        }

        public b() {
            super(C2102A.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: k4.A$c */
    public static final class c extends AbstractC1255y implements W {
        private static final c DEFAULT_INSTANCE;
        public static final int DOCUMENTS_FIELD_NUMBER = 2;
        private static volatile f0 PARSER;
        private C.e documents_ = AbstractC1255y.A();

        /* JADX INFO: renamed from: k4.A$c$a */
        public static final class a extends AbstractC1255y.a implements W {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a w(String str) {
                q();
                ((c) this.f12868b).b0(str);
                return this;
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

        /* JADX INFO: Access modifiers changed from: private */
        public void b0(String str) {
            str.getClass();
            c0();
            this.documents_.add(str);
        }

        private void c0() {
            C.e eVar = this.documents_;
            if (eVar.f()) {
                return;
            }
            this.documents_ = AbstractC1255y.L(eVar);
        }

        public static c d0() {
            return DEFAULT_INSTANCE;
        }

        public static a g0() {
            return (a) DEFAULT_INSTANCE.u();
        }

        public String e0(int i7) {
            return (String) this.documents_.get(i7);
        }

        public int f0() {
            return this.documents_.size();
        }

        @Override // com.google.protobuf.AbstractC1255y
        public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f17994a[dVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002Ț", new Object[]{"documents_"});
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

    /* JADX INFO: renamed from: k4.A$d */
    public static final class d extends AbstractC1255y implements W {
        private static final d DEFAULT_INSTANCE;
        public static final int PARENT_FIELD_NUMBER = 1;
        private static volatile f0 PARSER = null;
        public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
        private Object queryType_;
        private int queryTypeCase_ = 0;
        private String parent_ = "";

        /* JADX INFO: renamed from: k4.A$d$a */
        public static final class a extends AbstractC1255y.a implements W {
            public /* synthetic */ a(a aVar) {
                this();
            }

            public a w(String str) {
                q();
                ((d) this.f12868b).g0(str);
                return this;
            }

            public a x(C2135z.b bVar) {
                q();
                ((d) this.f12868b).h0((C2135z) bVar.n());
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

        public static d c0() {
            return DEFAULT_INSTANCE;
        }

        public static a f0() {
            return (a) DEFAULT_INSTANCE.u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g0(String str) {
            str.getClass();
            this.parent_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h0(C2135z c2135z) {
            c2135z.getClass();
            this.queryType_ = c2135z;
            this.queryTypeCase_ = 2;
        }

        public String d0() {
            return this.parent_;
        }

        public C2135z e0() {
            return this.queryTypeCase_ == 2 ? (C2135z) this.queryType_ : C2135z.k0();
        }

        @Override // com.google.protobuf.AbstractC1255y
        public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f17994a[dVar.ordinal()]) {
                case 1:
                    return new d();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000", new Object[]{"queryType_", "queryTypeCase_", "parent_", C2135z.class});
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
        C2102A c2102a = new C2102A();
        DEFAULT_INSTANCE = c2102a;
        AbstractC1255y.V(C2102A.class, c2102a);
    }

    public static b g0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(c cVar) {
        cVar.getClass();
        this.targetType_ = cVar;
        this.targetTypeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(d dVar) {
        dVar.getClass();
        this.targetType_ = dVar;
        this.targetTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(t0 t0Var) {
        t0Var.getClass();
        this.resumeType_ = t0Var;
        this.resumeTypeCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(AbstractC1240i abstractC1240i) {
        abstractC1240i.getClass();
        this.resumeTypeCase_ = 4;
        this.resumeType_ = abstractC1240i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(int i7) {
        this.targetId_ = i7;
    }

    public final void i0(C1256z c1256z) {
        c1256z.getClass();
        this.expectedCount_ = c1256z;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f17994a[dVar.ordinal()]) {
            case 1:
                return new C2102A();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0007\u0002\u0001\u0002\f\u0007\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004=\u0001\u0005\u0004\u0006\u0007\u000b<\u0001\fဉ\u0000", new Object[]{"targetType_", "targetTypeCase_", "resumeType_", "resumeTypeCase_", "bitField0_", d.class, c.class, "targetId_", "once_", t0.class, "expectedCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2102A.class) {
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
