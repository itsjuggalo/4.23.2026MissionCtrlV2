package D3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class e extends AbstractC1480t implements K {
    private static final e DEFAULT_INSTANCE;
    private static volatile S PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(e.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(AbstractC0460c abstractC0460c) {
            this();
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        AbstractC1480t.N(e.class, eVar);
    }

    public static e S() {
        return DEFAULT_INSTANCE;
    }

    public int T() {
        return this.value_;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        AbstractC0460c abstractC0460c = null;
        switch (AbstractC0460c.f791a[dVar.ordinal()]) {
            case 1:
                return new e();
            case 2:
                return new a(abstractC0460c);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (e.class) {
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
