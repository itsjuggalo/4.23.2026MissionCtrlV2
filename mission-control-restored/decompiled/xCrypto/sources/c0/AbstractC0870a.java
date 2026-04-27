package c0;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: c0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0870a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f8301a = new LinkedHashMap();

    /* JADX INFO: renamed from: c0.a$a, reason: collision with other inner class name */
    public static final class C0128a extends AbstractC0870a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0128a f8302b = new C0128a();

        @Override // c0.AbstractC0870a
        public Object a(b key) {
            r.f(key, "key");
            return null;
        }
    }

    /* JADX INFO: renamed from: c0.a$b */
    public interface b {
    }

    public abstract Object a(b bVar);

    public final Map b() {
        return this.f8301a;
    }
}
