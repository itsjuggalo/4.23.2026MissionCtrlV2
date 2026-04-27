package p2;

import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C0;
import com.google.protobuf.O;
import com.google.protobuf.P;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class u extends AbstractC1077y implements X {
    private static final u DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile g0 PARSER;
    private P fields_ = P.e();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14088a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14088a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14088a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14088a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14088a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14088a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14088a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14088a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1077y.a implements X {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public boolean f(String str) {
            str.getClass();
            return ((u) this.instance).n().containsKey(str);
        }

        public b g(Map map) {
            copyOnWrite();
            ((u) this.instance).q().putAll(map);
            return this;
        }

        public b h(String str, C1698D c1698d) {
            str.getClass();
            c1698d.getClass();
            copyOnWrite();
            ((u) this.instance).q().put(str, c1698d);
            return this;
        }

        public b i(String str) {
            str.getClass();
            copyOnWrite();
            ((u) this.instance).q().remove(str);
            return this;
        }

        public b() {
            super(u.DEFAULT_INSTANCE);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final O f14089a = O.d(C0.b.f10899k, "", C0.b.f10901m, C1698D.y());
    }

    static {
        u uVar = new u();
        DEFAULT_INSTANCE = uVar;
        AbstractC1077y.registerDefaultInstance(u.class, uVar);
    }

    public static u l() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map q() {
        return s();
    }

    private P r() {
        return this.fields_;
    }

    private P s() {
        if (!this.fields_.i()) {
            this.fields_ = this.fields_.l();
        }
        return this.fields_;
    }

    public static b t() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        a aVar = null;
        switch (a.f14088a[eVar.ordinal()]) {
            case 1:
                return new u();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"fields_", c.f14089a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (u.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
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

    public int m() {
        return r().size();
    }

    public Map n() {
        return Collections.unmodifiableMap(r());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1698D o(String str, C1698D c1698d) {
        str.getClass();
        P pR = r();
        return pR.containsKey(str) ? (C1698D) pR.get(str) : c1698d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1698D p(String str) {
        str.getClass();
        P pR = r();
        if (pR.containsKey(str)) {
            return (C1698D) pR.get(str);
        }
        throw new IllegalArgumentException();
    }
}
