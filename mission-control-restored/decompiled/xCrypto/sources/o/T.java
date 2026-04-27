package o;

/* JADX INFO: loaded from: classes.dex */
public class T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13748a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13749b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13750c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13751d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13752e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13753f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13754g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13755h = false;

    public int a() {
        return this.f13754g ? this.f13748a : this.f13749b;
    }

    public int b() {
        return this.f13748a;
    }

    public int c() {
        return this.f13749b;
    }

    public int d() {
        return this.f13754g ? this.f13749b : this.f13748a;
    }

    public void e(int i4, int i5) {
        this.f13755h = false;
        if (i4 != Integer.MIN_VALUE) {
            this.f13752e = i4;
            this.f13748a = i4;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f13753f = i5;
            this.f13749b = i5;
        }
    }

    public void f(boolean z4) {
        if (z4 == this.f13754g) {
            return;
        }
        this.f13754g = z4;
        if (!this.f13755h) {
            this.f13748a = this.f13752e;
            this.f13749b = this.f13753f;
            return;
        }
        if (z4) {
            int i4 = this.f13751d;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.f13752e;
            }
            this.f13748a = i4;
            int i5 = this.f13750c;
            if (i5 == Integer.MIN_VALUE) {
                i5 = this.f13753f;
            }
            this.f13749b = i5;
            return;
        }
        int i6 = this.f13750c;
        if (i6 == Integer.MIN_VALUE) {
            i6 = this.f13752e;
        }
        this.f13748a = i6;
        int i7 = this.f13751d;
        if (i7 == Integer.MIN_VALUE) {
            i7 = this.f13753f;
        }
        this.f13749b = i7;
    }

    public void g(int i4, int i5) {
        this.f13750c = i4;
        this.f13751d = i5;
        this.f13755h = true;
        if (this.f13754g) {
            if (i5 != Integer.MIN_VALUE) {
                this.f13748a = i5;
            }
            if (i4 != Integer.MIN_VALUE) {
                this.f13749b = i4;
                return;
            }
            return;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f13748a = i4;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f13749b = i5;
        }
    }
}
