package s3;

import com.google.protobuf.AbstractC0472l;
import com.google.protobuf.C0483q0;
import com.google.protobuf.EnumC0473l0;
import com.google.protobuf.InterfaceC0475m0;

/* JADX INFO: loaded from: classes.dex */
public final class I0 extends com.google.protobuf.E {
    public static final int ARRAY_VALUE_FIELD_NUMBER = 9;
    public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1;
    public static final int BYTES_VALUE_FIELD_NUMBER = 18;
    private static final I0 DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
    public static final int GEO_POINT_VALUE_FIELD_NUMBER = 8;
    public static final int INTEGER_VALUE_FIELD_NUMBER = 2;
    public static final int MAP_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 11;
    private static volatile InterfaceC0475m0 PARSER = null;
    public static final int REFERENCE_VALUE_FIELD_NUMBER = 5;
    public static final int STRING_VALUE_FIELD_NUMBER = 17;
    public static final int TIMESTAMP_VALUE_FIELD_NUMBER = 10;
    private int valueTypeCase_ = 0;
    private Object valueType_;

    static {
        I0 i02 = new I0();
        DEFAULT_INSTANCE = i02;
        com.google.protobuf.E.r(I0.class, i02);
    }

    public static void A(I0 i02) {
        EnumC0473l0 enumC0473l0 = EnumC0473l0.NULL_VALUE;
        i02.getClass();
        i02.valueType_ = Integer.valueOf(enumC0473l0.a());
        i02.valueTypeCase_ = 11;
    }

    public static void B(I0 i02, boolean z6) {
        i02.valueTypeCase_ = 1;
        i02.valueType_ = Boolean.valueOf(z6);
    }

    public static void C(I0 i02, long j4) {
        i02.valueTypeCase_ = 2;
        i02.valueType_ = Long.valueOf(j4);
    }

    public static void D(I0 i02, double d4) {
        i02.valueTypeCase_ = 3;
        i02.valueType_ = Double.valueOf(d4);
    }

    public static I0 H() {
        return DEFAULT_INSTANCE;
    }

    public static H0 R() {
        return (H0) DEFAULT_INSTANCE.g();
    }

    public static void t(I0 i02, com.google.protobuf.B0 b02) {
        i02.getClass();
        i02.valueType_ = b02;
        i02.valueTypeCase_ = 10;
    }

    public static void u(String str, I0 i02) {
        i02.getClass();
        str.getClass();
        i02.valueTypeCase_ = 17;
        i02.valueType_ = str;
    }

    public static void v(I0 i02, AbstractC0472l abstractC0472l) {
        i02.getClass();
        abstractC0472l.getClass();
        i02.valueTypeCase_ = 18;
        i02.valueType_ = abstractC0472l;
    }

    public static void w(String str, I0 i02) {
        i02.getClass();
        str.getClass();
        i02.valueTypeCase_ = 5;
        i02.valueType_ = str;
    }

    public static void x(I0 i02, D3.b bVar) {
        i02.getClass();
        i02.valueType_ = bVar;
        i02.valueTypeCase_ = 8;
    }

    public static void y(C1016d c1016d, I0 i02) {
        i02.getClass();
        c1016d.getClass();
        i02.valueType_ = c1016d;
        i02.valueTypeCase_ = 9;
    }

    public static void z(I0 i02, K k6) {
        i02.getClass();
        k6.getClass();
        i02.valueType_ = k6;
        i02.valueTypeCase_ = 6;
    }

    public final C1016d E() {
        return this.valueTypeCase_ == 9 ? (C1016d) this.valueType_ : C1016d.w();
    }

    public final boolean F() {
        if (this.valueTypeCase_ == 1) {
            return ((Boolean) this.valueType_).booleanValue();
        }
        return false;
    }

    public final AbstractC0472l G() {
        return this.valueTypeCase_ == 18 ? (AbstractC0472l) this.valueType_ : AbstractC0472l.f5744b;
    }

    public final double I() {
        if (this.valueTypeCase_ == 3) {
            return ((Double) this.valueType_).doubleValue();
        }
        return 0.0d;
    }

    public final D3.b J() {
        return this.valueTypeCase_ == 8 ? (D3.b) this.valueType_ : D3.b.v();
    }

    public final long K() {
        if (this.valueTypeCase_ == 2) {
            return ((Long) this.valueType_).longValue();
        }
        return 0L;
    }

    public final K L() {
        return this.valueTypeCase_ == 6 ? (K) this.valueType_ : K.u();
    }

    public final String M() {
        return this.valueTypeCase_ == 5 ? (String) this.valueType_ : "";
    }

    public final String N() {
        return this.valueTypeCase_ == 17 ? (String) this.valueType_ : "";
    }

    public final com.google.protobuf.B0 O() {
        return this.valueTypeCase_ == 10 ? (com.google.protobuf.B0) this.valueType_ : com.google.protobuf.B0.v();
    }

    public final int P() {
        int i = this.valueTypeCase_;
        if (i == 0) {
            return 12;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 5) {
            return 8;
        }
        if (i == 6) {
            return 11;
        }
        if (i == 17) {
            return 6;
        }
        if (i == 18) {
            return 7;
        }
        switch (i) {
            case 8:
                return 9;
            case ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return 10;
            case TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return 5;
            case 11:
                return 1;
            default:
                return 0;
        }
    }

    public final boolean Q() {
        return this.valueTypeCase_ == 11;
    }

    @Override // com.google.protobuf.E
    public final Object h(int i) {
        InterfaceC0475m0 d4;
        switch (S.i.c(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new C0483q0(DEFAULT_INSTANCE, "\u0000\u000b\u0001\u0000\u0001\u0012\u000b\u0000\u0000\u0000\u0001:\u0000\u00025\u0000\u00033\u0000\u0005Ȼ\u0000\u0006<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b?\u0000\u0011Ȼ\u0000\u0012=\u0000", new Object[]{"valueType_", "valueTypeCase_", K.class, D3.b.class, C1016d.class, com.google.protobuf.B0.class});
            case 3:
                return new I0();
            case 4:
                return new H0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0475m0 interfaceC0475m0 = PARSER;
                if (interfaceC0475m0 != null) {
                    return interfaceC0475m0;
                }
                synchronized (I0.class) {
                    try {
                        d4 = PARSER;
                        if (d4 == null) {
                            d4 = new com.google.protobuf.D(DEFAULT_INSTANCE);
                            PARSER = d4;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return d4;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
