package q3;

import S.i;
import com.google.protobuf.C0483q0;
import com.google.protobuf.D;
import com.google.protobuf.E;
import com.google.protobuf.InterfaceC0475m0;

/* JADX INFO: renamed from: q3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0941e extends E {
    public static final int ARRAY_CONFIG_FIELD_NUMBER = 3;
    private static final C0941e DEFAULT_INSTANCE;
    public static final int FIELD_PATH_FIELD_NUMBER = 1;
    public static final int ORDER_FIELD_NUMBER = 2;
    private static volatile InterfaceC0475m0 PARSER;
    private Object valueMode_;
    private int valueModeCase_ = 0;
    private String fieldPath_ = "";

    static {
        C0941e c0941e = new C0941e();
        DEFAULT_INSTANCE = c0941e;
        E.r(C0941e.class, c0941e);
    }

    public static void t(C0941e c0941e, String str) {
        c0941e.getClass();
        str.getClass();
        c0941e.fieldPath_ = str;
    }

    public static void u(C0941e c0941e, EnumC0940d enumC0940d) {
        c0941e.getClass();
        c0941e.valueMode_ = Integer.valueOf(enumC0940d.a());
        c0941e.valueModeCase_ = 2;
    }

    public static void v(C0941e c0941e) {
        EnumC0938b enumC0938b = EnumC0938b.CONTAINS;
        c0941e.getClass();
        c0941e.valueMode_ = Integer.valueOf(enumC0938b.a());
        c0941e.valueModeCase_ = 3;
    }

    public static C0939c z() {
        return (C0939c) DEFAULT_INSTANCE.g();
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
                return new C0483q0(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003?\u0000", new Object[]{"valueMode_", "valueModeCase_", "fieldPath_"});
            case 3:
                return new C0941e();
            case 4:
                return new C0939c(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0475m0 interfaceC0475m0 = PARSER;
                if (interfaceC0475m0 != null) {
                    return interfaceC0475m0;
                }
                synchronized (C0941e.class) {
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

    public final String w() {
        return this.fieldPath_;
    }

    public final EnumC0940d x() {
        int i = this.valueModeCase_;
        EnumC0940d enumC0940d = EnumC0940d.ORDER_UNSPECIFIED;
        if (i == 2) {
            int iIntValue = ((Integer) this.valueMode_).intValue();
            if (iIntValue != 0) {
                enumC0940d = iIntValue != 1 ? iIntValue != 2 ? null : EnumC0940d.DESCENDING : EnumC0940d.ASCENDING;
            }
            if (enumC0940d == null) {
                return EnumC0940d.UNRECOGNIZED;
            }
        }
        return enumC0940d;
    }

    public final int y() {
        int i = this.valueModeCase_;
        if (i == 0) {
            return 3;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }
}
