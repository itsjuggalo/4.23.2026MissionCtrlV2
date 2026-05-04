package vd;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends vd.a implements d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f23384e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f23385f = new c(1, 0);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public c(char c10, char c11) {
        super(c10, c11, 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (isEmpty() && ((c) obj).isEmpty()) {
            return true;
        }
        c cVar = (c) obj;
        return e() == cVar.e() && f() == cVar.f();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (e() * 31) + f();
    }

    @Override // vd.d
    public boolean isEmpty() {
        return t.g(e(), f()) > 0;
    }

    @Override // vd.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Character c() {
        return Character.valueOf(f());
    }

    @Override // vd.d
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Character a() {
        return Character.valueOf(e());
    }

    public String toString() {
        return e() + ".." + f();
    }
}
