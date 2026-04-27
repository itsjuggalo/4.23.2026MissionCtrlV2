package F5;

import java.util.Random;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends F5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f1915c = new a();

    public static final class a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // F5.a
    public Random g() {
        Object obj = this.f1915c.get();
        AbstractC2304t.e(obj, "get(...)");
        return (Random) obj;
    }
}
