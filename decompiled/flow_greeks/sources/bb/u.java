package bb;

import com.google.protobuf.a2;
import com.google.protobuf.e1;
import com.google.protobuf.n0;
import com.google.protobuf.o0;
import com.google.protobuf.v0;
import com.google.protobuf.y;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends com.google.protobuf.y implements v0 {
    private static final u DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile e1 PARSER;
    private o0 fields_ = o0.f();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3242a;

        static {
            int[] iArr = new int[y.d.values().length];
            f3242a = iArr;
            try {
                iArr[y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3242a[y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3242a[y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3242a[y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3242a[y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3242a[y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3242a[y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends y.a implements v0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b A(String str) {
            str.getClass();
            q();
            ((u) this.f7244b).g0().remove(str);
            return this;
        }

        public boolean x(String str) {
            str.getClass();
            return ((u) this.f7244b).d0().containsKey(str);
        }

        public b y(Map map) {
            q();
            ((u) this.f7244b).g0().putAll(map);
            return this;
        }

        public b z(String str, d0 d0Var) {
            str.getClass();
            d0Var.getClass();
            q();
            ((u) this.f7244b).g0().put(str, d0Var);
            return this;
        }

        public b() {
            super(u.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n0 f3243a = n0.d(a2.b.f6909k, "", a2.b.f6911m, d0.o0());
    }

    static {
        u uVar = new u();
        DEFAULT_INSTANCE = uVar;
        com.google.protobuf.y.V(u.class, uVar);
    }

    public static u b0() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map g0() {
        return i0();
    }

    private o0 h0() {
        return this.fields_;
    }

    private o0 i0() {
        if (!this.fields_.j()) {
            this.fields_ = this.fields_.m();
        }
        return this.fields_;
    }

    public static b j0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public int c0() {
        return h0().size();
    }

    public Map d0() {
        return Collections.unmodifiableMap(h0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0 e0(String str, d0 d0Var) {
        str.getClass();
        o0 o0VarH0 = h0();
        return o0VarH0.containsKey(str) ? (d0) o0VarH0.get(str) : d0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0 f0(String str) {
        str.getClass();
        o0 o0VarH0 = h0();
        if (o0VarH0.containsKey(str)) {
            return (d0) o0VarH0.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        a aVar = null;
        switch (a.f3242a[dVar.ordinal()]) {
            case 1:
                return new u();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"fields_", c.f3243a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (u.class) {
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
