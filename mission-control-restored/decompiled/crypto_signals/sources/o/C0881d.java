package o;

import java.util.Iterator;

/* JADX INFO: renamed from: o.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0881d extends AbstractC0882e implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0880c f8619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8620b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0883f f8621c;

    public C0881d(C0883f c0883f) {
        this.f8621c = c0883f;
    }

    @Override // o.AbstractC0882e
    public final void a(C0880c c0880c) {
        C0880c c0880c2 = this.f8619a;
        if (c0880c == c0880c2) {
            C0880c c0880c3 = c0880c2.f8618d;
            this.f8619a = c0880c3;
            this.f8620b = c0880c3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f8620b) {
            return this.f8621c.f8622a != null;
        }
        C0880c c0880c = this.f8619a;
        return (c0880c == null || c0880c.f8617c == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f8620b) {
            this.f8620b = false;
            this.f8619a = this.f8621c.f8622a;
        } else {
            C0880c c0880c = this.f8619a;
            this.f8619a = c0880c != null ? c0880c.f8617c : null;
        }
        return this.f8619a;
    }
}
