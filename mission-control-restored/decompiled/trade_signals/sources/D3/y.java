package D3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class y extends AbstractC1480t implements K {
    public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 5;
    public static final int BODY_FIELD_NUMBER = 2;
    private static final y DEFAULT_INSTANCE;
    public static final int LANDSCAPE_IMAGE_URL_FIELD_NUMBER = 4;
    private static volatile S PARSER = null;
    public static final int PORTRAIT_IMAGE_URL_FIELD_NUMBER = 3;
    public static final int PRIMARY_ACTION_BUTTON_FIELD_NUMBER = 6;
    public static final int PRIMARY_ACTION_FIELD_NUMBER = 7;
    public static final int SECONDARY_ACTION_BUTTON_FIELD_NUMBER = 8;
    public static final int SECONDARY_ACTION_FIELD_NUMBER = 9;
    public static final int TITLE_FIELD_NUMBER = 1;
    private int bitField0_;
    private C body_;
    private x primaryActionButton_;
    private v primaryAction_;
    private x secondaryActionButton_;
    private v secondaryAction_;
    private C title_;
    private String portraitImageUrl_ = "";
    private String landscapeImageUrl_ = "";
    private String backgroundHexColor_ = "";

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(y.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        y yVar = new y();
        DEFAULT_INSTANCE = yVar;
        AbstractC1480t.N(y.class, yVar);
    }

    public static y U() {
        return DEFAULT_INSTANCE;
    }

    public String S() {
        return this.backgroundHexColor_;
    }

    public C T() {
        C c8 = this.body_;
        return c8 == null ? C.S() : c8;
    }

    public String V() {
        return this.landscapeImageUrl_;
    }

    public String W() {
        return this.portraitImageUrl_;
    }

    public v X() {
        v vVar = this.primaryAction_;
        return vVar == null ? v.T() : vVar;
    }

    public x Y() {
        x xVar = this.primaryActionButton_;
        return xVar == null ? x.T() : xVar;
    }

    public v Z() {
        v vVar = this.secondaryAction_;
        return vVar == null ? v.T() : vVar;
    }

    public x a0() {
        x xVar = this.secondaryActionButton_;
        return xVar == null ? x.T() : xVar;
    }

    public C b0() {
        C c8 = this.title_;
        return c8 == null ? C.S() : c8;
    }

    public boolean c0() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean d0() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean e0() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean f0() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean g0() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean h0() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        u uVar = null;
        switch (u.f851a[dVar.ordinal()]) {
            case 1:
                return new y();
            case 2:
                return new a(uVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006ဉ\u0002\u0007ဉ\u0003\bဉ\u0004\tဉ\u0005", new Object[]{"bitField0_", "title_", "body_", "portraitImageUrl_", "landscapeImageUrl_", "backgroundHexColor_", "primaryActionButton_", "primaryAction_", "secondaryActionButton_", "secondaryAction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (y.class) {
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
