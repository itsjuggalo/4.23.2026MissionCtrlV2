package U4;

import V4.j;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.j f4987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f4988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.c f4989c;

    public class a implements j.c {
        public a() {
        }

        @Override // V4.j.c
        public void onMethodCall(V4.i iVar, j.d dVar) {
            if (m.this.f4988b == null) {
                return;
            }
            String str = iVar.f5332a;
            J4.b.f("MouseCursorChannel", "Received '" + str + "' message.");
            try {
                if (str.hashCode() == -1307105544 && str.equals("activateSystemCursor")) {
                    try {
                        m.this.f4988b.a((String) ((HashMap) iVar.f5333b).get("kind"));
                        dVar.a(Boolean.TRUE);
                    } catch (Exception e7) {
                        dVar.b("error", "Error when setting cursors: " + e7.getMessage(), null);
                    }
                }
            } catch (Exception e8) {
                dVar.b("error", "Unhandled error: " + e8.getMessage(), null);
            }
        }
    }

    public interface b {
        void a(String str);
    }

    public m(M4.a aVar) {
        a aVar2 = new a();
        this.f4989c = aVar2;
        V4.j jVar = new V4.j(aVar, "flutter/mousecursor", V4.p.f5347b);
        this.f4987a = jVar;
        jVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f4988b = bVar;
    }
}
