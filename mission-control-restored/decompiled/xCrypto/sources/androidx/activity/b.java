package androidx.activity;

import android.window.BackEvent;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f6251e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f6252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f6253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f6254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6255d;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public b(float f4, float f5, float f6, int i4) {
        this.f6252a = f4;
        this.f6253b = f5;
        this.f6254c = f6;
        this.f6255d = i4;
    }

    public final float a() {
        return this.f6254c;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f6252a + ", touchY=" + this.f6253b + ", progress=" + this.f6254c + ", swipeEdge=" + this.f6255d + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(BackEvent backEvent) {
        kotlin.jvm.internal.r.f(backEvent, "backEvent");
        androidx.activity.a aVar = androidx.activity.a.f6250a;
        this(aVar.d(backEvent), aVar.e(backEvent), aVar.b(backEvent), aVar.c(backEvent));
    }
}
