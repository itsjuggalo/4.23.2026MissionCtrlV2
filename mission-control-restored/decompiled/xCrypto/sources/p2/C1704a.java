package p2;

import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C0;
import com.google.protobuf.O;
import com.google.protobuf.P;
import com.google.protobuf.X;
import com.google.protobuf.g0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: p2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1704a extends AbstractC1077y implements X {
    public static final int AGGREGATE_FIELDS_FIELD_NUMBER = 2;
    private static final C1704a DEFAULT_INSTANCE;
    private static volatile g0 PARSER;
    private P aggregateFields_ = P.e();

    /* JADX INFO: renamed from: p2.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0223a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14034a;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            f14034a = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14034a[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14034a[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14034a[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14034a[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14034a[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14034a[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: p2.a$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final O f14035a = O.d(C0.b.f10899k, "", C0.b.f10901m, C1698D.y());
    }

    /* JADX INFO: renamed from: p2.a$c */
    public static final class c extends AbstractC1077y.a implements X {
        public /* synthetic */ c(C0223a c0223a) {
            this();
        }

        public c() {
            super(C1704a.DEFAULT_INSTANCE);
        }
    }

    static {
        C1704a c1704a = new C1704a();
        DEFAULT_INSTANCE = c1704a;
        AbstractC1077y.registerDefaultInstance(C1704a.class, c1704a);
    }

    public static C1704a l() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        C0223a c0223a = null;
        switch (C0223a.f14034a[eVar.ordinal()]) {
            case 1:
                return new C1704a();
            case 2:
                return new c(c0223a);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0001\u0000\u0000\u00022", new Object[]{"aggregateFields_", b.f14035a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (C1704a.class) {
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

    public Map k() {
        return Collections.unmodifiableMap(m());
    }

    public final P m() {
        return this.aggregateFields_;
    }
}
