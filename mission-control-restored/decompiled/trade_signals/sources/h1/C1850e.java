package h1;

import W0.r;

/* JADX INFO: renamed from: h1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1850e extends f1.j implements r {
    public C1850e(C1848c c1848c) {
        super(c1848c);
    }

    @Override // f1.j, W0.r
    public void a() {
        ((C1848c) this.f17382a).e().prepareToDraw();
    }

    @Override // W0.v
    public void b() {
        ((C1848c) this.f17382a).stop();
        ((C1848c) this.f17382a).k();
    }

    @Override // W0.v
    public int c() {
        return ((C1848c) this.f17382a).i();
    }

    @Override // W0.v
    public Class d() {
        return C1848c.class;
    }
}
