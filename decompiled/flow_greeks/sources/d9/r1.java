package d9;

import android.app.Activity;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1 f7924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0 f7925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f7926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f7927d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b1 f7928a = b1.EXCLUDE;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public s0 f7929b = s0.DEFAULT;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Executor f7930c = n9.p.f16962a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Activity f7931d = null;

        public r1 e() {
            return new r1(this);
        }

        public b f(b1 b1Var) {
            n9.x.c(b1Var, "metadataChanges must not be null.");
            this.f7928a = b1Var;
            return this;
        }

        public b g(s0 s0Var) {
            n9.x.c(s0Var, "listen source must not be null.");
            this.f7929b = s0Var;
            return this;
        }
    }

    public Activity a() {
        return this.f7927d;
    }

    public Executor b() {
        return this.f7926c;
    }

    public b1 c() {
        return this.f7924a;
    }

    public s0 d() {
        return this.f7925b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && r1.class == obj.getClass()) {
            r1 r1Var = (r1) obj;
            if (this.f7924a == r1Var.f7924a && this.f7925b == r1Var.f7925b && this.f7926c.equals(r1Var.f7926c) && this.f7927d.equals(r1Var.f7927d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((this.f7924a.hashCode() * 31) + this.f7925b.hashCode()) * 31) + this.f7926c.hashCode()) * 31;
        Activity activity = this.f7927d;
        return iHashCode + (activity != null ? activity.hashCode() : 0);
    }

    public String toString() {
        return "SnapshotListenOptions{metadataChanges=" + this.f7924a + ", source=" + this.f7925b + ", executor=" + this.f7926c + ", activity=" + this.f7927d + '}';
    }

    public r1(b bVar) {
        this.f7924a = bVar.f7928a;
        this.f7925b = bVar.f7929b;
        this.f7926c = bVar.f7930c;
        this.f7927d = bVar.f7931d;
    }
}
