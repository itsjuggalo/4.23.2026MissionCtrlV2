package e5;

import P4.s;
import P4.t;
import P4.u;
import Z4.f;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: e5.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1673d extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f17190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.e f17191b;

    /* JADX INFO: renamed from: e5.d$a */
    public static final class a extends AtomicReference implements t, S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f17192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V4.e f17193b;

        public a(t tVar, V4.e eVar) {
            this.f17192a = tVar;
            this.f17193b = eVar;
        }

        @Override // P4.t
        public void b(S4.b bVar) {
            if (W4.b.m(this, bVar)) {
                this.f17192a.b(this);
            }
        }

        @Override // S4.b
        public void dispose() {
            W4.b.a(this);
        }

        @Override // S4.b
        public boolean g() {
            return W4.b.b((S4.b) get());
        }

        @Override // P4.t
        public void onError(Throwable th) {
            try {
                ((u) X4.b.d(this.f17193b.apply(th), "The nextFunction returned a null SingleSource.")).d(new f(this, this.f17192a));
            } catch (Throwable th2) {
                T4.b.b(th2);
                this.f17192a.onError(new T4.a(th, th2));
            }
        }

        @Override // P4.t
        public void onSuccess(Object obj) {
            this.f17192a.onSuccess(obj);
        }
    }

    public C1673d(u uVar, V4.e eVar) {
        this.f17190a = uVar;
        this.f17191b = eVar;
    }

    @Override // P4.s
    public void k(t tVar) {
        this.f17190a.d(new a(tVar, this.f17191b));
    }
}
