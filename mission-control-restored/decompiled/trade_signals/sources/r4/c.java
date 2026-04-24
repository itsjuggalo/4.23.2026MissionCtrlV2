package r4;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class c extends AbstractC1480t implements K {
    public static final int APP_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int APP_INSTANCE_ID_TOKEN_FIELD_NUMBER = 3;
    private static final c DEFAULT_INSTANCE;
    public static final int GMP_APP_ID_FIELD_NUMBER = 1;
    private static volatile S PARSER;
    private String gmpAppId_ = "";
    private String appInstanceId_ = "";
    private String appInstanceIdToken_ = "";

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22916a;

        static {
            int[] iArr = new int[AbstractC1480t.d.values().length];
            f22916a = iArr;
            try {
                iArr[AbstractC1480t.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22916a[AbstractC1480t.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22916a[AbstractC1480t.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22916a[AbstractC1480t.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22916a[AbstractC1480t.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f22916a[AbstractC1480t.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f22916a[AbstractC1480t.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1480t.a implements K {
        public b() {
            super(c.DEFAULT_INSTANCE);
        }

        public b x(String str) {
            r();
            ((c) this.f16577b).W(str);
            return this;
        }

        public b y(String str) {
            r();
            ((c) this.f16577b).X(str);
            return this;
        }

        public b z(String str) {
            r();
            ((c) this.f16577b).Y(str);
            return this;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        AbstractC1480t.N(c.class, cVar);
    }

    public static b V() {
        return (b) DEFAULT_INSTANCE.s();
    }

    public final void W(String str) {
        str.getClass();
        this.appInstanceId_ = str;
    }

    public final void X(String str) {
        str.getClass();
        this.appInstanceIdToken_ = str;
    }

    public final void Y(String str) {
        str.getClass();
        this.gmpAppId_ = str;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f22916a[dVar.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"gmpAppId_", "appInstanceId_", "appInstanceIdToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (c.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1480t.b(DEFAULT_INSTANCE);
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
