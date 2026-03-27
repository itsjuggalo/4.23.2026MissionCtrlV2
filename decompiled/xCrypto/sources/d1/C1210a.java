package d1;

import a1.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: d1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1210a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C1210a f11387e = new C0183a().b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1215f f11388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1211b f11390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11391d;

    /* JADX INFO: renamed from: d1.a$a, reason: collision with other inner class name */
    public static final class C0183a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C1215f f11392a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f11393b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C1211b f11394c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11395d = "";

        public C0183a a(C1213d c1213d) {
            this.f11393b.add(c1213d);
            return this;
        }

        public C1210a b() {
            return new C1210a(this.f11392a, Collections.unmodifiableList(this.f11393b), this.f11394c, this.f11395d);
        }

        public C0183a c(String str) {
            this.f11395d = str;
            return this;
        }

        public C0183a d(C1211b c1211b) {
            this.f11394c = c1211b;
            return this;
        }

        public C0183a e(C1215f c1215f) {
            this.f11392a = c1215f;
            return this;
        }
    }

    public C1210a(C1215f c1215f, List list, C1211b c1211b, String str) {
        this.f11388a = c1215f;
        this.f11389b = list;
        this.f11390c = c1211b;
        this.f11391d = str;
    }

    public static C0183a e() {
        return new C0183a();
    }

    public String a() {
        return this.f11391d;
    }

    public C1211b b() {
        return this.f11390c;
    }

    public List c() {
        return this.f11389b;
    }

    public C1215f d() {
        return this.f11388a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
