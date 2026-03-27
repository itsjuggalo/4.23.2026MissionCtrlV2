package r4;

import com.google.protobuf.AbstractC1462a;
import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.AbstractC1481u;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class d extends AbstractC1480t implements K {
    public static final int ALREADY_SEEN_CAMPAIGNS_FIELD_NUMBER = 3;
    public static final int CLIENT_SIGNALS_FIELD_NUMBER = 4;
    private static final d DEFAULT_INSTANCE;
    private static volatile S PARSER = null;
    public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
    public static final int REQUESTING_CLIENT_APP_FIELD_NUMBER = 2;
    private int bitField0_;
    private F2.b clientSignals_;
    private c requestingClientApp_;
    private String projectNumber_ = "";
    private AbstractC1481u.d alreadySeenCampaigns_ = AbstractC1480t.x();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22917a;

        static {
            int[] iArr = new int[AbstractC1480t.d.values().length];
            f22917a = iArr;
            try {
                iArr[AbstractC1480t.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22917a[AbstractC1480t.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22917a[AbstractC1480t.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22917a[AbstractC1480t.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22917a[AbstractC1480t.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f22917a[AbstractC1480t.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f22917a[AbstractC1480t.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends AbstractC1480t.a implements K {
        public b() {
            super(d.DEFAULT_INSTANCE);
        }

        public b A(c cVar) {
            r();
            ((d) this.f16577b).c0(cVar);
            return this;
        }

        public b x(Iterable iterable) {
            r();
            ((d) this.f16577b).W(iterable);
            return this;
        }

        public b y(F2.b bVar) {
            r();
            ((d) this.f16577b).a0(bVar);
            return this;
        }

        public b z(String str) {
            r();
            ((d) this.f16577b).b0(str);
            return this;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        AbstractC1480t.N(d.class, dVar);
    }

    private void X() {
        AbstractC1481u.d dVar = this.alreadySeenCampaigns_;
        if (dVar.m()) {
            return;
        }
        this.alreadySeenCampaigns_ = AbstractC1480t.I(dVar);
    }

    public static d Y() {
        return DEFAULT_INSTANCE;
    }

    public static b Z() {
        return (b) DEFAULT_INSTANCE.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(String str) {
        str.getClass();
        this.projectNumber_ = str;
    }

    public final void W(Iterable iterable) {
        X();
        AbstractC1462a.a(iterable, this.alreadySeenCampaigns_);
    }

    public final void a0(F2.b bVar) {
        bVar.getClass();
        this.clientSignals_ = bVar;
        this.bitField0_ |= 2;
    }

    public final void c0(c cVar) {
        cVar.getClass();
        this.requestingClientApp_ = cVar;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f22917a[dVar.ordinal()]) {
            case 1:
                return new d();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002ဉ\u0000\u0003\u001b\u0004ဉ\u0001", new Object[]{"bitField0_", "projectNumber_", "requestingClientApp_", "alreadySeenCampaigns_", C2676a.class, "clientSignals_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (d.class) {
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
