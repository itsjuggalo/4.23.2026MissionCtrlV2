package s3;

import com.google.protobuf.AbstractC0450a;
import com.google.protobuf.AbstractC0452b;
import com.google.protobuf.C0481p0;
import com.google.protobuf.C0483q0;
import com.google.protobuf.InterfaceC0475m0;
import java.util.List;

/* JADX INFO: renamed from: s3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1016d extends com.google.protobuf.E implements InterfaceC1018e {
    private static final C1016d DEFAULT_INSTANCE;
    private static volatile InterfaceC0475m0 PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private com.google.protobuf.L values_ = C0481p0.f5779d;

    static {
        C1016d c1016d = new C1016d();
        DEFAULT_INSTANCE = c1016d;
        com.google.protobuf.E.r(C1016d.class, c1016d);
    }

    public static void t(C1016d c1016d, I0 i02) {
        c1016d.getClass();
        i02.getClass();
        com.google.protobuf.L l6 = c1016d.values_;
        if (!((AbstractC0452b) l6).f5706a) {
            c1016d.values_ = com.google.protobuf.E.n(l6);
        }
        c1016d.values_.add(i02);
    }

    public static void u(C1016d c1016d, List list) {
        com.google.protobuf.L l6 = c1016d.values_;
        if (!((AbstractC0452b) l6).f5706a) {
            c1016d.values_ = com.google.protobuf.E.n(l6);
        }
        AbstractC0450a.b(list, c1016d.values_);
    }

    public static void v(C1016d c1016d, int i) {
        com.google.protobuf.L l6 = c1016d.values_;
        if (!((AbstractC0452b) l6).f5706a) {
            c1016d.values_ = com.google.protobuf.E.n(l6);
        }
        c1016d.values_.remove(i);
    }

    public static C1016d w() {
        return DEFAULT_INSTANCE;
    }

    public static C1014c z() {
        return (C1014c) DEFAULT_INSTANCE.g();
    }

    @Override // s3.InterfaceC1018e
    public final List a() {
        return this.values_;
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
                return new C0483q0(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"values_", I0.class});
            case 3:
                return new C1016d();
            case 4:
                return new C1014c(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0475m0 interfaceC0475m0 = PARSER;
                if (interfaceC0475m0 != null) {
                    return interfaceC0475m0;
                }
                synchronized (C1016d.class) {
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

    public final I0 x(int i) {
        return (I0) this.values_.get(i);
    }

    public final int y() {
        return this.values_.size();
    }
}
