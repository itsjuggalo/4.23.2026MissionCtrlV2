package u0;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: renamed from: u0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2743b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f24398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f24399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f24400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f24401d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f24402e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f24403f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f24404g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f24405h = false;

    /* JADX INFO: renamed from: u0.b$a */
    public interface a {
        void a(AbstractC2743b abstractC2743b, Object obj);
    }

    public AbstractC2743b(Context context) {
        this.f24400c = context.getApplicationContext();
    }

    public void a() {
        this.f24402e = true;
        k();
    }

    public boolean b() {
        return l();
    }

    public void c() {
        this.f24405h = false;
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
        a aVar = this.f24399b;
        if (aVar != null) {
            aVar.a(this, obj);
        }
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f24398a);
        printWriter.print(" mListener=");
        printWriter.println(this.f24399b);
        if (this.f24401d || this.f24404g || this.f24405h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f24401d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f24404g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f24405h);
        }
        if (this.f24402e || this.f24403f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f24402e);
            printWriter.print(" mReset=");
            printWriter.println(this.f24403f);
        }
    }

    public void h() {
        n();
    }

    public boolean i() {
        return this.f24402e;
    }

    public boolean j() {
        return this.f24401d;
    }

    public abstract boolean l();

    public void m() {
        if (this.f24401d) {
            h();
        } else {
            this.f24404g = true;
        }
    }

    public abstract void p();

    public void r(int i7, a aVar) {
        if (this.f24399b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f24399b = aVar;
        this.f24398a = i7;
    }

    public void s() {
        o();
        this.f24403f = true;
        this.f24401d = false;
        this.f24402e = false;
        this.f24404g = false;
        this.f24405h = false;
    }

    public void t() {
        if (this.f24405h) {
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
        sb.append(this.f24398a);
        sb.append("}");
        return sb.toString();
    }

    public final void u() {
        this.f24401d = true;
        this.f24403f = false;
        this.f24402e = false;
        p();
    }

    public void v() {
        this.f24401d = false;
        q();
    }

    public void w(a aVar) {
        a aVar2 = this.f24399b;
        if (aVar2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (aVar2 != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f24399b = null;
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
