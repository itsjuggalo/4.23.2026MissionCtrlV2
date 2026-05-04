package ke;

import dd.a0;
import dd.q;
import ef.b;
import ie.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.t;
import xe.n;
import xe.w;
import xe.x;
import ye.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f14825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f14826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f14827c;

    public a(n resolver, g kotlinClassFinder) {
        t.f(resolver, "resolver");
        t.f(kotlinClassFinder, "kotlinClassFinder");
        this.f14825a = resolver;
        this.f14826b = kotlinClassFinder;
        this.f14827c = new ConcurrentHashMap();
    }

    public final qf.k a(f fileClass) {
        Collection collectionE;
        t.f(fileClass, "fileClass");
        ConcurrentHashMap concurrentHashMap = this.f14827c;
        ef.b bVarG = fileClass.g();
        Object obj = concurrentHashMap.get(bVarG);
        if (obj == null) {
            ef.c cVarF = fileClass.g().f();
            if (fileClass.b().c() == a.EnumC0469a.f25375h) {
                List<String> listF = fileClass.b().f();
                collectionE = new ArrayList();
                for (String str : listF) {
                    b.a aVar = ef.b.f8779d;
                    ef.c cVarE = of.d.d(str).e();
                    t.e(cVarE, "getFqNameForTopLevelClassMaybeWithDollars(...)");
                    x xVarA = w.a(this.f14826b, aVar.c(cVarE), hg.c.a(this.f14825a.f().g()));
                    if (xVarA != null) {
                        collectionE.add(xVarA);
                    }
                }
            } else {
                collectionE = q.e(fileClass);
            }
            p pVar = new p(this.f14825a.f().q(), cVarF);
            ArrayList arrayList = new ArrayList();
            Iterator it = collectionE.iterator();
            while (it.hasNext()) {
                qf.k kVarC = this.f14825a.c(pVar, (x) it.next());
                if (kVarC != null) {
                    arrayList.add(kVarC);
                }
            }
            List listI0 = a0.I0(arrayList);
            qf.k kVarA = qf.b.f19040d.a("package " + cVarF + " (" + fileClass + ')', listI0);
            Object objPutIfAbsent = concurrentHashMap.putIfAbsent(bVarG, kVarA);
            obj = objPutIfAbsent == null ? kVarA : objPutIfAbsent;
        }
        t.e(obj, "getOrPut(...)");
        return (qf.k) obj;
    }
}
