package o8;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j8.k f17625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q8.c f17626b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f17627a;

        public a(ArrayList arrayList) {
            this.f17627a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (e eVar : this.f17627a) {
                if (g.this.f17626b.f()) {
                    g.this.f17626b.b("Raising " + eVar.toString(), new Object[0]);
                }
                eVar.a();
            }
        }
    }

    public g(j8.g gVar) {
        this.f17625a = gVar.o();
        this.f17626b = gVar.q("EventRaiser");
    }

    public void b(List list) {
        if (this.f17626b.f()) {
            this.f17626b.b("Raising " + list.size() + " event(s)", new Object[0]);
        }
        this.f17625a.b(new a(new ArrayList(list)));
    }
}
