package D3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class l extends AbstractC1480t implements K {
    private static final l DEFAULT_INSTANCE;
    public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
    private static volatile S PARSER;
    private String experimentId_ = "";

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(l.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    static {
        l lVar = new l();
        DEFAULT_INSTANCE = lVar;
        AbstractC1480t.N(l.class, lVar);
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        k kVar = null;
        switch (k.f814a[dVar.ordinal()]) {
            case 1:
                return new l();
            case 2:
                return new a(kVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"experimentId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (l.class) {
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
