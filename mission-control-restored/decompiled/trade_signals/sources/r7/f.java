package r7;

import B5.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import o7.AbstractC2500d0;
import p5.O;
import r7.a;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f22933a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f22934b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f22935c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f22936d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f22937e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f22938f;

    public static /* synthetic */ void j(f fVar, I5.d dVar, I5.d dVar2, k7.b bVar, boolean z7, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            z7 = false;
        }
        fVar.i(dVar, dVar2, bVar, z7);
    }

    public static /* synthetic */ void l(f fVar, I5.d dVar, a aVar, boolean z7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        fVar.k(dVar, aVar, z7);
    }

    @Override // r7.i
    public void a(I5.d baseClass, k defaultDeserializerProvider) {
        AbstractC2304t.f(baseClass, "baseClass");
        AbstractC2304t.f(defaultDeserializerProvider, "defaultDeserializerProvider");
        g(baseClass, defaultDeserializerProvider, false);
    }

    @Override // r7.i
    public void b(I5.d kClass, k7.b serializer) {
        AbstractC2304t.f(kClass, "kClass");
        AbstractC2304t.f(serializer, "serializer");
        l(this, kClass, new a.C0393a(serializer), false, 4, null);
    }

    @Override // r7.i
    public void c(I5.d kClass, k provider) {
        AbstractC2304t.f(kClass, "kClass");
        AbstractC2304t.f(provider, "provider");
        l(this, kClass, new a.b(provider), false, 4, null);
    }

    @Override // r7.i
    public void d(I5.d baseClass, k defaultSerializerProvider) {
        AbstractC2304t.f(baseClass, "baseClass");
        AbstractC2304t.f(defaultSerializerProvider, "defaultSerializerProvider");
        h(baseClass, defaultSerializerProvider, false);
    }

    @Override // r7.i
    public void e(I5.d baseClass, I5.d actualClass, k7.b actualSerializer) {
        AbstractC2304t.f(baseClass, "baseClass");
        AbstractC2304t.f(actualClass, "actualClass");
        AbstractC2304t.f(actualSerializer, "actualSerializer");
        j(this, baseClass, actualClass, actualSerializer, false, 8, null);
    }

    public final e f() {
        return new c(this.f22933a, this.f22934b, this.f22935c, this.f22936d, this.f22937e, this.f22938f);
    }

    public final void g(I5.d baseClass, k defaultDeserializerProvider, boolean z7) {
        AbstractC2304t.f(baseClass, "baseClass");
        AbstractC2304t.f(defaultDeserializerProvider, "defaultDeserializerProvider");
        k kVar = (k) this.f22937e.get(baseClass);
        if (kVar == null || AbstractC2304t.b(kVar, defaultDeserializerProvider) || z7) {
            this.f22937e.put(baseClass, defaultDeserializerProvider);
            return;
        }
        throw new IllegalArgumentException("Default deserializers provider for " + baseClass + " is already registered: " + kVar);
    }

    public final void h(I5.d baseClass, k defaultSerializerProvider, boolean z7) {
        AbstractC2304t.f(baseClass, "baseClass");
        AbstractC2304t.f(defaultSerializerProvider, "defaultSerializerProvider");
        k kVar = (k) this.f22935c.get(baseClass);
        if (kVar == null || AbstractC2304t.b(kVar, defaultSerializerProvider) || z7) {
            this.f22935c.put(baseClass, defaultSerializerProvider);
            return;
        }
        throw new IllegalArgumentException("Default serializers provider for " + baseClass + " is already registered: " + kVar);
    }

    public final void i(I5.d baseClass, I5.d concreteClass, k7.b concreteSerializer, boolean z7) {
        Object next;
        AbstractC2304t.f(baseClass, "baseClass");
        AbstractC2304t.f(concreteClass, "concreteClass");
        AbstractC2304t.f(concreteSerializer, "concreteSerializer");
        String strA = concreteSerializer.getDescriptor().a();
        Map map = this.f22934b;
        Object map2 = map.get(baseClass);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(baseClass, map2);
        }
        Map map3 = (Map) map2;
        k7.b bVar = (k7.b) map3.get(concreteClass);
        Map map4 = this.f22936d;
        Object map5 = map4.get(baseClass);
        if (map5 == null) {
            map5 = new HashMap();
            map4.put(baseClass, map5);
        }
        Map map6 = (Map) map5;
        if (!z7) {
            if (bVar != null) {
                if (!AbstractC2304t.b(bVar, concreteSerializer)) {
                    throw new d(baseClass, concreteClass);
                }
            }
            k7.b bVar2 = (k7.b) map6.get(strA);
            if (bVar2 != null) {
                Object obj = this.f22934b.get(baseClass);
                AbstractC2304t.c(obj);
                Iterator it = O.z((Map) obj).iterator();
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
        } else if (bVar != null) {
            map6.remove(bVar.getDescriptor().a());
        }
        map3.put(concreteClass, concreteSerializer);
        map6.put(strA, concreteSerializer);
    }

    public final void k(I5.d forClass, a provider, boolean z7) {
        a aVar;
        AbstractC2304t.f(forClass, "forClass");
        AbstractC2304t.f(provider, "provider");
        if (z7 || (aVar = (a) this.f22933a.get(forClass)) == null || AbstractC2304t.b(aVar, provider)) {
            this.f22933a.put(forClass, provider);
            if (AbstractC2500d0.b(forClass)) {
                this.f22938f = true;
                return;
            }
            return;
        }
        throw new d("Contextual serializer or serializer provider for " + forClass + " already registered in this module");
    }
}
