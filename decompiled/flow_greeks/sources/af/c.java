package af;

import cd.q;
import cd.w;
import gf.g;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.t;
import ze.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final q a(InputStream inputStream) throws IllegalAccessException, IOException, InvocationTargetException {
        m mVarW;
        t.f(inputStream, "<this>");
        try {
            a aVarA = a.f809g.a(inputStream);
            if (aVarA.h()) {
                g gVarD = g.d();
                b.a(gVarD);
                mVarW = m.W(inputStream, gVarD);
            } else {
                mVarW = null;
            }
            q qVarA = w.a(mVarW, aVarA);
            nd.b.a(inputStream, null);
            return qVarA;
        } finally {
        }
    }
}
