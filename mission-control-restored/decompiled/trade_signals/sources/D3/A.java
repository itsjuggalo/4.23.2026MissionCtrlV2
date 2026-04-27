package D3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class A extends AbstractC1480t implements K {
    public static final int ACTION_FIELD_NUMBER = 2;
    private static final A DEFAULT_INSTANCE;
    public static final int IMAGE_URL_FIELD_NUMBER = 1;
    private static volatile S PARSER;
    private v action_;
    private int bitField0_;
    private String imageUrl_ = "";

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(A.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        A a8 = new A();
        DEFAULT_INSTANCE = a8;
        AbstractC1480t.N(A.class, a8);
    }

    public static A T() {
        return DEFAULT_INSTANCE;
    }

    public v S() {
        v vVar = this.action_;
        return vVar == null ? v.T() : vVar;
    }

    public String U() {
        return this.imageUrl_;
    }

    public boolean V() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        u uVar = null;
        switch (u.f851a[dVar.ordinal()]) {
            case 1:
                return new A();
            case 2:
                return new a(uVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "imageUrl_", "action_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (A.class) {
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
