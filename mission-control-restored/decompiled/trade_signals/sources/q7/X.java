package q7;

import kotlin.jvm.internal.AbstractC2304t;
import m7.l;
import m7.m;
import r7.i;

/* JADX INFO: loaded from: classes2.dex */
public final class X implements r7.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22837b;

    public X(boolean z7, String discriminator) {
        AbstractC2304t.f(discriminator, "discriminator");
        this.f22836a = z7;
        this.f22837b = discriminator;
    }

    @Override // r7.i
    public void a(I5.d baseClass, B5.k defaultDeserializerProvider) {
        AbstractC2304t.f(baseClass, "baseClass");
        AbstractC2304t.f(defaultDeserializerProvider, "defaultDeserializerProvider");
    }

    @Override // r7.i
    public void b(I5.d dVar, k7.b bVar) {
        i.a.b(this, dVar, bVar);
    }

    @Override // r7.i
    public void c(I5.d kClass, B5.k provider) {
        AbstractC2304t.f(kClass, "kClass");
        AbstractC2304t.f(provider, "provider");
    }

    @Override // r7.i
    public void d(I5.d baseClass, B5.k defaultSerializerProvider) {
        AbstractC2304t.f(baseClass, "baseClass");
        AbstractC2304t.f(defaultSerializerProvider, "defaultSerializerProvider");
    }

    @Override // r7.i
    public void e(I5.d baseClass, I5.d actualClass, k7.b actualSerializer) {
        AbstractC2304t.f(baseClass, "baseClass");
        AbstractC2304t.f(actualClass, "actualClass");
        AbstractC2304t.f(actualSerializer, "actualSerializer");
        m7.e descriptor = actualSerializer.getDescriptor();
        g(descriptor, actualClass);
        if (this.f22836a) {
            return;
        }
        f(descriptor, actualClass);
    }

    public final void f(m7.e eVar, I5.d dVar) {
        int iE = eVar.e();
        for (int i8 = 0; i8 < iE; i8++) {
            String strF = eVar.f(i8);
            if (AbstractC2304t.b(strF, this.f22837b)) {
                throw new IllegalArgumentException("Polymorphic serializer for " + dVar + " has property '" + strF + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }

    public final void g(m7.e eVar, I5.d dVar) {
        m7.l lVarI = eVar.i();
        if ((lVarI instanceof m7.c) || AbstractC2304t.b(lVarI, l.a.f21529a)) {
            throw new IllegalArgumentException("Serializer for " + dVar.r() + " can't be registered as a subclass for polymorphic serialization because its kind " + lVarI + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (this.f22836a) {
            return;
        }
        if (AbstractC2304t.b(lVarI, m.b.f21532a) || AbstractC2304t.b(lVarI, m.c.f21533a) || (lVarI instanceof m7.d) || (lVarI instanceof l.b)) {
            throw new IllegalArgumentException("Serializer for " + dVar.r() + " of kind " + lVarI + " cannot be serialized polymorphically with class discriminator.");
        }
    }
}
