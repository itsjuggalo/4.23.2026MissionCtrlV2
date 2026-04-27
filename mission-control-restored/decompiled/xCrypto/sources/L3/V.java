package L3;

import H3.i;
import H3.j;
import M3.h;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
public final class V implements M3.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1483b;

    public V(boolean z4, String discriminator) {
        kotlin.jvm.internal.r.f(discriminator, "discriminator");
        this.f1482a = z4;
        this.f1483b = discriminator;
    }

    @Override // M3.h
    public void a(InterfaceC1716c interfaceC1716c, F3.b bVar) {
        h.a.a(this, interfaceC1716c, bVar);
    }

    @Override // M3.h
    public void b(InterfaceC1716c baseClass, i3.k defaultSerializerProvider) {
        kotlin.jvm.internal.r.f(baseClass, "baseClass");
        kotlin.jvm.internal.r.f(defaultSerializerProvider, "defaultSerializerProvider");
    }

    @Override // M3.h
    public void c(InterfaceC1716c baseClass, InterfaceC1716c actualClass, F3.b actualSerializer) {
        kotlin.jvm.internal.r.f(baseClass, "baseClass");
        kotlin.jvm.internal.r.f(actualClass, "actualClass");
        kotlin.jvm.internal.r.f(actualSerializer, "actualSerializer");
        H3.e descriptor = actualSerializer.getDescriptor();
        g(descriptor, actualClass);
        if (this.f1482a) {
            return;
        }
        f(descriptor, actualClass);
    }

    @Override // M3.h
    public void d(InterfaceC1716c kClass, i3.k provider) {
        kotlin.jvm.internal.r.f(kClass, "kClass");
        kotlin.jvm.internal.r.f(provider, "provider");
    }

    @Override // M3.h
    public void e(InterfaceC1716c baseClass, i3.k defaultDeserializerProvider) {
        kotlin.jvm.internal.r.f(baseClass, "baseClass");
        kotlin.jvm.internal.r.f(defaultDeserializerProvider, "defaultDeserializerProvider");
    }

    public final void f(H3.e eVar, InterfaceC1716c interfaceC1716c) {
        int iF = eVar.f();
        for (int i4 = 0; i4 < iF; i4++) {
            String strG = eVar.g(i4);
            if (kotlin.jvm.internal.r.b(strG, this.f1483b)) {
                throw new IllegalArgumentException("Polymorphic serializer for " + interfaceC1716c + " has property '" + strG + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }

    public final void g(H3.e eVar, InterfaceC1716c interfaceC1716c) {
        H3.i iVarE = eVar.e();
        if ((iVarE instanceof H3.c) || kotlin.jvm.internal.r.b(iVarE, i.a.f764a)) {
            throw new IllegalArgumentException("Serializer for " + interfaceC1716c.b() + " can't be registered as a subclass for polymorphic serialization because its kind " + iVarE + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (this.f1482a) {
            return;
        }
        if (kotlin.jvm.internal.r.b(iVarE, j.b.f767a) || kotlin.jvm.internal.r.b(iVarE, j.c.f768a) || (iVarE instanceof H3.d) || (iVarE instanceof i.b)) {
            throw new IllegalArgumentException("Serializer for " + interfaceC1716c.b() + " of kind " + iVarE + " cannot be serialized polymorphically with class discriminator.");
        }
    }
}
