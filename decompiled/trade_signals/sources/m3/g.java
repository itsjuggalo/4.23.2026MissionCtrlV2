package m3;

import h3.AbstractC1870f;
import h3.InterfaceC1874j;
import java.util.ArrayList;
import java.util.List;
import o3.C2460c;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1874j f21422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2460c f21423b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f21424a;

        public a(ArrayList arrayList) {
            this.f21424a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (e eVar : this.f21424a) {
                if (g.this.f21423b.f()) {
                    g.this.f21423b.b("Raising " + eVar.toString(), new Object[0]);
                }
                eVar.a();
            }
        }
    }

    public g(AbstractC1870f abstractC1870f) {
        this.f21422a = abstractC1870f.o();
        this.f21423b = abstractC1870f.q("EventRaiser");
    }

    public void b(List list) {
        if (this.f21423b.f()) {
            this.f21423b.b("Raising " + list.size() + " event(s)", new Object[0]);
        }
        this.f21422a.b(new a(new ArrayList(list)));
    }
}
