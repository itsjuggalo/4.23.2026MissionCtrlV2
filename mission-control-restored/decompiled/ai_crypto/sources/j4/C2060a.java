package j4;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.C;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import k4.C2135z;

/* JADX INFO: renamed from: j4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2060a extends AbstractC1255y implements W {
    private static final C2060a DEFAULT_INSTANCE;
    public static final int LIMIT_TYPE_FIELD_NUMBER = 3;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile f0 PARSER = null;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
    private int limitType_;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private String parent_ = "";

    /* JADX INFO: renamed from: j4.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0265a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17439a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f17439a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17439a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17439a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17439a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17439a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17439a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17439a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: j4.a$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(C0265a c0265a) {
            this();
        }

        public b w(c cVar) {
            q();
            ((C2060a) this.f12868b).i0(cVar);
            return this;
        }

        public b x(String str) {
            q();
            ((C2060a) this.f12868b).j0(str);
            return this;
        }

        public b y(C2135z c2135z) {
            q();
            ((C2060a) this.f12868b).k0(c2135z);
            return this;
        }

        public b() {
            super(C2060a.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: j4.a$c */
    public enum c implements C.a {
        FIRST(0),
        LAST(1),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final C.b f17443e = new C0266a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17445a;

        /* JADX INFO: renamed from: j4.a$c$a, reason: collision with other inner class name */
        public class C0266a implements C.b {
        }

        c(int i7) {
            this.f17445a = i7;
        }

        public static c b(int i7) {
            if (i7 == 0) {
                return FIRST;
            }
            if (i7 != 1) {
                return null;
            }
            return LAST;
        }

        @Override // com.google.protobuf.C.a
        public final int d() {
            if (this != UNRECOGNIZED) {
                return this.f17445a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        C2060a c2060a = new C2060a();
        DEFAULT_INSTANCE = c2060a;
        AbstractC1255y.V(C2060a.class, c2060a);
    }

    public static b g0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public static C2060a h0(byte[] bArr) {
        return (C2060a) AbstractC1255y.R(DEFAULT_INSTANCE, bArr);
    }

    public c d0() {
        c cVarB = c.b(this.limitType_);
        return cVarB == null ? c.UNRECOGNIZED : cVarB;
    }

    public String e0() {
        return this.parent_;
    }

    public C2135z f0() {
        return this.queryTypeCase_ == 2 ? (C2135z) this.queryType_ : C2135z.k0();
    }

    public final void i0(c cVar) {
        this.limitType_ = cVar.d();
    }

    public final void j0(String str) {
        str.getClass();
        this.parent_ = str;
    }

    public final void k0(C2135z c2135z) {
        c2135z.getClass();
        this.queryType_ = c2135z;
        this.queryTypeCase_ = 2;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        C0265a c0265a = null;
        switch (C0265a.f17439a[dVar.ordinal()]) {
            case 1:
                return new C2060a();
            case 2:
                return new b(c0265a);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000\u0003\f", new Object[]{"queryType_", "queryTypeCase_", "parent_", C2135z.class, "limitType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2060a.class) {
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
