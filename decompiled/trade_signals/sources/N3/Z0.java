package N3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.l0;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class Z0 extends AbstractC1480t implements com.google.protobuf.K {
    private static final Z0 DEFAULT_INSTANCE;
    public static final int LIMITS_FIELD_NUMBER = 1;
    private static volatile com.google.protobuf.S PARSER;
    private com.google.protobuf.D limits_ = com.google.protobuf.D.e();

    public static final class a extends AbstractC1480t.a implements com.google.protobuf.K {
        public a() {
            super(Z0.DEFAULT_INSTANCE);
        }

        public a x(String str, Y0 y02) {
            str.getClass();
            y02.getClass();
            r();
            ((Z0) this.f16577b).V().put(str, y02);
            return this;
        }

        public /* synthetic */ a(X0 x02) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final com.google.protobuf.C f5647a = com.google.protobuf.C.d(l0.b.f16467k, "", l0.b.f16469m, Y0.W());
    }

    static {
        Z0 z02 = new Z0();
        DEFAULT_INSTANCE = z02;
        AbstractC1480t.N(Z0.class, z02);
    }

    public static Z0 T() {
        return DEFAULT_INSTANCE;
    }

    public static a Y(Z0 z02) {
        return (a) DEFAULT_INSTANCE.t(z02);
    }

    public static com.google.protobuf.S Z() {
        return DEFAULT_INSTANCE.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Y0 U(String str, Y0 y02) {
        str.getClass();
        com.google.protobuf.D dW = W();
        return dW.containsKey(str) ? (Y0) dW.get(str) : y02;
    }

    public final Map V() {
        return X();
    }

    public final com.google.protobuf.D W() {
        return this.limits_;
    }

    public final com.google.protobuf.D X() {
        if (!this.limits_.j()) {
            this.limits_ = this.limits_.m();
        }
        return this.limits_;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        X0 x02 = null;
        switch (X0.f5646a[dVar.ordinal()]) {
            case 1:
                return new Z0();
            case 2:
                return new a(x02);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"limits_", b.f5647a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                com.google.protobuf.S bVar = PARSER;
                if (bVar == null) {
                    synchronized (Z0.class) {
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
