package H3;

import X2.AbstractC0769p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f732g;

    public a(String serialName) {
        r.f(serialName, "serialName");
        this.f726a = serialName;
        this.f727b = AbstractC0769p.g();
        this.f728c = new ArrayList();
        this.f729d = new HashSet();
        this.f730e = new ArrayList();
        this.f731f = new ArrayList();
        this.f732g = new ArrayList();
    }

    public static /* synthetic */ void b(a aVar, String str, e eVar, List list, boolean z4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            list = AbstractC0769p.g();
        }
        if ((i4 & 8) != 0) {
            z4 = false;
        }
        aVar.a(str, eVar, list, z4);
    }

    public final void a(String elementName, e descriptor, List annotations, boolean z4) {
        r.f(elementName, "elementName");
        r.f(descriptor, "descriptor");
        r.f(annotations, "annotations");
        if (this.f729d.add(elementName)) {
            this.f728c.add(elementName);
            this.f730e.add(descriptor);
            this.f731f.add(annotations);
            this.f732g.add(Boolean.valueOf(z4));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + elementName + "' is already registered in " + this.f726a).toString());
    }

    public final List c() {
        return this.f727b;
    }

    public final List d() {
        return this.f731f;
    }

    public final List e() {
        return this.f730e;
    }

    public final List f() {
        return this.f728c;
    }

    public final List g() {
        return this.f732g;
    }

    public final void h(List list) {
        r.f(list, "<set-?>");
        this.f727b = list;
    }
}
