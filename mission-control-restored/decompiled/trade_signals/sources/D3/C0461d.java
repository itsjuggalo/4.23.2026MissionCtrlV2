package D3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.AbstractC1481u;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: renamed from: D3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0461d extends AbstractC1480t implements K {
    public static final int COUNT_FIELD_NUMBER = 5;
    private static final C0461d DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile S PARSER = null;
    public static final int PREVIOUS_TIMESTAMP_MILLIS_FIELD_NUMBER = 4;
    public static final int TIMESTAMP_MILLIS_FIELD_NUMBER = 3;
    public static final int TRIGGER_PARAMS_FIELD_NUMBER = 1;
    private int count_;
    private long previousTimestampMillis_;
    private long timestampMillis_;
    private AbstractC1481u.d triggerParams_ = AbstractC1480t.x();
    private String name_ = "";

    /* JADX INFO: renamed from: D3.d$a */
    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(C0461d.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(AbstractC0460c abstractC0460c) {
            this();
        }
    }

    static {
        C0461d c0461d = new C0461d();
        DEFAULT_INSTANCE = c0461d;
        AbstractC1480t.N(C0461d.class, c0461d);
    }

    public static C0461d S() {
        return DEFAULT_INSTANCE;
    }

    public String T() {
        return this.name_;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        AbstractC0460c abstractC0460c = null;
        switch (AbstractC0460c.f791a[dVar.ordinal()]) {
            case 1:
                return new C0461d();
            case 2:
                return new a(abstractC0460c);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002Ȉ\u0003\u0002\u0004\u0002\u0005\u0004", new Object[]{"triggerParams_", g.class, "name_", "timestampMillis_", "previousTimestampMillis_", "count_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (C0461d.class) {
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
