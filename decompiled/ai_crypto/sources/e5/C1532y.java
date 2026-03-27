package e5;

/* JADX INFO: renamed from: e5.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1532y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Exception f13735a;

    public C1532y(Exception exc) {
        this.f13735a = exc;
    }

    public static C1532y a() {
        return new C1532y();
    }

    public static C1532y b(Exception exc) {
        return new C1532y(exc);
    }

    public C1532y() {
        this.f13735a = null;
    }
}
