package H3;

import H3.j;
import J3.i0;
import W2.E;
import X2.AbstractC0765l;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    public static final class a extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f763a = new a();

        public a() {
            super(1);
        }

        public final void invoke(H3.a aVar) {
            r.f(aVar, "$this$null");
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((H3.a) obj);
            return E.f5463a;
        }
    }

    public static final e a(String serialName, d kind) {
        r.f(serialName, "serialName");
        r.f(kind, "kind");
        if (AbstractC1753A.U(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        return i0.a(serialName, kind);
    }

    public static final e b(String serialName, e[] typeParameters, k builderAction) {
        r.f(serialName, "serialName");
        r.f(typeParameters, "typeParameters");
        r.f(builderAction, "builderAction");
        if (AbstractC1753A.U(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        H3.a aVar = new H3.a(serialName);
        builderAction.invoke(aVar);
        return new f(serialName, j.a.f766a, aVar.f().size(), AbstractC0765l.j0(typeParameters), aVar);
    }

    public static final e c(String serialName, i kind, e[] typeParameters, k builder) {
        r.f(serialName, "serialName");
        r.f(kind, "kind");
        r.f(typeParameters, "typeParameters");
        r.f(builder, "builder");
        if (AbstractC1753A.U(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (r.b(kind, j.a.f766a)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        H3.a aVar = new H3.a(serialName);
        builder.invoke(aVar);
        return new f(serialName, kind, aVar.f().size(), AbstractC0765l.j0(typeParameters), aVar);
    }

    public static /* synthetic */ e d(String str, i iVar, e[] eVarArr, k kVar, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            kVar = a.f763a;
        }
        return c(str, iVar, eVarArr, kVar);
    }
}
