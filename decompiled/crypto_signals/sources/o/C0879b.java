package o;

import java.util.Iterator;

/* JADX INFO: renamed from: o.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0879b extends AbstractC0882e implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0880c f8612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0880c f8613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8614c;

    public C0879b(C0880c c0880c, C0880c c0880c2, int i) {
        this.f8614c = i;
        this.f8612a = c0880c2;
        this.f8613b = c0880c;
    }

    @Override // o.AbstractC0882e
    public final void a(C0880c c0880c) {
        C0880c c0880c2;
        C0880c c0880cB = null;
        if (this.f8612a == c0880c && c0880c == this.f8613b) {
            this.f8613b = null;
            this.f8612a = null;
        }
        C0880c c0880c3 = this.f8612a;
        if (c0880c3 == c0880c) {
            switch (this.f8614c) {
                case 0:
                    c0880c2 = c0880c3.f8618d;
                    break;
                default:
                    c0880c2 = c0880c3.f8617c;
                    break;
            }
            this.f8612a = c0880c2;
        }
        C0880c c0880c4 = this.f8613b;
        if (c0880c4 == c0880c) {
            C0880c c0880c5 = this.f8612a;
            if (c0880c4 != c0880c5 && c0880c5 != null) {
                c0880cB = b(c0880c4);
            }
            this.f8613b = c0880cB;
        }
    }

    public final C0880c b(C0880c c0880c) {
        switch (this.f8614c) {
            case 0:
                return c0880c.f8617c;
            default:
                return c0880c.f8618d;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f8613b != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        C0880c c0880c = this.f8613b;
        C0880c c0880c2 = this.f8612a;
        this.f8613b = (c0880c == c0880c2 || c0880c2 == null) ? null : b(c0880c);
        return c0880c;
    }
}
