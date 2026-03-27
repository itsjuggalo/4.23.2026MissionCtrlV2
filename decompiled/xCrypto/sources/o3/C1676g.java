package o3;

import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: o3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1676g extends C1674e implements InterfaceC1673d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f13942e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C1676g f13943f = new C1676g(1, 0);

    /* JADX INFO: renamed from: o3.g$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final C1676g a() {
            return C1676g.f13943f;
        }

        public a() {
        }
    }

    public C1676g(int i4, int i5) {
        super(i4, i5, 1);
    }

    @Override // o3.C1674e
    public boolean equals(Object obj) {
        if (!(obj instanceof C1676g)) {
            return false;
        }
        if (isEmpty() && ((C1676g) obj).isEmpty()) {
            return true;
        }
        C1676g c1676g = (C1676g) obj;
        return k() == c1676g.k() && l() == c1676g.l();
    }

    @Override // o3.C1674e
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (k() * 31) + l();
    }

    @Override // o3.C1674e, o3.InterfaceC1673d
    public boolean isEmpty() {
        return k() > l();
    }

    @Override // o3.InterfaceC1673d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Integer i() {
        return Integer.valueOf(l());
    }

    @Override // o3.InterfaceC1673d
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Integer f() {
        return Integer.valueOf(k());
    }

    @Override // o3.C1674e
    public String toString() {
        return k() + ".." + l();
    }
}
