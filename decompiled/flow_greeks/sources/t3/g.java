package t3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.k;
import g3.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f3.a f20700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f20701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f20702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f20703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j3.d f20704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f20706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f20707h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bumptech.glide.j f20708i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f20709j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f20710k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f20711l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap f20712m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l f20713n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f20714o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f20715p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f20716q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20717r;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends z3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Handler f20718d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f20719e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f20720f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bitmap f20721g;

        public a(Handler handler, int i10, long j10) {
            this.f20718d = handler;
            this.f20719e = i10;
            this.f20720f = j10;
        }

        @Override // z3.d
        public void k(Drawable drawable) {
            this.f20721g = null;
        }

        public Bitmap l() {
            return this.f20721g;
        }

        @Override // z3.d
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(Bitmap bitmap, a4.b bVar) {
            this.f20721g = bitmap;
            this.f20718d.sendMessageAtTime(this.f20718d.obtainMessage(1, this), this.f20720f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                g.this.m((a) message.obj);
                return true;
            }
            if (i10 != 2) {
                return false;
            }
            g.this.f20703d.o((a) message.obj);
            return false;
        }
    }

    public g(com.bumptech.glide.b bVar, f3.a aVar, int i10, int i11, l lVar, Bitmap bitmap) {
        this(bVar.f(), com.bumptech.glide.b.t(bVar.h()), aVar, null, i(com.bumptech.glide.b.t(bVar.h()), i10, i11), lVar, bitmap);
    }

    public static g3.f g() {
        return new b4.b(Double.valueOf(Math.random()));
    }

    public static com.bumptech.glide.j i(k kVar, int i10, int i11) {
        return kVar.m().a(((y3.f) ((y3.f) y3.f.Z(i3.j.f11666b).X(true)).T(true)).L(i10, i11));
    }

    public void a() {
        this.f20702c.clear();
        n();
        q();
        a aVar = this.f20709j;
        if (aVar != null) {
            this.f20703d.o(aVar);
            this.f20709j = null;
        }
        a aVar2 = this.f20711l;
        if (aVar2 != null) {
            this.f20703d.o(aVar2);
            this.f20711l = null;
        }
        a aVar3 = this.f20714o;
        if (aVar3 != null) {
            this.f20703d.o(aVar3);
            this.f20714o = null;
        }
        this.f20700a.clear();
        this.f20710k = true;
    }

    public ByteBuffer b() {
        return this.f20700a.getData().asReadOnlyBuffer();
    }

    public Bitmap c() {
        a aVar = this.f20709j;
        return aVar != null ? aVar.l() : this.f20712m;
    }

    public int d() {
        a aVar = this.f20709j;
        if (aVar != null) {
            return aVar.f20719e;
        }
        return -1;
    }

    public Bitmap e() {
        return this.f20712m;
    }

    public int f() {
        return this.f20700a.d();
    }

    public int h() {
        return this.f20717r;
    }

    public int j() {
        return this.f20700a.a() + this.f20715p;
    }

    public int k() {
        return this.f20716q;
    }

    public final void l() {
        if (!this.f20705f || this.f20706g) {
            return;
        }
        if (this.f20707h) {
            c4.k.b(this.f20714o == null, "Pending target must be null when starting from the first frame");
            this.f20700a.g();
            this.f20707h = false;
        }
        a aVar = this.f20714o;
        if (aVar != null) {
            this.f20714o = null;
            m(aVar);
            return;
        }
        this.f20706g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.f20700a.e());
        this.f20700a.c();
        this.f20711l = new a(this.f20701b, this.f20700a.h(), jUptimeMillis);
        this.f20708i.a(y3.f.a0(g())).k0(this.f20700a).g0(this.f20711l);
    }

    public void m(a aVar) {
        this.f20706g = false;
        if (this.f20710k) {
            this.f20701b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f20705f) {
            if (this.f20707h) {
                this.f20701b.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.f20714o = aVar;
                return;
            }
        }
        if (aVar.l() != null) {
            n();
            a aVar2 = this.f20709j;
            this.f20709j = aVar;
            for (int size = this.f20702c.size() - 1; size >= 0; size--) {
                ((b) this.f20702c.get(size)).a();
            }
            if (aVar2 != null) {
                this.f20701b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        l();
    }

    public final void n() {
        Bitmap bitmap = this.f20712m;
        if (bitmap != null) {
            this.f20704e.c(bitmap);
            this.f20712m = null;
        }
    }

    public void o(l lVar, Bitmap bitmap) {
        this.f20713n = (l) c4.k.e(lVar);
        this.f20712m = (Bitmap) c4.k.e(bitmap);
        this.f20708i = this.f20708i.a(new y3.f().U(lVar));
        this.f20715p = c4.l.h(bitmap);
        this.f20716q = bitmap.getWidth();
        this.f20717r = bitmap.getHeight();
    }

    public final void p() {
        if (this.f20705f) {
            return;
        }
        this.f20705f = true;
        this.f20710k = false;
        l();
    }

    public final void q() {
        this.f20705f = false;
    }

    public void r(b bVar) {
        if (this.f20710k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f20702c.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.f20702c.isEmpty();
        this.f20702c.add(bVar);
        if (zIsEmpty) {
            p();
        }
    }

    public void s(b bVar) {
        this.f20702c.remove(bVar);
        if (this.f20702c.isEmpty()) {
            q();
        }
    }

    public g(j3.d dVar, k kVar, f3.a aVar, Handler handler, com.bumptech.glide.j jVar, l lVar, Bitmap bitmap) {
        this.f20702c = new ArrayList();
        this.f20703d = kVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f20704e = dVar;
        this.f20701b = handler;
        this.f20708i = jVar;
        this.f20700a = aVar;
        o(lVar, bitmap);
    }
}
