package androidx.activity;

import android.window.BackEvent;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f10294e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f10295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f10296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f10297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10298d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public b(float f8, float f9, float f10, int i8) {
        this.f10295a = f8;
        this.f10296b = f9;
        this.f10297c = f10;
        this.f10298d = i8;
    }

    public final float a() {
        return this.f10297c;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f10295a + ", touchY=" + this.f10296b + ", progress=" + this.f10297c + ", swipeEdge=" + this.f10298d + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(BackEvent backEvent) {
        AbstractC2304t.f(backEvent, "backEvent");
        androidx.activity.a aVar = androidx.activity.a.f10293a;
        this(aVar.d(backEvent), aVar.e(backEvent), aVar.b(backEvent), aVar.c(backEvent));
    }
}
