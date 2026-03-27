package f0;

import androidx.datastore.preferences.protobuf.AbstractC0935f;
import androidx.datastore.preferences.protobuf.AbstractC0948t;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.S;
import f0.C1548g;

/* JADX INFO: loaded from: classes.dex */
public final class h extends AbstractC0948t implements K {
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

    public static final class a extends AbstractC0948t.a implements K {
        public /* synthetic */ a(AbstractC1546e abstractC1546e) {
            this();
        }

        public a q(boolean z7) {
            l();
            ((h) this.f7605b).i0(z7);
            return this;
        }

        public a r(AbstractC0935f abstractC0935f) {
            l();
            ((h) this.f7605b).j0(abstractC0935f);
            return this;
        }

        public a s(double d7) {
            l();
            ((h) this.f7605b).k0(d7);
            return this;
        }

        public a t(float f7) {
            l();
            ((h) this.f7605b).l0(f7);
            return this;
        }

        public a u(int i7) {
            l();
            ((h) this.f7605b).m0(i7);
            return this;
        }

        public a v(long j7) {
            l();
            ((h) this.f7605b).n0(j7);
            return this;
        }

        public a w(String str) {
            l();
            ((h) this.f7605b).o0(str);
            return this;
        }

        public a x(C1548g.a aVar) {
            l();
            ((h) this.f7605b).p0((C1548g) aVar.i());
            return this;
        }

        public a() {
            super(h.DEFAULT_INSTANCE);
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
        public final int f14047a;

        b(int i7) {
            this.f14047a = i7;
        }

        public static b b(int i7) {
            switch (i7) {
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
        AbstractC0948t.L(h.class, hVar);
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

    public AbstractC0935f Y() {
        return this.valueCase_ == 8 ? (AbstractC0935f) this.value_ : AbstractC0935f.f7402b;
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

    public C1548g f0() {
        return this.valueCase_ == 6 ? (C1548g) this.value_ : C1548g.S();
    }

    public b g0() {
        return b.b(this.valueCase_);
    }

    public final void i0(boolean z7) {
        this.valueCase_ = 1;
        this.value_ = Boolean.valueOf(z7);
    }

    public final void j0(AbstractC0935f abstractC0935f) {
        abstractC0935f.getClass();
        this.valueCase_ = 8;
        this.value_ = abstractC0935f;
    }

    public final void k0(double d7) {
        this.valueCase_ = 7;
        this.value_ = Double.valueOf(d7);
    }

    public final void l0(float f7) {
        this.valueCase_ = 2;
        this.value_ = Float.valueOf(f7);
    }

    public final void m0(int i7) {
        this.valueCase_ = 3;
        this.value_ = Integer.valueOf(i7);
    }

    public final void n0(long j7) {
        this.valueCase_ = 4;
        this.value_ = Long.valueOf(j7);
    }

    public final void o0(String str) {
        str.getClass();
        this.valueCase_ = 5;
        this.value_ = str;
    }

    public final void p0(C1548g c1548g) {
        c1548g.getClass();
        this.value_ = c1548g;
        this.valueCase_ = 6;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0948t
    public final Object s(AbstractC0948t.d dVar, Object obj, Object obj2) {
        AbstractC1546e abstractC1546e = null;
        switch (AbstractC1546e.f14035a[dVar.ordinal()]) {
            case 1:
                return new h();
            case 2:
                return new a(abstractC1546e);
            case 3:
                return AbstractC0948t.H(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", C1548g.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (h.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC0948t.b(DEFAULT_INSTANCE);
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
