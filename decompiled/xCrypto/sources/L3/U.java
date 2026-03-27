package L3;

import H3.i;
import J3.AbstractC0326b;
import W2.C0739g;
import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes3.dex */
public abstract class U {
    public static final void b(H3.i kind) {
        kotlin.jvm.internal.r.f(kind, "kind");
        if (kind instanceof i.b) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        }
        if (kind instanceof H3.d) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        }
        if (kind instanceof H3.c) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself");
        }
    }

    public static final String c(H3.e eVar, K3.a json) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        kotlin.jvm.internal.r.f(json, "json");
        for (Annotation annotation : eVar.getAnnotations()) {
            if (annotation instanceof K3.e) {
                return ((K3.e) annotation).discriminator();
            }
        }
        return json.f().c();
    }

    public static final Object d(K3.g gVar, F3.a deserializer) {
        K3.w wVarO;
        kotlin.jvm.internal.r.f(gVar, "<this>");
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        if (!(deserializer instanceof AbstractC0326b) || gVar.b().f().l()) {
            return deserializer.deserialize(gVar);
        }
        String strC = c(deserializer.getDescriptor(), gVar.b());
        K3.h hVarK = gVar.k();
        H3.e descriptor = deserializer.getDescriptor();
        if (hVarK instanceof K3.u) {
            K3.u uVar = (K3.u) hVarK;
            K3.h hVar = (K3.h) uVar.get(strC);
            String strF = (hVar == null || (wVarO = K3.i.o(hVar)) == null) ? null : wVarO.f();
            F3.a aVarC = ((AbstractC0326b) deserializer).c(gVar, strF);
            if (aVarC != null) {
                return b0.b(gVar.b(), strC, uVar, aVarC);
            }
            e(strF, uVar);
            throw new C0739g();
        }
        throw E.e(-1, "Expected " + kotlin.jvm.internal.G.b(K3.u.class) + " as the serialized body of " + descriptor.a() + ", but had " + kotlin.jvm.internal.G.b(hVarK.getClass()));
    }

    public static final Void e(String str, K3.u jsonTree) {
        String str2;
        kotlin.jvm.internal.r.f(jsonTree, "jsonTree");
        if (str == null) {
            str2 = "missing class discriminator ('null')";
        } else {
            str2 = "class discriminator '" + str + '\'';
        }
        throw E.f(-1, "Polymorphic serializer was not found for " + str2, jsonTree.toString());
    }

    public static final void f(F3.h hVar, F3.h hVar2, String str) {
        if ((hVar instanceof F3.e) && J3.I.a(hVar2.getDescriptor()).contains(str)) {
            String strA = hVar.getDescriptor().a();
            throw new IllegalStateException(("Sealed class '" + hVar2.getDescriptor().a() + "' cannot be serialized as base class '" + strA + "' because it has property name that conflicts with JSON class discriminator '" + str + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
        }
    }
}
