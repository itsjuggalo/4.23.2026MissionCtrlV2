package a2;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f24a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f25b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f26c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f27d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f28e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f29f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f30g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f31h = false;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void a(b bVar, Object obj);
    }

    public b(Context context) {
        this.f26c = context.getApplicationContext();
    }

    public void a() {
        this.f28e = true;
        k();
    }

    public boolean b() {
        return l();
    }

    public void c() {
        this.f31h = false;
    }

    public String d(Object obj) {
        StringBuilder sb2 = new StringBuilder(64);
        if (obj == null) {
            sb2.append("null");
        } else {
            Class<?> cls = obj.getClass();
            sb2.append(cls.getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(cls)));
            sb2.append("}");
        }
        return sb2.toString();
    }

    public void f(Object obj) {
        a aVar = this.f25b;
        if (aVar != null) {
            aVar.a(this, obj);
        }
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f24a);
        printWriter.print(" mListener=");
        printWriter.println(this.f25b);
        if (this.f27d || this.f30g || this.f31h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f27d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f30g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f31h);
        }
        if (this.f28e || this.f29f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f28e);
            printWriter.print(" mReset=");
            printWriter.println(this.f29f);
        }
    }

    public void h() {
        n();
    }

    public boolean i() {
        return this.f28e;
    }

    public boolean j() {
        return this.f27d;
    }

    public abstract boolean l();

    public void m() {
        if (this.f27d) {
            h();
        } else {
            this.f30g = true;
        }
    }

    public abstract void p();

    public void r(int i10, a aVar) {
        if (this.f25b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f25b = aVar;
        this.f24a = i10;
    }

    public void s() {
        o();
        this.f29f = true;
        this.f27d = false;
        this.f28e = false;
        this.f30g = false;
        this.f31h = false;
    }

    public void t() {
        if (this.f31h) {
            m();
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        Class<?> cls = getClass();
        sb2.append(cls.getSimpleName());
        sb2.append("{");
        sb2.append(Integer.toHexString(System.identityHashCode(cls)));
        sb2.append(" id=");
        sb2.append(this.f24a);
        sb2.append("}");
        return sb2.toString();
    }

    public final void u() {
        this.f27d = true;
        this.f29f = false;
        this.f28e = false;
        p();
    }

    public void v() {
        this.f27d = false;
        q();
    }

    public void w(a aVar) {
        a aVar2 = this.f25b;
        if (aVar2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (aVar2 != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f25b = null;
    }

    public void e() {
    }

    public void k() {
    }

    public void n() {
    }

    public void o() {
    }

    public void q() {
    }
}
