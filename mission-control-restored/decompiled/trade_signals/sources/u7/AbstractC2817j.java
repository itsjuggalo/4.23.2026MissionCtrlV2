package u7;

import java.io.IOException;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import u7.M;

/* JADX INFO: renamed from: u7.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2817j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23671a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC2817j f23672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final M f23673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbstractC2817j f23674d;

    /* JADX INFO: renamed from: u7.j$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        AbstractC2817j c2822o;
        try {
            Class.forName("java.nio.file.Files");
            c2822o = new G();
        } catch (ClassNotFoundException unused) {
            c2822o = new C2822o();
        }
        f23672b = c2822o;
        M.a aVar = M.f23583b;
        String property = System.getProperty("java.io.tmpdir");
        AbstractC2304t.e(property, "getProperty(\"java.io.tmpdir\")");
        f23673c = M.a.e(aVar, property, false, 1, null);
        ClassLoader classLoader = v7.h.class.getClassLoader();
        AbstractC2304t.e(classLoader, "ResourceFileSystem::class.java.classLoader");
        f23674d = new v7.h(classLoader, false);
    }

    public abstract void a(M m8, M m9);

    public final void b(M dir, boolean z7) throws IOException {
        AbstractC2304t.f(dir, "dir");
        v7.c.a(this, dir, z7);
    }

    public final void c(M dir) {
        AbstractC2304t.f(dir, "dir");
        d(dir, false);
    }

    public abstract void d(M m8, boolean z7);

    public final void e(M path) {
        AbstractC2304t.f(path, "path");
        f(path, false);
    }

    public abstract void f(M m8, boolean z7);

    public final boolean g(M path) {
        AbstractC2304t.f(path, "path");
        return v7.c.b(this, path);
    }

    public abstract C2816i h(M m8);

    public abstract AbstractC2815h i(M m8);

    public final AbstractC2815h j(M file) {
        AbstractC2304t.f(file, "file");
        return k(file, false, false);
    }

    public abstract AbstractC2815h k(M m8, boolean z7, boolean z8);

    public abstract V l(M m8);
}
