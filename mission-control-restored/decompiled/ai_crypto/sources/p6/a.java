package p6;

import F5.AbstractC0556n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f22055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f22056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f22057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f22058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f22059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f22060g;

    public a(String serialName) {
        r.f(serialName, "serialName");
        this.f22054a = serialName;
        this.f22055b = AbstractC0556n.g();
        this.f22056c = new ArrayList();
        this.f22057d = new HashSet();
        this.f22058e = new ArrayList();
        this.f22059f = new ArrayList();
        this.f22060g = new ArrayList();
    }

    public static /* synthetic */ void b(a aVar, String str, e eVar, List list, boolean z7, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            list = AbstractC0556n.g();
        }
        if ((i7 & 8) != 0) {
            z7 = false;
        }
        aVar.a(str, eVar, list, z7);
    }

    public final void a(String elementName, e descriptor, List annotations, boolean z7) {
        r.f(elementName, "elementName");
        r.f(descriptor, "descriptor");
        r.f(annotations, "annotations");
        if (this.f22057d.add(elementName)) {
            this.f22056c.add(elementName);
            this.f22058e.add(descriptor);
            this.f22059f.add(annotations);
            this.f22060g.add(Boolean.valueOf(z7));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + elementName + "' is already registered in " + this.f22054a).toString());
    }

    public final List c() {
        return this.f22055b;
    }

    public final List d() {
        return this.f22059f;
    }

    public final List e() {
        return this.f22058e;
    }

    public final List f() {
        return this.f22056c;
    }

    public final List g() {
        return this.f22060g;
    }

    public final void h(List list) {
        r.f(list, "<set-?>");
        this.f22055b = list;
    }
}
