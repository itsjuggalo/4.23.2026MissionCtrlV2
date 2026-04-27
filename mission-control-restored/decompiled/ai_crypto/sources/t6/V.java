package t6;

import p6.i;
import p6.j;
import u6.h;

/* JADX INFO: loaded from: classes2.dex */
public final class V implements u6.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f24275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24276b;

    public V(boolean z7, String discriminator) {
        kotlin.jvm.internal.r.f(discriminator, "discriminator");
        this.f24275a = z7;
        this.f24276b = discriminator;
    }

    @Override // u6.h
    public void a(X5.c baseClass, Q5.k defaultSerializerProvider) {
        kotlin.jvm.internal.r.f(baseClass, "baseClass");
        kotlin.jvm.internal.r.f(defaultSerializerProvider, "defaultSerializerProvider");
    }

    @Override // u6.h
    public void b(X5.c baseClass, Q5.k defaultDeserializerProvider) {
        kotlin.jvm.internal.r.f(baseClass, "baseClass");
        kotlin.jvm.internal.r.f(defaultDeserializerProvider, "defaultDeserializerProvider");
    }

    @Override // u6.h
    public void c(X5.c kClass, Q5.k provider) {
        kotlin.jvm.internal.r.f(kClass, "kClass");
        kotlin.jvm.internal.r.f(provider, "provider");
    }

    @Override // u6.h
    public void d(X5.c baseClass, X5.c actualClass, n6.b actualSerializer) {
        kotlin.jvm.internal.r.f(baseClass, "baseClass");
        kotlin.jvm.internal.r.f(actualClass, "actualClass");
        kotlin.jvm.internal.r.f(actualSerializer, "actualSerializer");
        p6.e descriptor = actualSerializer.getDescriptor();
        g(descriptor, actualClass);
        if (this.f24275a) {
            return;
        }
        f(descriptor, actualClass);
    }

    @Override // u6.h
    public void e(X5.c cVar, n6.b bVar) {
        h.a.a(this, cVar, bVar);
    }

    public final void f(p6.e eVar, X5.c cVar) {
        int iF = eVar.f();
        for (int i7 = 0; i7 < iF; i7++) {
            String strG = eVar.g(i7);
            if (kotlin.jvm.internal.r.b(strG, this.f24276b)) {
                throw new IllegalArgumentException("Polymorphic serializer for " + cVar + " has property '" + strG + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }

    public final void g(p6.e eVar, X5.c cVar) {
        p6.i iVarE = eVar.e();
        if ((iVarE instanceof p6.c) || kotlin.jvm.internal.r.b(iVarE, i.a.f22092a)) {
            throw new IllegalArgumentException("Serializer for " + cVar.c() + " can't be registered as a subclass for polymorphic serialization because its kind " + iVarE + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (this.f24275a) {
            return;
        }
        if (kotlin.jvm.internal.r.b(iVarE, j.b.f22095a) || kotlin.jvm.internal.r.b(iVarE, j.c.f22096a) || (iVarE instanceof p6.d) || (iVarE instanceof i.b)) {
            throw new IllegalArgumentException("Serializer for " + cVar.c() + " of kind " + iVarE + " cannot be serialized polymorphically with class discriminator.");
        }
    }
}
