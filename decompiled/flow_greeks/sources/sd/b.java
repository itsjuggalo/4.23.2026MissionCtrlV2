package sd;

import kotlin.jvm.internal.t;
import wd.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f20212a;

    public b(Object obj) {
        this.f20212a = obj;
    }

    @Override // sd.d, sd.c
    public Object a(Object obj, m property) {
        t.f(property, "property");
        return this.f20212a;
    }

    @Override // sd.d
    public void b(Object obj, m property, Object obj2) {
        t.f(property, "property");
        Object obj3 = this.f20212a;
        if (d(property, obj3, obj2)) {
            this.f20212a = obj2;
            c(property, obj3, obj2);
        }
    }

    public void c(m property, Object obj, Object obj2) {
        t.f(property, "property");
    }

    public abstract boolean d(m mVar, Object obj, Object obj2);

    public String toString() {
        return "ObservableProperty(value=" + this.f20212a + ')';
    }
}
