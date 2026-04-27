package U4;

import V4.j;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.j f4967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f4968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.c f4969c;

    public class a implements j.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map f4970c = new HashMap();

        public a() {
        }

        @Override // V4.j.c
        public void onMethodCall(V4.i iVar, j.d dVar) {
            if (j.this.f4968b == null) {
                dVar.a(this.f4970c);
                return;
            }
            String str = iVar.f5332a;
            str.hashCode();
            if (!str.equals("getKeyboardState")) {
                dVar.c();
                return;
            }
            try {
                this.f4970c = j.this.f4968b.b();
            } catch (IllegalStateException e7) {
                dVar.b("error", e7.getMessage(), null);
            }
            dVar.a(this.f4970c);
        }
    }

    public interface b {
        Map b();
    }

    public j(V4.b bVar) {
        a aVar = new a();
        this.f4969c = aVar;
        V4.j jVar = new V4.j(bVar, "flutter/keyboard", V4.p.f5347b);
        this.f4967a = jVar;
        jVar.e(aVar);
    }

    public void b(b bVar) {
        this.f4968b = bVar;
    }
}
