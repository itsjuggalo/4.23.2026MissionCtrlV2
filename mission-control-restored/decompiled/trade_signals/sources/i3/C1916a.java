package i3;

import h3.C1875k;
import i3.AbstractC1919d;
import k3.AbstractC2279m;
import k3.C2270d;
import p3.C2548b;

/* JADX INFO: renamed from: i3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1916a extends AbstractC1919d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C2270d f18781e;

    public C1916a(C1875k c1875k, C2270d c2270d, boolean z7) {
        super(AbstractC1919d.a.AckUserWrite, C1920e.f18791d, c1875k);
        this.f18781e = c2270d;
        this.f18780d = z7;
    }

    @Override // i3.AbstractC1919d
    public AbstractC1919d d(C2548b c2548b) {
        if (!this.f18785c.isEmpty()) {
            AbstractC2279m.g(this.f18785c.P().equals(c2548b), "operationForChild called for unrelated child.");
            return new C1916a(this.f18785c.S(), this.f18781e, this.f18780d);
        }
        if (this.f18781e.getValue() != null) {
            AbstractC2279m.g(this.f18781e.I().isEmpty(), "affectedTree should not have overlapping affected paths.");
            return this;
        }
        return new C1916a(C1875k.O(), this.f18781e.P(new C1875k(c2548b)), this.f18780d);
    }

    public C2270d e() {
        return this.f18781e;
    }

    public boolean f() {
        return this.f18780d;
    }

    public String toString() {
        return String.format("AckUserWrite { path=%s, revert=%s, affectedTree=%s }", a(), Boolean.valueOf(this.f18780d), this.f18781e);
    }
}
