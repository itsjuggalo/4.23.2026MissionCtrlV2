package o4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l4.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f17478e = new C0305a().b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f17479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f17480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f17481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17482d;

    /* JADX INFO: renamed from: o4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0305a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f17483a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f17484b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f17485c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f17486d = "";

        public C0305a a(d dVar) {
            this.f17484b.add(dVar);
            return this;
        }

        public a b() {
            return new a(this.f17483a, Collections.unmodifiableList(this.f17484b), this.f17485c, this.f17486d);
        }

        public C0305a c(String str) {
            this.f17486d = str;
            return this;
        }

        public C0305a d(b bVar) {
            this.f17485c = bVar;
            return this;
        }

        public C0305a e(f fVar) {
            this.f17483a = fVar;
            return this;
        }
    }

    public a(f fVar, List list, b bVar, String str) {
        this.f17479a = fVar;
        this.f17480b = list;
        this.f17481c = bVar;
        this.f17482d = str;
    }

    public static C0305a e() {
        return new C0305a();
    }

    public String a() {
        return this.f17482d;
    }

    public b b() {
        return this.f17481c;
    }

    public List c() {
        return this.f17480b;
    }

    public f d() {
        return this.f17479a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
