package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f17070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f17071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pd.p f17072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f17073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f17074e;

    public b0(Object obj, m mVar, pd.p pVar, Object obj2, Throwable th) {
        this.f17070a = obj;
        this.f17071b = mVar;
        this.f17072c = pVar;
        this.f17073d = obj2;
        this.f17074e = th;
    }

    public static /* synthetic */ b0 b(b0 b0Var, Object obj, m mVar, pd.p pVar, Object obj2, Throwable th, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = b0Var.f17070a;
        }
        if ((i10 & 2) != 0) {
            mVar = b0Var.f17071b;
        }
        if ((i10 & 4) != 0) {
            pVar = b0Var.f17072c;
        }
        if ((i10 & 8) != 0) {
            obj2 = b0Var.f17073d;
        }
        if ((i10 & 16) != 0) {
            th = b0Var.f17074e;
        }
        Throwable th2 = th;
        pd.p pVar2 = pVar;
        return b0Var.a(obj, mVar, pVar2, obj2, th2);
    }

    public final b0 a(Object obj, m mVar, pd.p pVar, Object obj2, Throwable th) {
        return new b0(obj, mVar, pVar, obj2, th);
    }

    public final boolean c() {
        return this.f17074e != null;
    }

    public final void d(p pVar, Throwable th) {
        m mVar = this.f17071b;
        if (mVar != null) {
            pVar.o(mVar, th);
        }
        pd.p pVar2 = this.f17072c;
        if (pVar2 != null) {
            pVar.q(pVar2, th, this.f17070a);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return kotlin.jvm.internal.t.b(this.f17070a, b0Var.f17070a) && kotlin.jvm.internal.t.b(this.f17071b, b0Var.f17071b) && kotlin.jvm.internal.t.b(this.f17072c, b0Var.f17072c) && kotlin.jvm.internal.t.b(this.f17073d, b0Var.f17073d) && kotlin.jvm.internal.t.b(this.f17074e, b0Var.f17074e);
    }

    public int hashCode() {
        Object obj = this.f17070a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        m mVar = this.f17071b;
        int iHashCode2 = (iHashCode + (mVar == null ? 0 : mVar.hashCode())) * 31;
        pd.p pVar = this.f17072c;
        int iHashCode3 = (iHashCode2 + (pVar == null ? 0 : pVar.hashCode())) * 31;
        Object obj2 = this.f17073d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f17074e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f17070a + ", cancelHandler=" + this.f17071b + ", onCancellation=" + this.f17072c + ", idempotentResume=" + this.f17073d + ", cancelCause=" + this.f17074e + ')';
    }

    public /* synthetic */ b0(Object obj, m mVar, pd.p pVar, Object obj2, Throwable th, int i10, kotlin.jvm.internal.k kVar) {
        this(obj, (i10 & 2) != 0 ? null : mVar, (i10 & 4) != 0 ? null : pVar, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th);
    }
}
