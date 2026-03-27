package l1;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: l1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2312a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f20519a = new ArrayList();

    /* JADX INFO: renamed from: l1.a$a, reason: collision with other inner class name */
    public static final class C0345a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f20520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final U0.d f20521b;

        public C0345a(Class cls, U0.d dVar) {
            this.f20520a = cls;
            this.f20521b = dVar;
        }

        public boolean a(Class cls) {
            return this.f20520a.isAssignableFrom(cls);
        }
    }

    public synchronized void a(Class cls, U0.d dVar) {
        this.f20519a.add(new C0345a(cls, dVar));
    }

    public synchronized U0.d b(Class cls) {
        for (C0345a c0345a : this.f20519a) {
            if (c0345a.a(cls)) {
                return c0345a.f20521b;
            }
        }
        return null;
    }
}
