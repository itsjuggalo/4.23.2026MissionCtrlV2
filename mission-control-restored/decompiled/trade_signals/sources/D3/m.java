package D3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.AbstractC1481u;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class m extends AbstractC1480t implements K {
    public static final int ACTIVATE_EVENT_TO_LOG_FIELD_NUMBER = 8;
    public static final int CLEAR_EVENT_TO_LOG_FIELD_NUMBER = 9;
    private static final m DEFAULT_INSTANCE;
    public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
    public static final int EXPERIMENT_START_TIME_MILLIS_FIELD_NUMBER = 3;
    public static final int ONGOING_EXPERIMENTS_FIELD_NUMBER = 13;
    public static final int OVERFLOW_POLICY_FIELD_NUMBER = 12;
    private static volatile S PARSER = null;
    public static final int SET_EVENT_TO_LOG_FIELD_NUMBER = 7;
    public static final int TIMEOUT_EVENT_TO_LOG_FIELD_NUMBER = 10;
    public static final int TIME_TO_LIVE_MILLIS_FIELD_NUMBER = 6;
    public static final int TRIGGER_EVENT_FIELD_NUMBER = 4;
    public static final int TRIGGER_TIMEOUT_MILLIS_FIELD_NUMBER = 5;
    public static final int TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER = 11;
    public static final int VARIANT_ID_FIELD_NUMBER = 2;
    private long experimentStartTimeMillis_;
    private int overflowPolicy_;
    private long timeToLiveMillis_;
    private long triggerTimeoutMillis_;
    private String experimentId_ = "";
    private String variantId_ = "";
    private String triggerEvent_ = "";
    private String setEventToLog_ = "";
    private String activateEventToLog_ = "";
    private String clearEventToLog_ = "";
    private String timeoutEventToLog_ = "";
    private String ttlExpiryEventToLog_ = "";
    private AbstractC1481u.d ongoingExperiments_ = AbstractC1480t.x();

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(m.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    static {
        m mVar = new m();
        DEFAULT_INSTANCE = mVar;
        AbstractC1480t.N(m.class, mVar);
    }

    public static m S() {
        return DEFAULT_INSTANCE;
    }

    public String T() {
        return this.experimentId_;
    }

    public long U() {
        return this.experimentStartTimeMillis_;
    }

    public long V() {
        return this.timeToLiveMillis_;
    }

    public String W() {
        return this.triggerEvent_;
    }

    public long X() {
        return this.triggerTimeoutMillis_;
    }

    public String Y() {
        return this.variantId_;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        k kVar = null;
        switch (k.f814a[dVar.ordinal()]) {
            case 1:
                return new m();
            case 2:
                return new a(kVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\r\u0000\u0000\u0001\r\r\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004Ȉ\u0005\u0002\u0006\u0002\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\f\f\r\u001b", new Object[]{"experimentId_", "variantId_", "experimentStartTimeMillis_", "triggerEvent_", "triggerTimeoutMillis_", "timeToLiveMillis_", "setEventToLog_", "activateEventToLog_", "clearEventToLog_", "timeoutEventToLog_", "ttlExpiryEventToLog_", "overflowPolicy_", "ongoingExperiments_", l.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (m.class) {
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
