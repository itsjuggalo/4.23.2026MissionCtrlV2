package E5;

import I5.m;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f896a;

    public b(Object obj) {
        this.f896a = obj;
    }

    @Override // E5.d, E5.c
    public Object a(Object obj, m property) {
        AbstractC2304t.f(property, "property");
        return this.f896a;
    }

    @Override // E5.d
    public void b(Object obj, m property, Object obj2) {
        AbstractC2304t.f(property, "property");
        Object obj3 = this.f896a;
        if (d(property, obj3, obj2)) {
            this.f896a = obj2;
            c(property, obj3, obj2);
        }
    }

    public void c(m property, Object obj, Object obj2) {
        AbstractC2304t.f(property, "property");
    }

    public abstract boolean d(m mVar, Object obj, Object obj2);

    public String toString() {
        return "ObservableProperty(value=" + this.f896a + ')';
    }
}
