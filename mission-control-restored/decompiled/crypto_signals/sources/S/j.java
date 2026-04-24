package S;

import androidx.datastore.preferences.protobuf.AbstractC0337t;
import androidx.datastore.preferences.protobuf.AbstractC0339v;
import androidx.datastore.preferences.protobuf.C0325g;
import androidx.datastore.preferences.protobuf.C0338u;
import androidx.datastore.preferences.protobuf.Q;
import androidx.datastore.preferences.protobuf.U;

/* JADX INFO: loaded from: classes.dex */
public final class j extends AbstractC0339v {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    public static final int BYTES_FIELD_NUMBER = 8;
    private static final j DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile Q PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int valueCase_ = 0;
    private Object value_;

    static {
        j jVar = new j();
        DEFAULT_INSTANCE = jVar;
        AbstractC0339v.j(j.class, jVar);
    }

    public static h D() {
        return (h) ((AbstractC0337t) DEFAULT_INSTANCE.c(5));
    }

    public static void l(j jVar, long j4) {
        jVar.valueCase_ = 4;
        jVar.value_ = Long.valueOf(j4);
    }

    public static void m(j jVar, String str) {
        jVar.getClass();
        str.getClass();
        jVar.valueCase_ = 5;
        jVar.value_ = str;
    }

    public static void n(j jVar, g gVar) {
        jVar.getClass();
        jVar.value_ = gVar;
        jVar.valueCase_ = 6;
    }

    public static void o(j jVar, double d4) {
        jVar.valueCase_ = 7;
        jVar.value_ = Double.valueOf(d4);
    }

    public static void p(j jVar, C0325g c0325g) {
        jVar.getClass();
        jVar.valueCase_ = 8;
        jVar.value_ = c0325g;
    }

    public static void q(j jVar, boolean z6) {
        jVar.valueCase_ = 1;
        jVar.value_ = Boolean.valueOf(z6);
    }

    public static void r(j jVar, float f6) {
        jVar.valueCase_ = 2;
        jVar.value_ = Float.valueOf(f6);
    }

    public static void s(j jVar, int i) {
        jVar.valueCase_ = 3;
        jVar.value_ = Integer.valueOf(i);
    }

    public static j v() {
        return DEFAULT_INSTANCE;
    }

    public final String A() {
        return this.valueCase_ == 5 ? (String) this.value_ : "";
    }

    public final g B() {
        return this.valueCase_ == 6 ? (g) this.value_ : g.m();
    }

    public final int C() {
        switch (this.valueCase_) {
            case 0:
                return 9;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            default:
                return 0;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0339v
    public final Object c(int i) {
        Q c0338u;
        switch (i.c(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new U(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", g.class});
            case 3:
                return new j();
            case 4:
                return new h(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Q q6 = PARSER;
                if (q6 != null) {
                    return q6;
                }
                synchronized (j.class) {
                    try {
                        c0338u = PARSER;
                        if (c0338u == null) {
                            c0338u = new C0338u();
                            PARSER = c0338u;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return c0338u;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final boolean t() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public final C0325g u() {
        return this.valueCase_ == 8 ? (C0325g) this.value_ : C0325g.f4550c;
    }

    public final double w() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public final float x() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public final int y() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public final long z() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }
}
