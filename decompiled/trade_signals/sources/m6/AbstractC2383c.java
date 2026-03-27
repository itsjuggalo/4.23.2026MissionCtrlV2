package m6;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.AbstractC2304t;
import l6.m;
import o5.C2489q;
import o5.w;
import s6.C2720g;
import z5.AbstractC3014b;

/* JADX INFO: renamed from: m6.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2383c {
    public static final C2489q a(InputStream inputStream) throws IllegalAccessException, IOException, InvocationTargetException {
        m mVarX;
        AbstractC2304t.f(inputStream, "<this>");
        try {
            C2381a c2381aA = C2381a.f21477g.a(inputStream);
            if (c2381aA.h()) {
                C2720g c2720gD = C2720g.d();
                AbstractC2382b.a(c2720gD);
                mVarX = m.X(inputStream, c2720gD);
            } else {
                mVarX = null;
            }
            C2489q c2489qA = w.a(mVarX, c2381aA);
            AbstractC3014b.a(inputStream, null);
            return c2489qA;
        } finally {
        }
    }
}
