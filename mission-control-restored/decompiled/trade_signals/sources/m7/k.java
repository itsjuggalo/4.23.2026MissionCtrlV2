package m7;

import V6.C;
import kotlin.jvm.internal.AbstractC2304t;
import m7.m;
import o5.C2470H;
import o7.r0;
import p5.AbstractC2592n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {
    public static final e b(String serialName, d kind) {
        AbstractC2304t.f(serialName, "serialName");
        AbstractC2304t.f(kind, "kind");
        if (!C.a0(serialName)) {
            return r0.a(serialName, kind);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final e c(String serialName, e[] typeParameters, B5.k builderAction) {
        AbstractC2304t.f(serialName, "serialName");
        AbstractC2304t.f(typeParameters, "typeParameters");
        AbstractC2304t.f(builderAction, "builderAction");
        if (!(!C.a0(serialName))) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        a aVar = new a(serialName);
        builderAction.invoke(aVar);
        return new h(serialName, m.a.f21531a, aVar.f().size(), AbstractC2592n.k0(typeParameters), aVar);
    }

    public static final e d(String serialName, l kind, e[] typeParameters, B5.k builder) {
        AbstractC2304t.f(serialName, "serialName");
        AbstractC2304t.f(kind, "kind");
        AbstractC2304t.f(typeParameters, "typeParameters");
        AbstractC2304t.f(builder, "builder");
        if (!(!C.a0(serialName))) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        if (!(!AbstractC2304t.b(kind, m.a.f21531a))) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
        }
        a aVar = new a(serialName);
        builder.invoke(aVar);
        return new h(serialName, kind, aVar.f().size(), AbstractC2592n.k0(typeParameters), aVar);
    }

    public static /* synthetic */ e e(String str, l lVar, e[] eVarArr, B5.k kVar, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            kVar = new B5.k() { // from class: m7.j
                @Override // B5.k
                public final Object invoke(Object obj2) {
                    return k.f((a) obj2);
                }
            };
        }
        return d(str, lVar, eVarArr, kVar);
    }

    public static final C2470H f(a aVar) {
        AbstractC2304t.f(aVar, "<this>");
        return C2470H.f21956a;
    }
}
