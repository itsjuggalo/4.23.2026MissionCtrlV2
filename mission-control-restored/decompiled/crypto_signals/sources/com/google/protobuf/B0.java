package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class B0 extends E {
    private static final B0 DEFAULT_INSTANCE;
    public static final int NANOS_FIELD_NUMBER = 2;
    private static volatile InterfaceC0475m0 PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 1;
    private int nanos_;
    private long seconds_;

    static {
        B0 b02 = new B0();
        DEFAULT_INSTANCE = b02;
        E.r(B0.class, b02);
    }

    public static void t(B0 b02, long j4) {
        b02.seconds_ = j4;
    }

    public static void u(B0 b02, int i) {
        b02.nanos_ = i;
    }

    public static B0 v() {
        return DEFAULT_INSTANCE;
    }

    public static A0 y() {
        return (A0) DEFAULT_INSTANCE.g();
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
                return new C0483q0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"seconds_", "nanos_"});
            case 3:
                return new B0();
            case 4:
                return new A0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0475m0 interfaceC0475m0 = PARSER;
                if (interfaceC0475m0 != null) {
                    return interfaceC0475m0;
                }
                synchronized (B0.class) {
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

    public final int w() {
        return this.nanos_;
    }

    public final long x() {
        return this.seconds_;
    }
}
