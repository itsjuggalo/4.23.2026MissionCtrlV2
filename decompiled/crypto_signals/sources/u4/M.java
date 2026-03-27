package u4;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class M {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1219a f10355b = new C1219a("internal:health-checking-config");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1226h f10356c = new C1226h(5);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1219a f10357d = new C1219a("internal:has-health-check-producer-listener");
    public static final C1219a e = new C1219a("io.grpc.IS_PETIOLE_POLICY");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10358a;

    public j0 a(J j4) {
        List list = j4.f10352a;
        if (!list.isEmpty() || b()) {
            int i = this.f10358a;
            this.f10358a = i + 1;
            if (i == 0) {
                d(j4);
            }
            this.f10358a = 0;
            return j0.e;
        }
        j0 j0VarG = j0.f10443n.g("NameResolver returned no usable address. addrs=" + list + ", attrs=" + j4.f10353b);
        c(j0VarG);
        return j0VarG;
    }

    public boolean b() {
        return false;
    }

    public abstract void c(j0 j0Var);

    public void d(J j4) {
        int i = this.f10358a;
        this.f10358a = i + 1;
        if (i == 0) {
            a(j4);
        }
        this.f10358a = 0;
    }

    public abstract void f();

    public void e() {
    }
}
