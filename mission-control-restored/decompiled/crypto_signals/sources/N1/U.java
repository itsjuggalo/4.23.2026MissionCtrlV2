package N1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ W f1360d;

    public U(W w6, int i, boolean z6, boolean z7) {
        Objects.requireNonNull(w6);
        this.f1360d = w6;
        this.f1357a = i;
        this.f1358b = z6;
        this.f1359c = z7;
    }

    public final void a(String str) {
        this.f1360d.y(this.f1357a, this.f1358b, this.f1359c, str, null, null, null);
    }

    public final void b(Object obj, String str) {
        this.f1360d.y(this.f1357a, this.f1358b, this.f1359c, str, obj, null, null);
    }

    public final void c(String str, Object obj, Object obj2) {
        this.f1360d.y(this.f1357a, this.f1358b, this.f1359c, str, obj, obj2, null);
    }

    public final void d(String str, Object obj, Object obj2, Object obj3) {
        this.f1360d.y(this.f1357a, this.f1358b, this.f1359c, str, obj, obj2, obj3);
    }
}
