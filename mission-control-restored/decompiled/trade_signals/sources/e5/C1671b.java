package e5;

import P4.s;
import P4.t;
import P4.u;

/* JADX INFO: renamed from: e5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1671b extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f17185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.d f17186b;

    /* JADX INFO: renamed from: e5.b$a */
    public final class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f17187a;

        public a(t tVar) {
            this.f17187a = tVar;
        }

        @Override // P4.t
        public void b(S4.b bVar) {
            this.f17187a.b(bVar);
        }

        @Override // P4.t
        public void onError(Throwable th) {
            this.f17187a.onError(th);
        }

        @Override // P4.t
        public void onSuccess(Object obj) {
            try {
                C1671b.this.f17186b.accept(obj);
                this.f17187a.onSuccess(obj);
            } catch (Throwable th) {
                T4.b.b(th);
                this.f17187a.onError(th);
            }
        }
    }

    public C1671b(u uVar, V4.d dVar) {
        this.f17185a = uVar;
        this.f17186b = dVar;
    }

    @Override // P4.s
    public void k(t tVar) {
        this.f17185a.d(new a(tVar));
    }
}
