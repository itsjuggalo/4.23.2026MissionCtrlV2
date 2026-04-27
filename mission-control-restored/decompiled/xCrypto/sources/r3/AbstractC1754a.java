package r3;

import o3.C1676g;

/* JADX INFO: renamed from: r3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1754a {
    public static int a(int i4) {
        if (2 <= i4 && i4 < 37) {
            return i4;
        }
        throw new IllegalArgumentException("radix " + i4 + " was not in valid range " + new C1676g(2, 36));
    }

    public static final int b(char c4, int i4) {
        return Character.digit((int) c4, i4);
    }

    public static final boolean c(char c4) {
        return Character.isWhitespace(c4) || Character.isSpaceChar(c4);
    }
}
