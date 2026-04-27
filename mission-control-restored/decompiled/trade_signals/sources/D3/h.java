package D3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class h extends AbstractC1480t implements K {
    private static final h DEFAULT_INSTANCE;
    public static final int EVENT_FIELD_NUMBER = 2;
    public static final int FIAM_TRIGGER_FIELD_NUMBER = 1;
    private static volatile S PARSER;
    private int conditionCase_ = 0;
    private Object condition_;

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(h.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(AbstractC0460c abstractC0460c) {
            this();
        }
    }

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        AbstractC1480t.N(h.class, hVar);
    }

    public C0461d S() {
        return this.conditionCase_ == 2 ? (C0461d) this.condition_ : C0461d.S();
    }

    public f T() {
        if (this.conditionCase_ != 1) {
            return f.UNKNOWN_TRIGGER;
        }
        f fVarB = f.b(((Integer) this.condition_).intValue());
        return fVarB == null ? f.UNRECOGNIZED : fVarB;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        AbstractC0460c abstractC0460c = null;
        switch (AbstractC0460c.f791a[dVar.ordinal()]) {
            case 1:
                return new h();
            case 2:
                return new a(abstractC0460c);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001?\u0000\u0002<\u0000", new Object[]{"condition_", "conditionCase_", C0461d.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (h.class) {
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
