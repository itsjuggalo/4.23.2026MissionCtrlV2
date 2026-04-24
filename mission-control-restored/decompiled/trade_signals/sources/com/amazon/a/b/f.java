package com.amazon.a.b;

import android.os.Build;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<? extends com.amazon.a.a.d.b>, c<? extends com.amazon.a.a.d.b>> f14174a = new HashMap();

    public static final class a implements c<com.amazon.a.a.n.a.a.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<String, com.amazon.a.a.i.c> f14177a;

        private a() {
            this.f14177a = new HashMap<String, com.amazon.a.a.i.c>() { // from class: com.amazon.a.b.f.a.1
                {
                    put("NO_INTERNET", e.f14167d);
                    put("INVALID_CONTENT_ID", e.f14168e);
                    put("INTERNAL_SERVICE_ERROR", e.f14169f);
                }
            };
        }

        @Override // com.amazon.a.b.f.c
        public com.amazon.a.a.i.c a(com.amazon.a.a.n.a.a.f fVar) {
            com.amazon.a.a.i.c cVar = this.f14177a.get(fVar.b());
            return cVar != null ? cVar : e.f14168e;
        }
    }

    public static final class b implements c<com.amazon.a.b.a.a> {
        private b() {
        }

        @Override // com.amazon.a.b.f.c
        public com.amazon.a.a.i.c a(com.amazon.a.b.a.a aVar) {
            return aVar.d().a(h.EXPIRATION) ? e.f14167d : e.f14168e;
        }
    }

    public interface c<T extends com.amazon.a.a.d.b> {
        com.amazon.a.a.i.c a(T t8);
    }

    public f() {
        a(com.amazon.a.a.n.a.a.c.class, "Amazon".equals(Build.MANUFACTURER) ? e.f14165b : e.f14164a);
        com.amazon.a.a.i.c cVar = e.f14165b;
        a(com.amazon.a.a.n.a.a.b.class, cVar);
        a(com.amazon.a.a.n.a.a.d.class, cVar);
        a(com.amazon.a.a.n.a.a.a.class, e.f14166c);
        a(com.amazon.a.a.n.a.a.f.class, new a());
        com.amazon.a.a.i.c cVar2 = e.f14168e;
        a(com.amazon.a.a.n.a.a.g.class, cVar2);
        a(com.amazon.a.a.n.a.a.h.class, cVar2);
        a(com.amazon.a.b.a.a.class, new b());
        a(com.amazon.a.a.o.b.a.a.class, e.f14170g);
        a(com.amazon.a.a.o.b.a.b.class, cVar2);
        a(com.amazon.a.a.o.b.a.c.class, cVar2);
    }

    public com.amazon.a.a.i.c a(com.amazon.a.a.d.b bVar) {
        c<? extends com.amazon.a.a.d.b> cVar = this.f14174a.get(bVar.getClass());
        if (cVar == null) {
            return null;
        }
        return cVar.a(bVar);
    }

    private void a(Class<? extends com.amazon.a.a.d.b> cls, final com.amazon.a.a.i.c cVar) {
        a(cls, new c<com.amazon.a.a.d.b>() { // from class: com.amazon.a.b.f.1
            @Override // com.amazon.a.b.f.c
            public com.amazon.a.a.i.c a(com.amazon.a.a.d.b bVar) {
                return cVar;
            }
        });
    }

    private void a(Class<? extends com.amazon.a.a.d.b> cls, c<? extends com.amazon.a.a.d.b> cVar) {
        com.amazon.a.a.o.a.a.b(this.f14174a.containsKey(cls), "mapping exists for type: " + cls);
        this.f14174a.put(cls, cVar);
    }
}
