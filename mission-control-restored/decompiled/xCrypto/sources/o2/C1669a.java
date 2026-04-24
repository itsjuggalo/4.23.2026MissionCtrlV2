package o2;

import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import p2.z;

/* JADX INFO: renamed from: o2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1669a extends AbstractC1077y implements X {
    private static final C1669a DEFAULT_INSTANCE;
    public static final int LIMIT_TYPE_FIELD_NUMBER = 3;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile g0 PARSER = null;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
    private int limitType_;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private String parent_ = "";

    /* JADX INFO: renamed from: o2.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0220a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13917a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f13917a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13917a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13917a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13917a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13917a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13917a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13917a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: o2.a$b */
    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(C0220a c0220a) {
            this();
        }

        public b f(c cVar) {
            copyOnWrite();
            ((C1669a) this.instance).s(cVar);
            return this;
        }

        public b g(String str) {
            copyOnWrite();
            ((C1669a) this.instance).t(str);
            return this;
        }

        public b h(z zVar) {
            copyOnWrite();
            ((C1669a) this.instance).u(zVar);
            return this;
        }

        public b() {
            super(C1669a.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: o2.a$c */
    public enum c implements C.c {
        FIRST(0),
        LAST(1),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final C.d f13921e = new C0221a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13923a;

        /* JADX INFO: renamed from: o2.a$c$a, reason: collision with other inner class name */
        public class C0221a implements C.d {
            @Override // com.google.protobuf.C.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i4) {
                return c.c(i4);
            }
        }

        c(int i4) {
            this.f13923a = i4;
        }

        public static c c(int i4) {
            if (i4 == 0) {
                return FIRST;
            }
            if (i4 != 1) {
                return null;
            }
            return LAST;
        }

        @Override // com.google.protobuf.C.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.f13923a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        C1669a c1669a = new C1669a();
        DEFAULT_INSTANCE = c1669a;
        AbstractC1077y.registerDefaultInstance(C1669a.class, c1669a);
    }

    public static b q() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static C1669a r(byte[] bArr) {
        return (C1669a) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        C0220a c0220a = null;
        switch (C0220a.f13917a[eVar.ordinal()]) {
            case 1:
                return new C1669a();
            case 2:
                return new b(c0220a);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000\u0003\f", new Object[]{"queryType_", "queryTypeCase_", "parent_", z.class, "limitType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1669a.class) {
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

    public c n() {
        c cVarC = c.c(this.limitType_);
        return cVarC == null ? c.UNRECOGNIZED : cVarC;
    }

    public String o() {
        return this.parent_;
    }

    public z p() {
        return this.queryTypeCase_ == 2 ? (z) this.queryType_ : z.u();
    }

    public final void s(c cVar) {
        this.limitType_ = cVar.getNumber();
    }

    public final void t(String str) {
        str.getClass();
        this.parent_ = str;
    }

    public final void u(z zVar) {
        zVar.getClass();
        this.queryType_ = zVar;
        this.queryTypeCase_ = 2;
    }
}
