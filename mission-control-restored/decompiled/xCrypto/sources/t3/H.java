package t3;

import Z2.i;
import b3.InterfaceC0867e;

/* JADX INFO: loaded from: classes3.dex */
public abstract class H {

    public static final class a extends kotlin.jvm.internal.s implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14942a = new a();

        public a() {
            super(2);
        }

        @Override // i3.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Z2.i invoke(Z2.i iVar, i.b bVar) {
            return iVar.plus(bVar);
        }
    }

    public static final class b extends kotlin.jvm.internal.s implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.F f14943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f14944b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kotlin.jvm.internal.F f4, boolean z4) {
            super(2);
            this.f14943a = f4;
            this.f14944b = z4;
        }

        @Override // i3.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Z2.i invoke(Z2.i iVar, i.b bVar) {
            return iVar.plus(bVar);
        }
    }

    public static final class c extends kotlin.jvm.internal.s implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14945a = new c();

        public c() {
            super(2);
        }

        public final Boolean a(boolean z4, i.b bVar) {
            return Boolean.valueOf(z4);
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Boolean) obj).booleanValue(), (i.b) obj2);
        }
    }

    public static final Z2.i a(Z2.i iVar, Z2.i iVar2, boolean z4) {
        boolean zC = c(iVar);
        boolean zC2 = c(iVar2);
        if (!zC && !zC2) {
            return iVar.plus(iVar2);
        }
        kotlin.jvm.internal.F f4 = new kotlin.jvm.internal.F();
        f4.f13410a = iVar2;
        Z2.j jVar = Z2.j.f6012a;
        Z2.i iVar3 = (Z2.i) iVar.fold(jVar, new b(f4, z4));
        if (zC2) {
            f4.f13410a = ((Z2.i) f4.f13410a).fold(jVar, a.f14942a);
        }
        return iVar3.plus((Z2.i) f4.f13410a);
    }

    public static final String b(Z2.i iVar) {
        return null;
    }

    public static final boolean c(Z2.i iVar) {
        return ((Boolean) iVar.fold(Boolean.FALSE, c.f14945a)).booleanValue();
    }

    public static final Z2.i d(Z2.i iVar, Z2.i iVar2) {
        return !c(iVar2) ? iVar.plus(iVar2) : a(iVar, iVar2, false);
    }

    public static final Z2.i e(L l4, Z2.i iVar) {
        Z2.i iVarA = a(l4.l(), iVar, true);
        return (iVarA == C1803a0.a() || iVarA.get(Z2.f.f6010J) != null) ? iVarA : iVarA.plus(C1803a0.a());
    }

    public static final Z0 f(InterfaceC0867e interfaceC0867e) {
        while (!(interfaceC0867e instanceof X) && (interfaceC0867e = interfaceC0867e.getCallerFrame()) != null) {
            if (interfaceC0867e instanceof Z0) {
                return (Z0) interfaceC0867e;
            }
        }
        return null;
    }

    public static final Z0 g(Z2.e eVar, Z2.i iVar, Object obj) {
        if (!(eVar instanceof InterfaceC0867e) || iVar.get(a1.f14979a) == null) {
            return null;
        }
        Z0 z0F = f((InterfaceC0867e) eVar);
        if (z0F != null) {
            z0F.P0(iVar, obj);
        }
        return z0F;
    }
}
