package p0;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2539a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f22250a = new LinkedHashMap();

    /* JADX INFO: renamed from: p0.a$a, reason: collision with other inner class name */
    public static final class C0373a extends AbstractC2539a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0373a f22251b = new C0373a();

        @Override // p0.AbstractC2539a
        public Object a(b key) {
            AbstractC2304t.f(key, "key");
            return null;
        }
    }

    /* JADX INFO: renamed from: p0.a$b */
    public interface b {
    }

    public abstract Object a(b bVar);

    public final Map b() {
        return this.f22250a;
    }
}
