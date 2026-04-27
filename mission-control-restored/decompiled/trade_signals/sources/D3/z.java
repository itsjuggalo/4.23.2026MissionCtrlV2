package D3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class z extends AbstractC1480t implements K {
    public static final int BANNER_FIELD_NUMBER = 1;
    public static final int CARD_FIELD_NUMBER = 4;
    private static final z DEFAULT_INSTANCE;
    public static final int IMAGE_ONLY_FIELD_NUMBER = 3;
    public static final int MODAL_FIELD_NUMBER = 2;
    private static volatile S PARSER;
    private int messageDetailsCase_ = 0;
    private Object messageDetails_;

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(z.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public enum b {
        BANNER(1),
        MODAL(2),
        IMAGE_ONLY(3),
        CARD(4),
        MESSAGEDETAILS_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f858a;

        b(int i8) {
            this.f858a = i8;
        }

        public static b b(int i8) {
            if (i8 == 0) {
                return MESSAGEDETAILS_NOT_SET;
            }
            if (i8 == 1) {
                return BANNER;
            }
            if (i8 == 2) {
                return MODAL;
            }
            if (i8 == 3) {
                return IMAGE_ONLY;
            }
            if (i8 != 4) {
                return null;
            }
            return CARD;
        }
    }

    static {
        z zVar = new z();
        DEFAULT_INSTANCE = zVar;
        AbstractC1480t.N(z.class, zVar);
    }

    public static z U() {
        return DEFAULT_INSTANCE;
    }

    public w S() {
        return this.messageDetailsCase_ == 1 ? (w) this.messageDetails_ : w.V();
    }

    public y T() {
        return this.messageDetailsCase_ == 4 ? (y) this.messageDetails_ : y.U();
    }

    public A V() {
        return this.messageDetailsCase_ == 3 ? (A) this.messageDetails_ : A.T();
    }

    public b W() {
        return b.b(this.messageDetailsCase_);
    }

    public B X() {
        return this.messageDetailsCase_ == 2 ? (B) this.messageDetails_ : B.W();
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        u uVar = null;
        switch (u.f851a[dVar.ordinal()]) {
            case 1:
                return new z();
            case 2:
                return new a(uVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"messageDetails_", "messageDetailsCase_", w.class, B.class, A.class, y.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (z.class) {
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
