package k4;

import com.google.protobuf.AbstractC1240i;
import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.W;
import com.google.protobuf.e0;
import com.google.protobuf.f0;
import com.google.protobuf.t0;
import k4.C2111b;
import k4.C2130u;
import v4.C2767a;

/* JADX INFO: renamed from: k4.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2105D extends AbstractC1255y implements W {
    public static final int ARRAY_VALUE_FIELD_NUMBER = 9;
    public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1;
    public static final int BYTES_VALUE_FIELD_NUMBER = 18;
    private static final C2105D DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
    public static final int GEO_POINT_VALUE_FIELD_NUMBER = 8;
    public static final int INTEGER_VALUE_FIELD_NUMBER = 2;
    public static final int MAP_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 11;
    private static volatile f0 PARSER = null;
    public static final int REFERENCE_VALUE_FIELD_NUMBER = 5;
    public static final int STRING_VALUE_FIELD_NUMBER = 17;
    public static final int TIMESTAMP_VALUE_FIELD_NUMBER = 10;
    private int valueTypeCase_ = 0;
    private Object valueType_;

    /* JADX INFO: renamed from: k4.D$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18006a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18006a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18006a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18006a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18006a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18006a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18006a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18006a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.D$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b A(AbstractC1240i abstractC1240i) {
            q();
            ((C2105D) this.f12868b).B0(abstractC1240i);
            return this;
        }

        public b B(double d7) {
            q();
            ((C2105D) this.f12868b).C0(d7);
            return this;
        }

        public b C(C2767a.b bVar) {
            q();
            ((C2105D) this.f12868b).D0((C2767a) bVar.n());
            return this;
        }

        public b D(long j7) {
            q();
            ((C2105D) this.f12868b).E0(j7);
            return this;
        }

        public b E(C2130u.b bVar) {
            q();
            ((C2105D) this.f12868b).F0((C2130u) bVar.n());
            return this;
        }

        public b F(C2130u c2130u) {
            q();
            ((C2105D) this.f12868b).F0(c2130u);
            return this;
        }

        public b G(e0 e0Var) {
            q();
            ((C2105D) this.f12868b).G0(e0Var);
            return this;
        }

        public b H(String str) {
            q();
            ((C2105D) this.f12868b).H0(str);
            return this;
        }

        public b I(String str) {
            q();
            ((C2105D) this.f12868b).I0(str);
            return this;
        }

        public b J(t0.b bVar) {
            q();
            ((C2105D) this.f12868b).J0((t0) bVar.n());
            return this;
        }

        public C2130u w() {
            return ((C2105D) this.f12868b).s0();
        }

        public b x(C2111b.C0290b c0290b) {
            q();
            ((C2105D) this.f12868b).z0((C2111b) c0290b.n());
            return this;
        }

        public b y(C2111b c2111b) {
            q();
            ((C2105D) this.f12868b).z0(c2111b);
            return this;
        }

        public b z(boolean z7) {
            q();
            ((C2105D) this.f12868b).A0(z7);
            return this;
        }

        public b() {
            super(C2105D.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: k4.D$c */
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
        public final int f18020a;

        c(int i7) {
            this.f18020a = i7;
        }

        public static c b(int i7) {
            if (i7 == 0) {
                return VALUETYPE_NOT_SET;
            }
            if (i7 == 1) {
                return BOOLEAN_VALUE;
            }
            if (i7 == 2) {
                return INTEGER_VALUE;
            }
            if (i7 == 3) {
                return DOUBLE_VALUE;
            }
            if (i7 == 5) {
                return REFERENCE_VALUE;
            }
            if (i7 == 6) {
                return MAP_VALUE;
            }
            if (i7 == 17) {
                return STRING_VALUE;
            }
            if (i7 == 18) {
                return BYTES_VALUE;
            }
            switch (i7) {
                case 8:
                    return GEO_POINT_VALUE;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    return ARRAY_VALUE;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    return TIMESTAMP_VALUE;
                case 11:
                    return NULL_VALUE;
                default:
                    return null;
            }
        }
    }

    static {
        C2105D c2105d = new C2105D();
        DEFAULT_INSTANCE = c2105d;
        AbstractC1255y.V(C2105D.class, c2105d);
    }

    public static C2105D o0() {
        return DEFAULT_INSTANCE;
    }

    public static b y0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public final void A0(boolean z7) {
        this.valueTypeCase_ = 1;
        this.valueType_ = Boolean.valueOf(z7);
    }

    public final void B0(AbstractC1240i abstractC1240i) {
        abstractC1240i.getClass();
        this.valueTypeCase_ = 18;
        this.valueType_ = abstractC1240i;
    }

    public final void C0(double d7) {
        this.valueTypeCase_ = 3;
        this.valueType_ = Double.valueOf(d7);
    }

    public final void D0(C2767a c2767a) {
        c2767a.getClass();
        this.valueType_ = c2767a;
        this.valueTypeCase_ = 8;
    }

    public final void E0(long j7) {
        this.valueTypeCase_ = 2;
        this.valueType_ = Long.valueOf(j7);
    }

    public final void F0(C2130u c2130u) {
        c2130u.getClass();
        this.valueType_ = c2130u;
        this.valueTypeCase_ = 6;
    }

    public final void G0(e0 e0Var) {
        this.valueType_ = Integer.valueOf(e0Var.d());
        this.valueTypeCase_ = 11;
    }

    public final void H0(String str) {
        str.getClass();
        this.valueTypeCase_ = 5;
        this.valueType_ = str;
    }

    public final void I0(String str) {
        str.getClass();
        this.valueTypeCase_ = 17;
        this.valueType_ = str;
    }

    public final void J0(t0 t0Var) {
        t0Var.getClass();
        this.valueType_ = t0Var;
        this.valueTypeCase_ = 10;
    }

    public C2111b l0() {
        return this.valueTypeCase_ == 9 ? (C2111b) this.valueType_ : C2111b.g0();
    }

    public boolean m0() {
        if (this.valueTypeCase_ == 1) {
            return ((Boolean) this.valueType_).booleanValue();
        }
        return false;
    }

    public AbstractC1240i n0() {
        return this.valueTypeCase_ == 18 ? (AbstractC1240i) this.valueType_ : AbstractC1240i.f12650b;
    }

    public double p0() {
        if (this.valueTypeCase_ == 3) {
            return ((Double) this.valueType_).doubleValue();
        }
        return 0.0d;
    }

    public C2767a q0() {
        return this.valueTypeCase_ == 8 ? (C2767a) this.valueType_ : C2767a.c0();
    }

    public long r0() {
        if (this.valueTypeCase_ == 2) {
            return ((Long) this.valueType_).longValue();
        }
        return 0L;
    }

    public C2130u s0() {
        return this.valueTypeCase_ == 6 ? (C2130u) this.valueType_ : C2130u.b0();
    }

    public String t0() {
        return this.valueTypeCase_ == 5 ? (String) this.valueType_ : "";
    }

    public String u0() {
        return this.valueTypeCase_ == 17 ? (String) this.valueType_ : "";
    }

    public t0 v0() {
        return this.valueTypeCase_ == 10 ? (t0) this.valueType_ : t0.c0();
    }

    public c w0() {
        return c.b(this.valueTypeCase_);
    }

    public boolean x0() {
        return this.valueTypeCase_ == 11;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18006a[dVar.ordinal()]) {
            case 1:
                return new C2105D();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u000b\u0001\u0000\u0001\u0012\u000b\u0000\u0000\u0000\u0001:\u0000\u00025\u0000\u00033\u0000\u0005Ȼ\u0000\u0006<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b?\u0000\u0011Ȼ\u0000\u0012=\u0000", new Object[]{"valueType_", "valueTypeCase_", C2130u.class, C2767a.class, C2111b.class, t0.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2105D.class) {
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

    public final void z0(C2111b c2111b) {
        c2111b.getClass();
        this.valueType_ = c2111b;
        this.valueTypeCase_ = 9;
    }
}
