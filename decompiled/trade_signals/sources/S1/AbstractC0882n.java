package S1;

import Q1.C0792d;
import R1.a;
import com.google.android.gms.common.internal.AbstractC1294n;
import l2.C2329m;

/* JADX INFO: renamed from: S1.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0882n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0792d[] f7426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7428c;

    /* JADX INFO: renamed from: S1.n$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InterfaceC0880l f7429a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C0792d[] f7431c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7430b = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7432d = 0;

        public /* synthetic */ a(P p8) {
        }

        public AbstractC0882n a() {
            AbstractC1294n.b(this.f7429a != null, "execute parameter required");
            return new O(this, this.f7431c, this.f7430b, this.f7432d);
        }

        public a b(InterfaceC0880l interfaceC0880l) {
            this.f7429a = interfaceC0880l;
            return this;
        }

        public a c(boolean z7) {
            this.f7430b = z7;
            return this;
        }

        public a d(C0792d... c0792dArr) {
            this.f7431c = c0792dArr;
            return this;
        }
    }

    public AbstractC0882n(C0792d[] c0792dArr, boolean z7, int i8) {
        this.f7426a = c0792dArr;
        boolean z8 = false;
        if (c0792dArr != null && z7) {
            z8 = true;
        }
        this.f7427b = z8;
        this.f7428c = i8;
    }

    public static a a() {
        return new a(null);
    }

    public abstract void b(a.b bVar, C2329m c2329m);

    public boolean c() {
        return this.f7427b;
    }

    public final int d() {
        return this.f7428c;
    }

    public final C0792d[] e() {
        return this.f7426a;
    }
}
