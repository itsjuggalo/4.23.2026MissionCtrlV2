package F2;

import com.google.protobuf.AbstractC1480t;
import com.google.protobuf.K;
import com.google.protobuf.S;

/* JADX INFO: loaded from: classes.dex */
public final class b extends AbstractC1480t implements K {
    public static final int APP_VERSION_FIELD_NUMBER = 1;
    private static final b DEFAULT_INSTANCE;
    public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
    private static volatile S PARSER = null;
    public static final int PLATFORM_VERSION_FIELD_NUMBER = 2;
    public static final int TIME_ZONE_FIELD_NUMBER = 4;
    private String appVersion_ = "";
    private String platformVersion_ = "";
    private String languageCode_ = "";
    private String timeZone_ = "";

    public static final class a extends AbstractC1480t.a implements K {
        public a() {
            super(b.DEFAULT_INSTANCE);
        }

        public a A(String str) {
            r();
            ((b) this.f16577b).a0(str);
            return this;
        }

        public a x(String str) {
            r();
            ((b) this.f16577b).X(str);
            return this;
        }

        public a y(String str) {
            r();
            ((b) this.f16577b).Y(str);
            return this;
        }

        public a z(String str) {
            r();
            ((b) this.f16577b).Z(str);
            return this;
        }

        public /* synthetic */ a(F2.a aVar) {
            this();
        }
    }

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        AbstractC1480t.N(b.class, bVar);
    }

    public static a W() {
        return (a) DEFAULT_INSTANCE.s();
    }

    public final void X(String str) {
        str.getClass();
        this.appVersion_ = str;
    }

    public final void Y(String str) {
        str.getClass();
        this.languageCode_ = str;
    }

    public final void Z(String str) {
        str.getClass();
        this.platformVersion_ = str;
    }

    public final void a0(String str) {
        str.getClass();
        this.timeZone_ = str;
    }

    @Override // com.google.protobuf.AbstractC1480t
    public final Object w(AbstractC1480t.d dVar, Object obj, Object obj2) {
        F2.a aVar = null;
        switch (F2.a.f1523a[dVar.ordinal()]) {
            case 1:
                return new b();
            case 2:
                return new a(aVar);
            case 3:
                return AbstractC1480t.K(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"appVersion_", "platformVersion_", "languageCode_", "timeZone_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                S bVar = PARSER;
                if (bVar == null) {
                    synchronized (b.class) {
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
