package q1;

import w.C2882a;

/* JADX INFO: renamed from: q1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2619b extends C2882a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22517g;

    @Override // w.i, java.util.Map
    public void clear() {
        this.f22517g = 0;
        super.clear();
    }

    @Override // w.i
    public void g(w.i iVar) {
        this.f22517g = 0;
        super.g(iVar);
    }

    @Override // w.i
    public Object h(int i8) {
        this.f22517g = 0;
        return super.h(i8);
    }

    @Override // w.i, java.util.Map
    public int hashCode() {
        if (this.f22517g == 0) {
            this.f22517g = super.hashCode();
        }
        return this.f22517g;
    }

    @Override // w.i
    public Object i(int i8, Object obj) {
        this.f22517g = 0;
        return super.i(i8, obj);
    }

    @Override // w.i, java.util.Map
    public Object put(Object obj, Object obj2) {
        this.f22517g = 0;
        return super.put(obj, obj2);
    }
}
