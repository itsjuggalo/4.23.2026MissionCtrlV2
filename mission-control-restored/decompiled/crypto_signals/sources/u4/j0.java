package u4;

import N1.C0094g0;
import a.AbstractC0284a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List f10435d;
    public static final j0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j0 f10436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j0 f10437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final j0 f10438h;
    public static final j0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final j0 f10439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final j0 f10440k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final j0 f10441l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final j0 f10442m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final j0 f10443n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final X f10444o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final X f10445p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f10446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f10448c;

    static {
        TreeMap treeMap = new TreeMap();
        for (i0 i0Var : i0.values()) {
            j0 j0Var = (j0) treeMap.put(Integer.valueOf(i0Var.f10431a), new j0(i0Var, null, null));
            if (j0Var != null) {
                throw new IllegalStateException("Code value duplication between " + j0Var.f10446a.name() + " & " + i0Var.name());
            }
        }
        f10435d = Collections.unmodifiableList(new ArrayList(treeMap.values()));
        e = i0.OK.a();
        f10436f = i0.CANCELLED.a();
        f10437g = i0.UNKNOWN.a();
        i0.INVALID_ARGUMENT.a();
        f10438h = i0.DEADLINE_EXCEEDED.a();
        i0.NOT_FOUND.a();
        i0.ALREADY_EXISTS.a();
        i = i0.PERMISSION_DENIED.a();
        f10439j = i0.UNAUTHENTICATED.a();
        f10440k = i0.RESOURCE_EXHAUSTED.a();
        f10441l = i0.FAILED_PRECONDITION.a();
        i0.ABORTED.a();
        i0.OUT_OF_RANGE.a();
        i0.UNIMPLEMENTED.a();
        f10442m = i0.INTERNAL.a();
        f10443n = i0.UNAVAILABLE.a();
        i0.DATA_LOSS.a();
        f10444o = new X("grpc-status", false, new C1226h(10));
        f10445p = new X("grpc-message", false, new C1226h(1));
    }

    public j0(i0 i0Var, String str, Throwable th) {
        s3.D.j(i0Var, "code");
        this.f10446a = i0Var;
        this.f10447b = str;
        this.f10448c = th;
    }

    public static String b(j0 j0Var) {
        String str = j0Var.f10447b;
        i0 i0Var = j0Var.f10446a;
        if (str == null) {
            return i0Var.toString();
        }
        return i0Var + ": " + j0Var.f10447b;
    }

    public static j0 c(int i6) {
        if (i6 >= 0) {
            List list = f10435d;
            if (i6 < list.size()) {
                return (j0) list.get(i6);
            }
        }
        return f10437g.g("Unknown code " + i6);
    }

    public static j0 d(Throwable th) {
        s3.D.j(th, "t");
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof k0) {
                return ((k0) cause).f10454a;
            }
            if (cause instanceof l0) {
                return ((l0) cause).f10458a;
            }
        }
        return f10437g.f(th);
    }

    public final j0 a(String str) {
        if (str == null) {
            return this;
        }
        Throwable th = this.f10448c;
        i0 i0Var = this.f10446a;
        String str2 = this.f10447b;
        if (str2 == null) {
            return new j0(i0Var, str, th);
        }
        return new j0(i0Var, str2 + "\n" + str, th);
    }

    public final boolean e() {
        return i0.OK == this.f10446a;
    }

    public final j0 f(Throwable th) {
        return android.support.v4.media.session.a.k(this.f10448c, th) ? this : new j0(this.f10446a, this.f10447b, th);
    }

    public final j0 g(String str) {
        return android.support.v4.media.session.a.k(this.f10447b, str) ? this : new j0(this.f10446a, str, this.f10448c);
    }

    public final String toString() {
        C0094g0 c0094g0J = AbstractC0284a.J(this);
        c0094g0J.a(this.f10446a.name(), "code");
        c0094g0J.a(this.f10447b, "description");
        Throwable th = this.f10448c;
        Object string = th;
        if (th != null) {
            Object obj = U1.p.f3121a;
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            string = stringWriter.toString();
        }
        c0094g0J.a(string, "cause");
        return c0094g0J.toString();
    }
}
