package e5;

import P4.s;
import P4.t;
import P4.u;

/* JADX INFO: renamed from: e5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1670a extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f17181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.d f17182b;

    /* JADX INFO: renamed from: e5.a$a, reason: collision with other inner class name */
    public final class C0296a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f17183a;

        public C0296a(t tVar) {
            this.f17183a = tVar;
        }

        @Override // P4.t
        public void b(S4.b bVar) {
            this.f17183a.b(bVar);
        }

        @Override // P4.t
        public void onError(Throwable th) {
            try {
                C1670a.this.f17182b.accept(th);
            } catch (Throwable th2) {
                T4.b.b(th2);
                th = new T4.a(th, th2);
            }
            this.f17183a.onError(th);
        }

        @Override // P4.t
        public void onSuccess(Object obj) {
            this.f17183a.onSuccess(obj);
        }
    }

    public C1670a(u uVar, V4.d dVar) {
        this.f17181a = uVar;
        this.f17182b = dVar;
    }

    @Override // P4.s
    public void k(t tVar) {
        this.f17181a.d(new C0296a(tVar));
    }
}
