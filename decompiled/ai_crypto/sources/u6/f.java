package u6;

import F5.L;
import Q5.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.r;
import u6.a;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f24701a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f24702b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f24703c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f24704d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f24705e = new HashMap();

    public static /* synthetic */ void j(f fVar, X5.c cVar, X5.c cVar2, n6.b bVar, boolean z7, int i7, Object obj) {
        if ((i7 & 8) != 0) {
            z7 = false;
        }
        fVar.i(cVar, cVar2, bVar, z7);
    }

    public static /* synthetic */ void l(f fVar, X5.c cVar, a aVar, boolean z7, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            z7 = false;
        }
        fVar.k(cVar, aVar, z7);
    }

    @Override // u6.h
    public void a(X5.c baseClass, k defaultSerializerProvider) {
        r.f(baseClass, "baseClass");
        r.f(defaultSerializerProvider, "defaultSerializerProvider");
        h(baseClass, defaultSerializerProvider, false);
    }

    @Override // u6.h
    public void b(X5.c baseClass, k defaultDeserializerProvider) {
        r.f(baseClass, "baseClass");
        r.f(defaultDeserializerProvider, "defaultDeserializerProvider");
        g(baseClass, defaultDeserializerProvider, false);
    }

    @Override // u6.h
    public void c(X5.c kClass, k provider) {
        r.f(kClass, "kClass");
        r.f(provider, "provider");
        l(this, kClass, new a.b(provider), false, 4, null);
    }

    @Override // u6.h
    public void d(X5.c baseClass, X5.c actualClass, n6.b actualSerializer) {
        r.f(baseClass, "baseClass");
        r.f(actualClass, "actualClass");
        r.f(actualSerializer, "actualSerializer");
        j(this, baseClass, actualClass, actualSerializer, false, 8, null);
    }

    @Override // u6.h
    public void e(X5.c kClass, n6.b serializer) {
        r.f(kClass, "kClass");
        r.f(serializer, "serializer");
        l(this, kClass, new a.C0381a(serializer), false, 4, null);
    }

    public final e f() {
        return new c(this.f24701a, this.f24702b, this.f24703c, this.f24704d, this.f24705e);
    }

    public final void g(X5.c baseClass, k defaultDeserializerProvider, boolean z7) {
        r.f(baseClass, "baseClass");
        r.f(defaultDeserializerProvider, "defaultDeserializerProvider");
        k kVar = (k) this.f24705e.get(baseClass);
        if (kVar == null || r.b(kVar, defaultDeserializerProvider) || z7) {
            this.f24705e.put(baseClass, defaultDeserializerProvider);
            return;
        }
        throw new IllegalArgumentException("Default deserializers provider for " + baseClass + " is already registered: " + kVar);
    }

    public final void h(X5.c baseClass, k defaultSerializerProvider, boolean z7) {
        r.f(baseClass, "baseClass");
        r.f(defaultSerializerProvider, "defaultSerializerProvider");
        k kVar = (k) this.f24703c.get(baseClass);
        if (kVar == null || r.b(kVar, defaultSerializerProvider) || z7) {
            this.f24703c.put(baseClass, defaultSerializerProvider);
            return;
        }
        throw new IllegalArgumentException("Default serializers provider for " + baseClass + " is already registered: " + kVar);
    }

    public final void i(X5.c baseClass, X5.c concreteClass, n6.b concreteSerializer, boolean z7) {
        Object next;
        r.f(baseClass, "baseClass");
        r.f(concreteClass, "concreteClass");
        r.f(concreteSerializer, "concreteSerializer");
        String strA = concreteSerializer.getDescriptor().a();
        Map map = this.f24702b;
        Object map2 = map.get(baseClass);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(baseClass, map2);
        }
        Map map3 = (Map) map2;
        n6.b bVar = (n6.b) map3.get(concreteClass);
        Map map4 = this.f24704d;
        Object map5 = map4.get(baseClass);
        if (map5 == null) {
            map5 = new HashMap();
            map4.put(baseClass, map5);
        }
        Map map6 = (Map) map5;
        if (z7) {
            if (bVar != null) {
                map6.remove(bVar.getDescriptor().a());
            }
            map3.put(concreteClass, concreteSerializer);
            map6.put(strA, concreteSerializer);
            return;
        }
        if (bVar != null) {
            if (!r.b(bVar, concreteSerializer)) {
                throw new d(baseClass, concreteClass);
            }
            map6.remove(bVar.getDescriptor().a());
        }
        n6.b bVar2 = (n6.b) map6.get(strA);
        if (bVar2 == null) {
            map3.put(concreteClass, concreteSerializer);
            map6.put(strA, concreteSerializer);
            return;
        }
        Object obj = this.f24702b.get(baseClass);
        r.c(obj);
        Iterator it = L.v((Map) obj).iterator();
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
        throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + baseClass + "' have the same serial name '" + strA + "': '" + concreteClass + "' and '" + ((Map.Entry) next) + '\'');
    }

    public final void k(X5.c forClass, a provider, boolean z7) {
        a aVar;
        r.f(forClass, "forClass");
        r.f(provider, "provider");
        if (z7 || (aVar = (a) this.f24701a.get(forClass)) == null || r.b(aVar, provider)) {
            this.f24701a.put(forClass, provider);
            return;
        }
        throw new d("Contextual serializer or serializer provider for " + forClass + " already registered in this module");
    }
}
