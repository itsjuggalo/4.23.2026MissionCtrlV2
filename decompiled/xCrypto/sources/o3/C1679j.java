package o3;

import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: o3.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1679j extends AbstractC1677h implements InterfaceC1673d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f13952e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C1679j f13953f = new C1679j(1, 0);

    /* JADX INFO: renamed from: o3.j$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public C1679j(long j4, long j5) {
        super(j4, j5, 1L);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1679j)) {
            return false;
        }
        if (isEmpty() && ((C1679j) obj).isEmpty()) {
            return true;
        }
        C1679j c1679j = (C1679j) obj;
        return k() == c1679j.k() && l() == c1679j.l();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (k() ^ (k() >>> 32))) + (l() ^ (l() >>> 32)));
    }

    @Override // o3.InterfaceC1673d
    public boolean isEmpty() {
        return k() > l();
    }

    @Override // o3.InterfaceC1673d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Long i() {
        return Long.valueOf(l());
    }

    @Override // o3.InterfaceC1673d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Long f() {
        return Long.valueOf(k());
    }

    public String toString() {
        return k() + ".." + l();
    }
}
