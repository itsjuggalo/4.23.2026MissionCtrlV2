package W5;

import F5.AbstractC0554l;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Iterable, R5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0096a f5439d = new C0096a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f5440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f5441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5442c;

    /* JADX INFO: renamed from: W5.a$a, reason: collision with other inner class name */
    public static final class C0096a {
        public /* synthetic */ C0096a(AbstractC2148j abstractC2148j) {
            this();
        }

        public C0096a() {
        }
    }

    public a(char c7, char c8, int i7) {
        if (i7 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i7 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f5440a = c7;
        this.f5441b = (char) L5.c.c(c7, c8, i7);
        this.f5442c = i7;
    }

    public final char g() {
        return this.f5440a;
    }

    public final char h() {
        return this.f5441b;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public AbstractC0554l iterator() {
        return new b(this.f5440a, this.f5441b, this.f5442c);
    }
}
