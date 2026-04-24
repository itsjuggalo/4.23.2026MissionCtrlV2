package f0;

import androidx.datastore.preferences.protobuf.AbstractC1104f;
import androidx.datastore.preferences.protobuf.AbstractC1117t;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.S;
import f0.g;

/* JADX INFO: loaded from: classes.dex */
public final class h extends AbstractC1117t implements K {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    public static final int BYTES_FIELD_NUMBER = 8;
    private static final h DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile S PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int valueCase_ = 0;
    private Object value_;

    public static final class a extends AbstractC1117t.a implements K {
        public a() {
            super(h.DEFAULT_INSTANCE);
        }

        public a s(boolean z7) {
            m();
            ((h) this.f11417b).i0(z7);
            return this;
        }

        public a t(AbstractC1104f abstractC1104f) {
            m();
            ((h) this.f11417b).j0(abstractC1104f);
            return this;
        }

        public a u(double d8) {
            m();
            ((h) this.f11417b).k0(d8);
            return this;
        }

        public a v(float f8) {
            m();
            ((h) this.f11417b).l0(f8);
            return this;
        }

        public a w(int i8) {
            m();
            ((h) this.f11417b).m0(i8);
            return this;
        }

        public a x(long j8) {
            m();
            ((h) this.f11417b).n0(j8);
            return this;
        }

        public a y(String str) {
            m();
            ((h) this.f11417b).o0(str);
            return this;
        }

        public a z(g.a aVar) {
            m();
            ((h) this.f11417b).p0((g) aVar.j());
            return this;
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public enum b {
        BOOLEAN(1),
        FLOAT(2),
        INTEGER(3),
        LONG(4),
        STRING(5),
        STRING_SET(6),
        DOUBLE(7),
        BYTES(8),
        VALUE_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17368a;

        b(int i8) {
            this.f17368a = i8;
        }

        public static b b(int i8) {
            switch (i8) {
                case 0:
                    return VALUE_NOT_SET;
                case 1:
                    return BOOLEAN;
                case 2:
                    return FLOAT;
                case 3:
                    return INTEGER;
                case 4:
                    return LONG;
                case 5:
                    return STRING;
                case 6:
                    return STRING_SET;
                case 7:
                    return DOUBLE;
                case 8:
                    return BYTES;
                default:
                    return null;
            }
        }
    }

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        AbstractC1117t.L(h.class, hVar);
    }

    public static h Z() {
        return DEFAULT_INSTANCE;
    }

    public static a h0() {
        return (a) DEFAULT_INSTANCE.p();
    }

    public boolean X() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public AbstractC1104f Y() {
        return this.valueCase_ == 8 ? (AbstractC1104f) this.value_ : AbstractC1104f.f11214b;
    }

    public double a0() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public float b0() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public int c0() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public long d0() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public String e0() {
        return this.valueCase_ == 5 ? (String) this.value_ : "";
    }

    public g f0() {
        return this.valueCase_ == 6 ? (g) this.value_ : g.S();
    }

    public b g0() {
        return b.b(this.valueCase_);
    }

    public final void i0(boolean z7) {
        this.valueCase_ = 1;
        this.value_ = Boolean.valueOf(z7);
    }

    public final void j0(AbstractC1104f abstractC1104f) {
        abstractC1104f.getClass();
        this.valueCase_ = 8;
        this.value_ = abstractC1104f;
    }

    public final void k0(double d8) {
        this.valueCase_ = 7;
        this.value_ = Double.valueOf(d8);
    }

    public final void l0(float f8) {
        this.valueCase_ = 2;
        this.value_ = Float.valueOf(f8);
    }

    public final void m0(int i8) {
        this.valueCase_ = 3;
        this.value_ = Integer.valueOf(i8);
    }

    public final void n0(long j8) {
        this.valueCase_ = 4;
        this.value_ = Long.valueOf(j8);
    }

    public final void o0(String str) {
        str.getClass();
        this.valueCase_ = 5;
        this.value_ = str;
    }

    public final void p0(g gVar) {
        gVar.getClass();
        this.value_ = gVar;
        this.valueCase_ = 6;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1117t
    public final Object s(AbstractC1117t.d dVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.f17356a[dVar.ordinal()]) {
            case 1:
                return new h();
            case 2:
                return new a(eVar);
            case 3:
                return AbstractC1117t.H(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", g.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (h.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1117t.b(DEFAULT_INSTANCE);
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
