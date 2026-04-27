package U5;

import java.util.Random;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends U5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f5205c = new a();

    public static final class a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // U5.a
    public Random g() {
        Object obj = this.f5205c.get();
        r.e(obj, "get(...)");
        return (Random) obj;
    }
}
