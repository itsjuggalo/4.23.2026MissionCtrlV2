package f;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: f.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1238a {

    /* JADX INFO: renamed from: f.a$a, reason: collision with other inner class name */
    public static final class C0191a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f11517a;

        public C0191a(Object obj) {
            this.f11517a = obj;
        }

        public final Object a() {
            return this.f11517a;
        }
    }

    public abstract Intent a(Context context, Object obj);

    public C0191a b(Context context, Object obj) {
        r.f(context, "context");
        return null;
    }

    public abstract Object c(int i4, Intent intent);
}
