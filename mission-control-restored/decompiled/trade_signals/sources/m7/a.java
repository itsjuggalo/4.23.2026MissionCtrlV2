package m7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f21493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f21494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f21495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f21496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f21497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f21498g;

    public a(String serialName) {
        AbstractC2304t.f(serialName, "serialName");
        this.f21492a = serialName;
        this.f21493b = AbstractC2595q.i();
        this.f21494c = new ArrayList();
        this.f21495d = new HashSet();
        this.f21496e = new ArrayList();
        this.f21497f = new ArrayList();
        this.f21498g = new ArrayList();
    }

    public static /* synthetic */ void b(a aVar, String str, e eVar, List list, boolean z7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            list = AbstractC2595q.i();
        }
        if ((i8 & 8) != 0) {
            z7 = false;
        }
        aVar.a(str, eVar, list, z7);
    }

    public final void a(String elementName, e descriptor, List annotations, boolean z7) {
        AbstractC2304t.f(elementName, "elementName");
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(annotations, "annotations");
        if (this.f21495d.add(elementName)) {
            this.f21494c.add(elementName);
            this.f21496e.add(descriptor);
            this.f21497f.add(annotations);
            this.f21498g.add(Boolean.valueOf(z7));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + elementName + "' is already registered in " + this.f21492a).toString());
    }

    public final List c() {
        return this.f21493b;
    }

    public final List d() {
        return this.f21497f;
    }

    public final List e() {
        return this.f21496e;
    }

    public final List f() {
        return this.f21494c;
    }

    public final List g() {
        return this.f21498g;
    }

    public final void h(List list) {
        AbstractC2304t.f(list, "<set-?>");
        this.f21493b = list;
    }
}
