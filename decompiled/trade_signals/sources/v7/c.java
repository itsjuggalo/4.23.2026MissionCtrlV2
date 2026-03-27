package v7;

import java.io.IOException;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;
import p5.C2587i;
import u7.AbstractC2817j;
import u7.M;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static final void a(AbstractC2817j abstractC2817j, M dir, boolean z7) throws IOException {
        AbstractC2304t.f(abstractC2817j, "<this>");
        AbstractC2304t.f(dir, "dir");
        C2587i c2587i = new C2587i();
        for (M mQ = dir; mQ != null && !abstractC2817j.g(mQ); mQ = mQ.q()) {
            c2587i.addFirst(mQ);
        }
        if (z7 && c2587i.isEmpty()) {
            throw new IOException(dir + " already exist.");
        }
        Iterator<E> it = c2587i.iterator();
        while (it.hasNext()) {
            abstractC2817j.c((M) it.next());
        }
    }

    public static final boolean b(AbstractC2817j abstractC2817j, M path) {
        AbstractC2304t.f(abstractC2817j, "<this>");
        AbstractC2304t.f(path, "path");
        return abstractC2817j.h(path) != null;
    }
}
