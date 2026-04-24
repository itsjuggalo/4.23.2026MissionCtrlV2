package p2;

import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import com.google.protobuf.u0;

/* JADX INFO: loaded from: classes.dex */
public final class w extends AbstractC1077y implements X {
    private static final w DEFAULT_INSTANCE;
    public static final int NEW_TRANSACTION_FIELD_NUMBER = 5;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile g0 PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 6;
    public static final int STRUCTURED_AGGREGATION_QUERY_FIELD_NUMBER = 2;
    public static final int TRANSACTION_FIELD_NUMBER = 4;
    private Object consistencySelector_;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private int consistencySelectorCase_ = 0;
    private String parent_ = "";

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14096a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14096a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14096a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14096a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14096a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14096a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14096a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14096a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b f(String str) {
            copyOnWrite();
            ((w) this.instance).o(str);
            return this;
        }

        public b g(y yVar) {
            copyOnWrite();
            ((w) this.instance).p(yVar);
            return this;
        }

        public b() {
            super(w.DEFAULT_INSTANCE);
        }
    }

    static {
        w wVar = new w();
        DEFAULT_INSTANCE = wVar;
        AbstractC1077y.registerDefaultInstance(w.class, wVar);
    }

    public static w m() {
        return DEFAULT_INSTANCE;
    }

    public static b n() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str) {
        str.getClass();
        this.parent_ = str;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14096a[eVar.ordinal()]) {
            case 1:
                return new w();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0002\u0000\u0001\u0006\u0005\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000\u0004=\u0001\u0005<\u0001\u0006<\u0001", new Object[]{"queryType_", "queryTypeCase_", "consistencySelector_", "consistencySelectorCase_", "parent_", y.class, C1697C.class, u0.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (w.class) {
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

    public final void p(y yVar) {
        yVar.getClass();
        this.queryType_ = yVar;
        this.queryTypeCase_ = 2;
    }
}
