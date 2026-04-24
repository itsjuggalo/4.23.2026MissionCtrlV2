package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.k0;

/* JADX INFO: loaded from: classes.dex */
public class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f7324c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k0.b f7325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f7326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k0.b f7327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f7328d;

        public a(k0.b bVar, Object obj, k0.b bVar2, Object obj2) {
            this.f7325a = bVar;
            this.f7326b = obj;
            this.f7327c = bVar2;
            this.f7328d = obj2;
        }
    }

    public C(k0.b bVar, Object obj, k0.b bVar2, Object obj2) {
        this.f7322a = new a(bVar, obj, bVar2, obj2);
        this.f7323b = obj;
        this.f7324c = obj2;
    }

    public static int b(a aVar, Object obj, Object obj2) {
        return C0946q.b(aVar.f7325a, 1, obj) + C0946q.b(aVar.f7327c, 2, obj2);
    }

    public static C d(k0.b bVar, Object obj, k0.b bVar2, Object obj2) {
        return new C(bVar, obj, bVar2, obj2);
    }

    public static void e(AbstractC0938i abstractC0938i, a aVar, Object obj, Object obj2) {
        C0946q.u(abstractC0938i, aVar.f7325a, 1, obj);
        C0946q.u(abstractC0938i, aVar.f7327c, 2, obj2);
    }

    public int a(int i7, Object obj, Object obj2) {
        return AbstractC0938i.O(i7) + AbstractC0938i.y(b(this.f7322a, obj, obj2));
    }

    public a c() {
        return this.f7322a;
    }
}
