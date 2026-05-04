package rc;

import cc.o;
import cc.q;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable f19804a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends mc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f19805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator f19806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f19807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f19808d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f19809e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f19810f;

        public a(q qVar, Iterator it) {
            this.f19805a = qVar;
            this.f19806b = it;
        }

        public void a() {
            while (!c()) {
                try {
                    this.f19805a.onNext(kc.b.d(this.f19806b.next(), "The iterator returned a null value"));
                    if (c()) {
                        return;
                    }
                    try {
                        if (!this.f19806b.hasNext()) {
                            if (c()) {
                                return;
                            }
                            this.f19805a.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        gc.b.b(th);
                        this.f19805a.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    gc.b.b(th2);
                    this.f19805a.onError(th2);
                    return;
                }
            }
        }

        @Override // fc.b
        public boolean c() {
            return this.f19807c;
        }

        @Override // lc.i
        public void clear() {
            this.f19809e = true;
        }

        @Override // fc.b
        public void dispose() {
            this.f19807c = true;
        }

        @Override // lc.i
        public boolean isEmpty() {
            return this.f19809e;
        }

        @Override // lc.i
        public Object poll() {
            if (this.f19809e) {
                return null;
            }
            if (!this.f19810f) {
                this.f19810f = true;
            } else if (!this.f19806b.hasNext()) {
                this.f19809e = true;
                return null;
            }
            return kc.b.d(this.f19806b.next(), "The iterator returned a null value");
        }
    }

    public e(Iterable iterable) {
        this.f19804a = iterable;
    }

    @Override // cc.o
    public void k(q qVar) {
        try {
            Iterator it = this.f19804a.iterator();
            try {
                if (!it.hasNext()) {
                    jc.c.i(qVar);
                    return;
                }
                a aVar = new a(qVar, it);
                qVar.a(aVar);
                if (aVar.f19808d) {
                    return;
                }
                aVar.a();
            } catch (Throwable th) {
                gc.b.b(th);
                jc.c.m(th, qVar);
            }
        } catch (Throwable th2) {
            gc.b.b(th2);
            jc.c.m(th2, qVar);
        }
    }
}
