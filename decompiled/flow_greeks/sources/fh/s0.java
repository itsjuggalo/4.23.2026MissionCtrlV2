package fh;

import bh.l;
import bh.m;
import gh.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s0 implements gh.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9629b;

    public s0(boolean z10, String discriminator) {
        kotlin.jvm.internal.t.f(discriminator, "discriminator");
        this.f9628a = z10;
        this.f9629b = discriminator;
    }

    @Override // gh.i
    public void a(wd.d baseClass, wd.d actualClass, zg.b actualSerializer) {
        kotlin.jvm.internal.t.f(baseClass, "baseClass");
        kotlin.jvm.internal.t.f(actualClass, "actualClass");
        kotlin.jvm.internal.t.f(actualSerializer, "actualSerializer");
        bh.e descriptor = actualSerializer.getDescriptor();
        g(descriptor, actualClass);
        if (this.f9628a) {
            return;
        }
        f(descriptor, actualClass);
    }

    @Override // gh.i
    public void b(wd.d dVar, zg.b bVar) {
        i.a.b(this, dVar, bVar);
    }

    @Override // gh.i
    public void c(wd.d baseClass, pd.k defaultSerializerProvider) {
        kotlin.jvm.internal.t.f(baseClass, "baseClass");
        kotlin.jvm.internal.t.f(defaultSerializerProvider, "defaultSerializerProvider");
    }

    @Override // gh.i
    public void d(wd.d kClass, pd.k provider) {
        kotlin.jvm.internal.t.f(kClass, "kClass");
        kotlin.jvm.internal.t.f(provider, "provider");
    }

    @Override // gh.i
    public void e(wd.d baseClass, pd.k defaultDeserializerProvider) {
        kotlin.jvm.internal.t.f(baseClass, "baseClass");
        kotlin.jvm.internal.t.f(defaultDeserializerProvider, "defaultDeserializerProvider");
    }

    public final void f(bh.e eVar, wd.d dVar) {
        int iL = eVar.l();
        for (int i10 = 0; i10 < iL; i10++) {
            String strM = eVar.m(i10);
            if (kotlin.jvm.internal.t.b(strM, this.f9629b)) {
                throw new IllegalArgumentException("Polymorphic serializer for " + dVar + " has property '" + strM + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }

    public final void g(bh.e eVar, wd.d dVar) {
        bh.l lVarH = eVar.h();
        if ((lVarH instanceof bh.c) || kotlin.jvm.internal.t.b(lVarH, l.a.f3400a)) {
            throw new IllegalArgumentException("Serializer for " + dVar.c() + " can't be registered as a subclass for polymorphic serialization because its kind " + lVarH + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (this.f9628a) {
            return;
        }
        if (kotlin.jvm.internal.t.b(lVarH, m.b.f3403a) || kotlin.jvm.internal.t.b(lVarH, m.c.f3404a) || (lVarH instanceof bh.d) || (lVarH instanceof l.b)) {
            throw new IllegalArgumentException("Serializer for " + dVar.c() + " of kind " + lVarH + " cannot be serialized polymorphically with class discriminator.");
        }
    }
}
