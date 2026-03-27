package u4;

import java.nio.charset.Charset;
import java.util.BitSet;
import w4.c2;

/* JADX INFO: loaded from: classes.dex */
public abstract class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f10340a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final W1.c f10341b = Z.e;

    public static X a(String str, c2 c2Var) {
        boolean z6 = false;
        if (!str.isEmpty() && str.charAt(0) == ':') {
            z6 = true;
        }
        BitSet bitSet = W.f10367d;
        return new X(str, z6, c2Var);
    }
}
