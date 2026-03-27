package p2;

import com.google.protobuf.AbstractC1062i;
import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import com.google.protobuf.u0;

/* JADX INFO: renamed from: p2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1708e extends AbstractC1077y implements X {
    private static final C1708e DEFAULT_INSTANCE;
    public static final int FOUND_FIELD_NUMBER = 1;
    public static final int MISSING_FIELD_NUMBER = 2;
    private static volatile g0 PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    private int bitField0_;
    private u0 readTime_;
    private Object result_;
    private int resultCase_ = 0;
    private AbstractC1062i transaction_ = AbstractC1062i.f11025b;

    /* JADX INFO: renamed from: p2.e$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14038a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14038a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14038a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14038a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14038a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14038a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14038a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14038a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: p2.e$b */
    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(C1708e.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: p2.e$c */
    public enum c {
        FOUND(1),
        MISSING(2),
        RESULT_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14043a;

        c(int i4) {
            this.f14043a = i4;
        }

        public static c c(int i4) {
            if (i4 == 0) {
                return RESULT_NOT_SET;
            }
            if (i4 == 1) {
                return FOUND;
            }
            if (i4 != 2) {
                return null;
            }
            return MISSING;
        }
    }

    static {
        C1708e c1708e = new C1708e();
        DEFAULT_INSTANCE = c1708e;
        AbstractC1077y.registerDefaultInstance(C1708e.class, c1708e);
    }

    public static C1708e k() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14038a[eVar.ordinal()]) {
            case 1:
                return new C1708e();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003\n\u0004ဉ\u0000", new Object[]{"result_", "resultCase_", "bitField0_", k.class, "transaction_", "readTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1708e.class) {
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

    public u0 getReadTime() {
        u0 u0Var = this.readTime_;
        return u0Var == null ? u0.m() : u0Var;
    }

    public k l() {
        return this.resultCase_ == 1 ? (k) this.result_ : k.n();
    }

    public String m() {
        return this.resultCase_ == 2 ? (String) this.result_ : "";
    }

    public c n() {
        return c.c(this.resultCase_);
    }
}
