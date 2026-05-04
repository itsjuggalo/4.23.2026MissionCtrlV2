package z1;

import a2.b;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.i0;
import androidx.lifecycle.j0;
import androidx.lifecycle.l0;
import androidx.lifecycle.m;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import w.j;
import z1.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b extends z1.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f25569c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f25570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f25571b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends r implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f25572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f25573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a2.b f25574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public m f25575d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C0479b f25576e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public a2.b f25577f;

        public a(int i10, Bundle bundle, a2.b bVar, a2.b bVar2) {
            this.f25572a = i10;
            this.f25573b = bundle;
            this.f25574c = bVar;
            this.f25577f = bVar2;
            bVar.r(i10, this);
        }

        @Override // a2.b.a
        public void a(a2.b bVar, Object obj) {
            if (b.f25569c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(obj);
                return;
            }
            if (b.f25569c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(obj);
        }

        public a2.b c(boolean z10) {
            if (b.f25569c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f25574c.b();
            this.f25574c.a();
            C0479b c0479b = this.f25576e;
            if (c0479b != null) {
                removeObserver(c0479b);
                if (z10) {
                    c0479b.d();
                }
            }
            this.f25574c.w(this);
            if ((c0479b == null || c0479b.c()) && !z10) {
                return this.f25574c;
            }
            this.f25574c.s();
            return this.f25577f;
        }

        public void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f25572a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f25573b);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f25574c);
            this.f25574c.g(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f25576e != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f25576e);
                this.f25576e.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().d(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        public a2.b e() {
            return this.f25574c;
        }

        public void f() {
            m mVar = this.f25575d;
            C0479b c0479b = this.f25576e;
            if (mVar == null || c0479b == null) {
                return;
            }
            super.removeObserver(c0479b);
            observe(mVar, c0479b);
        }

        public a2.b g(m mVar, a.InterfaceC0478a interfaceC0478a) {
            C0479b c0479b = new C0479b(this.f25574c, interfaceC0478a);
            observe(mVar, c0479b);
            s sVar = this.f25576e;
            if (sVar != null) {
                removeObserver(sVar);
            }
            this.f25575d = mVar;
            this.f25576e = c0479b;
            return this.f25574c;
        }

        @Override // androidx.lifecycle.p
        public void onActive() {
            if (b.f25569c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f25574c.u();
        }

        @Override // androidx.lifecycle.p
        public void onInactive() {
            if (b.f25569c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f25574c.v();
        }

        @Override // androidx.lifecycle.p
        public void removeObserver(s sVar) {
            super.removeObserver(sVar);
            this.f25575d = null;
            this.f25576e = null;
        }

        @Override // androidx.lifecycle.r, androidx.lifecycle.p
        public void setValue(Object obj) {
            super.setValue(obj);
            a2.b bVar = this.f25577f;
            if (bVar != null) {
                bVar.s();
                this.f25577f = null;
            }
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #");
            sb2.append(this.f25572a);
            sb2.append(" : ");
            Class<?> cls = this.f25574c.getClass();
            sb2.append(cls.getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(cls)));
            sb2.append("}}");
            return sb2.toString();
        }
    }

    /* JADX INFO: renamed from: z1.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0479b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a2.b f25578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a.InterfaceC0478a f25579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f25580c = false;

        public C0479b(a2.b bVar, a.InterfaceC0478a interfaceC0478a) {
            this.f25578a = bVar;
            this.f25579b = interfaceC0478a;
        }

        @Override // androidx.lifecycle.s
        public void a(Object obj) {
            if (b.f25569c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f25578a + ": " + this.f25578a.d(obj));
            }
            this.f25580c = true;
            this.f25579b.c(this.f25578a, obj);
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f25580c);
        }

        public boolean c() {
            return this.f25580c;
        }

        public void d() {
            if (this.f25580c) {
                if (b.f25569c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f25578a);
                }
                this.f25579b.b(this.f25578a);
            }
        }

        public String toString() {
            return this.f25579b.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends i0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final j0.b f25581f = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j f25582d = new j();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f25583e = false;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a implements j0.b {
            @Override // androidx.lifecycle.j0.b
            public i0 a(Class cls) {
                return new c();
            }
        }

        public static c h(l0 l0Var) {
            return (c) new j0(l0Var, f25581f).a(c.class);
        }

        @Override // androidx.lifecycle.i0
        public void d() {
            super.d();
            int iH = this.f25582d.h();
            for (int i10 = 0; i10 < iH; i10++) {
                ((a) this.f25582d.i(i10)).c(true);
            }
            this.f25582d.b();
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f25582d.h() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i10 = 0; i10 < this.f25582d.h(); i10++) {
                    a aVar = (a) this.f25582d.i(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f25582d.f(i10));
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.d(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void g() {
            this.f25583e = false;
        }

        public a i(int i10) {
            return (a) this.f25582d.d(i10);
        }

        public boolean j() {
            return this.f25583e;
        }

        public void k() {
            int iH = this.f25582d.h();
            for (int i10 = 0; i10 < iH; i10++) {
                ((a) this.f25582d.i(i10)).f();
            }
        }

        public void l(int i10, a aVar) {
            this.f25582d.g(i10, aVar);
        }

        public void m() {
            this.f25583e = true;
        }
    }

    public b(m mVar, l0 l0Var) {
        this.f25570a = mVar;
        this.f25571b = c.h(l0Var);
    }

    @Override // z1.a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f25571b.f(str, fileDescriptor, printWriter, strArr);
    }

    @Override // z1.a
    public a2.b c(int i10, Bundle bundle, a.InterfaceC0478a interfaceC0478a) {
        if (this.f25571b.j()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a aVarI = this.f25571b.i(i10);
        if (f25569c) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (aVarI == null) {
            return e(i10, bundle, interfaceC0478a, null);
        }
        if (f25569c) {
            Log.v("LoaderManager", "  Re-using existing loader " + aVarI);
        }
        return aVarI.g(this.f25570a, interfaceC0478a);
    }

    @Override // z1.a
    public void d() {
        this.f25571b.k();
    }

    public final a2.b e(int i10, Bundle bundle, a.InterfaceC0478a interfaceC0478a, a2.b bVar) {
        try {
            this.f25571b.m();
            a2.b bVarA = interfaceC0478a.a(i10, bundle);
            if (bVarA == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (bVarA.getClass().isMemberClass() && !Modifier.isStatic(bVarA.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + bVarA);
            }
            a aVar = new a(i10, bundle, bVarA, bVar);
            if (f25569c) {
                Log.v("LoaderManager", "  Created new loader " + aVar);
            }
            this.f25571b.l(i10, aVar);
            this.f25571b.g();
            return aVar.g(this.f25570a, interfaceC0478a);
        } catch (Throwable th) {
            this.f25571b.g();
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Class<?> cls = this.f25570a.getClass();
        sb2.append(cls.getSimpleName());
        sb2.append("{");
        sb2.append(Integer.toHexString(System.identityHashCode(cls)));
        sb2.append("}}");
        return sb2.toString();
    }
}
