package of;

import dd.w;
import ie.k0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import re.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f18110b;

    public a(List inner) {
        t.f(inner, "inner");
        this.f18110b = inner;
    }

    @Override // of.f
    public List a(fe.e thisDescriptor, k c10) {
        t.f(thisDescriptor, "thisDescriptor");
        t.f(c10, "c");
        List list = this.f18110b;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            w.z(arrayList, ((f) it.next()).a(thisDescriptor, c10));
        }
        return arrayList;
    }

    @Override // of.f
    public void b(fe.e thisDescriptor, ef.f name, Collection result, k c10) {
        t.f(thisDescriptor, "thisDescriptor");
        t.f(name, "name");
        t.f(result, "result");
        t.f(c10, "c");
        Iterator it = this.f18110b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).b(thisDescriptor, name, result, c10);
        }
    }

    @Override // of.f
    public void c(fe.e thisDescriptor, ef.f name, Collection result, k c10) {
        t.f(thisDescriptor, "thisDescriptor");
        t.f(name, "name");
        t.f(result, "result");
        t.f(c10, "c");
        Iterator it = this.f18110b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).c(thisDescriptor, name, result, c10);
        }
    }

    @Override // of.f
    public k0 d(fe.e thisDescriptor, k0 propertyDescriptor, k c10) {
        t.f(thisDescriptor, "thisDescriptor");
        t.f(propertyDescriptor, "propertyDescriptor");
        t.f(c10, "c");
        Iterator it = this.f18110b.iterator();
        while (it.hasNext()) {
            propertyDescriptor = ((f) it.next()).d(thisDescriptor, propertyDescriptor, c10);
        }
        return propertyDescriptor;
    }

    @Override // of.f
    public List e(fe.e thisDescriptor, k c10) {
        t.f(thisDescriptor, "thisDescriptor");
        t.f(c10, "c");
        List list = this.f18110b;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            w.z(arrayList, ((f) it.next()).e(thisDescriptor, c10));
        }
        return arrayList;
    }

    @Override // of.f
    public void f(fe.e thisDescriptor, ef.f name, List result, k c10) {
        t.f(thisDescriptor, "thisDescriptor");
        t.f(name, "name");
        t.f(result, "result");
        t.f(c10, "c");
        Iterator it = this.f18110b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).f(thisDescriptor, name, result, c10);
        }
    }

    @Override // of.f
    public List g(fe.e thisDescriptor, k c10) {
        t.f(thisDescriptor, "thisDescriptor");
        t.f(c10, "c");
        List list = this.f18110b;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            w.z(arrayList, ((f) it.next()).g(thisDescriptor, c10));
        }
        return arrayList;
    }

    @Override // of.f
    public void h(fe.e thisDescriptor, List result, k c10) {
        t.f(thisDescriptor, "thisDescriptor");
        t.f(result, "result");
        t.f(c10, "c");
        Iterator it = this.f18110b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).h(thisDescriptor, result, c10);
        }
    }
}
