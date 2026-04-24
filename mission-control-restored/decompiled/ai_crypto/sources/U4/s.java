package U4;

import V4.j;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.j f5110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PackageManager f5111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f5112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j.c f5113d;

    public class a implements j.c {
        public a() {
        }

        @Override // V4.j.c
        public void onMethodCall(V4.i iVar, j.d dVar) {
            if (s.this.f5112c == null) {
                return;
            }
            String str = iVar.f5332a;
            Object obj = iVar.f5333b;
            str.hashCode();
            if (!str.equals("ProcessText.processTextAction")) {
                if (!str.equals("ProcessText.queryTextActions")) {
                    dVar.c();
                    return;
                }
                try {
                    dVar.a(s.this.f5112c.b());
                    return;
                } catch (IllegalStateException e7) {
                    dVar.b("error", e7.getMessage(), null);
                    return;
                }
            }
            try {
                ArrayList arrayList = (ArrayList) obj;
                s.this.f5112c.a((String) arrayList.get(0), (String) arrayList.get(1), ((Boolean) arrayList.get(2)).booleanValue(), dVar);
            } catch (IllegalStateException e8) {
                dVar.b("error", e8.getMessage(), null);
            }
        }
    }

    public interface b {
        void a(String str, String str2, boolean z7, j.d dVar);

        Map b();
    }

    public s(M4.a aVar, PackageManager packageManager) {
        a aVar2 = new a();
        this.f5113d = aVar2;
        this.f5111b = packageManager;
        V4.j jVar = new V4.j(aVar, "flutter/processtext", V4.p.f5347b);
        this.f5110a = jVar;
        jVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f5112c = bVar;
    }
}
