package k4;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.B0;
import com.google.protobuf.N;
import com.google.protobuf.O;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: k4.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2130u extends AbstractC1255y implements W {
    private static final C2130u DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile f0 PARSER;
    private O fields_ = O.e();

    /* JADX INFO: renamed from: k4.u$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18087a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18087a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18087a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18087a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18087a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18087a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18087a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18087a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.u$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public boolean w(String str) {
            str.getClass();
            return ((C2130u) this.f12868b).d0().containsKey(str);
        }

        public b x(Map map) {
            q();
            ((C2130u) this.f12868b).g0().putAll(map);
            return this;
        }

        public b y(String str, C2105D c2105d) {
            str.getClass();
            c2105d.getClass();
            q();
            ((C2130u) this.f12868b).g0().put(str, c2105d);
            return this;
        }

        public b z(String str) {
            str.getClass();
            q();
            ((C2130u) this.f12868b).g0().remove(str);
            return this;
        }

        public b() {
            super(C2130u.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: renamed from: k4.u$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final N f18088a = N.d(B0.b.f12521k, "", B0.b.f12523m, C2105D.o0());
    }

    static {
        C2130u c2130u = new C2130u();
        DEFAULT_INSTANCE = c2130u;
        AbstractC1255y.V(C2130u.class, c2130u);
    }

    public static C2130u b0() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map g0() {
        return i0();
    }

    private O h0() {
        return this.fields_;
    }

    private O i0() {
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
    public C2105D e0(String str, C2105D c2105d) {
        str.getClass();
        O oH0 = h0();
        return oH0.containsKey(str) ? (C2105D) oH0.get(str) : c2105d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C2105D f0(String str) {
        str.getClass();
        O oH0 = h0();
        if (oH0.containsKey(str)) {
            return (C2105D) oH0.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18087a[dVar.ordinal()]) {
            case 1:
                return new C2130u();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"fields_", c.f18088a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2130u.class) {
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
