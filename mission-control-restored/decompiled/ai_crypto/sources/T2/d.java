package T2;

import S2.a;
import h2.C1669a;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f4732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a.b f4733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1669a f4734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f4735d;

    public d(C1669a c1669a, a.b bVar) {
        this.f4733b = bVar;
        this.f4734c = c1669a;
        c cVar = new c(this);
        this.f4735d = cVar;
        c1669a.b(cVar);
        this.f4732a = new HashSet();
    }

    public final /* synthetic */ a.b a() {
        return this.f4733b;
    }
}
