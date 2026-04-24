package p;

/* JADX INFO: loaded from: classes.dex */
public class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21256a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21257b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21258c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21259d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21260e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21261f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21262g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f21263h = false;

    public int a() {
        return this.f21262g ? this.f21256a : this.f21257b;
    }

    public int b() {
        return this.f21256a;
    }

    public int c() {
        return this.f21257b;
    }

    public int d() {
        return this.f21262g ? this.f21257b : this.f21256a;
    }

    public void e(int i7, int i8) {
        this.f21263h = false;
        if (i7 != Integer.MIN_VALUE) {
            this.f21260e = i7;
            this.f21256a = i7;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.f21261f = i8;
            this.f21257b = i8;
        }
    }

    public void f(boolean z7) {
        if (z7 == this.f21262g) {
            return;
        }
        this.f21262g = z7;
        if (!this.f21263h) {
            this.f21256a = this.f21260e;
            this.f21257b = this.f21261f;
            return;
        }
        if (z7) {
            int i7 = this.f21259d;
            if (i7 == Integer.MIN_VALUE) {
                i7 = this.f21260e;
            }
            this.f21256a = i7;
            int i8 = this.f21258c;
            if (i8 == Integer.MIN_VALUE) {
                i8 = this.f21261f;
            }
            this.f21257b = i8;
            return;
        }
        int i9 = this.f21258c;
        if (i9 == Integer.MIN_VALUE) {
            i9 = this.f21260e;
        }
        this.f21256a = i9;
        int i10 = this.f21259d;
        if (i10 == Integer.MIN_VALUE) {
            i10 = this.f21261f;
        }
        this.f21257b = i10;
    }

    public void g(int i7, int i8) {
        this.f21258c = i7;
        this.f21259d = i8;
        this.f21263h = true;
        if (this.f21262g) {
            if (i8 != Integer.MIN_VALUE) {
                this.f21256a = i8;
            }
            if (i7 != Integer.MIN_VALUE) {
                this.f21257b = i7;
                return;
            }
            return;
        }
        if (i7 != Integer.MIN_VALUE) {
            this.f21256a = i7;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.f21257b = i8;
        }
    }
}
