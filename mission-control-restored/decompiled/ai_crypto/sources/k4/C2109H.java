package k4;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.C;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import com.google.protobuf.t0;

/* JADX INFO: renamed from: k4.H, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2109H extends AbstractC1255y implements W {
    private static final C2109H DEFAULT_INSTANCE;
    private static volatile f0 PARSER = null;
    public static final int TRANSFORM_RESULTS_FIELD_NUMBER = 2;
    public static final int UPDATE_TIME_FIELD_NUMBER = 1;
    private int bitField0_;
    private C.e transformResults_ = AbstractC1255y.A();
    private t0 updateTime_;

    /* JADX INFO: renamed from: k4.H$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18032a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f18032a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18032a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18032a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18032a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18032a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18032a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18032a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: k4.H$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            super(C2109H.DEFAULT_INSTANCE);
        }
    }

    static {
        C2109H c2109h = new C2109H();
        DEFAULT_INSTANCE = c2109h;
        AbstractC1255y.V(C2109H.class, c2109h);
    }

    public C2105D a0(int i7) {
        return (C2105D) this.transformResults_.get(i7);
    }

    public int b0() {
        return this.transformResults_.size();
    }

    public t0 c0() {
        t0 t0Var = this.updateTime_;
        return t0Var == null ? t0.c0() : t0Var;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18032a[dVar.ordinal()]) {
            case 1:
                return new C2109H();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "updateTime_", "transformResults_", C2105D.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2109H.class) {
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
