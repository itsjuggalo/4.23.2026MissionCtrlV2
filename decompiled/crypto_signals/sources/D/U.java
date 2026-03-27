package D;

import android.os.Build;
import android.view.View;
import java.util.Objects;
import w.C1264c;

/* JADX INFO: loaded from: classes.dex */
public class U {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final V f216b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f217a;

    static {
        int i = Build.VERSION.SDK_INT;
        f216b = (i >= 30 ? new L() : i >= 29 ? new K() : new J()).b().f219a.a().f219a.b().f219a.c();
    }

    public U(V v2) {
        this.f217a = v2;
    }

    public V a() {
        return this.f217a;
    }

    public V b() {
        return this.f217a;
    }

    public V c() {
        return this.f217a;
    }

    public C0004d e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof U)) {
            return false;
        }
        U u6 = (U) obj;
        return j() == u6.j() && i() == u6.i() && Objects.equals(g(), u6.g()) && Objects.equals(f(), u6.f()) && Objects.equals(e(), u6.e());
    }

    public C1264c f() {
        return C1264c.e;
    }

    public C1264c g() {
        return C1264c.e;
    }

    public V h(int i, int i6, int i7, int i8) {
        return f216b;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(j()), Boolean.valueOf(i()), g(), f(), e());
    }

    public boolean i() {
        return false;
    }

    public boolean j() {
        return false;
    }

    public void d(View view) {
    }

    public void k(C1264c[] c1264cArr) {
    }

    public void l(V v2) {
    }

    public void m(C1264c c1264c) {
    }
}
