package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0337t implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0339v f4614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AbstractC0339v f4615b;

    public AbstractC0337t(AbstractC0339v abstractC0339v) {
        this.f4614a = abstractC0339v;
        if (abstractC0339v.g()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f4615b = abstractC0339v.i();
    }

    public final AbstractC0339v a() {
        AbstractC0339v abstractC0339vB = b();
        abstractC0339vB.getClass();
        if (AbstractC0339v.f(abstractC0339vB, true)) {
            return abstractC0339vB;
        }
        throw new b0();
    }

    public final AbstractC0339v b() {
        if (!this.f4615b.g()) {
            return this.f4615b;
        }
        AbstractC0339v abstractC0339v = this.f4615b;
        abstractC0339v.getClass();
        S s6 = S.f4509c;
        s6.getClass();
        s6.a(abstractC0339v.getClass()).b(abstractC0339v);
        abstractC0339v.h();
        return this.f4615b;
    }

    public final void c() {
        if (this.f4615b.g()) {
            return;
        }
        AbstractC0339v abstractC0339vI = this.f4614a.i();
        AbstractC0339v abstractC0339v = this.f4615b;
        S s6 = S.f4509c;
        s6.getClass();
        s6.a(abstractC0339vI.getClass()).a(abstractC0339vI, abstractC0339v);
        this.f4615b = abstractC0339vI;
    }

    public final Object clone() {
        AbstractC0337t abstractC0337t = (AbstractC0337t) this.f4614a.c(5);
        abstractC0337t.f4615b = b();
        return abstractC0337t;
    }
}
