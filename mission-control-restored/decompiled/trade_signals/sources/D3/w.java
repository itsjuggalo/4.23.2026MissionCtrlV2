package D3;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class w extends AbstractC1480t implements K {
    public static final int ACTION_FIELD_NUMBER = 4;
    public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 5;
    public static final int BODY_FIELD_NUMBER = 2;
    private static final w DEFAULT_INSTANCE;
    public static final int IMAGE_URL_FIELD_NUMBER = 3;
    private static volatile S PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    private v action_;
    private int bitField0_;
    private C body_;
    private C title_;
    private String imageUrl_ = "";
    private String backgroundHexColor_ = "";

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(w.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        w wVar = new w();
        DEFAULT_INSTANCE = wVar;
        AbstractC1480t.N(w.class, wVar);
    }

    public static w V() {
        return DEFAULT_INSTANCE;
    }

    public v S() {
        v vVar = this.action_;
        return vVar == null ? v.T() : vVar;
    }

    public String T() {
        return this.backgroundHexColor_;
    }

    public C U() {
        C c8 = this.body_;
        return c8 == null ? C.S() : c8;
    }

    public String W() {
        return this.imageUrl_;
    }

    public C X() {
        C c8 = this.title_;
        return c8 == null ? C.S() : c8;
    }

    public boolean Y() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean Z() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean a0() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        u uVar = null;
        switch (u.f851a[dVar.ordinal()]) {
            case 1:
                return new w();
            case 2:
                return new a(uVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003Ȉ\u0004ဉ\u0002\u0005Ȉ", new Object[]{"bitField0_", "title_", "body_", "imageUrl_", "action_", "backgroundHexColor_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (w.class) {
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
