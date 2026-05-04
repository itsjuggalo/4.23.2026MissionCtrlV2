package y;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import u6.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f25138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f25139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public y.d f25140c = y.d.G();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f25141d;

        public void a() {
            this.f25138a = null;
            this.f25139b = null;
            this.f25140c.y(null);
        }

        public boolean b(Object obj) {
            this.f25141d = true;
            d dVar = this.f25139b;
            boolean z10 = dVar != null && dVar.c(obj);
            if (z10) {
                d();
            }
            return z10;
        }

        public boolean c() {
            this.f25141d = true;
            d dVar = this.f25139b;
            boolean z10 = dVar != null && dVar.b(true);
            if (z10) {
                d();
            }
            return z10;
        }

        public final void d() {
            this.f25138a = null;
            this.f25139b = null;
            this.f25140c = null;
        }

        public boolean e(Throwable th) {
            this.f25141d = true;
            d dVar = this.f25139b;
            boolean z10 = dVar != null && dVar.d(th);
            if (z10) {
                d();
            }
            return z10;
        }

        public void finalize() {
            y.d dVar;
            d dVar2 = this.f25139b;
            if (dVar2 != null && !dVar2.isDone()) {
                dVar2.d(new b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f25138a));
            }
            if (this.f25141d || (dVar = this.f25140c) == null) {
                return;
            }
            dVar.y(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends Throwable {
        public b(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: renamed from: y.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface InterfaceC0465c {
        Object a(a aVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f25142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y.a f25143b = new a();

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a extends y.a {
            public a() {
            }

            @Override // y.a
            public String u() {
                a aVar = (a) d.this.f25142a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f25138a + "]";
            }
        }

        public d(a aVar) {
            this.f25142a = new WeakReference(aVar);
        }

        @Override // u6.f
        public void a(Runnable runnable, Executor executor) {
            this.f25143b.a(runnable, executor);
        }

        public boolean b(boolean z10) {
            return this.f25143b.cancel(z10);
        }

        public boolean c(Object obj) {
            return this.f25143b.y(obj);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            a aVar = (a) this.f25142a.get();
            boolean zCancel = this.f25143b.cancel(z10);
            if (zCancel && aVar != null) {
                aVar.a();
            }
            return zCancel;
        }

        public boolean d(Throwable th) {
            return this.f25143b.A(th);
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            return this.f25143b.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f25143b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f25143b.isDone();
        }

        public String toString() {
            return this.f25143b.toString();
        }

        @Override // java.util.concurrent.Future
        public Object get(long j10, TimeUnit timeUnit) {
            return this.f25143b.get(j10, timeUnit);
        }
    }

    public static f a(InterfaceC0465c interfaceC0465c) {
        a aVar = new a();
        d dVar = new d(aVar);
        aVar.f25139b = dVar;
        aVar.f25138a = interfaceC0465c.getClass();
        try {
            Object objA = interfaceC0465c.a(aVar);
            if (objA == null) {
                return dVar;
            }
            aVar.f25138a = objA;
            return dVar;
        } catch (Exception e10) {
            dVar.d(e10);
            return dVar;
        }
    }
}
