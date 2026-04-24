package s0;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: s0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2640a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f22963a = new LinkedHashMap();

    /* JADX INFO: renamed from: s0.a$a, reason: collision with other inner class name */
    public static final class C0354a extends AbstractC2640a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0354a f22964b = new C0354a();

        @Override // s0.AbstractC2640a
        public Object a(b key) {
            r.f(key, "key");
            return null;
        }
    }

    /* JADX INFO: renamed from: s0.a$b */
    public interface b {
    }

    public abstract Object a(b bVar);

    public final Map b() {
        return this.f22963a;
    }
}
