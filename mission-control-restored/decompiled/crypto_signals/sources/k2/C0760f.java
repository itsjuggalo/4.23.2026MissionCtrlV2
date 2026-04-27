package k2;

/* JADX INFO: renamed from: k2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0760f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0769o f7848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7849b;

    public C0760f(C0769o c0769o, boolean z6) {
        this.f7848a = c0769o;
        this.f7849b = z6;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0760f) {
            C0760f c0760f = (C0760f) obj;
            if (c0760f.f7848a.equals(this.f7848a) && c0760f.f7849b == this.f7849b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f7848a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f7849b).hashCode();
    }
}
