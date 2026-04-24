package w3;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: w3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1283c extends t3.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10750a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f10751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f10752c;

    public C1283c(t3.e eVar, Type type, t3.s sVar, v3.n nVar) {
        this.f10751b = new com.dexterous.flutterlocalnotifications.j(eVar, sVar, type);
        this.f10752c = nVar;
    }

    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        switch (this.f10750a) {
            case 0:
                if (aVar.B() == 9) {
                    aVar.x();
                    return null;
                }
                Collection collection = (Collection) ((v3.n) this.f10752c).b();
                aVar.d();
                while (aVar.o()) {
                    collection.add(((t3.s) ((com.dexterous.flutterlocalnotifications.j) this.f10751b).f4991c).b(aVar));
                }
                aVar.i();
                return collection;
            default:
                Object objB = ((Y) this.f10752c).f10743c.b(aVar);
                if (objB != null) {
                    Class cls = (Class) this.f10751b;
                    if (!cls.isInstance(objB)) {
                        throw new t3.i("Expected a " + cls.getName() + " but was " + objB.getClass().getName() + "; at path " + aVar.n());
                    }
                }
                return objB;
        }
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        switch (this.f10750a) {
            case 0:
                Collection collection = (Collection) obj;
                if (collection != null) {
                    bVar.f();
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        ((com.dexterous.flutterlocalnotifications.j) this.f10751b).c(bVar, it.next());
                    }
                    bVar.i();
                } else {
                    bVar.m();
                }
                break;
            default:
                ((Y) this.f10752c).f10743c.c(bVar, obj);
                break;
        }
    }

    public C1283c(Y y, Class cls) {
        this.f10752c = y;
        this.f10751b = cls;
    }
}
