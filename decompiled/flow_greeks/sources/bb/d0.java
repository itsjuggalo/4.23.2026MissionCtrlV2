package bb;

import bb.b;
import bb.u;
import com.google.protobuf.d1;
import com.google.protobuf.e1;
import com.google.protobuf.s1;
import com.google.protobuf.v0;
import com.google.protobuf.y;
import kb.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends com.google.protobuf.y implements v0 {
    public static final int ARRAY_VALUE_FIELD_NUMBER = 9;
    public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1;
    public static final int BYTES_VALUE_FIELD_NUMBER = 18;
    private static final d0 DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
    public static final int GEO_POINT_VALUE_FIELD_NUMBER = 8;
    public static final int INTEGER_VALUE_FIELD_NUMBER = 2;
    public static final int MAP_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 11;
    private static volatile e1 PARSER = null;
    public static final int REFERENCE_VALUE_FIELD_NUMBER = 5;
    public static final int STRING_VALUE_FIELD_NUMBER = 17;
    public static final int TIMESTAMP_VALUE_FIELD_NUMBER = 10;
    private int valueTypeCase_ = 0;
    private Object valueType_;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3165a;

        static {
            int[] iArr = new int[y.d.values().length];
            f3165a = iArr;
            try {
                iArr[y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3165a[y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3165a[y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3165a[y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3165a[y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3165a[y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3165a[y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends y.a implements v0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b A(boolean z10) {
            q();
            ((d0) this.f7244b).A0(z10);
            return this;
        }

        public b B(com.google.protobuf.i iVar) {
            q();
            ((d0) this.f7244b).B0(iVar);
            return this;
        }

        public b C(double d10) {
            q();
            ((d0) this.f7244b).C0(d10);
            return this;
        }

        public b D(a.b bVar) {
            q();
            ((d0) this.f7244b).D0((kb.a) bVar.n());
            return this;
        }

        public b E(long j10) {
            q();
            ((d0) this.f7244b).E0(j10);
            return this;
        }

        public b F(u.b bVar) {
            q();
            ((d0) this.f7244b).F0((u) bVar.n());
            return this;
        }

        public b G(u uVar) {
            q();
            ((d0) this.f7244b).F0(uVar);
            return this;
        }

        public b H(d1 d1Var) {
            q();
            ((d0) this.f7244b).G0(d1Var);
            return this;
        }

        public b I(String str) {
            q();
            ((d0) this.f7244b).H0(str);
            return this;
        }

        public b J(String str) {
            q();
            ((d0) this.f7244b).I0(str);
            return this;
        }

        public b K(s1.b bVar) {
            q();
            ((d0) this.f7244b).J0((s1) bVar.n());
            return this;
        }

        public u x() {
            return ((d0) this.f7244b).s0();
        }

        public b y(b.C0055b c0055b) {
            q();
            ((d0) this.f7244b).z0((bb.b) c0055b.n());
            return this;
        }

        public b z(bb.b bVar) {
            q();
            ((d0) this.f7244b).z0(bVar);
            return this;
        }

        public b() {
            super(d0.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
        public final int f3179a;

        c(int i10) {
            this.f3179a = i10;
        }

        public static c b(int i10) {
            if (i10 == 0) {
                return VALUETYPE_NOT_SET;
            }
            if (i10 == 1) {
                return BOOLEAN_VALUE;
            }
            if (i10 == 2) {
                return INTEGER_VALUE;
            }
            if (i10 == 3) {
                return DOUBLE_VALUE;
            }
            if (i10 == 5) {
                return REFERENCE_VALUE;
            }
            if (i10 == 6) {
                return MAP_VALUE;
            }
            if (i10 == 17) {
                return STRING_VALUE;
            }
            if (i10 == 18) {
                return BYTES_VALUE;
            }
            switch (i10) {
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
        d0 d0Var = new d0();
        DEFAULT_INSTANCE = d0Var;
        com.google.protobuf.y.V(d0.class, d0Var);
    }

    public static d0 o0() {
        return DEFAULT_INSTANCE;
    }

    public static b y0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public final void A0(boolean z10) {
        this.valueTypeCase_ = 1;
        this.valueType_ = Boolean.valueOf(z10);
    }

    public final void B0(com.google.protobuf.i iVar) {
        iVar.getClass();
        this.valueTypeCase_ = 18;
        this.valueType_ = iVar;
    }

    public final void C0(double d10) {
        this.valueTypeCase_ = 3;
        this.valueType_ = Double.valueOf(d10);
    }

    public final void D0(kb.a aVar) {
        aVar.getClass();
        this.valueType_ = aVar;
        this.valueTypeCase_ = 8;
    }

    public final void E0(long j10) {
        this.valueTypeCase_ = 2;
        this.valueType_ = Long.valueOf(j10);
    }

    public final void F0(u uVar) {
        uVar.getClass();
        this.valueType_ = uVar;
        this.valueTypeCase_ = 6;
    }

    public final void G0(d1 d1Var) {
        this.valueType_ = Integer.valueOf(d1Var.d());
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

    public final void J0(s1 s1Var) {
        s1Var.getClass();
        this.valueType_ = s1Var;
        this.valueTypeCase_ = 10;
    }

    public bb.b l0() {
        return this.valueTypeCase_ == 9 ? (bb.b) this.valueType_ : bb.b.g0();
    }

    public boolean m0() {
        if (this.valueTypeCase_ == 1) {
            return ((Boolean) this.valueType_).booleanValue();
        }
        return false;
    }

    public com.google.protobuf.i n0() {
        return this.valueTypeCase_ == 18 ? (com.google.protobuf.i) this.valueType_ : com.google.protobuf.i.f6998b;
    }

    public double p0() {
        if (this.valueTypeCase_ == 3) {
            return ((Double) this.valueType_).doubleValue();
        }
        return 0.0d;
    }

    public kb.a q0() {
        return this.valueTypeCase_ == 8 ? (kb.a) this.valueType_ : kb.a.c0();
    }

    public long r0() {
        if (this.valueTypeCase_ == 2) {
            return ((Long) this.valueType_).longValue();
        }
        return 0L;
    }

    public u s0() {
        return this.valueTypeCase_ == 6 ? (u) this.valueType_ : u.b0();
    }

    public String t0() {
        return this.valueTypeCase_ == 5 ? (String) this.valueType_ : "";
    }

    public String u0() {
        return this.valueTypeCase_ == 17 ? (String) this.valueType_ : "";
    }

    public s1 v0() {
        return this.valueTypeCase_ == 10 ? (s1) this.valueType_ : s1.c0();
    }

    public c w0() {
        return c.b(this.valueTypeCase_);
    }

    public boolean x0() {
        return this.valueTypeCase_ == 11;
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        a aVar = null;
        switch (a.f3165a[dVar.ordinal()]) {
            case 1:
                return new d0();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u000b\u0001\u0000\u0001\u0012\u000b\u0000\u0000\u0000\u0001:\u0000\u00025\u0000\u00033\u0000\u0005Ȼ\u0000\u0006<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b?\u0000\u0011Ȼ\u0000\u0012=\u0000", new Object[]{"valueType_", "valueTypeCase_", u.class, kb.a.class, bb.b.class, s1.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (d0.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new y.b(DEFAULT_INSTANCE);
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

    public final void z0(bb.b bVar) {
        bVar.getClass();
        this.valueType_ = bVar;
        this.valueTypeCase_ = 9;
    }
}
