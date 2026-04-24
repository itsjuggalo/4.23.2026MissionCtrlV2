package N3;

import com.google.protobuf.AbstractC1480t;

/* JADX INFO: loaded from: classes.dex */
public final class Y0 extends AbstractC1480t implements com.google.protobuf.K {
    private static final Y0 DEFAULT_INSTANCE;
    private static volatile com.google.protobuf.S PARSER = null;
    public static final int START_TIME_EPOCH_FIELD_NUMBER = 2;
    public static final int VALUE_FIELD_NUMBER = 1;
    private long startTimeEpoch_;
    private long value_;

    public static final class a extends AbstractC1480t.a implements com.google.protobuf.K {
        public a() {
            super(Y0.DEFAULT_INSTANCE);
        }

        public a x() {
            r();
            ((Y0) this.f16577b).V();
            return this;
        }

        public a y(long j8) {
            r();
            ((Y0) this.f16577b).b0(j8);
            return this;
        }

        public a z(long j8) {
            r();
            ((Y0) this.f16577b).c0(j8);
            return this;
        }

        public /* synthetic */ a(X0 x02) {
            this();
        }
    }

    static {
        Y0 y02 = new Y0();
        DEFAULT_INSTANCE = y02;
        AbstractC1480t.N(Y0.class, y02);
    }

    public static Y0 W() {
        return DEFAULT_INSTANCE;
    }

    public static a Z() {
        return (a) DEFAULT_INSTANCE.s();
    }

    public static a a0(Y0 y02) {
        return (a) DEFAULT_INSTANCE.t(y02);
    }

    public final void V() {
        this.value_ = 0L;
    }

    public long X() {
        return this.startTimeEpoch_;
    }

    public long Y() {
        return this.value_;
    }

    public final void b0(long j8) {
        this.startTimeEpoch_ = j8;
    }

    public final void c0(long j8) {
        this.value_ = j8;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        X0 x02 = null;
        switch (X0.f5646a[dVar.ordinal()]) {
            case 1:
                return new Y0();
            case 2:
                return new a(x02);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0002", new Object[]{"value_", "startTimeEpoch_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                com.google.protobuf.S bVar = PARSER;
                if (bVar == null) {
                    synchronized (Y0.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1480t.b(DEFAULT_INSTANCE);
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
