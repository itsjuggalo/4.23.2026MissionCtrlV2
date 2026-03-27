package U;

import U.g;
import androidx.datastore.preferences.protobuf.AbstractC0793f;
import androidx.datastore.preferences.protobuf.AbstractC0806t;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class h extends AbstractC0806t implements K {
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

    public static final class a extends AbstractC0806t.a implements K {
        public /* synthetic */ a(e eVar) {
            this();
        }

        public a m(boolean z4) {
            h();
            ((h) this.f7197b).e0(z4);
            return this;
        }

        public a n(AbstractC0793f abstractC0793f) {
            h();
            ((h) this.f7197b).f0(abstractC0793f);
            return this;
        }

        public a o(double d4) {
            h();
            ((h) this.f7197b).g0(d4);
            return this;
        }

        public a p(float f4) {
            h();
            ((h) this.f7197b).h0(f4);
            return this;
        }

        public a q(int i4) {
            h();
            ((h) this.f7197b).i0(i4);
            return this;
        }

        public a r(long j4) {
            h();
            ((h) this.f7197b).j0(j4);
            return this;
        }

        public a s(String str) {
            h();
            ((h) this.f7197b).k0(str);
            return this;
        }

        public a t(g.a aVar) {
            h();
            ((h) this.f7197b).l0((g) aVar.e());
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
        public final int f5247a;

        b(int i4) {
            this.f5247a = i4;
        }

        public static b c(int i4) {
            switch (i4) {
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
        AbstractC0806t.H(h.class, hVar);
    }

    public static h V() {
        return DEFAULT_INSTANCE;
    }

    public static a d0() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public boolean T() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public AbstractC0793f U() {
        return this.valueCase_ == 8 ? (AbstractC0793f) this.value_ : AbstractC0793f.f6994b;
    }

    public double W() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public float X() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public int Y() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public long Z() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public String a0() {
        return this.valueCase_ == 5 ? (String) this.value_ : "";
    }

    public g b0() {
        return this.valueCase_ == 6 ? (g) this.value_ : g.O();
    }

    public b c0() {
        return b.c(this.valueCase_);
    }

    public final void e0(boolean z4) {
        this.valueCase_ = 1;
        this.value_ = Boolean.valueOf(z4);
    }

    public final void f0(AbstractC0793f abstractC0793f) {
        abstractC0793f.getClass();
        this.valueCase_ = 8;
        this.value_ = abstractC0793f;
    }

    public final void g0(double d4) {
        this.valueCase_ = 7;
        this.value_ = Double.valueOf(d4);
    }

    public final void h0(float f4) {
        this.valueCase_ = 2;
        this.value_ = Float.valueOf(f4);
    }

    public final void i0(int i4) {
        this.valueCase_ = 3;
        this.value_ = Integer.valueOf(i4);
    }

    public final void j0(long j4) {
        this.valueCase_ = 4;
        this.value_ = Long.valueOf(j4);
    }

    public final void k0(String str) {
        str.getClass();
        this.valueCase_ = 5;
        this.value_ = str;
    }

    public final void l0(g gVar) {
        gVar.getClass();
        this.value_ = gVar;
        this.valueCase_ = 6;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0806t
    public final Object o(AbstractC0806t.d dVar, Object obj, Object obj2) {
        S bVar;
        e eVar = null;
        switch (e.f5235a[dVar.ordinal()]) {
            case 1:
                return new h();
            case 2:
                return new a(eVar);
            case 3:
                return AbstractC0806t.D(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", g.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S s4 = PARSER;
                if (s4 != null) {
                    return s4;
                }
                synchronized (h.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new AbstractC0806t.b(DEFAULT_INSTANCE);
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
}
