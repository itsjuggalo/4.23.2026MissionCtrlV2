package s3;

import com.google.protobuf.C0483q0;
import com.google.protobuf.InterfaceC0475m0;

/* JADX INFO: renamed from: s3.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1033l0 extends com.google.protobuf.E {
    private static final C1033l0 DEFAULT_INSTANCE;
    public static final int FIELD_PATH_FIELD_NUMBER = 2;
    private static volatile InterfaceC0475m0 PARSER;
    private String fieldPath_ = "";

    static {
        C1033l0 c1033l0 = new C1033l0();
        DEFAULT_INSTANCE = c1033l0;
        com.google.protobuf.E.r(C1033l0.class, c1033l0);
    }

    public static void t(C1033l0 c1033l0, String str) {
        c1033l0.getClass();
        str.getClass();
        c1033l0.fieldPath_ = str;
    }

    public static C1033l0 u() {
        return DEFAULT_INSTANCE;
    }

    public static C1031k0 w() {
        return (C1031k0) DEFAULT_INSTANCE.g();
    }

    @Override // com.google.protobuf.E
    public final Object h(int i) {
        InterfaceC0475m0 d4;
        switch (S.i.c(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new C0483q0(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002Ȉ", new Object[]{"fieldPath_"});
            case 3:
                return new C1033l0();
            case 4:
                return new C1031k0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0475m0 interfaceC0475m0 = PARSER;
                if (interfaceC0475m0 != null) {
                    return interfaceC0475m0;
                }
                synchronized (C1033l0.class) {
                    try {
                        d4 = PARSER;
                        if (d4 == null) {
                            d4 = new com.google.protobuf.D(DEFAULT_INSTANCE);
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

    public final String v() {
        return this.fieldPath_;
    }
}
