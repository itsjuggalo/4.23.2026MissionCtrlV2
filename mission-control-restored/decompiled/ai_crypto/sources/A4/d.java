package A4;

import V4.i;
import V4.j;

/* JADX INFO: loaded from: classes2.dex */
public class d extends A4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f264b;

    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j.d f265a;

        public a(j.d dVar) {
            this.f265a = dVar;
        }

        @Override // A4.f
        public void a(Object obj) {
            this.f265a.a(obj);
        }

        @Override // A4.f
        public void b(String str, String str2, Object obj) {
            this.f265a.b(str, str2, obj);
        }
    }

    public d(i iVar, j.d dVar) {
        this.f264b = iVar;
        this.f263a = new a(dVar);
    }

    @Override // A4.e
    public Object c(String str) {
        return this.f264b.a(str);
    }

    @Override // A4.e
    public String h() {
        return this.f264b.f5332a;
    }

    @Override // A4.e
    public boolean i(String str) {
        return this.f264b.c(str);
    }

    @Override // A4.a
    public f o() {
        return this.f263a;
    }
}
