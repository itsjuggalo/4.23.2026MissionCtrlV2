package U4;

import V4.j;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.j f4991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j.c f4992b;

    public class a implements j.c {
        public a() {
        }

        @Override // V4.j.c
        public void onMethodCall(V4.i iVar, j.d dVar) {
            dVar.a(null);
        }
    }

    public n(M4.a aVar) {
        a aVar2 = new a();
        this.f4992b = aVar2;
        V4.j jVar = new V4.j(aVar, "flutter/navigation", V4.f.f5331a);
        this.f4991a = jVar;
        jVar.e(aVar2);
    }

    public void a() {
        J4.b.f("NavigationChannel", "Sending message to pop route.");
        this.f4991a.c("popRoute", null);
    }

    public void b(String str) {
        J4.b.f("NavigationChannel", "Sending message to push route information '" + str + "'");
        HashMap map = new HashMap();
        map.put("location", str);
        this.f4991a.c("pushRouteInformation", map);
    }

    public void c(String str) {
        J4.b.f("NavigationChannel", "Sending message to set initial route to '" + str + "'");
        this.f4991a.c("setInitialRoute", str);
    }
}
