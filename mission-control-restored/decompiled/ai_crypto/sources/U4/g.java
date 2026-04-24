package U4;

import V4.j;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.j f4959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f4960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.c f4961c;

    public class a implements j.c {
        public a() {
        }

        @Override // V4.j.c
        public void onMethodCall(V4.i iVar, j.d dVar) {
            g.a(g.this);
        }
    }

    public g(M4.a aVar) {
        a aVar2 = new a();
        this.f4961c = aVar2;
        V4.j jVar = new V4.j(aVar, "flutter/deferredcomponent", V4.p.f5347b);
        this.f4959a = jVar;
        jVar.e(aVar2);
        J4.a.e().a();
        this.f4960b = new HashMap();
    }

    public static /* synthetic */ N4.a a(g gVar) {
        gVar.getClass();
        return null;
    }
}
