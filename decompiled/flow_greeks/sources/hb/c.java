package hb;

import com.google.protobuf.a2;
import com.google.protobuf.c0;
import com.google.protobuf.e1;
import com.google.protobuf.n0;
import com.google.protobuf.o0;
import com.google.protobuf.v0;
import com.google.protobuf.y;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import q9.e;
import q9.h;
import q9.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends y implements v0 {
    public static final int CONTENT_FIELD_NUMBER = 3;
    public static final int DATA_BUNDLE_FIELD_NUMBER = 8;
    private static final c DEFAULT_INSTANCE;
    public static final int EXPERIMENTAL_PAYLOAD_FIELD_NUMBER = 2;
    public static final int IS_TEST_CAMPAIGN_FIELD_NUMBER = 7;
    private static volatile e1 PARSER = null;
    public static final int PRIORITY_FIELD_NUMBER = 4;
    public static final int TRIGGERING_CONDITIONS_FIELD_NUMBER = 5;
    public static final int VANILLA_PAYLOAD_FIELD_NUMBER = 1;
    private int bitField0_;
    private z content_;
    private boolean isTestCampaign_;
    private Object payload_;
    private e priority_;
    private int payloadCase_ = 0;
    private o0 dataBundle_ = o0.f();
    private c0.e triggeringConditions_ = y.A();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends y.a implements v0 {
        public /* synthetic */ a(hb.a aVar) {
            this();
        }

        public a() {
            super(c.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n0 f11283a;

        static {
            a2.b bVar = a2.b.f6909k;
            f11283a = n0.d(bVar, "", bVar, "");
        }
    }

    /* JADX INFO: renamed from: hb.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum EnumC0206c {
        VANILLA_PAYLOAD(1),
        EXPERIMENTAL_PAYLOAD(2),
        PAYLOAD_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11288a;

        EnumC0206c(int i10) {
            this.f11288a = i10;
        }

        public static EnumC0206c b(int i10) {
            if (i10 == 0) {
                return PAYLOAD_NOT_SET;
            }
            if (i10 == 1) {
                return VANILLA_PAYLOAD;
            }
            if (i10 != 2) {
                return null;
            }
            return EXPERIMENTAL_PAYLOAD;
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        y.V(c.class, cVar);
    }

    public z a0() {
        z zVar = this.content_;
        return zVar == null ? z.c0() : zVar;
    }

    public Map b0() {
        return Collections.unmodifiableMap(i0());
    }

    public hb.b c0() {
        return this.payloadCase_ == 2 ? (hb.b) this.payload_ : hb.b.e0();
    }

    public boolean d0() {
        return this.isTestCampaign_;
    }

    public EnumC0206c e0() {
        return EnumC0206c.b(this.payloadCase_);
    }

    public e f0() {
        e eVar = this.priority_;
        return eVar == null ? e.a0() : eVar;
    }

    public List g0() {
        return this.triggeringConditions_;
    }

    public d h0() {
        return this.payloadCase_ == 1 ? (d) this.payload_ : d.e0();
    }

    public final o0 i0() {
        return this.dataBundle_;
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        hb.a aVar = null;
        switch (hb.a.f11282a[dVar.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return new a(aVar);
            case 3:
                return y.N(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\b\u0007\u0001\u0001\u0000\u0001<\u0000\u0002<\u0000\u0003ဉ\u0000\u0004ဉ\u0001\u0005\u001b\u0007\u0007\b2", new Object[]{"payload_", "payloadCase_", "bitField0_", d.class, hb.b.class, "content_", "priority_", "triggeringConditions_", h.class, "isTestCampaign_", "dataBundle_", b.f11283a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (c.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new y.b(DEFAULT_INSTANCE);
                            PARSER = bVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
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
