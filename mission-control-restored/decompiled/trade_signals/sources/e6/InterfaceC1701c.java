package e6;

import h6.InterfaceC1905n;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: renamed from: e6.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC1701c {

    /* JADX INFO: renamed from: e6.c$a */
    public static final class a implements InterfaceC1701c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f17275a = new a();

        @Override // e6.InterfaceC1701c
        public Set a() {
            return p5.S.d();
        }

        @Override // e6.InterfaceC1701c
        public Set c() {
            return p5.S.d();
        }

        @Override // e6.InterfaceC1701c
        public InterfaceC1905n d(q6.f name) {
            AbstractC2304t.f(name, "name");
            return null;
        }

        @Override // e6.InterfaceC1701c
        public h6.w e(q6.f name) {
            AbstractC2304t.f(name, "name");
            return null;
        }

        @Override // e6.InterfaceC1701c
        public Set f() {
            return p5.S.d();
        }

        @Override // e6.InterfaceC1701c
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public List b(q6.f name) {
            AbstractC2304t.f(name, "name");
            return AbstractC2595q.i();
        }
    }

    Set a();

    Collection b(q6.f fVar);

    Set c();

    InterfaceC1905n d(q6.f fVar);

    h6.w e(q6.f fVar);

    Set f();
}
