package C1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import z1.m;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f586e = new C0008a().b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f590d;

    /* JADX INFO: renamed from: C1.a$a, reason: collision with other inner class name */
    public static final class C0008a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f591a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f592b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f593c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f594d = "";

        public C0008a a(d dVar) {
            this.f592b.add(dVar);
            return this;
        }

        public a b() {
            return new a(this.f591a, Collections.unmodifiableList(this.f592b), this.f593c, this.f594d);
        }

        public C0008a c(String str) {
            this.f594d = str;
            return this;
        }

        public C0008a d(b bVar) {
            this.f593c = bVar;
            return this;
        }

        public C0008a e(f fVar) {
            this.f591a = fVar;
            return this;
        }
    }

    public a(f fVar, List list, b bVar, String str) {
        this.f587a = fVar;
        this.f588b = list;
        this.f589c = bVar;
        this.f590d = str;
    }

    public static C0008a e() {
        return new C0008a();
    }

    public String a() {
        return this.f590d;
    }

    public b b() {
        return this.f589c;
    }

    public List c() {
        return this.f588b;
    }

    public f d() {
        return this.f587a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
