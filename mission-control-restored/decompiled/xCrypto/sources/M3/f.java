package M3;

import M3.a;
import X2.N;
import i3.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.r;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2693a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f2694b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f2695c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f2696d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f2697e = new HashMap();

    public static /* synthetic */ void j(f fVar, InterfaceC1716c interfaceC1716c, InterfaceC1716c interfaceC1716c2, F3.b bVar, boolean z4, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            z4 = false;
        }
        fVar.i(interfaceC1716c, interfaceC1716c2, bVar, z4);
    }

    public static /* synthetic */ void l(f fVar, InterfaceC1716c interfaceC1716c, a aVar, boolean z4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        fVar.k(interfaceC1716c, aVar, z4);
    }

    @Override // M3.h
    public void a(InterfaceC1716c kClass, F3.b serializer) {
        r.f(kClass, "kClass");
        r.f(serializer, "serializer");
        l(this, kClass, new a.C0047a(serializer), false, 4, null);
    }

    @Override // M3.h
    public void b(InterfaceC1716c baseClass, k defaultSerializerProvider) {
        r.f(baseClass, "baseClass");
        r.f(defaultSerializerProvider, "defaultSerializerProvider");
        h(baseClass, defaultSerializerProvider, false);
    }

    @Override // M3.h
    public void c(InterfaceC1716c baseClass, InterfaceC1716c actualClass, F3.b actualSerializer) {
        r.f(baseClass, "baseClass");
        r.f(actualClass, "actualClass");
        r.f(actualSerializer, "actualSerializer");
        j(this, baseClass, actualClass, actualSerializer, false, 8, null);
    }

    @Override // M3.h
    public void d(InterfaceC1716c kClass, k provider) {
        r.f(kClass, "kClass");
        r.f(provider, "provider");
        l(this, kClass, new a.b(provider), false, 4, null);
    }

    @Override // M3.h
    public void e(InterfaceC1716c baseClass, k defaultDeserializerProvider) {
        r.f(baseClass, "baseClass");
        r.f(defaultDeserializerProvider, "defaultDeserializerProvider");
        g(baseClass, defaultDeserializerProvider, false);
    }

    public final e f() {
        return new c(this.f2693a, this.f2694b, this.f2695c, this.f2696d, this.f2697e);
    }

    public final void g(InterfaceC1716c baseClass, k defaultDeserializerProvider, boolean z4) {
        r.f(baseClass, "baseClass");
        r.f(defaultDeserializerProvider, "defaultDeserializerProvider");
        k kVar = (k) this.f2697e.get(baseClass);
        if (kVar == null || r.b(kVar, defaultDeserializerProvider) || z4) {
            this.f2697e.put(baseClass, defaultDeserializerProvider);
            return;
        }
        throw new IllegalArgumentException("Default deserializers provider for " + baseClass + " is already registered: " + kVar);
    }

    public final void h(InterfaceC1716c baseClass, k defaultSerializerProvider, boolean z4) {
        r.f(baseClass, "baseClass");
        r.f(defaultSerializerProvider, "defaultSerializerProvider");
        k kVar = (k) this.f2695c.get(baseClass);
        if (kVar == null || r.b(kVar, defaultSerializerProvider) || z4) {
            this.f2695c.put(baseClass, defaultSerializerProvider);
            return;
        }
        throw new IllegalArgumentException("Default serializers provider for " + baseClass + " is already registered: " + kVar);
    }

    public final void i(InterfaceC1716c baseClass, InterfaceC1716c concreteClass, F3.b concreteSerializer, boolean z4) {
        Object next;
        r.f(baseClass, "baseClass");
        r.f(concreteClass, "concreteClass");
        r.f(concreteSerializer, "concreteSerializer");
        String strA = concreteSerializer.getDescriptor().a();
        Map map = this.f2694b;
        Object map2 = map.get(baseClass);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(baseClass, map2);
        }
        Map map3 = (Map) map2;
        F3.b bVar = (F3.b) map3.get(concreteClass);
        Map map4 = this.f2696d;
        Object map5 = map4.get(baseClass);
        if (map5 == null) {
            map5 = new HashMap();
            map4.put(baseClass, map5);
        }
        Map map6 = (Map) map5;
        if (z4) {
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
        F3.b bVar2 = (F3.b) map6.get(strA);
        if (bVar2 == null) {
            map3.put(concreteClass, concreteSerializer);
            map6.put(strA, concreteSerializer);
            return;
        }
        Object obj = this.f2694b.get(baseClass);
        r.c(obj);
        Iterator it = N.v((Map) obj).iterator();
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

    public final void k(InterfaceC1716c forClass, a provider, boolean z4) {
        a aVar;
        r.f(forClass, "forClass");
        r.f(provider, "provider");
        if (z4 || (aVar = (a) this.f2693a.get(forClass)) == null || r.b(aVar, provider)) {
            this.f2693a.put(forClass, provider);
            return;
        }
        throw new d("Contextual serializer or serializer provider for " + forClass + " already registered in this module");
    }
}
