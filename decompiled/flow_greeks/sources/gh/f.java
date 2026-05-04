package gh;

import dd.q0;
import dh.c1;
import gh.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.t;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f10781a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f10782b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f10783c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f10784d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f10785e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10786f;

    public static /* synthetic */ void j(f fVar, wd.d dVar, wd.d dVar2, zg.b bVar, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        fVar.i(dVar, dVar2, bVar, z10);
    }

    public static /* synthetic */ void l(f fVar, wd.d dVar, a aVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        fVar.k(dVar, aVar, z10);
    }

    @Override // gh.i
    public void a(wd.d baseClass, wd.d actualClass, zg.b actualSerializer) {
        t.f(baseClass, "baseClass");
        t.f(actualClass, "actualClass");
        t.f(actualSerializer, "actualSerializer");
        j(this, baseClass, actualClass, actualSerializer, false, 8, null);
    }

    @Override // gh.i
    public void b(wd.d kClass, zg.b serializer) {
        t.f(kClass, "kClass");
        t.f(serializer, "serializer");
        l(this, kClass, new a.C0195a(serializer), false, 4, null);
    }

    @Override // gh.i
    public void c(wd.d baseClass, k defaultSerializerProvider) {
        t.f(baseClass, "baseClass");
        t.f(defaultSerializerProvider, "defaultSerializerProvider");
        h(baseClass, defaultSerializerProvider, false);
    }

    @Override // gh.i
    public void d(wd.d kClass, k provider) {
        t.f(kClass, "kClass");
        t.f(provider, "provider");
        l(this, kClass, new a.b(provider), false, 4, null);
    }

    @Override // gh.i
    public void e(wd.d baseClass, k defaultDeserializerProvider) {
        t.f(baseClass, "baseClass");
        t.f(defaultDeserializerProvider, "defaultDeserializerProvider");
        g(baseClass, defaultDeserializerProvider, false);
    }

    public final e f() {
        return new c(this.f10781a, this.f10782b, this.f10783c, this.f10784d, this.f10785e, this.f10786f);
    }

    public final void g(wd.d baseClass, k defaultDeserializerProvider, boolean z10) {
        t.f(baseClass, "baseClass");
        t.f(defaultDeserializerProvider, "defaultDeserializerProvider");
        k kVar = (k) this.f10785e.get(baseClass);
        if (kVar == null || t.b(kVar, defaultDeserializerProvider) || z10) {
            this.f10785e.put(baseClass, defaultDeserializerProvider);
            return;
        }
        throw new IllegalArgumentException("Default deserializers provider for " + baseClass + " is already registered: " + kVar);
    }

    public final void h(wd.d baseClass, k defaultSerializerProvider, boolean z10) {
        t.f(baseClass, "baseClass");
        t.f(defaultSerializerProvider, "defaultSerializerProvider");
        k kVar = (k) this.f10783c.get(baseClass);
        if (kVar == null || t.b(kVar, defaultSerializerProvider) || z10) {
            this.f10783c.put(baseClass, defaultSerializerProvider);
            return;
        }
        throw new IllegalArgumentException("Default serializers provider for " + baseClass + " is already registered: " + kVar);
    }

    public final void i(wd.d baseClass, wd.d concreteClass, zg.b concreteSerializer, boolean z10) {
        Object next;
        t.f(baseClass, "baseClass");
        t.f(concreteClass, "concreteClass");
        t.f(concreteSerializer, "concreteSerializer");
        String strI = concreteSerializer.getDescriptor().i();
        Map map = this.f10782b;
        Object map2 = map.get(baseClass);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(baseClass, map2);
        }
        Map map3 = (Map) map2;
        zg.b bVar = (zg.b) map3.get(concreteClass);
        Map map4 = this.f10784d;
        Object map5 = map4.get(baseClass);
        if (map5 == null) {
            map5 = new HashMap();
            map4.put(baseClass, map5);
        }
        Map map6 = (Map) map5;
        if (z10) {
            if (bVar != null) {
                map6.remove(bVar.getDescriptor().i());
            }
            map3.put(concreteClass, concreteSerializer);
            map6.put(strI, concreteSerializer);
            return;
        }
        if (bVar != null) {
            if (!t.b(bVar, concreteSerializer)) {
                throw new d(baseClass, concreteClass);
            }
        }
        zg.b bVar2 = (zg.b) map6.get(strI);
        if (bVar2 == null) {
            map3.put(concreteClass, concreteSerializer);
            map6.put(strI, concreteSerializer);
            return;
        }
        Object obj = this.f10782b.get(baseClass);
        t.c(obj);
        Iterator it = q0.A((Map) obj).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Map.Entry) next).getValue() == bVar2) {
                    break;
                }
            }
        }
        throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + baseClass + "' have the same serial name '" + strI + "': '" + concreteClass + "' and '" + ((Map.Entry) next) + '\'');
    }

    public final void k(wd.d forClass, a provider, boolean z10) {
        a aVar;
        t.f(forClass, "forClass");
        t.f(provider, "provider");
        if (z10 || (aVar = (a) this.f10781a.get(forClass)) == null || t.b(aVar, provider)) {
            this.f10781a.put(forClass, provider);
            if (c1.b(forClass)) {
                this.f10786f = true;
                return;
            }
            return;
        }
        throw new d("Contextual serializer or serializer provider for " + forClass + " already registered in this module");
    }
}
