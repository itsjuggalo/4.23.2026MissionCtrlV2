package q9;

import com.google.protobuf.e1;
import com.google.protobuf.v0;
import com.google.protobuf.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z extends com.google.protobuf.y implements v0 {
    public static final int BANNER_FIELD_NUMBER = 1;
    public static final int CARD_FIELD_NUMBER = 4;
    private static final z DEFAULT_INSTANCE;
    public static final int IMAGE_ONLY_FIELD_NUMBER = 3;
    public static final int MODAL_FIELD_NUMBER = 2;
    private static volatile e1 PARSER;
    private int messageDetailsCase_ = 0;
    private Object messageDetails_;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends y.a implements v0 {
        public /* synthetic */ a(u uVar) {
            this();
        }

        public a() {
            super(z.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        BANNER(1),
        MODAL(2),
        IMAGE_ONLY(3),
        CARD(4),
        MESSAGEDETAILS_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18963a;

        b(int i10) {
            this.f18963a = i10;
        }

        public static b b(int i10) {
            if (i10 == 0) {
                return MESSAGEDETAILS_NOT_SET;
            }
            if (i10 == 1) {
                return BANNER;
            }
            if (i10 == 2) {
                return MODAL;
            }
            if (i10 == 3) {
                return IMAGE_ONLY;
            }
            if (i10 != 4) {
                return null;
            }
            return CARD;
        }
    }

    static {
        z zVar = new z();
        DEFAULT_INSTANCE = zVar;
        com.google.protobuf.y.V(z.class, zVar);
    }

    public static z c0() {
        return DEFAULT_INSTANCE;
    }

    public w a0() {
        return this.messageDetailsCase_ == 1 ? (w) this.messageDetails_ : w.d0();
    }

    public y b0() {
        return this.messageDetailsCase_ == 4 ? (y) this.messageDetails_ : y.c0();
    }

    public a0 d0() {
        return this.messageDetailsCase_ == 3 ? (a0) this.messageDetails_ : a0.b0();
    }

    public b e0() {
        return b.b(this.messageDetailsCase_);
    }

    public b0 f0() {
        return this.messageDetailsCase_ == 2 ? (b0) this.messageDetails_ : b0.e0();
    }

    @Override // com.google.protobuf.y
    public final Object y(y.d dVar, Object obj, Object obj2) {
        e1 bVar;
        u uVar = null;
        switch (u.f18956a[dVar.ordinal()]) {
            case 1:
                return new z();
            case 2:
                return new a(uVar);
            case 3:
                return com.google.protobuf.y.N(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"messageDetails_", "messageDetailsCase_", w.class, b0.class, a0.class, y.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                e1 e1Var = PARSER;
                if (e1Var != null) {
                    return e1Var;
                }
                synchronized (z.class) {
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
