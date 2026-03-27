package u4;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.C;
import com.google.protobuf.C1236e;
import com.google.protobuf.W;
import com.google.protobuf.f0;

/* JADX INFO: renamed from: u4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2753a extends AbstractC1255y implements W {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final C2753a DEFAULT_INSTANCE;
    public static final int DETAILS_FIELD_NUMBER = 3;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile f0 PARSER;
    private int code_;
    private String message_ = "";
    private C.e details_ = AbstractC1255y.A();

    /* JADX INFO: renamed from: u4.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0378a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24467a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f24467a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24467a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24467a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24467a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f24467a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f24467a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f24467a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: u4.a$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(C0378a c0378a) {
            this();
        }

        public b() {
            super(C2753a.DEFAULT_INSTANCE);
        }
    }

    static {
        C2753a c2753a = new C2753a();
        DEFAULT_INSTANCE = c2753a;
        AbstractC1255y.V(C2753a.class, c2753a);
    }

    public static C2753a b0() {
        return DEFAULT_INSTANCE;
    }

    public int a0() {
        return this.code_;
    }

    public String c0() {
        return this.message_;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        C0378a c0378a = null;
        switch (C0378a.f24467a[dVar.ordinal()]) {
            case 1:
                return new C2753a();
            case 2:
                return new b(c0378a);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003\u001b", new Object[]{"code_", "message_", "details_", C1236e.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2753a.class) {
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
