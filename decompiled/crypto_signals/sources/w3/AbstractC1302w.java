package w3;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import t2.u0;
import y3.AbstractC1430c;

/* JADX INFO: renamed from: w3.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1302w extends t3.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1304y f10821a;

    public AbstractC1302w(C1304y c1304y) {
        this.f10821a = c1304y;
    }

    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        if (aVar.B() == 9) {
            aVar.x();
            return null;
        }
        Object objD = d();
        Map map = this.f10821a.f10824a;
        try {
            aVar.f();
            while (aVar.o()) {
                C1301v c1301v = (C1301v) map.get(aVar.v());
                if (c1301v == null) {
                    aVar.H();
                } else {
                    f(objD, aVar, c1301v);
                }
            }
            aVar.j();
            return e(objD);
        } catch (IllegalAccessException e) {
            u0 u0Var = AbstractC1430c.f11662a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.12.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
        } catch (IllegalStateException e2) {
            throw new t3.i(e2);
        }
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.m();
            return;
        }
        bVar.g();
        try {
            Iterator it = this.f10821a.f10825b.iterator();
            while (it.hasNext()) {
                ((C1301v) it.next()).a(bVar, obj);
            }
            bVar.j();
        } catch (IllegalAccessException e) {
            u0 u0Var = AbstractC1430c.f11662a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.12.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
        }
    }

    public abstract Object d();

    public abstract Object e(Object obj);

    public abstract void f(Object obj, B3.a aVar, C1301v c1301v);
}
