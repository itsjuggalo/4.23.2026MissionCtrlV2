package d;

import android.window.BackEvent;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: renamed from: d.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1386b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f13052e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f13054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f13055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13056d;

    /* JADX INFO: renamed from: d.b$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public C1386b(float f7, float f8, float f9, int i7) {
        this.f13053a = f7;
        this.f13054b = f8;
        this.f13055c = f9;
        this.f13056d = i7;
    }

    public final float a() {
        return this.f13055c;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f13053a + ", touchY=" + this.f13054b + ", progress=" + this.f13055c + ", swipeEdge=" + this.f13056d + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C1386b(BackEvent backEvent) {
        kotlin.jvm.internal.r.f(backEvent, "backEvent");
        C1385a c1385a = C1385a.f13051a;
        this(c1385a.d(backEvent), c1385a.e(backEvent), c1385a.b(backEvent), c1385a.c(backEvent));
    }
}
