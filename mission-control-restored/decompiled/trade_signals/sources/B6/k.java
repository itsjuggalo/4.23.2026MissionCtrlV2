package B6;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import p5.S;

/* JADX INFO: loaded from: classes2.dex */
public interface k extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f216a = a.f217a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f217a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final B5.k f218b = j.f215a;

        public static final boolean a(q6.f it) {
            AbstractC2304t.f(it, "it");
            return true;
        }

        public final B5.k c() {
            return f218b;
        }
    }

    public static final class b extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f219b = new b();

        @Override // B6.l, B6.k
        public Set b() {
            return S.d();
        }

        @Override // B6.l, B6.k
        public Set c() {
            return S.d();
        }

        @Override // B6.l, B6.k
        public Set f() {
            return S.d();
        }
    }

    Collection a(q6.f fVar, Z5.b bVar);

    Set b();

    Set c();

    Collection d(q6.f fVar, Z5.b bVar);

    Set f();
}
