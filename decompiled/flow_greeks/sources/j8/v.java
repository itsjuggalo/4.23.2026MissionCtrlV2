package j8;

import java.util.HashMap;
import java.util.Map;
import r8.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r8.n f14147a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f14148b = null;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends c.AbstractC0339c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f14149a;

        public a(l lVar) {
            this.f14149a = lVar;
        }

        @Override // r8.c.AbstractC0339c
        public void b(r8.b bVar, r8.n nVar) {
            v.this.d(this.f14149a.v(bVar), nVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f14151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f14152b;

        public b(l lVar, d dVar) {
            this.f14151a = lVar;
            this.f14152b = dVar;
        }

        @Override // j8.v.c
        public void a(r8.b bVar, v vVar) {
            vVar.b(this.f14151a.v(bVar), this.f14152b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
        void a(r8.b bVar, v vVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface d {
        void a(l lVar, r8.n nVar);
    }

    public void a(c cVar) {
        Map map = this.f14148b;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                cVar.a((r8.b) entry.getKey(), (v) entry.getValue());
            }
        }
    }

    public void b(l lVar, d dVar) {
        r8.n nVar = this.f14147a;
        if (nVar != null) {
            dVar.a(lVar, nVar);
        } else {
            a(new b(lVar, dVar));
        }
    }

    public boolean c(l lVar) {
        if (lVar.isEmpty()) {
            this.f14147a = null;
            this.f14148b = null;
            return true;
        }
        r8.n nVar = this.f14147a;
        if (nVar != null) {
            if (nVar.J()) {
                return false;
            }
            r8.c cVar = (r8.c) this.f14147a;
            this.f14147a = null;
            cVar.q(new a(lVar));
            return c(lVar);
        }
        if (this.f14148b == null) {
            return true;
        }
        r8.b bVarK = lVar.K();
        l lVarS = lVar.S();
        if (this.f14148b.containsKey(bVarK) && ((v) this.f14148b.get(bVarK)).c(lVarS)) {
            this.f14148b.remove(bVarK);
        }
        if (!this.f14148b.isEmpty()) {
            return false;
        }
        this.f14148b = null;
        return true;
    }

    public void d(l lVar, r8.n nVar) {
        if (lVar.isEmpty()) {
            this.f14147a = nVar;
            this.f14148b = null;
            return;
        }
        r8.n nVar2 = this.f14147a;
        if (nVar2 != null) {
            this.f14147a = nVar2.I(lVar, nVar);
            return;
        }
        if (this.f14148b == null) {
            this.f14148b = new HashMap();
        }
        r8.b bVarK = lVar.K();
        if (!this.f14148b.containsKey(bVarK)) {
            this.f14148b.put(bVarK, new v());
        }
        ((v) this.f14148b.get(bVarK)).d(lVar.S(), nVar);
    }
}
