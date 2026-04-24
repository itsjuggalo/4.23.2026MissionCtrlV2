package D3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class g extends AbstractC1480t implements K {
    private static final g DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 5;
    public static final int FLOAT_VALUE_FIELD_NUMBER = 4;
    public static final int INT_VALUE_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile S PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 2;
    private double doubleValue_;
    private float floatValue_;
    private long intValue_;
    private String name_ = "";
    private String stringValue_ = "";

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(g.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(AbstractC0460c abstractC0460c) {
            this();
        }
    }

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        AbstractC1480t.N(g.class, gVar);
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        AbstractC0460c abstractC0460c = null;
        switch (AbstractC0460c.f791a[dVar.ordinal()]) {
            case 1:
                return new g();
            case 2:
                return new a(abstractC0460c);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004\u0001\u0005\u0000", new Object[]{"name_", "stringValue_", "intValue_", "floatValue_", "doubleValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (g.class) {
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
