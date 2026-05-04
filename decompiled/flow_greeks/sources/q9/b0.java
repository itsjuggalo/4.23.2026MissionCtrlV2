package q9;

import com.google.protobuf.e1;
import com.google.protobuf.v0;
import com.google.protobuf.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends com.google.protobuf.y implements v0 {
    public static final int ACTION_BUTTON_FIELD_NUMBER = 4;
    public static final int ACTION_FIELD_NUMBER = 5;
    public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 6;
    public static final int BODY_FIELD_NUMBER = 2;
    private static final b0 DEFAULT_INSTANCE;
    public static final int IMAGE_URL_FIELD_NUMBER = 3;
    private static volatile e1 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    private x actionButton_;
    private v action_;
    private int bitField0_;
    private c0 body_;
    private c0 title_;
    private String imageUrl_ = "";
    private String backgroundHexColor_ = "";

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends y.a implements v0 {
        public /* synthetic */ a(u uVar) {
            this();
        }

        public a() {
            super(b0.DEFAULT_INSTANCE);
        }
    }

    static {
        b0 b0Var = new b0();
        DEFAULT_INSTANCE = b0Var;
        com.google.protobuf.y.V(b0.class, b0Var);
    }

    public static b0 e0() {
        return DEFAULT_INSTANCE;
    }

    public v a0() {
        v vVar = this.action_;
        return vVar == null ? v.b0() : vVar;
    }

    public x b0() {
        x xVar = this.actionButton_;
        return xVar == null ? x.b0() : xVar;
    }

    public String c0() {
        return this.backgroundHexColor_;
    }

    public c0 d0() {
        c0 c0Var = this.body_;
        return c0Var == null ? c0.a0() : c0Var;
    }

    public String f0() {
        return this.imageUrl_;
    }

    public c0 g0() {
        c0 c0Var = this.title_;
        return c0Var == null ? c0.a0() : c0Var;
    }

    public boolean h0() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean i0() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean j0() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        u uVar = null;
        switch (u.f18956a[dVar.ordinal()]) {
            case 1:
                return new b0();
            case 2:
                return new a(uVar);
            case 3:
                return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003Ȉ\u0004ဉ\u0002\u0005ဉ\u0003\u0006Ȉ", new Object[]{"bitField0_", "title_", "body_", "imageUrl_", "actionButton_", "action_", "backgroundHexColor_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (b0.class) {
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
