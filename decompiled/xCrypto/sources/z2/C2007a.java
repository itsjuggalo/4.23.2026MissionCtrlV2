package z2;

import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.C1058e;
import com.google.protobuf.X;
import com.google.protobuf.g0;

/* JADX INFO: renamed from: z2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2007a extends AbstractC1077y implements X {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final C2007a DEFAULT_INSTANCE;
    public static final int DETAILS_FIELD_NUMBER = 3;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile g0 PARSER;
    private int code_;
    private String message_ = "";
    private C.i details_ = AbstractC1077y.emptyProtobufList();

    /* JADX INFO: renamed from: z2.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0261a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16121a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f16121a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16121a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16121a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16121a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16121a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16121a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16121a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: z2.a$b */
    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(C0261a c0261a) {
            this();
        }

        public b() {
            super(C2007a.DEFAULT_INSTANCE);
        }
    }

    static {
        C2007a c2007a = new C2007a();
        DEFAULT_INSTANCE = c2007a;
        AbstractC1077y.registerDefaultInstance(C2007a.class, c2007a);
    }

    public static C2007a l() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        C0261a c0261a = null;
        switch (C0261a.f16121a[eVar.ordinal()]) {
            case 1:
                return new C2007a();
            case 2:
                return new b(c0261a);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003\u001b", new Object[]{"code_", "message_", "details_", C1058e.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C2007a.class) {
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

    public int k() {
        return this.code_;
    }

    public String m() {
        return this.message_;
    }
}
