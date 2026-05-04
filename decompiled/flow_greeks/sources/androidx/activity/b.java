package androidx.activity;

import android.window.BackEvent;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f879e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f883d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public b(float f10, float f11, float f12, int i10) {
        this.f880a = f10;
        this.f881b = f11;
        this.f882c = f12;
        this.f883d = i10;
    }

    public final float a() {
        return this.f882c;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f880a + ", touchY=" + this.f881b + ", progress=" + this.f882c + ", swipeEdge=" + this.f883d + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(BackEvent backEvent) {
        kotlin.jvm.internal.t.f(backEvent, "backEvent");
        androidx.activity.a aVar = androidx.activity.a.f878a;
        this(aVar.d(backEvent), aVar.e(backEvent), aVar.b(backEvent), aVar.c(backEvent));
    }
}
