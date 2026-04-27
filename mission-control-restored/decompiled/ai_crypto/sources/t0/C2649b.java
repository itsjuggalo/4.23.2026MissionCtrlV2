package t0;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.InterfaceC0967m;
import androidx.lifecycle.J;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import t0.AbstractC2648a;
import u.h;
import u0.AbstractC2743b;

/* JADX INFO: renamed from: t0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2649b extends AbstractC2648a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f23097c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0967m f23098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f23099b;

    /* JADX INFO: renamed from: t0.b$a */
    public static class a extends r implements AbstractC2743b.a {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f23100l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Bundle f23101m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final AbstractC2743b f23102n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public InterfaceC0967m f23103o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public C0364b f23104p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public AbstractC2743b f23105q;

        public a(int i7, Bundle bundle, AbstractC2743b abstractC2743b, AbstractC2743b abstractC2743b2) {
            this.f23100l = i7;
            this.f23101m = bundle;
            this.f23102n = abstractC2743b;
            this.f23105q = abstractC2743b2;
            abstractC2743b.r(i7, this);
        }

        @Override // u0.AbstractC2743b.a
        public void a(AbstractC2743b abstractC2743b, Object obj) {
            if (C2649b.f23097c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                n(obj);
                return;
            }
            if (C2649b.f23097c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            l(obj);
        }

        @Override // androidx.lifecycle.AbstractC0970p
        public void j() {
            if (C2649b.f23097c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f23102n.u();
        }

        @Override // androidx.lifecycle.AbstractC0970p
        public void k() {
            if (C2649b.f23097c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f23102n.v();
        }

        @Override // androidx.lifecycle.AbstractC0970p
        public void m(s sVar) {
            super.m(sVar);
            this.f23103o = null;
            this.f23104p = null;
        }

        @Override // androidx.lifecycle.r, androidx.lifecycle.AbstractC0970p
        public void n(Object obj) {
            super.n(obj);
            AbstractC2743b abstractC2743b = this.f23105q;
            if (abstractC2743b != null) {
                abstractC2743b.s();
                this.f23105q = null;
            }
        }

        public AbstractC2743b o(boolean z7) {
            if (C2649b.f23097c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f23102n.b();
            this.f23102n.a();
            C0364b c0364b = this.f23104p;
            if (c0364b != null) {
                m(c0364b);
                if (z7) {
                    c0364b.d();
                }
            }
            this.f23102n.w(this);
            if ((c0364b == null || c0364b.c()) && !z7) {
                return this.f23102n;
            }
            this.f23102n.s();
            return this.f23105q;
        }

        public void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f23100l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f23101m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f23102n);
            this.f23102n.g(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f23104p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f23104p);
                this.f23104p.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(q().d(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(g());
        }

        public AbstractC2743b q() {
            return this.f23102n;
        }

        public void r() {
            InterfaceC0967m interfaceC0967m = this.f23103o;
            C0364b c0364b = this.f23104p;
            if (interfaceC0967m == null || c0364b == null) {
                return;
            }
            super.m(c0364b);
            h(interfaceC0967m, c0364b);
        }

        public AbstractC2743b s(InterfaceC0967m interfaceC0967m, AbstractC2648a.InterfaceC0363a interfaceC0363a) {
            C0364b c0364b = new C0364b(this.f23102n, interfaceC0363a);
            h(interfaceC0967m, c0364b);
            s sVar = this.f23104p;
            if (sVar != null) {
                m(sVar);
            }
            this.f23103o = interfaceC0967m;
            this.f23104p = c0364b;
            return this.f23102n;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f23100l);
            sb.append(" : ");
            Class<?> cls = this.f23102n.getClass();
            sb.append(cls.getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(cls)));
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: t0.b$b, reason: collision with other inner class name */
    public static class C0364b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC2743b f23106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC2648a.InterfaceC0363a f23107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f23108c = false;

        public C0364b(AbstractC2743b abstractC2743b, AbstractC2648a.InterfaceC0363a interfaceC0363a) {
            this.f23106a = abstractC2743b;
            this.f23107b = interfaceC0363a;
        }

        @Override // androidx.lifecycle.s
        public void a(Object obj) {
            if (C2649b.f23097c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f23106a + ": " + this.f23106a.d(obj));
            }
            this.f23108c = true;
            this.f23107b.b(this.f23106a, obj);
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f23108c);
        }

        public boolean c() {
            return this.f23108c;
        }

        public void d() {
            if (this.f23108c) {
                if (C2649b.f23097c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f23106a);
                }
                this.f23107b.c(this.f23106a);
            }
        }

        public String toString() {
            return this.f23107b.toString();
        }
    }

    /* JADX INFO: renamed from: t0.b$c */
    public static class c extends J {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final K.b f23109f = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public h f23110d = new h();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f23111e = false;

        /* JADX INFO: renamed from: t0.b$c$a */
        public static class a implements K.b {
            @Override // androidx.lifecycle.K.b
            public J a(Class cls) {
                return new c();
            }
        }

        public static c h(M m7) {
            return (c) new K(m7, f23109f).a(c.class);
        }

        @Override // androidx.lifecycle.J
        public void d() {
            super.d();
            int iK = this.f23110d.k();
            for (int i7 = 0; i7 < iK; i7++) {
                ((a) this.f23110d.l(i7)).o(true);
            }
            this.f23110d.b();
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f23110d.k() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i7 = 0; i7 < this.f23110d.k(); i7++) {
                    a aVar = (a) this.f23110d.l(i7);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f23110d.i(i7));
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.p(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void g() {
            this.f23111e = false;
        }

        public a i(int i7) {
            return (a) this.f23110d.e(i7);
        }

        public boolean j() {
            return this.f23111e;
        }

        public void k() {
            int iK = this.f23110d.k();
            for (int i7 = 0; i7 < iK; i7++) {
                ((a) this.f23110d.l(i7)).r();
            }
        }

        public void l(int i7, a aVar) {
            this.f23110d.j(i7, aVar);
        }

        public void m() {
            this.f23111e = true;
        }
    }

    public C2649b(InterfaceC0967m interfaceC0967m, M m7) {
        this.f23098a = interfaceC0967m;
        this.f23099b = c.h(m7);
    }

    @Override // t0.AbstractC2648a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f23099b.f(str, fileDescriptor, printWriter, strArr);
    }

    @Override // t0.AbstractC2648a
    public AbstractC2743b c(int i7, Bundle bundle, AbstractC2648a.InterfaceC0363a interfaceC0363a) {
        if (this.f23099b.j()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a aVarI = this.f23099b.i(i7);
        if (f23097c) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (aVarI == null) {
            return e(i7, bundle, interfaceC0363a, null);
        }
        if (f23097c) {
            Log.v("LoaderManager", "  Re-using existing loader " + aVarI);
        }
        return aVarI.s(this.f23098a, interfaceC0363a);
    }

    @Override // t0.AbstractC2648a
    public void d() {
        this.f23099b.k();
    }

    public final AbstractC2743b e(int i7, Bundle bundle, AbstractC2648a.InterfaceC0363a interfaceC0363a, AbstractC2743b abstractC2743b) {
        try {
            this.f23099b.m();
            AbstractC2743b abstractC2743bA = interfaceC0363a.a(i7, bundle);
            if (abstractC2743bA == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (abstractC2743bA.getClass().isMemberClass() && !Modifier.isStatic(abstractC2743bA.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + abstractC2743bA);
            }
            a aVar = new a(i7, bundle, abstractC2743bA, abstractC2743b);
            if (f23097c) {
                Log.v("LoaderManager", "  Created new loader " + aVar);
            }
            this.f23099b.l(i7, aVar);
            this.f23099b.g();
            return aVar.s(this.f23098a, interfaceC0363a);
        } catch (Throwable th) {
            this.f23099b.g();
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Class<?> cls = this.f23098a.getClass();
        sb.append(cls.getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(cls)));
        sb.append("}}");
        return sb.toString();
    }
}
