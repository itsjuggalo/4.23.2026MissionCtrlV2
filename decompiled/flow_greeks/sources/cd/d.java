package cd;

import cd.r;
import kotlin.jvm.internal.t0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends c implements gd.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pd.p f3841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f3842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gd.e f3843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f3844d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(pd.p block, Object obj) {
        super(null);
        kotlin.jvm.internal.t.f(block, "block");
        this.f3841a = block;
        this.f3842b = obj;
        kotlin.jvm.internal.t.d(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f3843c = this;
        this.f3844d = b.f3835a;
    }

    @Override // cd.c
    public Object a(Object obj, gd.e eVar) {
        kotlin.jvm.internal.t.d(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f3843c = eVar;
        this.f3842b = obj;
        Object objF = hd.c.f();
        if (objF == hd.c.f()) {
            id.h.c(eVar);
        }
        return objF;
    }

    public final Object b() throws Throwable {
        while (true) {
            Object obj = this.f3844d;
            gd.e eVar = this.f3843c;
            if (eVar == null) {
                s.b(obj);
                return obj;
            }
            if (r.d(b.f3835a, obj)) {
                try {
                    pd.p pVar = this.f3841a;
                    Object obj2 = this.f3842b;
                    Object objE = !(pVar instanceof id.a) ? hd.b.e(pVar, this, obj2, eVar) : ((pd.p) t0.c(pVar, 3)).invoke(this, obj2, eVar);
                    if (objE != hd.c.f()) {
                        eVar.resumeWith(r.b(objE));
                    }
                } catch (Throwable th) {
                    r.a aVar = r.f3870b;
                    eVar.resumeWith(r.b(s.a(th)));
                }
            } else {
                this.f3844d = b.f3835a;
                eVar.resumeWith(obj);
            }
        }
    }

    @Override // gd.e
    public gd.i getContext() {
        return gd.j.f10531a;
    }

    @Override // gd.e
    public void resumeWith(Object obj) {
        this.f3843c = null;
        this.f3844d = obj;
    }
}
