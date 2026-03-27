package k4;

import com.google.protobuf.AbstractC1240i;
import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.C;
import com.google.protobuf.W;
import com.google.protobuf.f0;

/* JADX INFO: renamed from: k4.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2117h extends AbstractC1255y implements W {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final C2117h DEFAULT_INSTANCE;
    private static volatile f0 PARSER = null;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    public static final int WRITES_FIELD_NUMBER = 2;
    private String database_ = "";
    private C.e writes_ = AbstractC1255y.A();
    private AbstractC1240i transaction_ = AbstractC1240i.f12650b;

    /* JADX INFO: renamed from: k4.h$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18045a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18045a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18045a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18045a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18045a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18045a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18045a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18045a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.h$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b w(C2106E c2106e) {
            q();
            ((C2117h) this.f12868b).c0(c2106e);
            return this;
        }

        public b x(String str) {
            q();
            ((C2117h) this.f12868b).g0(str);
            return this;
        }

        public b() {
            super(C2117h.DEFAULT_INSTANCE);
        }
    }

    static {
        C2117h c2117h = new C2117h();
        DEFAULT_INSTANCE = c2117h;
        AbstractC1255y.V(C2117h.class, c2117h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(C2106E c2106e) {
        c2106e.getClass();
        d0();
        this.writes_.add(c2106e);
    }

    private void d0() {
        C.e eVar = this.writes_;
        if (eVar.f()) {
            return;
        }
        this.writes_ = AbstractC1255y.L(eVar);
    }

    public static C2117h e0() {
        return DEFAULT_INSTANCE;
    }

    public static b f0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(String str) {
        str.getClass();
        this.database_ = str;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18045a[dVar.ordinal()]) {
            case 1:
                return new C2117h();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003\n", new Object[]{"database_", "writes_", C2106E.class, "transaction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2117h.class) {
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
