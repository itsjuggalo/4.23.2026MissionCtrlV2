package D3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class x extends AbstractC1480t implements K {
    public static final int BUTTON_HEX_COLOR_FIELD_NUMBER = 2;
    private static final x DEFAULT_INSTANCE;
    private static volatile S PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    private int bitField0_;
    private String buttonHexColor_ = "";
    private C text_;

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(x.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        x xVar = new x();
        DEFAULT_INSTANCE = xVar;
        AbstractC1480t.N(x.class, xVar);
    }

    public static x T() {
        return DEFAULT_INSTANCE;
    }

    public String S() {
        return this.buttonHexColor_;
    }

    public C U() {
        C c8 = this.text_;
        return c8 == null ? C.S() : c8;
    }

    public boolean V() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        u uVar = null;
        switch (u.f851a[dVar.ordinal()]) {
            case 1:
                return new x();
            case 2:
                return new a(uVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ", new Object[]{"bitField0_", "text_", "buttonHexColor_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (x.class) {
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
