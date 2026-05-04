package q9;

import com.google.protobuf.e1;
import com.google.protobuf.v0;
import com.google.protobuf.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class y extends com.google.protobuf.y implements v0 {
    public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 5;
    public static final int BODY_FIELD_NUMBER = 2;
    private static final y DEFAULT_INSTANCE;
    public static final int LANDSCAPE_IMAGE_URL_FIELD_NUMBER = 4;
    private static volatile e1 PARSER = null;
    public static final int PORTRAIT_IMAGE_URL_FIELD_NUMBER = 3;
    public static final int PRIMARY_ACTION_BUTTON_FIELD_NUMBER = 6;
    public static final int PRIMARY_ACTION_FIELD_NUMBER = 7;
    public static final int SECONDARY_ACTION_BUTTON_FIELD_NUMBER = 8;
    public static final int SECONDARY_ACTION_FIELD_NUMBER = 9;
    public static final int TITLE_FIELD_NUMBER = 1;
    private int bitField0_;
    private c0 body_;
    private x primaryActionButton_;
    private v primaryAction_;
    private x secondaryActionButton_;
    private v secondaryAction_;
    private c0 title_;
    private String portraitImageUrl_ = "";
    private String landscapeImageUrl_ = "";
    private String backgroundHexColor_ = "";

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends y.a implements v0 {
        public /* synthetic */ a(u uVar) {
            this();
        }

        public a() {
            super(y.DEFAULT_INSTANCE);
        }
    }

    static {
        y yVar = new y();
        DEFAULT_INSTANCE = yVar;
        com.google.protobuf.y.V(y.class, yVar);
    }

    public static y c0() {
        return DEFAULT_INSTANCE;
    }

    public String a0() {
        return this.backgroundHexColor_;
    }

    public c0 b0() {
        c0 c0Var = this.body_;
        return c0Var == null ? c0.a0() : c0Var;
    }

    public String d0() {
        return this.landscapeImageUrl_;
    }

    public String e0() {
        return this.portraitImageUrl_;
    }

    public v f0() {
        v vVar = this.primaryAction_;
        return vVar == null ? v.b0() : vVar;
    }

    public x g0() {
        x xVar = this.primaryActionButton_;
        return xVar == null ? x.b0() : xVar;
    }

    public v h0() {
        v vVar = this.secondaryAction_;
        return vVar == null ? v.b0() : vVar;
    }

    public x i0() {
        x xVar = this.secondaryActionButton_;
        return xVar == null ? x.b0() : xVar;
    }

    public c0 j0() {
        c0 c0Var = this.title_;
        return c0Var == null ? c0.a0() : c0Var;
    }

    public boolean k0() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean l0() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean m0() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean n0() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean o0() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean p0() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        u uVar = null;
        switch (u.f18956a[dVar.ordinal()]) {
            case 1:
                return new y();
            case 2:
                return new a(uVar);
            case 3:
                return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006ဉ\u0002\u0007ဉ\u0003\bဉ\u0004\tဉ\u0005", new Object[]{"bitField0_", "title_", "body_", "portraitImageUrl_", "landscapeImageUrl_", "backgroundHexColor_", "primaryActionButton_", "primaryAction_", "secondaryActionButton_", "secondaryAction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (y.class) {
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
