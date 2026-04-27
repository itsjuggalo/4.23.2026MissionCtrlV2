package y3;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import t3.I0;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f16014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final I0 f16015b;

    static {
        u uVar = new u();
        f16014a = uVar;
        G.f("kotlinx.coroutines.fast.service.loader", true);
        f16015b = uVar.a();
    }

    public final I0 a() {
        Object next;
        I0 i0E;
        try {
            List listK = q3.l.k(q3.j.c(ServiceLoader.load(t.class, t.class.getClassLoader()).iterator()));
            Iterator it = listK.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iC = ((t) next).c();
                    do {
                        Object next2 = it.next();
                        int iC2 = ((t) next2).c();
                        if (iC < iC2) {
                            next = next2;
                            iC = iC2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            t tVar = (t) next;
            if (tVar != null && (i0E = v.e(tVar, listK)) != null) {
                return i0E;
            }
            return v.b(null, null, 3, null);
        } catch (Throwable th) {
            return v.b(th, null, 2, null);
        }
    }
}
