package D3;

import D3.C0459b;
import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: renamed from: D3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0458a extends AbstractC1480t implements K {
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 2;
    public static final int CLIENT_APP_FIELD_NUMBER = 3;
    public static final int CLIENT_TIMESTAMP_MILLIS_FIELD_NUMBER = 4;
    private static final C0458a DEFAULT_INSTANCE;
    public static final int DISMISS_TYPE_FIELD_NUMBER = 6;
    public static final int ENGAGEMENTMETRICS_DELIVERY_RETRY_COUNT_FIELD_NUMBER = 10;
    public static final int EVENT_TYPE_FIELD_NUMBER = 5;
    public static final int FETCH_ERROR_REASON_FIELD_NUMBER = 8;
    public static final int FIAM_SDK_VERSION_FIELD_NUMBER = 9;
    private static volatile S PARSER = null;
    public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
    public static final int RENDER_ERROR_REASON_FIELD_NUMBER = 7;
    private int bitField0_;
    private C0459b clientApp_;
    private long clientTimestampMillis_;
    private int engagementMetricsDeliveryRetryCount_;
    private Object event_;
    private int eventCase_ = 0;
    private String projectNumber_ = "";
    private String campaignId_ = "";
    private String fiamSdkVersion_ = "";

    /* JADX INFO: renamed from: D3.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0017a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f789a;

        static {
            int[] iArr = new int[AbstractC1480t.d.values().length];
            f789a = iArr;
            try {
                iArr[AbstractC1480t.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f789a[AbstractC1480t.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f789a[AbstractC1480t.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f789a[AbstractC1480t.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f789a[AbstractC1480t.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f789a[AbstractC1480t.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f789a[AbstractC1480t.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: D3.a$b */
    public static final class b extends AbstractC1480t.a implements K {
        public b() {
            super(C0458a.DEFAULT_INSTANCE);
        }

        public b A(i iVar) {
            r();
            ((C0458a) this.f16577b).e0(iVar);
            return this;
        }

        public b B(j jVar) {
            r();
            ((C0458a) this.f16577b).f0(jVar);
            return this;
        }

        public b C(String str) {
            r();
            ((C0458a) this.f16577b).g0(str);
            return this;
        }

        public b D(String str) {
            r();
            ((C0458a) this.f16577b).h0(str);
            return this;
        }

        public b E(D d8) {
            r();
            ((C0458a) this.f16577b).i0(d8);
            return this;
        }

        public b x(String str) {
            r();
            ((C0458a) this.f16577b).b0(str);
            return this;
        }

        public b y(C0459b.C0018b c0018b) {
            r();
            ((C0458a) this.f16577b).c0((C0459b) c0018b.o());
            return this;
        }

        public b z(long j8) {
            r();
            ((C0458a) this.f16577b).d0(j8);
            return this;
        }

        public /* synthetic */ b(C0017a c0017a) {
            this();
        }
    }

    static {
        C0458a c0458a = new C0458a();
        DEFAULT_INSTANCE = c0458a;
        AbstractC1480t.N(C0458a.class, c0458a);
    }

    public static b a0() {
        return (b) DEFAULT_INSTANCE.s();
    }

    public final void b0(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.campaignId_ = str;
    }

    public final void c0(C0459b c0459b) {
        c0459b.getClass();
        this.clientApp_ = c0459b;
        this.bitField0_ |= 4;
    }

    public final void d0(long j8) {
        this.bitField0_ |= 8;
        this.clientTimestampMillis_ = j8;
    }

    public final void e0(i iVar) {
        this.event_ = Integer.valueOf(iVar.d());
        this.eventCase_ = 6;
    }

    public final void f0(j jVar) {
        this.event_ = Integer.valueOf(jVar.d());
        this.eventCase_ = 5;
    }

    public final void g0(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.fiamSdkVersion_ = str;
    }

    public final void h0(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.projectNumber_ = str;
    }

    public final void i0(D d8) {
        this.event_ = Integer.valueOf(d8.d());
        this.eventCase_ = 7;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        C0017a c0017a = null;
        switch (C0017a.f789a[dVar.ordinal()]) {
            case 1:
                return new C0458a();
            case 2:
                return new b(c0017a);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0001\n\u0001\u0001\u0001\n\n\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဂ\u0003\u0005\u083f\u0000\u0006\u083f\u0000\u0007\u083f\u0000\b\u083f\u0000\tဈ\u0004\nင\u0005", new Object[]{"event_", "eventCase_", "bitField0_", "projectNumber_", "campaignId_", "clientApp_", "clientTimestampMillis_", j.g(), i.g(), D.g(), n.g(), "fiamSdkVersion_", "engagementMetricsDeliveryRetryCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (C0458a.class) {
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
