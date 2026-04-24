package o3;

import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: o3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1672c extends AbstractC1670a implements InterfaceC1673d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f13932e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C1672c f13933f = new C1672c(1, 0);

    /* JADX INFO: renamed from: o3.c$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public C1672c(char c4, char c5) {
        super(c4, c5, 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1672c)) {
            return false;
        }
        if (isEmpty() && ((C1672c) obj).isEmpty()) {
            return true;
        }
        C1672c c1672c = (C1672c) obj;
        return k() == c1672c.k() && l() == c1672c.l();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (k() * 31) + l();
    }

    @Override // o3.InterfaceC1673d
    public boolean isEmpty() {
        return r.g(k(), l()) > 0;
    }

    @Override // o3.InterfaceC1673d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Character i() {
        return Character.valueOf(l());
    }

    @Override // o3.InterfaceC1673d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Character f() {
        return Character.valueOf(k());
    }

    public String toString() {
        return k() + ".." + l();
    }
}
