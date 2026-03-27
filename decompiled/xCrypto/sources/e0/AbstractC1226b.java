package e0;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: renamed from: e0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1226b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f11479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f11480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11481d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11482e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11483f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11484g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11485h = false;

    /* JADX INFO: renamed from: e0.b$a */
    public interface a {
        void a(AbstractC1226b abstractC1226b, Object obj);
    }

    public AbstractC1226b(Context context) {
        this.f11480c = context.getApplicationContext();
    }

    public void a() {
        this.f11482e = true;
        k();
    }

    public boolean b() {
        return l();
    }

    public void c() {
        this.f11485h = false;
    }

    public String d(Object obj) {
        StringBuilder sb = new StringBuilder(64);
        if (obj == null) {
            sb.append("null");
        } else {
            Class<?> cls = obj.getClass();
            sb.append(cls.getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(cls)));
            sb.append("}");
        }
        return sb.toString();
    }

    public void f(Object obj) {
        a aVar = this.f11479b;
        if (aVar != null) {
            aVar.a(this, obj);
        }
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f11478a);
        printWriter.print(" mListener=");
        printWriter.println(this.f11479b);
        if (this.f11481d || this.f11484g || this.f11485h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f11481d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f11484g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f11485h);
        }
        if (this.f11482e || this.f11483f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f11482e);
            printWriter.print(" mReset=");
            printWriter.println(this.f11483f);
        }
    }

    public void h() {
        n();
    }

    public boolean i() {
        return this.f11482e;
    }

    public boolean j() {
        return this.f11481d;
    }

    public abstract boolean l();

    public void m() {
        if (this.f11481d) {
            h();
        } else {
            this.f11484g = true;
        }
    }

    public abstract void p();

    public void r(int i4, a aVar) {
        if (this.f11479b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f11479b = aVar;
        this.f11478a = i4;
    }

    public void s() {
        o();
        this.f11483f = true;
        this.f11481d = false;
        this.f11482e = false;
        this.f11484g = false;
        this.f11485h = false;
    }

    public void t() {
        if (this.f11485h) {
            m();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        Class<?> cls = getClass();
        sb.append(cls.getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(cls)));
        sb.append(" id=");
        sb.append(this.f11478a);
        sb.append("}");
        return sb.toString();
    }

    public final void u() {
        this.f11481d = true;
        this.f11483f = false;
        this.f11482e = false;
        p();
    }

    public void v() {
        this.f11481d = false;
        q();
    }

    public void w(a aVar) {
        a aVar2 = this.f11479b;
        if (aVar2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (aVar2 != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f11479b = null;
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
