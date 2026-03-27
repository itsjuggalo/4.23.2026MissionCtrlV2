package D3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: renamed from: D3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0459b extends AbstractC1480t implements K {
    private static final C0459b DEFAULT_INSTANCE;
    public static final int FIREBASE_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int GOOGLE_APP_ID_FIELD_NUMBER = 1;
    private static volatile S PARSER;
    private int bitField0_;
    private String googleAppId_ = "";
    private String firebaseInstanceId_ = "";

    /* JADX INFO: renamed from: D3.b$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f790a;

        static {
            int[] iArr = new int[AbstractC1480t.d.values().length];
            f790a = iArr;
            try {
                iArr[AbstractC1480t.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f790a[AbstractC1480t.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f790a[AbstractC1480t.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f790a[AbstractC1480t.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f790a[AbstractC1480t.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f790a[AbstractC1480t.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f790a[AbstractC1480t.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: D3.b$b, reason: collision with other inner class name */
    public static final class C0018b extends AbstractC1480t.a implements K {
        public C0018b() {
            super(C0459b.DEFAULT_INSTANCE);
        }

        public C0018b x(String str) {
            r();
            ((C0459b) this.f16577b).V(str);
            return this;
        }

        public C0018b y(String str) {
            r();
            ((C0459b) this.f16577b).W(str);
            return this;
        }

        public /* synthetic */ C0018b(a aVar) {
            this();
        }
    }

    static {
        C0459b c0459b = new C0459b();
        DEFAULT_INSTANCE = c0459b;
        AbstractC1480t.N(C0459b.class, c0459b);
    }

    public static C0018b U() {
        return (C0018b) DEFAULT_INSTANCE.s();
    }

    public final void V(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.firebaseInstanceId_ = str;
    }

    public final void W(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.googleAppId_ = str;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f790a[dVar.ordinal()]) {
            case 1:
                return new C0459b();
            case 2:
                return new C0018b(aVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"bitField0_", "googleAppId_", "firebaseInstanceId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (C0459b.class) {
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
