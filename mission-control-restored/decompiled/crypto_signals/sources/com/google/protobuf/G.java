package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class G extends E {
    private static final G DEFAULT_INSTANCE;
    private static volatile InterfaceC0475m0 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;

    static {
        G g2 = new G();
        DEFAULT_INSTANCE = g2;
        E.r(G.class, g2);
    }

    public static void t(G g2, int i) {
        g2.value_ = i;
    }

    public static G u() {
        return DEFAULT_INSTANCE;
    }

    public static F w() {
        return (F) DEFAULT_INSTANCE.g();
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
                return new C0483q0(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"value_"});
            case 3:
                return new G();
            case 4:
                return new F(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0475m0 interfaceC0475m0 = PARSER;
                if (interfaceC0475m0 != null) {
                    return interfaceC0475m0;
                }
                synchronized (G.class) {
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

    public final int v() {
        return this.value_;
    }
}
