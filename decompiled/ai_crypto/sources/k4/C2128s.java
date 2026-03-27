package k4;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.B0;
import com.google.protobuf.N;
import com.google.protobuf.O;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import java.util.Map;

/* JADX INFO: renamed from: k4.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2128s extends AbstractC1255y implements W {
    public static final int ADD_TARGET_FIELD_NUMBER = 2;
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final C2128s DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 4;
    private static volatile f0 PARSER = null;
    public static final int REMOVE_TARGET_FIELD_NUMBER = 3;
    private Object targetChange_;
    private int targetChangeCase_ = 0;
    private O labels_ = O.e();
    private String database_ = "";

    /* JADX INFO: renamed from: k4.s$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18076a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18076a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18076a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18076a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18076a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18076a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18076a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18076a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.s$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b w(Map map) {
            q();
            ((C2128s) this.f12868b).f0().putAll(map);
            return this;
        }

        public b x(C2102A c2102a) {
            q();
            ((C2128s) this.f12868b).i0(c2102a);
            return this;
        }

        public b y(String str) {
            q();
            ((C2128s) this.f12868b).j0(str);
            return this;
        }

        public b z(int i7) {
            q();
            ((C2128s) this.f12868b).k0(i7);
            return this;
        }

        public b() {
            super(C2128s.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: k4.s$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final N f18077a;

        static {
            B0.b bVar = B0.b.f12521k;
            f18077a = N.d(bVar, "", bVar, "");
        }
    }

    static {
        C2128s c2128s = new C2128s();
        DEFAULT_INSTANCE = c2128s;
        AbstractC1255y.V(C2128s.class, c2128s);
    }

    public static C2128s e0() {
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

    public final O g0() {
        if (!this.labels_.j()) {
            this.labels_ = this.labels_.m();
        }
        return this.labels_;
    }

    public final void i0(C2102A c2102a) {
        c2102a.getClass();
        this.targetChange_ = c2102a;
        this.targetChangeCase_ = 2;
    }

    public final void k0(int i7) {
        this.targetChangeCase_ = 3;
        this.targetChange_ = Integer.valueOf(i7);
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18076a[dVar.ordinal()]) {
            case 1:
                return new C2128s();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u0002<\u0000\u00037\u0000\u00042", new Object[]{"targetChange_", "targetChangeCase_", "database_", C2102A.class, "labels_", c.f18077a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2128s.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1255y.b(DEFAULT_INSTANCE);
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
