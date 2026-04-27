package W5;

import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends W5.a implements d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f5447e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f5448f = new c(1, 0);

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public c(char c7, char c8) {
        super(c7, c8, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (g() != cVar.g() || h() != cVar.h()) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + h();
    }

    @Override // W5.d
    public boolean isEmpty() {
        return r.g(g(), h()) > 0;
    }

    @Override // W5.d
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Character c() {
        return Character.valueOf(h());
    }

    @Override // W5.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public Character a() {
        return Character.valueOf(g());
    }

    public String toString() {
        return g() + ".." + h();
    }
}
