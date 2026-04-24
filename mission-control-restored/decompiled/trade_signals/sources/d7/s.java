package d7;

import Y6.E0;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f17076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final E0 f17077b;

    static {
        s sVar = new s();
        f17076a = sVar;
        E.f("kotlinx.coroutines.fast.service.loader", true);
        f17077b = sVar.a();
    }

    public final E0 a() {
        Object next;
        E0 e0E;
        try {
            List listJ = U6.r.J(U6.o.e(ServiceLoader.load(r.class, r.class.getClassLoader()).iterator()));
            Iterator it = listJ.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iC = ((r) next).c();
                    do {
                        Object next2 = it.next();
                        int iC2 = ((r) next2).c();
                        if (iC < iC2) {
                            next = next2;
                            iC = iC2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            r rVar = (r) next;
            if (rVar != null && (e0E = t.e(rVar, listJ)) != null) {
                return e0E;
            }
            return t.b(null, null, 3, null);
        } catch (Throwable th) {
            return t.b(th, null, 2, null);
        }
    }
}
