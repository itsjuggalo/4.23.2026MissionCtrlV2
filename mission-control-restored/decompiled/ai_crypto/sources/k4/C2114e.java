package k4;

import com.google.protobuf.AbstractC1240i;
import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import com.google.protobuf.t0;

/* JADX INFO: renamed from: k4.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2114e extends AbstractC1255y implements W {
    private static final C2114e DEFAULT_INSTANCE;
    public static final int FOUND_FIELD_NUMBER = 1;
    public static final int MISSING_FIELD_NUMBER = 2;
    private static volatile f0 PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    private int bitField0_;
    private t0 readTime_;
    private Object result_;
    private int resultCase_ = 0;
    private AbstractC1240i transaction_ = AbstractC1240i.f12650b;

    /* JADX INFO: renamed from: k4.e$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18037a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18037a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18037a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18037a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18037a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18037a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18037a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18037a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.e$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(C2114e.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: k4.e$c */
    public enum c {
        FOUND(1),
        MISSING(2),
        RESULT_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18042a;

        c(int i7) {
            this.f18042a = i7;
        }

        public static c b(int i7) {
            if (i7 == 0) {
                return RESULT_NOT_SET;
            }
            if (i7 == 1) {
                return FOUND;
            }
            if (i7 != 2) {
                return null;
            }
            return MISSING;
        }
    }

    static {
        C2114e c2114e = new C2114e();
        DEFAULT_INSTANCE = c2114e;
        AbstractC1255y.V(C2114e.class, c2114e);
    }

    public static C2114e a0() {
        return DEFAULT_INSTANCE;
    }

    public C2120k b0() {
        return this.resultCase_ == 1 ? (C2120k) this.result_ : C2120k.d0();
    }

    public String c0() {
        return this.resultCase_ == 2 ? (String) this.result_ : "";
    }

    public t0 d0() {
        t0 t0Var = this.readTime_;
        return t0Var == null ? t0.c0() : t0Var;
    }

    public c e0() {
        return c.b(this.resultCase_);
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18037a[dVar.ordinal()]) {
            case 1:
                return new C2114e();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003\n\u0004ဉ\u0000", new Object[]{"result_", "resultCase_", "bitField0_", C2120k.class, "transaction_", "readTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2114e.class) {
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
