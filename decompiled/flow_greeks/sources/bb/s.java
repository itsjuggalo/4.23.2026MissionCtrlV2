package bb;

import com.google.protobuf.a2;
import com.google.protobuf.e1;
import com.google.protobuf.n0;
import com.google.protobuf.o0;
import com.google.protobuf.v0;
import com.google.protobuf.y;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends com.google.protobuf.y implements v0 {
    public static final int ADD_TARGET_FIELD_NUMBER = 2;
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final s DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 4;
    private static volatile e1 PARSER = null;
    public static final int REMOVE_TARGET_FIELD_NUMBER = 3;
    private Object targetChange_;
    private int targetChangeCase_ = 0;
    private o0 labels_ = o0.f();
    private String database_ = "";

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3231a;

        static {
            int[] iArr = new int[y.d.values().length];
            f3231a = iArr;
            try {
                iArr[y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3231a[y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3231a[y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3231a[y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3231a[y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3231a[y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3231a[y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends y.a implements v0 {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b A(int i10) {
            q();
            ((s) this.f7244b).k0(i10);
            return this;
        }

        public b x(Map map) {
            q();
            ((s) this.f7244b).f0().putAll(map);
            return this;
        }

        public b y(a0 a0Var) {
            q();
            ((s) this.f7244b).i0(a0Var);
            return this;
        }

        public b z(String str) {
            q();
            ((s) this.f7244b).j0(str);
            return this;
        }

        public b() {
            super(s.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n0 f3232a;

        static {
            a2.b bVar = a2.b.f6909k;
            f3232a = n0.d(bVar, "", bVar, "");
        }
    }

    static {
        s sVar = new s();
        DEFAULT_INSTANCE = sVar;
        com.google.protobuf.y.V(s.class, sVar);
    }

    public static s e0() {
        return DEFAULT_INSTANCE;
    }

    public static b h0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(String str) {
        str.getClass();
        this.database_ = str;
    }

    public final Map f0() {
        return g0();
    }

    public final o0 g0() {
        if (!this.labels_.j()) {
            this.labels_ = this.labels_.m();
        }
        return this.labels_;
    }

    public final void i0(a0 a0Var) {
        a0Var.getClass();
        this.targetChange_ = a0Var;
        this.targetChangeCase_ = 2;
    }

    public final void k0(int i10) {
        this.targetChangeCase_ = 3;
        this.targetChange_ = Integer.valueOf(i10);
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        a aVar = null;
        switch (a.f3231a[dVar.ordinal()]) {
            case 1:
                return new s();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u0002<\u0000\u00037\u0000\u00042", new Object[]{"targetChange_", "targetChangeCase_", "database_", a0.class, "labels_", c.f3232a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (s.class) {
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
