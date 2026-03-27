package o3;

import X2.AbstractC0767n;
import j3.InterfaceC1564a;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: o3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1670a implements Iterable, InterfaceC1564a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0222a f13924d = new C0222a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f13925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f13926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13927c;

    /* JADX INFO: renamed from: o3.a$a, reason: collision with other inner class name */
    public static final class C0222a {
        public /* synthetic */ C0222a(AbstractC1585j abstractC1585j) {
            this();
        }

        public C0222a() {
        }
    }

    public AbstractC1670a(char c4, char c5, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f13925a = c4;
        this.f13926b = (char) d3.c.c(c4, c5, i4);
        this.f13927c = i4;
    }

    public final char k() {
        return this.f13925a;
    }

    public final char l() {
        return this.f13926b;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public AbstractC0767n iterator() {
        return new C1671b(this.f13925a, this.f13926b, this.f13927c);
    }
}
