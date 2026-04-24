package I3;

import com.google.protobuf.AbstractC1255y;
import com.google.protobuf.W;
import com.google.protobuf.f0;
import com.google.protobuf.t0;

/* JADX INFO: loaded from: classes.dex */
public final class d extends AbstractC1255y implements W {
    private static final d DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile f0 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private int bitField0_;
    private String name_ = "";
    private t0 version_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3029a;

        static {
            int[] iArr = new int[AbstractC1255y.d.values().length];
            f3029a = iArr;
            try {
                iArr[AbstractC1255y.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3029a[AbstractC1255y.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3029a[AbstractC1255y.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3029a[AbstractC1255y.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3029a[AbstractC1255y.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3029a[AbstractC1255y.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3029a[AbstractC1255y.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1255y.a implements W {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b w(String str) {
            q();
            ((d) this.f12868b).g0(str);
            return this;
        }

        public b x(t0 t0Var) {
            q();
            ((d) this.f12868b).h0(t0Var);
            return this;
        }

        public b() {
            super(d.DEFAULT_INSTANCE);
        }
    }

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        AbstractC1255y.V(d.class, dVar);
    }

    public static d c0() {
        return DEFAULT_INSTANCE;
    }

    public static b f0() {
        return (b) DEFAULT_INSTANCE.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(String str) {
        str.getClass();
        this.name_ = str;
    }

    public String d0() {
        return this.name_;
    }

    public t0 e0() {
        t0 t0Var = this.version_;
        return t0Var == null ? t0.c0() : t0Var;
    }

    public final void h0(t0 t0Var) {
        t0Var.getClass();
        this.version_ = t0Var;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.AbstractC1255y
    public final Object y(AbstractC1255y.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f3029a[dVar.ordinal()]) {
            case 1:
                return new d();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1255y.N(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "name_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                f0 bVar = PARSER;
                if (bVar == null) {
                    synchronized (d.class) {
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
