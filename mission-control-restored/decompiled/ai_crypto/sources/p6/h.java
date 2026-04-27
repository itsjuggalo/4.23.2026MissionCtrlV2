package p6;

import E5.E;
import F5.AbstractC0552j;
import Q5.k;
import Z5.u;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import p6.j;
import r6.i0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    public static final class a extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22091a = new a();

        public a() {
            super(1);
        }

        public final void invoke(p6.a aVar) {
            r.f(aVar, "$this$null");
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((p6.a) obj);
            return E.f1657a;
        }
    }

    public static final e a(String serialName, d kind) {
        r.f(serialName, "serialName");
        r.f(kind, "kind");
        if (u.P(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        return i0.a(serialName, kind);
    }

    public static final e b(String serialName, e[] typeParameters, k builderAction) {
        r.f(serialName, "serialName");
        r.f(typeParameters, "typeParameters");
        r.f(builderAction, "builderAction");
        if (u.P(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        p6.a aVar = new p6.a(serialName);
        builderAction.invoke(aVar);
        return new f(serialName, j.a.f22094a, aVar.f().size(), AbstractC0552j.i0(typeParameters), aVar);
    }

    public static final e c(String serialName, i kind, e[] typeParameters, k builder) {
        r.f(serialName, "serialName");
        r.f(kind, "kind");
        r.f(typeParameters, "typeParameters");
        r.f(builder, "builder");
        if (u.P(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (r.b(kind, j.a.f22094a)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        p6.a aVar = new p6.a(serialName);
        builder.invoke(aVar);
        return new f(serialName, kind, aVar.f().size(), AbstractC0552j.i0(typeParameters), aVar);
    }

    public static /* synthetic */ e d(String str, i iVar, e[] eVarArr, k kVar, int i7, Object obj) {
        if ((i7 & 8) != 0) {
            kVar = a.f22091a;
        }
        return c(str, iVar, eVarArr, kVar);
    }
}
