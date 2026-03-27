package U4;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f4972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f4973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final V4.a f4975d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4976a;

        static {
            int[] iArr = new int[b.values().length];
            f4976a = iArr;
            try {
                iArr[b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4976a[b.INACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4976a[b.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4976a[b.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4976a[b.DETACHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        DETACHED,
        RESUMED,
        INACTIVE,
        HIDDEN,
        PAUSED
    }

    public k(M4.a aVar) {
        this(new V4.a(aVar, "flutter/lifecycle", V4.q.f5350b));
    }

    public void a() {
        g(this.f4972a, true);
    }

    public void b() {
        g(b.DETACHED, this.f4974c);
    }

    public void c() {
        g(b.INACTIVE, this.f4974c);
    }

    public void d() {
        g(b.PAUSED, this.f4974c);
    }

    public void e() {
        g(b.RESUMED, this.f4974c);
    }

    public void f() {
        g(this.f4972a, false);
    }

    public final void g(b bVar, boolean z7) {
        b bVar2 = this.f4972a;
        if (bVar2 == bVar && z7 == this.f4974c) {
            return;
        }
        if (bVar == null && bVar2 == null) {
            this.f4974c = z7;
            return;
        }
        int i7 = a.f4976a[bVar.ordinal()];
        b bVar3 = i7 != 1 ? (i7 == 2 || i7 == 3 || i7 == 4 || i7 == 5) ? bVar : null : z7 ? b.RESUMED : b.INACTIVE;
        this.f4972a = bVar;
        this.f4974c = z7;
        if (bVar3 == this.f4973b) {
            return;
        }
        String str = "AppLifecycleState." + bVar3.name().toLowerCase(Locale.ROOT);
        J4.b.f("LifecycleChannel", "Sending " + str + " message.");
        this.f4975d.c(str);
        this.f4973b = bVar3;
    }

    public k(V4.a aVar) {
        this.f4972a = null;
        this.f4973b = null;
        this.f4974c = true;
        this.f4975d = aVar;
    }
}
