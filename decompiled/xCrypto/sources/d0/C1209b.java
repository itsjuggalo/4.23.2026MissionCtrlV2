package d0;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.InterfaceC0850m;
import androidx.lifecycle.J;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import d0.AbstractC1208a;
import e0.AbstractC1226b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import u.C1860h;

/* JADX INFO: renamed from: d0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1209b extends AbstractC1208a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f11372c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0850m f11373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f11374b;

    /* JADX INFO: renamed from: d0.b$a */
    public static class a extends r implements AbstractC1226b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f11376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AbstractC1226b f11377c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public InterfaceC0850m f11378d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C0182b f11379e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public AbstractC1226b f11380f;

        public a(int i4, Bundle bundle, AbstractC1226b abstractC1226b, AbstractC1226b abstractC1226b2) {
            this.f11375a = i4;
            this.f11376b = bundle;
            this.f11377c = abstractC1226b;
            this.f11380f = abstractC1226b2;
            abstractC1226b.r(i4, this);
        }

        @Override // e0.AbstractC1226b.a
        public void a(AbstractC1226b abstractC1226b, Object obj) {
            if (C1209b.f11372c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(obj);
                return;
            }
            if (C1209b.f11372c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(obj);
        }

        public AbstractC1226b c(boolean z4) {
            if (C1209b.f11372c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f11377c.b();
            this.f11377c.a();
            C0182b c0182b = this.f11379e;
            if (c0182b != null) {
                removeObserver(c0182b);
                if (z4) {
                    c0182b.d();
                }
            }
            this.f11377c.w(this);
            if ((c0182b == null || c0182b.c()) && !z4) {
                return this.f11377c;
            }
            this.f11377c.s();
            return this.f11380f;
        }

        public void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f11375a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f11376b);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f11377c);
            this.f11377c.g(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f11379e != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f11379e);
                this.f11379e.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().d(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        public AbstractC1226b e() {
            return this.f11377c;
        }

        public void f() {
            InterfaceC0850m interfaceC0850m = this.f11378d;
            C0182b c0182b = this.f11379e;
            if (interfaceC0850m == null || c0182b == null) {
                return;
            }
            super.removeObserver(c0182b);
            observe(interfaceC0850m, c0182b);
        }

        public AbstractC1226b g(InterfaceC0850m interfaceC0850m, AbstractC1208a.InterfaceC0181a interfaceC0181a) {
            C0182b c0182b = new C0182b(this.f11377c, interfaceC0181a);
            observe(interfaceC0850m, c0182b);
            s sVar = this.f11379e;
            if (sVar != null) {
                removeObserver(sVar);
            }
            this.f11378d = interfaceC0850m;
            this.f11379e = c0182b;
            return this.f11377c;
        }

        @Override // androidx.lifecycle.AbstractC0853p
        public void onActive() {
            if (C1209b.f11372c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f11377c.u();
        }

        @Override // androidx.lifecycle.AbstractC0853p
        public void onInactive() {
            if (C1209b.f11372c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f11377c.v();
        }

        @Override // androidx.lifecycle.AbstractC0853p
        public void removeObserver(s sVar) {
            super.removeObserver(sVar);
            this.f11378d = null;
            this.f11379e = null;
        }

        @Override // androidx.lifecycle.r, androidx.lifecycle.AbstractC0853p
        public void setValue(Object obj) {
            super.setValue(obj);
            AbstractC1226b abstractC1226b = this.f11380f;
            if (abstractC1226b != null) {
                abstractC1226b.s();
                this.f11380f = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f11375a);
            sb.append(" : ");
            Class<?> cls = this.f11377c.getClass();
            sb.append(cls.getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(cls)));
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: d0.b$b, reason: collision with other inner class name */
    public static class C0182b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC1226b f11381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC1208a.InterfaceC0181a f11382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f11383c = false;

        public C0182b(AbstractC1226b abstractC1226b, AbstractC1208a.InterfaceC0181a interfaceC0181a) {
            this.f11381a = abstractC1226b;
            this.f11382b = interfaceC0181a;
        }

        @Override // androidx.lifecycle.s
        public void a(Object obj) {
            if (C1209b.f11372c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f11381a + ": " + this.f11381a.d(obj));
            }
            this.f11383c = true;
            this.f11382b.b(this.f11381a, obj);
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f11383c);
        }

        public boolean c() {
            return this.f11383c;
        }

        public void d() {
            if (this.f11383c) {
                if (C1209b.f11372c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f11381a);
                }
                this.f11382b.c(this.f11381a);
            }
        }

        public String toString() {
            return this.f11382b.toString();
        }
    }

    /* JADX INFO: renamed from: d0.b$c */
    public static class c extends J {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final K.b f11384f = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C1860h f11385d = new C1860h();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f11386e = false;

        /* JADX INFO: renamed from: d0.b$c$a */
        public static class a implements K.b {
            @Override // androidx.lifecycle.K.b
            public J a(Class cls) {
                return new c();
            }
        }

        public static c h(M m4) {
            return (c) new K(m4, f11384f).a(c.class);
        }

        @Override // androidx.lifecycle.J
        public void d() {
            super.d();
            int i4 = this.f11385d.i();
            for (int i5 = 0; i5 < i4; i5++) {
                ((a) this.f11385d.j(i5)).c(true);
            }
            this.f11385d.b();
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f11385d.i() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i4 = 0; i4 < this.f11385d.i(); i4++) {
                    a aVar = (a) this.f11385d.j(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f11385d.g(i4));
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.d(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void g() {
            this.f11386e = false;
        }

        public a i(int i4) {
            return (a) this.f11385d.e(i4);
        }

        public boolean j() {
            return this.f11386e;
        }

        public void k() {
            int i4 = this.f11385d.i();
            for (int i5 = 0; i5 < i4; i5++) {
                ((a) this.f11385d.j(i5)).f();
            }
        }

        public void l(int i4, a aVar) {
            this.f11385d.h(i4, aVar);
        }

        public void m() {
            this.f11386e = true;
        }
    }

    public C1209b(InterfaceC0850m interfaceC0850m, M m4) {
        this.f11373a = interfaceC0850m;
        this.f11374b = c.h(m4);
    }

    @Override // d0.AbstractC1208a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f11374b.f(str, fileDescriptor, printWriter, strArr);
    }

    @Override // d0.AbstractC1208a
    public AbstractC1226b c(int i4, Bundle bundle, AbstractC1208a.InterfaceC0181a interfaceC0181a) {
        if (this.f11374b.j()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a aVarI = this.f11374b.i(i4);
        if (f11372c) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (aVarI == null) {
            return e(i4, bundle, interfaceC0181a, null);
        }
        if (f11372c) {
            Log.v("LoaderManager", "  Re-using existing loader " + aVarI);
        }
        return aVarI.g(this.f11373a, interfaceC0181a);
    }

    @Override // d0.AbstractC1208a
    public void d() {
        this.f11374b.k();
    }

    public final AbstractC1226b e(int i4, Bundle bundle, AbstractC1208a.InterfaceC0181a interfaceC0181a, AbstractC1226b abstractC1226b) {
        try {
            this.f11374b.m();
            AbstractC1226b abstractC1226bA = interfaceC0181a.a(i4, bundle);
            if (abstractC1226bA == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (abstractC1226bA.getClass().isMemberClass() && !Modifier.isStatic(abstractC1226bA.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + abstractC1226bA);
            }
            a aVar = new a(i4, bundle, abstractC1226bA, abstractC1226b);
            if (f11372c) {
                Log.v("LoaderManager", "  Created new loader " + aVar);
            }
            this.f11374b.l(i4, aVar);
            this.f11374b.g();
            return aVar.g(this.f11373a, interfaceC0181a);
        } catch (Throwable th) {
            this.f11374b.g();
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Class<?> cls = this.f11373a.getClass();
        sb.append(cls.getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(cls)));
        sb.append("}}");
        return sb.toString();
    }
}
