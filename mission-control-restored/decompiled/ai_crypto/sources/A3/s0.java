package A3;

import android.app.Activity;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f225d;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c0 f226a = c0.EXCLUDE;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public T f227b = T.DEFAULT;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Executor f228c = K3.p.f3450a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Activity f229d = null;

        public s0 e() {
            return new s0(this);
        }

        public b f(c0 c0Var) {
            K3.z.c(c0Var, "metadataChanges must not be null.");
            this.f226a = c0Var;
            return this;
        }

        public b g(T t7) {
            K3.z.c(t7, "listen source must not be null.");
            this.f227b = t7;
            return this;
        }
    }

    public Activity a() {
        return this.f225d;
    }

    public Executor b() {
        return this.f224c;
    }

    public c0 c() {
        return this.f222a;
    }

    public T d() {
        return this.f223b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s0.class != obj.getClass()) {
            return false;
        }
        s0 s0Var = (s0) obj;
        return this.f222a == s0Var.f222a && this.f223b == s0Var.f223b && this.f224c.equals(s0Var.f224c) && this.f225d.equals(s0Var.f225d);
    }

    public int hashCode() {
        int iHashCode = ((((this.f222a.hashCode() * 31) + this.f223b.hashCode()) * 31) + this.f224c.hashCode()) * 31;
        Activity activity = this.f225d;
        return iHashCode + (activity != null ? activity.hashCode() : 0);
    }

    public String toString() {
        return "SnapshotListenOptions{metadataChanges=" + this.f222a + ", source=" + this.f223b + ", executor=" + this.f224c + ", activity=" + this.f225d + '}';
    }

    public s0(b bVar) {
        this.f222a = bVar.f226a;
        this.f223b = bVar.f227b;
        this.f224c = bVar.f228c;
        this.f225d = bVar.f229d;
    }
}
