package C6;

import I6.S;

/* JADX INFO: loaded from: classes2.dex */
public class i extends a {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(S s8) {
        this(s8, null);
        if (s8 == null) {
            b(0);
        }
    }

    private static /* synthetic */ void b(int i8) {
        Object[] objArr = new Object[3];
        if (i8 != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i8 != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        return "{Transient} : " + getType();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(S s8, g gVar) {
        super(s8, gVar);
        if (s8 == null) {
            b(1);
        }
    }
}
