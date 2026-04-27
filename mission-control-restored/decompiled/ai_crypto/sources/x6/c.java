package x6;

import F5.C0548f;
import java.io.IOException;
import java.util.Iterator;
import kotlin.jvm.internal.r;
import w6.AbstractC2798k;
import w6.Q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static final void a(AbstractC2798k abstractC2798k, Q dir, boolean z7) throws IOException {
        r.f(abstractC2798k, "<this>");
        r.f(dir, "dir");
        C0548f c0548f = new C0548f();
        for (Q qM = dir; qM != null && !abstractC2798k.g(qM); qM = qM.m()) {
            c0548f.addFirst(qM);
        }
        if (z7 && c0548f.isEmpty()) {
            throw new IOException(dir + " already exist.");
        }
        Iterator<E> it = c0548f.iterator();
        while (it.hasNext()) {
            abstractC2798k.c((Q) it.next());
        }
    }

    public static final boolean b(AbstractC2798k abstractC2798k, Q path) {
        r.f(abstractC2798k, "<this>");
        r.f(path, "path");
        return abstractC2798k.h(path) != null;
    }
}
