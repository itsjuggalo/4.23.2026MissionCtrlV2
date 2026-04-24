package q4;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class d extends AbstractC1480t implements K {
    public static final int CAMPAIGN_END_TIME_MILLIS_FIELD_NUMBER = 4;
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
    public static final int CAMPAIGN_NAME_FIELD_NUMBER = 5;
    public static final int CAMPAIGN_START_TIME_MILLIS_FIELD_NUMBER = 3;
    private static final d DEFAULT_INSTANCE;
    public static final int EXPERIMENTAL_CAMPAIGN_ID_FIELD_NUMBER = 2;
    private static volatile S PARSER;
    private long campaignEndTimeMillis_;
    private long campaignStartTimeMillis_;
    private String campaignId_ = "";
    private String experimentalCampaignId_ = "";
    private String campaignName_ = "";

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(d.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(AbstractC2633a abstractC2633a) {
            this();
        }
    }

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        AbstractC1480t.N(d.class, dVar);
    }

    public static d W() {
        return DEFAULT_INSTANCE;
    }

    public long S() {
        return this.campaignEndTimeMillis_;
    }

    public String T() {
        return this.campaignId_;
    }

    public String U() {
        return this.campaignName_;
    }

    public long V() {
        return this.campaignStartTimeMillis_;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        AbstractC2633a abstractC2633a = null;
        switch (AbstractC2633a.f22594a[dVar.ordinal()]) {
            case 1:
                return new d();
            case 2:
                return new a(abstractC2633a);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004\u0002\u0005Ȉ", new Object[]{"campaignId_", "experimentalCampaignId_", "campaignStartTimeMillis_", "campaignEndTimeMillis_", "campaignName_"});
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
