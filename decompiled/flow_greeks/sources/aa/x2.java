package aa;

import com.google.protobuf.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x2 extends com.google.protobuf.y implements com.google.protobuf.v0 {
    private static final x2 DEFAULT_INSTANCE;
    private static volatile com.google.protobuf.e1 PARSER = null;
    public static final int START_TIME_EPOCH_FIELD_NUMBER = 2;
    public static final int VALUE_FIELD_NUMBER = 1;
    private long startTimeEpoch_;
    private long value_;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends y.a implements com.google.protobuf.v0 {
        public /* synthetic */ a(w2 w2Var) {
            this();
        }

        public a x() {
            q();
            ((x2) this.f7244b).d0();
            return this;
        }

        public a y(long j10) {
            q();
            ((x2) this.f7244b).j0(j10);
            return this;
        }

        public a z(long j10) {
            q();
            ((x2) this.f7244b).k0(j10);
            return this;
        }

        public a() {
            super(x2.DEFAULT_INSTANCE);
        }
    }

    static {
        x2 x2Var = new x2();
        DEFAULT_INSTANCE = x2Var;
        com.google.protobuf.y.V(x2.class, x2Var);
    }

    public static x2 e0() {
        return DEFAULT_INSTANCE;
    }

    public static a h0() {
        return (a) DEFAULT_INSTANCE.u();
    }

    public static a i0(x2 x2Var) {
        return (a) DEFAULT_INSTANCE.v(x2Var);
    }

    public final void d0() {
        this.value_ = 0L;
    }

    public long f0() {
        return this.startTimeEpoch_;
    }

    public long g0() {
        return this.value_;
    }

    public final void j0(long j10) {
        this.startTimeEpoch_ = j10;
    }

    public final void k0(long j10) {
        this.value_ = j10;
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        com.google.protobuf.e1 bVar;
        w2 w2Var = null;
        switch (w2.f598a[dVar.ordinal()]) {
            case 1:
                return new x2();
            case 2:
                return new a(w2Var);
            case 3:
                return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0002", new Object[]{"value_", "startTimeEpoch_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                com.google.protobuf.e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (x2.class) {
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
}
