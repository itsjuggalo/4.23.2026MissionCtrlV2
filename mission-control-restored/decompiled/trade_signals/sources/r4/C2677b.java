package r4;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.AbstractC1481u;
import com.google.protobuf.K;
import com.google.protobuf.S;
import java.util.List;

/* JADX INFO: renamed from: r4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2677b extends AbstractC1480t implements K {
    public static final int ALREADY_SEEN_CAMPAIGNS_FIELD_NUMBER = 1;
    private static final C2677b DEFAULT_INSTANCE;
    private static volatile S PARSER;
    private AbstractC1481u.d alreadySeenCampaigns_ = AbstractC1480t.x();

    /* JADX INFO: renamed from: r4.b$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22915a;

        static {
            int[] iArr = new int[AbstractC1480t.d.values().length];
            f22915a = iArr;
            try {
                iArr[AbstractC1480t.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22915a[AbstractC1480t.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22915a[AbstractC1480t.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22915a[AbstractC1480t.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22915a[AbstractC1480t.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f22915a[AbstractC1480t.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f22915a[AbstractC1480t.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: r4.b$b, reason: collision with other inner class name */
    public static final class C0392b extends AbstractC1480t.a implements K {
        public C0392b() {
            super(C2677b.DEFAULT_INSTANCE);
        }

        public C0392b x(C2676a c2676a) {
            r();
            ((C2677b) this.f16577b).T(c2676a);
            return this;
        }

        public /* synthetic */ C0392b(a aVar) {
            this();
        }
    }

    static {
        C2677b c2677b = new C2677b();
        DEFAULT_INSTANCE = c2677b;
        AbstractC1480t.N(C2677b.class, c2677b);
    }

    public static C2677b W() {
        return DEFAULT_INSTANCE;
    }

    public static C0392b X() {
        return (C0392b) DEFAULT_INSTANCE.s();
    }

    public static C0392b Y(C2677b c2677b) {
        return (C0392b) DEFAULT_INSTANCE.t(c2677b);
    }

    public static S Z() {
        return DEFAULT_INSTANCE.j();
    }

    public final void T(C2676a c2676a) {
        c2676a.getClass();
        U();
        this.alreadySeenCampaigns_.add(c2676a);
    }

    public final void U() {
        AbstractC1481u.d dVar = this.alreadySeenCampaigns_;
        if (dVar.m()) {
            return;
        }
        this.alreadySeenCampaigns_ = AbstractC1480t.I(dVar);
    }

    public List V() {
        return this.alreadySeenCampaigns_;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f22915a[dVar.ordinal()]) {
            case 1:
                return new C2677b();
            case 2:
                return new C0392b(aVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"alreadySeenCampaigns_", C2676a.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (C2677b.class) {
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
