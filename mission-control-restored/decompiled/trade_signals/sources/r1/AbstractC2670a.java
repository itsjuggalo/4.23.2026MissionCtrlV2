package r1;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: r1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2670a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f22907a = new C0390a();

    /* JADX INFO: renamed from: r1.a$b */
    public class b implements d {
        @Override // r1.AbstractC2670a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: renamed from: r1.a$c */
    public class c implements g {
        @Override // r1.AbstractC2670a.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List list) {
            list.clear();
        }
    }

    /* JADX INFO: renamed from: r1.a$d */
    public interface d {
        Object a();
    }

    /* JADX INFO: renamed from: r1.a$e */
    public static final class e implements S.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f22908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f22909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final S.d f22910c;

        public e(S.d dVar, d dVar2, g gVar) {
            this.f22910c = dVar;
            this.f22908a = dVar2;
            this.f22909b = gVar;
        }

        @Override // S.d
        public boolean a(Object obj) {
            if (obj instanceof f) {
                ((f) obj).a().b(true);
            }
            this.f22909b.a(obj);
            return this.f22910c.a(obj);
        }

        @Override // S.d
        public Object b() {
            Object objB = this.f22910c.b();
            if (objB == null) {
                objB = this.f22908a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + objB.getClass());
                }
            }
            if (objB instanceof f) {
                ((f) objB).a().b(false);
            }
            return objB;
        }
    }

    /* JADX INFO: renamed from: r1.a$f */
    public interface f {
        AbstractC2672c a();
    }

    /* JADX INFO: renamed from: r1.a$g */
    public interface g {
        void a(Object obj);
    }

    public static S.d a(S.d dVar, d dVar2) {
        return b(dVar, dVar2, c());
    }

    public static S.d b(S.d dVar, d dVar2, g gVar) {
        return new e(dVar, dVar2, gVar);
    }

    public static g c() {
        return f22907a;
    }

    public static S.d d(int i8, d dVar) {
        return a(new S.f(i8), dVar);
    }

    public static S.d e() {
        return f(20);
    }

    public static S.d f(int i8) {
        return b(new S.f(i8), new b(), new c());
    }

    /* JADX INFO: renamed from: r1.a$a, reason: collision with other inner class name */
    public class C0390a implements g {
        @Override // r1.AbstractC2670a.g
        public void a(Object obj) {
        }
    }
}
