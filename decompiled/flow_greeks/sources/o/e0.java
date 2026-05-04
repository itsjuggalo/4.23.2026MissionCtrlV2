package o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17246a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17247b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17248c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17249d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17250e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17251f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f17252g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f17253h = false;

    public int a() {
        return this.f17252g ? this.f17246a : this.f17247b;
    }

    public int b() {
        return this.f17246a;
    }

    public int c() {
        return this.f17247b;
    }

    public int d() {
        return this.f17252g ? this.f17247b : this.f17246a;
    }

    public void e(int i10, int i11) {
        this.f17253h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f17250e = i10;
            this.f17246a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f17251f = i11;
            this.f17247b = i11;
        }
    }

    public void f(boolean z10) {
        if (z10 == this.f17252g) {
            return;
        }
        this.f17252g = z10;
        if (!this.f17253h) {
            this.f17246a = this.f17250e;
            this.f17247b = this.f17251f;
            return;
        }
        if (z10) {
            int i10 = this.f17249d;
            if (i10 == Integer.MIN_VALUE) {
                i10 = this.f17250e;
            }
            this.f17246a = i10;
            int i11 = this.f17248c;
            if (i11 == Integer.MIN_VALUE) {
                i11 = this.f17251f;
            }
            this.f17247b = i11;
            return;
        }
        int i12 = this.f17248c;
        if (i12 == Integer.MIN_VALUE) {
            i12 = this.f17250e;
        }
        this.f17246a = i12;
        int i13 = this.f17249d;
        if (i13 == Integer.MIN_VALUE) {
            i13 = this.f17251f;
        }
        this.f17247b = i13;
    }

    public void g(int i10, int i11) {
        this.f17248c = i10;
        this.f17249d = i11;
        this.f17253h = true;
        if (this.f17252g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f17246a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f17247b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f17246a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f17247b = i11;
        }
    }
}
