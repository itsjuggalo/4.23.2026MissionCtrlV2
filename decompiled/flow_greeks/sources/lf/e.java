package lf;

import fe.h0;
import java.util.Arrays;
import xf.c1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends r {
    public e(char c10) {
        super(Character.valueOf(c10));
    }

    public final String c(char c10) {
        switch (c10) {
            case '\b':
                return "\\b";
            case '\t':
                return "\\t";
            case '\n':
                return "\\n";
            case 11:
            default:
                return e(c10) ? String.valueOf(c10) : "?";
            case '\f':
                return "\\f";
            case '\r':
                return "\\r";
        }
    }

    @Override // lf.g
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public c1 a(h0 module) {
        kotlin.jvm.internal.t.f(module, "module");
        c1 c1VarV = module.p().v();
        kotlin.jvm.internal.t.e(c1VarV, "getCharType(...)");
        return c1VarV;
    }

    public final boolean e(char c10) {
        byte type = (byte) Character.getType(c10);
        return (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? false : true;
    }

    @Override // lf.g
    public String toString() {
        String str = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(((Character) b()).charValue()), c(((Character) b()).charValue())}, 2));
        kotlin.jvm.internal.t.e(str, "format(...)");
        return str;
    }
}
