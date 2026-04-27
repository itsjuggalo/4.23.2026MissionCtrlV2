package o;

/* JADX INFO: loaded from: classes.dex */
public class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21747a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21748b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21749c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21750d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21751e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21752f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21753g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f21754h = false;

    public int a() {
        return this.f21753g ? this.f21747a : this.f21748b;
    }

    public int b() {
        return this.f21747a;
    }

    public int c() {
        return this.f21748b;
    }

    public int d() {
        return this.f21753g ? this.f21748b : this.f21747a;
    }

    public void e(int i8, int i9) {
        this.f21754h = false;
        if (i8 != Integer.MIN_VALUE) {
            this.f21751e = i8;
            this.f21747a = i8;
        }
        if (i9 != Integer.MIN_VALUE) {
            this.f21752f = i9;
            this.f21748b = i9;
        }
    }

    public void f(boolean z7) {
        int i8;
        if (z7 == this.f21753g) {
            return;
        }
        this.f21753g = z7;
        if (this.f21754h) {
            if (z7) {
                int i9 = this.f21750d;
                if (i9 == Integer.MIN_VALUE) {
                    i9 = this.f21751e;
                }
                this.f21747a = i9;
                i8 = this.f21749c;
                if (i8 == Integer.MIN_VALUE) {
                }
            } else {
                int i10 = this.f21749c;
                if (i10 == Integer.MIN_VALUE) {
                    i10 = this.f21751e;
                }
                this.f21747a = i10;
                i8 = this.f21750d;
                if (i8 == Integer.MIN_VALUE) {
                }
            }
            this.f21748b = i8;
        }
        this.f21747a = this.f21751e;
        i8 = this.f21752f;
        this.f21748b = i8;
    }

    public void g(int i8, int i9) {
        this.f21749c = i8;
        this.f21750d = i9;
        this.f21754h = true;
        if (this.f21753g) {
            if (i9 != Integer.MIN_VALUE) {
                this.f21747a = i9;
            }
            if (i8 != Integer.MIN_VALUE) {
                this.f21748b = i8;
                return;
            }
            return;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.f21747a = i8;
        }
        if (i9 != Integer.MIN_VALUE) {
            this.f21748b = i9;
        }
    }
}
