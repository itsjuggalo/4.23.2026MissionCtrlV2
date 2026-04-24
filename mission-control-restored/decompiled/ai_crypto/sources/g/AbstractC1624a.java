package g;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: g.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1624a {

    /* JADX INFO: renamed from: g.a$a, reason: collision with other inner class name */
    public static final class C0243a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f14230a;

        public C0243a(Object obj) {
            this.f14230a = obj;
        }

        public final Object a() {
            return this.f14230a;
        }
    }

    public abstract Intent a(Context context, Object obj);

    public C0243a b(Context context, Object obj) {
        r.f(context, "context");
        return null;
    }

    public abstract Object c(int i7, Intent intent);
}
