package p2;

import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import com.google.protobuf.u0;

/* JADX INFO: renamed from: p2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1707d extends AbstractC1077y implements X {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final C1707d DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 2;
    public static final int MASK_FIELD_NUMBER = 3;
    public static final int NEW_TRANSACTION_FIELD_NUMBER = 5;
    private static volatile g0 PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 7;
    public static final int TRANSACTION_FIELD_NUMBER = 4;
    private int bitField0_;
    private Object consistencySelector_;
    private n mask_;
    private int consistencySelectorCase_ = 0;
    private String database_ = "";
    private C.i documents_ = AbstractC1077y.emptyProtobufList();

    /* JADX INFO: renamed from: p2.d$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14037a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14037a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14037a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14037a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14037a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14037a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14037a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14037a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: p2.d$b */
    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b f(String str) {
            copyOnWrite();
            ((C1707d) this.instance).m(str);
            return this;
        }

        public b g(String str) {
            copyOnWrite();
            ((C1707d) this.instance).q(str);
            return this;
        }

        public b() {
            super(C1707d.DEFAULT_INSTANCE);
        }
    }

    static {
        C1707d c1707d = new C1707d();
        DEFAULT_INSTANCE = c1707d;
        AbstractC1077y.registerDefaultInstance(C1707d.class, c1707d);
    }

    public static C1707d o() {
        return DEFAULT_INSTANCE;
    }

    public static b p() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14037a[eVar.ordinal()]) {
            case 1:
                return new C1707d();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0001\u0001\u0007\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ț\u0003ဉ\u0000\u0004=\u0000\u0005<\u0000\u0007<\u0000", new Object[]{"consistencySelector_", "consistencySelectorCase_", "bitField0_", "database_", "documents_", "mask_", C1697C.class, u0.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1707d.class) {
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

    public final void m(String str) {
        str.getClass();
        n();
        this.documents_.add(str);
    }

    public final void n() {
        C.i iVar = this.documents_;
        if (iVar.e()) {
            return;
        }
        this.documents_ = AbstractC1077y.mutableCopy(iVar);
    }

    public final void q(String str) {
        str.getClass();
        this.database_ = str;
    }
}
