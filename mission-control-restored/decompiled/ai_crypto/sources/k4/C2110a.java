package k4;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.B0;
import com.google.protobuf.N;
import com.google.protobuf.O;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: k4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2110a extends AbstractC1255y implements W {
    public static final int AGGREGATE_FIELDS_FIELD_NUMBER = 2;
    private static final C2110a DEFAULT_INSTANCE;
    private static volatile f0 PARSER;
    private O aggregateFields_ = O.e();

    /* JADX INFO: renamed from: k4.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0289a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18033a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18033a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18033a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18033a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18033a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18033a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18033a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18033a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.a$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final N f18034a = N.d(B0.b.f12521k, "", B0.b.f12523m, C2105D.o0());
    }

    /* JADX INFO: renamed from: k4.a$c */
    public static final class c extends AbstractC1255y.a implements W {
        public /* synthetic */ c(C0289a c0289a) {
            this();
        }

        public c() {
            super(C2110a.DEFAULT_INSTANCE);
        }
    }

    static {
        C2110a c2110a = new C2110a();
        DEFAULT_INSTANCE = c2110a;
        AbstractC1255y.V(C2110a.class, c2110a);
    }

    public static C2110a b0() {
        return DEFAULT_INSTANCE;
    }

    public Map a0() {
        return Collections.unmodifiableMap(c0());
    }

    public final O c0() {
        return this.aggregateFields_;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        C0289a c0289a = null;
        switch (C0289a.f18033a[dVar.ordinal()]) {
            case 1:
                return new C2110a();
            case 2:
                return new c(c0289a);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0001\u0000\u0000\u00022", new Object[]{"aggregateFields_", b.f18034a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2110a.class) {
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
