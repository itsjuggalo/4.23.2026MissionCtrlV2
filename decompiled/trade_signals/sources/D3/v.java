package D3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class v extends AbstractC1480t implements K {
    public static final int ACTION_URL_FIELD_NUMBER = 1;
    private static final v DEFAULT_INSTANCE;
    private static volatile S PARSER;
    private String actionUrl_ = "";

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(v.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        v vVar = new v();
        DEFAULT_INSTANCE = vVar;
        AbstractC1480t.N(v.class, vVar);
    }

    public static v T() {
        return DEFAULT_INSTANCE;
    }

    public String S() {
        return this.actionUrl_;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        u uVar = null;
        switch (u.f851a[dVar.ordinal()]) {
            case 1:
                return new v();
            case 2:
                return new a(uVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"actionUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (v.class) {
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
