package androidx.lifecycle;

import androidx.lifecycle.AbstractC0963i;
import java.util.Map;
import q.C2546c;
import r.C2571b;

/* JADX INFO: renamed from: androidx.lifecycle.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0970p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f7799k = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7800a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C2571b f7801b = new C2571b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7802c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f7804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Object f7805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Runnable f7809j;

    /* JADX INFO: renamed from: androidx.lifecycle.p$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (AbstractC0970p.this.f7800a) {
                obj = AbstractC0970p.this.f7805f;
                AbstractC0970p.this.f7805f = AbstractC0970p.f7799k;
            }
            AbstractC0970p.this.n(obj);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.p$b */
    public class b extends d {
        public b(s sVar) {
            super(sVar);
        }

        @Override // androidx.lifecycle.AbstractC0970p.d
        public boolean e() {
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.p$c */
    public class c extends d implements InterfaceC0965k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final InterfaceC0967m f7812e;

        public c(InterfaceC0967m interfaceC0967m, s sVar) {
            super(sVar);
            this.f7812e = interfaceC0967m;
        }

        @Override // androidx.lifecycle.InterfaceC0965k
        public void a(InterfaceC0967m interfaceC0967m, AbstractC0963i.a aVar) {
            AbstractC0963i.b bVarB = this.f7812e.a().b();
            if (bVarB == AbstractC0963i.b.DESTROYED) {
                AbstractC0970p.this.m(this.f7814a);
                return;
            }
            AbstractC0963i.b bVar = null;
            while (bVar != bVarB) {
                b(e());
                bVar = bVarB;
                bVarB = this.f7812e.a().b();
            }
        }

        @Override // androidx.lifecycle.AbstractC0970p.d
        public void c() {
            this.f7812e.a().c(this);
        }

        @Override // androidx.lifecycle.AbstractC0970p.d
        public boolean d(InterfaceC0967m interfaceC0967m) {
            return this.f7812e == interfaceC0967m;
        }

        @Override // androidx.lifecycle.AbstractC0970p.d
        public boolean e() {
            return this.f7812e.a().b().b(AbstractC0963i.b.STARTED);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.p$d */
    public abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f7814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7816c = -1;

        public d(s sVar) {
            this.f7814a = sVar;
        }

        public void b(boolean z7) {
            if (z7 == this.f7815b) {
                return;
            }
            this.f7815b = z7;
            AbstractC0970p.this.c(z7 ? 1 : -1);
            if (this.f7815b) {
                AbstractC0970p.this.e(this);
            }
        }

        public void c() {
        }

        public boolean d(InterfaceC0967m interfaceC0967m) {
            return false;
        }

        public abstract boolean e();
    }

    public AbstractC0970p() {
        Object obj = f7799k;
        this.f7805f = obj;
        this.f7809j = new a();
        this.f7804e = obj;
        this.f7806g = -1;
    }

    public static void b(String str) {
        if (C2546c.f().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public void c(int i7) {
        int i8 = this.f7802c;
        this.f7802c = i7 + i8;
        if (this.f7803d) {
            return;
        }
        this.f7803d = true;
        while (true) {
            try {
                int i9 = this.f7802c;
                if (i8 == i9) {
                    this.f7803d = false;
                    return;
                }
                boolean z7 = i8 == 0 && i9 > 0;
                boolean z8 = i8 > 0 && i9 == 0;
                if (z7) {
                    j();
                } else if (z8) {
                    k();
                }
                i8 = i9;
            } catch (Throwable th) {
                this.f7803d = false;
                throw th;
            }
        }
    }

    public final void d(d dVar) {
        if (dVar.f7815b) {
            if (!dVar.e()) {
                dVar.b(false);
                return;
            }
            int i7 = dVar.f7816c;
            int i8 = this.f7806g;
            if (i7 >= i8) {
                return;
            }
            dVar.f7816c = i8;
            dVar.f7814a.a(this.f7804e);
        }
    }

    public void e(d dVar) {
        if (this.f7807h) {
            this.f7808i = true;
            return;
        }
        this.f7807h = true;
        do {
            this.f7808i = false;
            if (dVar != null) {
                d(dVar);
                dVar = null;
            } else {
                C2571b.d dVarC = this.f7801b.c();
                while (dVarC.hasNext()) {
                    d((d) ((Map.Entry) dVarC.next()).getValue());
                    if (this.f7808i) {
                        break;
                    }
                }
            }
        } while (this.f7808i);
        this.f7807h = false;
    }

    public Object f() {
        Object obj = this.f7804e;
        if (obj != f7799k) {
            return obj;
        }
        return null;
    }

    public boolean g() {
        return this.f7802c > 0;
    }

    public void h(InterfaceC0967m interfaceC0967m, s sVar) {
        b("observe");
        if (interfaceC0967m.a().b() == AbstractC0963i.b.DESTROYED) {
            return;
        }
        c cVar = new c(interfaceC0967m, sVar);
        d dVar = (d) this.f7801b.j(sVar, cVar);
        if (dVar != null && !dVar.d(interfaceC0967m)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVar != null) {
            return;
        }
        interfaceC0967m.a().a(cVar);
    }

    public void i(s sVar) {
        b("observeForever");
        b bVar = new b(sVar);
        d dVar = (d) this.f7801b.j(sVar, bVar);
        if (dVar instanceof c) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVar != null) {
            return;
        }
        bVar.b(true);
    }

    public void j() {
    }

    public void k() {
    }

    public void l(Object obj) {
        boolean z7;
        synchronized (this.f7800a) {
            z7 = this.f7805f == f7799k;
            this.f7805f = obj;
        }
        if (z7) {
            C2546c.f().c(this.f7809j);
        }
    }

    public void m(s sVar) {
        b("removeObserver");
        d dVar = (d) this.f7801b.k(sVar);
        if (dVar == null) {
            return;
        }
        dVar.c();
        dVar.b(false);
    }

    public void n(Object obj) {
        b("setValue");
        this.f7806g++;
        this.f7804e = obj;
        e(null);
    }
}
