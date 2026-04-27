package O;

import a.AbstractC0284a;

/* JADX INFO: renamed from: O.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0195s extends K4.j implements R4.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2282a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2284c;

    public /* synthetic */ C0195s(int i, I4.d dVar) {
        super(i, dVar);
    }

    @Override // R4.q
    public final Object b(Object obj, Object obj2, Object obj3) {
        switch (this.f2282a) {
            case 0:
                return new C0195s((S) this.f2284c, (I4.d) obj3).invokeSuspend(G4.l.f540a);
            default:
                ((Boolean) obj2).getClass();
                C0195s c0195s = new C0195s(3, (I4.d) obj3);
                c0195s.f2284c = (s0) obj;
                return c0195s.invokeSuspend(G4.l.f540a);
        }
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f2282a) {
            case 0:
                J4.a aVar = J4.a.f791a;
                int i = this.f2283b;
                if (i == 0) {
                    AbstractC0284a.E(obj);
                    this.f2283b = 1;
                    if (S.b((S) this.f2284c, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC0284a.E(obj);
                }
                return G4.l.f540a;
            default:
                J4.a aVar2 = J4.a.f791a;
                int i6 = this.f2283b;
                if (i6 != 0) {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC0284a.E(obj);
                    return obj;
                }
                AbstractC0284a.E(obj);
                s0 s0Var = (s0) this.f2284c;
                this.f2283b = 1;
                Object objB = s0Var.b(this);
                return objB == aVar2 ? aVar2 : objB;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0195s(S s6, I4.d dVar) {
        super(3, dVar);
        this.f2284c = s6;
    }
}
