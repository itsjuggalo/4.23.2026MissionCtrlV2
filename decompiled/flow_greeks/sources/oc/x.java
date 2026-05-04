package oc;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends cc.f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f17922b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ic.e f17923c;

        public a(Object obj, ic.e eVar) {
            this.f17922b = obj;
            this.f17923c = eVar;
        }

        @Override // cc.f
        public void I(kh.b bVar) {
            try {
                kh.a aVar = (kh.a) kc.b.d(this.f17923c.apply(this.f17922b), "The mapper returned a null Publisher");
                if (!(aVar instanceof Callable)) {
                    aVar.a(bVar);
                    return;
                }
                try {
                    Object objCall = ((Callable) aVar).call();
                    if (objCall == null) {
                        wc.d.a(bVar);
                    } else {
                        bVar.b(new wc.e(bVar, objCall));
                    }
                } catch (Throwable th) {
                    gc.b.b(th);
                    wc.d.b(th, bVar);
                }
            } catch (Throwable th2) {
                wc.d.b(th2, bVar);
            }
        }
    }

    public static cc.f a(Object obj, ic.e eVar) {
        return yc.a.k(new a(obj, eVar));
    }

    public static boolean b(kh.a aVar, kh.b bVar, ic.e eVar) {
        if (!(aVar instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) aVar).call();
            if (objCall == null) {
                wc.d.a(bVar);
                return true;
            }
            try {
                kh.a aVar2 = (kh.a) kc.b.d(eVar.apply(objCall), "The mapper returned a null Publisher");
                if (aVar2 instanceof Callable) {
                    try {
                        Object objCall2 = ((Callable) aVar2).call();
                        if (objCall2 == null) {
                            wc.d.a(bVar);
                            return true;
                        }
                        bVar.b(new wc.e(bVar, objCall2));
                    } catch (Throwable th) {
                        gc.b.b(th);
                        wc.d.b(th, bVar);
                        return true;
                    }
                } else {
                    aVar2.a(bVar);
                }
                return true;
            } catch (Throwable th2) {
                gc.b.b(th2);
                wc.d.b(th2, bVar);
                return true;
            }
        } catch (Throwable th3) {
            gc.b.b(th3);
            wc.d.b(th3, bVar);
            return true;
        }
    }
}
