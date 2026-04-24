package P0;

import android.util.SparseArray;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3381a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArray f3382b = new SparseArray();

    public final Q0.a a(int i4) {
        return (Q0.a) f3382b.get(i4);
    }

    public final void b(Q0.a handler) {
        r.f(handler, "handler");
        f3382b.append(handler.getType(), handler);
    }
}
