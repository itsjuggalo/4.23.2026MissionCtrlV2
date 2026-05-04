package fh;

import bh.l;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9625a;

        static {
            int[] iArr = new int[eh.a.values().length];
            try {
                iArr[eh.a.f8965a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[eh.a.f8967c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[eh.a.f8966b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f9625a = iArr;
        }
    }

    public static final void b(bh.l kind) {
        kotlin.jvm.internal.t.f(kind, "kind");
        if (kind instanceof l.b) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        }
        if (kind instanceof bh.d) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        }
        if (kind instanceof bh.c) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself");
        }
    }

    public static final String c(bh.e eVar, eh.b json) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        kotlin.jvm.internal.t.f(json, "json");
        for (Annotation annotation : eVar.getAnnotations()) {
            if (annotation instanceof eh.f) {
                return ((eh.f) annotation).discriminator();
            }
        }
        return json.f().e();
    }

    public static final void d(zg.k kVar, zg.k kVar2, String str) {
        if ((kVar instanceof zg.h) && dh.k0.a(kVar2.getDescriptor()).contains(str)) {
            String strI = ((zg.h) kVar).getDescriptor().i();
            throw new IllegalStateException(("Sealed class '" + kVar2.getDescriptor().i() + "' cannot be serialized as base class '" + strI + "' because it has property name that conflicts with JSON class discriminator '" + str + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
        }
    }
}
