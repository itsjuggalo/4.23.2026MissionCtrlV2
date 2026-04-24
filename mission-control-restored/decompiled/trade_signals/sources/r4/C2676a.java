package r4;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: renamed from: r4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2676a extends AbstractC1480t implements K {
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
    private static final C2676a DEFAULT_INSTANCE;
    public static final int IMPRESSION_TIMESTAMP_MILLIS_FIELD_NUMBER = 2;
    private static volatile S PARSER;
    private String campaignId_ = "";
    private long impressionTimestampMillis_;

    /* JADX INFO: renamed from: r4.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0391a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22914a;

        static {
            int[] iArr = new int[AbstractC1480t.d.values().length];
            f22914a = iArr;
            try {
                iArr[AbstractC1480t.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22914a[AbstractC1480t.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22914a[AbstractC1480t.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22914a[AbstractC1480t.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22914a[AbstractC1480t.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f22914a[AbstractC1480t.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f22914a[AbstractC1480t.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: r4.a$b */
    public static final class b extends AbstractC1480t.a implements K {
        public b() {
            super(C2676a.DEFAULT_INSTANCE);
        }

        public b x(String str) {
            r();
            ((C2676a) this.f16577b).W(str);
            return this;
        }

        public b y(long j8) {
            r();
            ((C2676a) this.f16577b).X(j8);
            return this;
        }

        public /* synthetic */ b(C0391a c0391a) {
            this();
        }
    }

    static {
        C2676a c2676a = new C2676a();
        DEFAULT_INSTANCE = c2676a;
        AbstractC1480t.N(C2676a.class, c2676a);
    }

    public static b V() {
        return (b) DEFAULT_INSTANCE.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str) {
        str.getClass();
        this.campaignId_ = str;
    }

    public String U() {
        return this.campaignId_;
    }

    public final void X(long j8) {
        this.impressionTimestampMillis_ = j8;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        C0391a c0391a = null;
        switch (C0391a.f22914a[dVar.ordinal()]) {
            case 1:
                return new C2676a();
            case 2:
                return new b(c0391a);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0002", new Object[]{"campaignId_", "impressionTimestampMillis_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2676a.class) {
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
