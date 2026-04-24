package D3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class C extends AbstractC1480t implements K {
    private static final C DEFAULT_INSTANCE;
    public static final int HEX_COLOR_FIELD_NUMBER = 2;
    private static volatile S PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    private String text_ = "";
    private String hexColor_ = "";

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(C.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        C c8 = new C();
        DEFAULT_INSTANCE = c8;
        AbstractC1480t.N(C.class, c8);
    }

    public static C S() {
        return DEFAULT_INSTANCE;
    }

    public String T() {
        return this.hexColor_;
    }

    public String U() {
        return this.text_;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        u uVar = null;
        switch (u.f851a[dVar.ordinal()]) {
            case 1:
                return new C();
            case 2:
                return new a(uVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"text_", "hexColor_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (C.class) {
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
