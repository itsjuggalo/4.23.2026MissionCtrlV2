package bh;

import dd.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f3364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f3365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f3366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f3367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f3368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f3369g;

    public a(String serialName) {
        t.f(serialName, "serialName");
        this.f3363a = serialName;
        this.f3364b = r.k();
        this.f3365c = new ArrayList();
        this.f3366d = new HashSet();
        this.f3367e = new ArrayList();
        this.f3368f = new ArrayList();
        this.f3369g = new ArrayList();
    }

    public static /* synthetic */ void b(a aVar, String str, e eVar, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            list = r.k();
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        aVar.a(str, eVar, list, z10);
    }

    public final void a(String elementName, e descriptor, List annotations, boolean z10) {
        t.f(elementName, "elementName");
        t.f(descriptor, "descriptor");
        t.f(annotations, "annotations");
        if (this.f3366d.add(elementName)) {
            this.f3365c.add(elementName);
            this.f3367e.add(descriptor);
            this.f3368f.add(annotations);
            this.f3369g.add(Boolean.valueOf(z10));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + elementName + "' is already registered in " + this.f3363a).toString());
    }

    public final List c() {
        return this.f3364b;
    }

    public final List d() {
        return this.f3368f;
    }

    public final List e() {
        return this.f3367e;
    }

    public final List f() {
        return this.f3365c;
    }

    public final List g() {
        return this.f3369g;
    }

    public final void h(List list) {
        t.f(list, "<set-?>");
        this.f3364b = list;
    }
}
