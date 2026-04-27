package u1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import r1.m;

/* JADX INFO: renamed from: u1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2745a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2745a f24420e = new C0377a().b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2750f f24421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f24422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2746b f24423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f24424d;

    /* JADX INFO: renamed from: u1.a$a, reason: collision with other inner class name */
    public static final class C0377a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C2750f f24425a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f24426b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C2746b f24427c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f24428d = "";

        public C0377a a(C2748d c2748d) {
            this.f24426b.add(c2748d);
            return this;
        }

        public C2745a b() {
            return new C2745a(this.f24425a, Collections.unmodifiableList(this.f24426b), this.f24427c, this.f24428d);
        }

        public C0377a c(String str) {
            this.f24428d = str;
            return this;
        }

        public C0377a d(C2746b c2746b) {
            this.f24427c = c2746b;
            return this;
        }

        public C0377a e(C2750f c2750f) {
            this.f24425a = c2750f;
            return this;
        }
    }

    public C2745a(C2750f c2750f, List list, C2746b c2746b, String str) {
        this.f24421a = c2750f;
        this.f24422b = list;
        this.f24423c = c2746b;
        this.f24424d = str;
    }

    public static C0377a e() {
        return new C0377a();
    }

    public String a() {
        return this.f24424d;
    }

    public C2746b b() {
        return this.f24423c;
    }

    public List c() {
        return this.f24422b;
    }

    public C2750f d() {
        return this.f24421a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
