package q4;

import D3.e;
import D3.h;
import D3.z;
import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.AbstractC1481u;
import com.google.protobuf.C;
import com.google.protobuf.D;
import com.google.protobuf.K;
import com.google.protobuf.S;
import com.google.protobuf.l0;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c extends AbstractC1480t implements K {
    public static final int CONTENT_FIELD_NUMBER = 3;
    public static final int DATA_BUNDLE_FIELD_NUMBER = 8;
    private static final c DEFAULT_INSTANCE;
    public static final int EXPERIMENTAL_PAYLOAD_FIELD_NUMBER = 2;
    public static final int IS_TEST_CAMPAIGN_FIELD_NUMBER = 7;
    private static volatile S PARSER = null;
    public static final int PRIORITY_FIELD_NUMBER = 4;
    public static final int TRIGGERING_CONDITIONS_FIELD_NUMBER = 5;
    public static final int VANILLA_PAYLOAD_FIELD_NUMBER = 1;
    private int bitField0_;
    private z content_;
    private boolean isTestCampaign_;
    private Object payload_;
    private e priority_;
    private int payloadCase_ = 0;
    private D dataBundle_ = D.e();
    private AbstractC1481u.d triggeringConditions_ = AbstractC1480t.x();

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(c.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(AbstractC2633a abstractC2633a) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C f22595a;

        static {
            l0.b bVar = l0.b.f16467k;
            f22595a = C.d(bVar, "", bVar, "");
        }
    }

    /* JADX INFO: renamed from: q4.c$c, reason: collision with other inner class name */
    public enum EnumC0385c {
        VANILLA_PAYLOAD(1),
        EXPERIMENTAL_PAYLOAD(2),
        PAYLOAD_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f22600a;

        EnumC0385c(int i8) {
            this.f22600a = i8;
        }

        public static EnumC0385c b(int i8) {
            if (i8 == 0) {
                return PAYLOAD_NOT_SET;
            }
            if (i8 == 1) {
                return VANILLA_PAYLOAD;
            }
            if (i8 != 2) {
                return null;
            }
            return EXPERIMENTAL_PAYLOAD;
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        AbstractC1480t.N(c.class, cVar);
    }

    public z S() {
        z zVar = this.content_;
        return zVar == null ? z.U() : zVar;
    }

    public Map T() {
        return Collections.unmodifiableMap(a0());
    }

    public q4.b U() {
        return this.payloadCase_ == 2 ? (q4.b) this.payload_ : q4.b.W();
    }

    public boolean V() {
        return this.isTestCampaign_;
    }

    public EnumC0385c W() {
        return EnumC0385c.b(this.payloadCase_);
    }

    public e X() {
        e eVar = this.priority_;
        return eVar == null ? e.S() : eVar;
    }

    public List Y() {
        return this.triggeringConditions_;
    }

    public d Z() {
        return this.payloadCase_ == 1 ? (d) this.payload_ : d.W();
    }

    public final D a0() {
        return this.dataBundle_;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        AbstractC2633a abstractC2633a = null;
        switch (AbstractC2633a.f22594a[dVar.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return new a(abstractC2633a);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\b\u0007\u0001\u0001\u0000\u0001<\u0000\u0002<\u0000\u0003ဉ\u0000\u0004ဉ\u0001\u0005\u001b\u0007\u0007\b2", new Object[]{"payload_", "payloadCase_", "bitField0_", d.class, q4.b.class, "content_", "priority_", "triggeringConditions_", h.class, "isTestCampaign_", "dataBundle_", b.f22595a});
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
