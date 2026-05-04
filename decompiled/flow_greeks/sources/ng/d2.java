package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d2 extends sg.o implements e1, u1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e2 f17084d;

    @Override // ng.u1
    public j2 b() {
        return null;
    }

    @Override // ng.e1
    public void dispose() {
        t().y0(this);
    }

    @Override // ng.u1
    public boolean isActive() {
        return true;
    }

    public final e2 t() {
        e2 e2Var = this.f17084d;
        if (e2Var != null) {
            return e2Var;
        }
        kotlin.jvm.internal.t.s("job");
        return null;
    }

    @Override // sg.o
    public String toString() {
        return r0.a(this) + '@' + r0.b(this) + "[job@" + r0.b(t()) + ']';
    }

    public abstract boolean u();

    public abstract void v(Throwable th);

    public final void w(e2 e2Var) {
        this.f17084d = e2Var;
    }
}
