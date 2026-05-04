package aa;

import com.google.protobuf.a2;
import com.google.protobuf.y;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class y2 extends com.google.protobuf.y implements com.google.protobuf.v0 {
    private static final y2 DEFAULT_INSTANCE;
    public static final int LIMITS_FIELD_NUMBER = 1;
    private static volatile com.google.protobuf.e1 PARSER;
    private com.google.protobuf.o0 limits_ = com.google.protobuf.o0.f();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends y.a implements com.google.protobuf.v0 {
        public /* synthetic */ a(w2 w2Var) {
            this();
        }

        public a x(String str, x2 x2Var) {
            str.getClass();
            x2Var.getClass();
            q();
            ((y2) this.f7244b).d0().put(str, x2Var);
            return this;
        }

        public a() {
            super(y2.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final com.google.protobuf.n0 f601a = com.google.protobuf.n0.d(a2.b.f6909k, "", a2.b.f6911m, x2.e0());
    }

    static {
        y2 y2Var = new y2();
        DEFAULT_INSTANCE = y2Var;
        com.google.protobuf.y.V(y2.class, y2Var);
    }

    public static y2 b0() {
        return DEFAULT_INSTANCE;
    }

    public static a g0(y2 y2Var) {
        return (a) DEFAULT_INSTANCE.v(y2Var);
    }

    public static com.google.protobuf.e1 h0() {
        return DEFAULT_INSTANCE.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x2 c0(String str, x2 x2Var) {
        str.getClass();
        com.google.protobuf.o0 o0VarE0 = e0();
        return o0VarE0.containsKey(str) ? (x2) o0VarE0.get(str) : x2Var;
    }

    public final Map d0() {
        return f0();
    }

    public final com.google.protobuf.o0 e0() {
        return this.limits_;
    }

    public final com.google.protobuf.o0 f0() {
        if (!this.limits_.j()) {
            this.limits_ = this.limits_.m();
        }
        return this.limits_;
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        com.google.protobuf.e1 bVar;
        w2 w2Var = null;
        switch (w2.f598a[dVar.ordinal()]) {
            case 1:
                return new y2();
            case 2:
                return new a(w2Var);
            case 3:
                return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"limits_", b.f601a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                com.google.protobuf.e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (y2.class) {
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
