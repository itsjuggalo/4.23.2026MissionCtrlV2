package v4;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.W;
import com.google.protobuf.f0;

/* JADX INFO: renamed from: v4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2767a extends AbstractC1255y implements W {
    private static final C2767a DEFAULT_INSTANCE;
    public static final int LATITUDE_FIELD_NUMBER = 1;
    public static final int LONGITUDE_FIELD_NUMBER = 2;
    private static volatile f0 PARSER;
    private double latitude_;
    private double longitude_;

    /* JADX INFO: renamed from: v4.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0387a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24758a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f24758a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24758a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24758a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24758a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f24758a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f24758a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f24758a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: v4.a$b */
    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(C0387a c0387a) {
            this();
        }

        public b w(double d7) {
            q();
            ((C2767a) this.f12868b).g0(d7);
            return this;
        }

        public b x(double d7) {
            q();
            ((C2767a) this.f12868b).h0(d7);
            return this;
        }

        public b() {
            super(C2767a.DEFAULT_INSTANCE);
        }
    }

    static {
        C2767a c2767a = new C2767a();
        DEFAULT_INSTANCE = c2767a;
        AbstractC1255y.V(C2767a.class, c2767a);
    }

    public static C2767a c0() {
        return DEFAULT_INSTANCE;
    }

    public static b f0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    public double d0() {
        return this.latitude_;
    }

    public double e0() {
        return this.longitude_;
    }

    public final void g0(double d7) {
        this.latitude_ = d7;
    }

    public final void h0(double d7) {
        this.longitude_ = d7;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        C0387a c0387a = null;
        switch (C0387a.f24758a[dVar.ordinal()]) {
            case 1:
                return new C2767a();
            case 2:
                return new b(c0387a);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0000\u0002\u0000", new Object[]{"latitude_", "longitude_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2767a.class) {
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
