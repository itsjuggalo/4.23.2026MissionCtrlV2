package p2;

import A2.a;
import com.google.protobuf.AbstractC1062i;
import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.X;
import com.google.protobuf.f0;
import com.google.protobuf.g0;
import com.google.protobuf.u0;
import p2.C1705b;
import p2.u;

/* JADX INFO: renamed from: p2.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1698D extends AbstractC1077y implements X {
    public static final int ARRAY_VALUE_FIELD_NUMBER = 9;
    public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1;
    public static final int BYTES_VALUE_FIELD_NUMBER = 18;
    private static final C1698D DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
    public static final int GEO_POINT_VALUE_FIELD_NUMBER = 8;
    public static final int INTEGER_VALUE_FIELD_NUMBER = 2;
    public static final int MAP_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 11;
    private static volatile g0 PARSER = null;
    public static final int REFERENCE_VALUE_FIELD_NUMBER = 5;
    public static final int STRING_VALUE_FIELD_NUMBER = 17;
    public static final int TIMESTAMP_VALUE_FIELD_NUMBER = 10;
    private int valueTypeCase_ = 0;
    private Object valueType_;

    /* JADX INFO: renamed from: p2.D$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14007a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14007a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14007a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14007a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14007a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14007a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14007a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14007a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: p2.D$b */
    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public u f() {
            return ((C1698D) this.instance).C();
        }

        public b g(C1705b.C0224b c0224b) {
            copyOnWrite();
            ((C1698D) this.instance).J((C1705b) c0224b.build());
            return this;
        }

        public b h(C1705b c1705b) {
            copyOnWrite();
            ((C1698D) this.instance).J(c1705b);
            return this;
        }

        public b i(boolean z4) {
            copyOnWrite();
            ((C1698D) this.instance).K(z4);
            return this;
        }

        public b j(AbstractC1062i abstractC1062i) {
            copyOnWrite();
            ((C1698D) this.instance).L(abstractC1062i);
            return this;
        }

        public b k(double d4) {
            copyOnWrite();
            ((C1698D) this.instance).M(d4);
            return this;
        }

        public b l(a.b bVar) {
            copyOnWrite();
            ((C1698D) this.instance).N((A2.a) bVar.build());
            return this;
        }

        public b m(long j4) {
            copyOnWrite();
            ((C1698D) this.instance).O(j4);
            return this;
        }

        public b n(u.b bVar) {
            copyOnWrite();
            ((C1698D) this.instance).P((u) bVar.build());
            return this;
        }

        public b o(u uVar) {
            copyOnWrite();
            ((C1698D) this.instance).P(uVar);
            return this;
        }

        public b p(f0 f0Var) {
            copyOnWrite();
            ((C1698D) this.instance).Q(f0Var);
            return this;
        }

        public b q(String str) {
            copyOnWrite();
            ((C1698D) this.instance).R(str);
            return this;
        }

        public b r(String str) {
            copyOnWrite();
            ((C1698D) this.instance).S(str);
            return this;
        }

        public b s(u0.b bVar) {
            copyOnWrite();
            ((C1698D) this.instance).T((u0) bVar.build());
            return this;
        }

        public b() {
            super(C1698D.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: p2.D$c */
    public enum c {
        NULL_VALUE(11),
        BOOLEAN_VALUE(1),
        INTEGER_VALUE(2),
        DOUBLE_VALUE(3),
        TIMESTAMP_VALUE(10),
        STRING_VALUE(17),
        BYTES_VALUE(18),
        REFERENCE_VALUE(5),
        GEO_POINT_VALUE(8),
        ARRAY_VALUE(9),
        MAP_VALUE(6),
        VALUETYPE_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14021a;

        c(int i4) {
            this.f14021a = i4;
        }

        public static c c(int i4) {
            if (i4 == 0) {
                return VALUETYPE_NOT_SET;
            }
            if (i4 == 1) {
                return BOOLEAN_VALUE;
            }
            if (i4 == 2) {
                return INTEGER_VALUE;
            }
            if (i4 == 3) {
                return DOUBLE_VALUE;
            }
            if (i4 == 5) {
                return REFERENCE_VALUE;
            }
            if (i4 == 6) {
                return MAP_VALUE;
            }
            if (i4 == 17) {
                return STRING_VALUE;
            }
            if (i4 == 18) {
                return BYTES_VALUE;
            }
            switch (i4) {
                case 8:
                    return GEO_POINT_VALUE;
                case 9:
                    return ARRAY_VALUE;
                case 10:
                    return TIMESTAMP_VALUE;
                case 11:
                    return NULL_VALUE;
                default:
                    return null;
            }
        }
    }

    static {
        C1698D c1698d = new C1698D();
        DEFAULT_INSTANCE = c1698d;
        AbstractC1077y.registerDefaultInstance(C1698D.class, c1698d);
    }

    public static b I() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static C1698D y() {
        return DEFAULT_INSTANCE;
    }

    public A2.a A() {
        return this.valueTypeCase_ == 8 ? (A2.a) this.valueType_ : A2.a.m();
    }

    public long B() {
        if (this.valueTypeCase_ == 2) {
            return ((Long) this.valueType_).longValue();
        }
        return 0L;
    }

    public u C() {
        return this.valueTypeCase_ == 6 ? (u) this.valueType_ : u.l();
    }

    public String D() {
        return this.valueTypeCase_ == 5 ? (String) this.valueType_ : "";
    }

    public String E() {
        return this.valueTypeCase_ == 17 ? (String) this.valueType_ : "";
    }

    public u0 F() {
        return this.valueTypeCase_ == 10 ? (u0) this.valueType_ : u0.m();
    }

    public c G() {
        return c.c(this.valueTypeCase_);
    }

    public boolean H() {
        return this.valueTypeCase_ == 11;
    }

    public final void J(C1705b c1705b) {
        c1705b.getClass();
        this.valueType_ = c1705b;
        this.valueTypeCase_ = 9;
    }

    public final void K(boolean z4) {
        this.valueTypeCase_ = 1;
        this.valueType_ = Boolean.valueOf(z4);
    }

    public final void L(AbstractC1062i abstractC1062i) {
        abstractC1062i.getClass();
        this.valueTypeCase_ = 18;
        this.valueType_ = abstractC1062i;
    }

    public final void M(double d4) {
        this.valueTypeCase_ = 3;
        this.valueType_ = Double.valueOf(d4);
    }

    public final void N(A2.a aVar) {
        aVar.getClass();
        this.valueType_ = aVar;
        this.valueTypeCase_ = 8;
    }

    public final void O(long j4) {
        this.valueTypeCase_ = 2;
        this.valueType_ = Long.valueOf(j4);
    }

    public final void P(u uVar) {
        uVar.getClass();
        this.valueType_ = uVar;
        this.valueTypeCase_ = 6;
    }

    public final void Q(f0 f0Var) {
        this.valueType_ = Integer.valueOf(f0Var.getNumber());
        this.valueTypeCase_ = 11;
    }

    public final void R(String str) {
        str.getClass();
        this.valueTypeCase_ = 5;
        this.valueType_ = str;
    }

    public final void S(String str) {
        str.getClass();
        this.valueTypeCase_ = 17;
        this.valueType_ = str;
    }

    public final void T(u0 u0Var) {
        u0Var.getClass();
        this.valueType_ = u0Var;
        this.valueTypeCase_ = 10;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14007a[eVar.ordinal()]) {
            case 1:
                return new C1698D();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0001\u0000\u0001\u0012\u000b\u0000\u0000\u0000\u0001:\u0000\u00025\u0000\u00033\u0000\u0005Ȼ\u0000\u0006<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b?\u0000\u0011Ȼ\u0000\u0012=\u0000", new Object[]{"valueType_", "valueTypeCase_", u.class, A2.a.class, C1705b.class, u0.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1698D.class) {
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

    public C1705b v() {
        return this.valueTypeCase_ == 9 ? (C1705b) this.valueType_ : C1705b.q();
    }

    public boolean w() {
        if (this.valueTypeCase_ == 1) {
            return ((Boolean) this.valueType_).booleanValue();
        }
        return false;
    }

    public AbstractC1062i x() {
        return this.valueTypeCase_ == 18 ? (AbstractC1062i) this.valueType_ : AbstractC1062i.f11025b;
    }

    public double z() {
        if (this.valueTypeCase_ == 3) {
            return ((Double) this.valueType_).doubleValue();
        }
        return 0.0d;
    }
}
