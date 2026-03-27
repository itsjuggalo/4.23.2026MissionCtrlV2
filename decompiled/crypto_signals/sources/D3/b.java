package D3;

import S.i;
import com.google.protobuf.C0483q0;
import com.google.protobuf.D;
import com.google.protobuf.E;
import com.google.protobuf.InterfaceC0475m0;

/* JADX INFO: loaded from: classes.dex */
public final class b extends E {
    private static final b DEFAULT_INSTANCE;
    public static final int LATITUDE_FIELD_NUMBER = 1;
    public static final int LONGITUDE_FIELD_NUMBER = 2;
    private static volatile InterfaceC0475m0 PARSER;
    private double latitude_;
    private double longitude_;

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        E.r(b.class, bVar);
    }

    public static void t(b bVar, double d4) {
        bVar.latitude_ = d4;
    }

    public static void u(b bVar, double d4) {
        bVar.longitude_ = d4;
    }

    public static b v() {
        return DEFAULT_INSTANCE;
    }

    public static a y() {
        return (a) DEFAULT_INSTANCE.g();
    }

    @Override // com.google.protobuf.E
    public final Object h(int i) {
        InterfaceC0475m0 d4;
        switch (i.c(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new C0483q0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0000\u0002\u0000", new Object[]{"latitude_", "longitude_"});
            case 3:
                return new b();
            case 4:
                return new a(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0475m0 interfaceC0475m0 = PARSER;
                if (interfaceC0475m0 != null) {
                    return interfaceC0475m0;
                }
                synchronized (b.class) {
                    try {
                        d4 = PARSER;
                        if (d4 == null) {
                            d4 = new D(DEFAULT_INSTANCE);
                            PARSER = d4;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return d4;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final double w() {
        return this.latitude_;
    }

    public final double x() {
        return this.longitude_;
    }
}
