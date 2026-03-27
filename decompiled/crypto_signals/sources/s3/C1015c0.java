package s3;

import com.google.protobuf.C0483q0;
import com.google.protobuf.InterfaceC0475m0;

/* JADX INFO: renamed from: s3.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1015c0 extends com.google.protobuf.E {
    public static final int ALL_DESCENDANTS_FIELD_NUMBER = 3;
    public static final int COLLECTION_ID_FIELD_NUMBER = 2;
    private static final C1015c0 DEFAULT_INSTANCE;
    private static volatile InterfaceC0475m0 PARSER;
    private boolean allDescendants_;
    private String collectionId_ = "";

    static {
        C1015c0 c1015c0 = new C1015c0();
        DEFAULT_INSTANCE = c1015c0;
        com.google.protobuf.E.r(C1015c0.class, c1015c0);
    }

    public static void t(C1015c0 c1015c0, String str) {
        c1015c0.getClass();
        str.getClass();
        c1015c0.collectionId_ = str;
    }

    public static void u(C1015c0 c1015c0) {
        c1015c0.allDescendants_ = true;
    }

    public static C1013b0 x() {
        return (C1013b0) DEFAULT_INSTANCE.g();
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
                return new C0483q0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002Ȉ\u0003\u0007", new Object[]{"collectionId_", "allDescendants_"});
            case 3:
                return new C1015c0();
            case 4:
                return new C1013b0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0475m0 interfaceC0475m0 = PARSER;
                if (interfaceC0475m0 != null) {
                    return interfaceC0475m0;
                }
                synchronized (C1015c0.class) {
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

    public final boolean v() {
        return this.allDescendants_;
    }

    public final String w() {
        return this.collectionId_;
    }
}
