package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.k0;

/* JADX INFO: loaded from: classes.dex */
public class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f6914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f6915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6916c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k0.b f6917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f6918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k0.b f6919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f6920d;

        public a(k0.b bVar, Object obj, k0.b bVar2, Object obj2) {
            this.f6917a = bVar;
            this.f6918b = obj;
            this.f6919c = bVar2;
            this.f6920d = obj2;
        }
    }

    public C(k0.b bVar, Object obj, k0.b bVar2, Object obj2) {
        this.f6914a = new a(bVar, obj, bVar2, obj2);
        this.f6915b = obj;
        this.f6916c = obj2;
    }

    public static int b(a aVar, Object obj, Object obj2) {
        return C0804q.b(aVar.f6917a, 1, obj) + C0804q.b(aVar.f6919c, 2, obj2);
    }

    public static C d(k0.b bVar, Object obj, k0.b bVar2, Object obj2) {
        return new C(bVar, obj, bVar2, obj2);
    }

    public static void e(AbstractC0796i abstractC0796i, a aVar, Object obj, Object obj2) {
        C0804q.u(abstractC0796i, aVar.f6917a, 1, obj);
        C0804q.u(abstractC0796i, aVar.f6919c, 2, obj2);
    }

    public int a(int i4, Object obj, Object obj2) {
        return AbstractC0796i.O(i4) + AbstractC0796i.y(b(this.f6914a, obj, obj2));
    }

    public a c() {
        return this.f6914a;
    }
}
