package f;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: f.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1725a {

    /* JADX INFO: renamed from: f.a$a, reason: collision with other inner class name */
    public static final class C0298a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f17342a;

        public C0298a(Object obj) {
            this.f17342a = obj;
        }

        public final Object a() {
            return this.f17342a;
        }
    }

    public abstract Intent a(Context context, Object obj);

    public C0298a b(Context context, Object obj) {
        AbstractC2304t.f(context, "context");
        return null;
    }

    public abstract Object c(int i8, Intent intent);
}
