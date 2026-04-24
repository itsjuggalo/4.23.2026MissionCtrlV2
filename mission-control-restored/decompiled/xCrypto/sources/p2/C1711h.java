package p2;

import com.google.protobuf.AbstractC1062i;
import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.X;
import com.google.protobuf.g0;

/* JADX INFO: renamed from: p2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1711h extends AbstractC1077y implements X {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final C1711h DEFAULT_INSTANCE;
    private static volatile g0 PARSER = null;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    public static final int WRITES_FIELD_NUMBER = 2;
    private String database_ = "";
    private C.i writes_ = AbstractC1077y.emptyProtobufList();
    private AbstractC1062i transaction_ = AbstractC1062i.f11025b;

    /* JADX INFO: renamed from: p2.h$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14046a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14046a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14046a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14046a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14046a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14046a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14046a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14046a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: p2.h$b */
    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b f(C1699E c1699e) {
            copyOnWrite();
            ((C1711h) this.instance).addWrites(c1699e);
            return this;
        }

        public b g(String str) {
            copyOnWrite();
            ((C1711h) this.instance).o(str);
            return this;
        }

        public b() {
            super(C1711h.DEFAULT_INSTANCE);
        }
    }

    static {
        C1711h c1711h = new C1711h();
        DEFAULT_INSTANCE = c1711h;
        AbstractC1077y.registerDefaultInstance(C1711h.class, c1711h);
    }

    public static C1711h m() {
        return DEFAULT_INSTANCE;
    }

    public static b n() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str) {
        str.getClass();
        this.database_ = str;
    }

    public final void addWrites(C1699E c1699e) {
        c1699e.getClass();
        ensureWritesIsMutable();
        this.writes_.add(c1699e);
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14046a[eVar.ordinal()]) {
            case 1:
                return new C1711h();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003\n", new Object[]{"database_", "writes_", C1699E.class, "transaction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1711h.class) {
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

    public final void ensureWritesIsMutable() {
        C.i iVar = this.writes_;
        if (iVar.e()) {
            return;
        }
        this.writes_ = AbstractC1077y.mutableCopy(iVar);
    }
}
