package W2;

import W2.p;
import a3.AbstractC0786b;
import a3.AbstractC0787c;
import b3.AbstractC0863a;
import kotlin.jvm.internal.K;

/* JADX INFO: renamed from: W2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0736d extends AbstractC0735c implements Z2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i3.p f5468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Z2.e f5470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5471d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0736d(i3.p block, Object obj) {
        super(null);
        kotlin.jvm.internal.r.f(block, "block");
        this.f5468a = block;
        this.f5469b = obj;
        kotlin.jvm.internal.r.d(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f5470c = this;
        this.f5471d = AbstractC0734b.f5467a;
    }

    @Override // W2.AbstractC0735c
    public Object a(Object obj, Z2.e eVar) {
        kotlin.jvm.internal.r.d(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f5470c = eVar;
        this.f5469b = obj;
        Object objE = AbstractC0787c.e();
        if (objE == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objE;
    }

    public final Object b() throws Throwable {
        while (true) {
            Object obj = this.f5471d;
            Z2.e eVar = this.f5470c;
            if (eVar == null) {
                q.b(obj);
                return obj;
            }
            if (p.d(AbstractC0734b.f5467a, obj)) {
                try {
                    i3.p pVar = this.f5468a;
                    Object obj2 = this.f5469b;
                    Object objD = !(pVar instanceof AbstractC0863a) ? AbstractC0786b.d(pVar, this, obj2, eVar) : ((i3.p) K.b(pVar, 3)).invoke(this, obj2, eVar);
                    if (objD != AbstractC0787c.e()) {
                        eVar.resumeWith(p.b(objD));
                    }
                } catch (Throwable th) {
                    p.a aVar = p.f5487b;
                    eVar.resumeWith(p.b(q.a(th)));
                }
            } else {
                this.f5471d = AbstractC0734b.f5467a;
                eVar.resumeWith(obj);
            }
        }
    }

    @Override // Z2.e
    public Z2.i getContext() {
        return Z2.j.f6012a;
    }

    @Override // Z2.e
    public void resumeWith(Object obj) {
        this.f5470c = null;
        this.f5471d = obj;
    }
}
