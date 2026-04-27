package U4;

import V4.j;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.j f5150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f5151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.c f5152c;

    public class a implements j.c {
        public a() {
        }

        @Override // V4.j.c
        public void onMethodCall(V4.i iVar, j.d dVar) {
            if (x.this.f5151b == null) {
                J4.b.f("SpellCheckChannel", "No SpellCheckeMethodHandler registered, call not forwarded to spell check API.");
                return;
            }
            String str = iVar.f5332a;
            Object obj = iVar.f5333b;
            J4.b.f("SpellCheckChannel", "Received '" + str + "' message.");
            str.hashCode();
            if (!str.equals("SpellCheck.initiateSpellCheck")) {
                dVar.c();
                return;
            }
            try {
                ArrayList arrayList = (ArrayList) obj;
                x.this.f5151b.a((String) arrayList.get(0), (String) arrayList.get(1), dVar);
            } catch (IllegalStateException e7) {
                dVar.b("error", e7.getMessage(), null);
            }
        }
    }

    public interface b {
        void a(String str, String str2, j.d dVar);
    }

    public x(M4.a aVar) {
        a aVar2 = new a();
        this.f5152c = aVar2;
        V4.j jVar = new V4.j(aVar, "flutter/spellcheck", V4.p.f5347b);
        this.f5150a = jVar;
        jVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f5151b = bVar;
    }
}
