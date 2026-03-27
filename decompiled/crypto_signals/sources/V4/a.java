package V4;

import java.util.Iterator;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Iterable, S4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f3291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f3292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3293c = 1;

    public a(char c6, char c7) {
        this.f3291a = c6;
        this.f3292b = (char) u0.u(c6, c7, 1);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f3291a, this.f3292b, this.f3293c);
    }
}
