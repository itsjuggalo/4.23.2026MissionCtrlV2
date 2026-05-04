package c4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends w.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3575g;

    @Override // w.i, java.util.Map
    public void clear() {
        this.f3575g = 0;
        super.clear();
    }

    @Override // w.i
    public void h(w.i iVar) {
        this.f3575g = 0;
        super.h(iVar);
    }

    @Override // w.i, java.util.Map
    public int hashCode() {
        if (this.f3575g == 0) {
            this.f3575g = super.hashCode();
        }
        return this.f3575g;
    }

    @Override // w.i
    public Object i(int i10) {
        this.f3575g = 0;
        return super.i(i10);
    }

    @Override // w.i
    public Object j(int i10, Object obj) {
        this.f3575g = 0;
        return super.j(i10, obj);
    }

    @Override // w.i, java.util.Map
    public Object put(Object obj, Object obj2) {
        this.f3575g = 0;
        return super.put(obj, obj2);
    }
}
