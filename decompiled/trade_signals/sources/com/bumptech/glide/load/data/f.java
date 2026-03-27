package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e.a f14834b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f14835a = new HashMap();

    public class a implements e.a {
        @Override // com.bumptech.glide.load.data.e.a
        public Class a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.data.e.a
        public e b(Object obj) {
            return new b(obj);
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f14836a;

        public b(Object obj) {
            this.f14836a = obj;
        }

        @Override // com.bumptech.glide.load.data.e
        public Object a() {
            return this.f14836a;
        }

        @Override // com.bumptech.glide.load.data.e
        public void b() {
        }
    }

    public synchronized e a(Object obj) {
        e.a aVar;
        try {
            AbstractC2628k.d(obj);
            aVar = (e.a) this.f14835a.get(obj.getClass());
            if (aVar == null) {
                Iterator it = this.f14835a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e.a aVar2 = (e.a) it.next();
                    if (aVar2.a().isAssignableFrom(obj.getClass())) {
                        aVar = aVar2;
                        break;
                    }
                }
            }
            if (aVar == null) {
                aVar = f14834b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return aVar.b(obj);
    }

    public synchronized void b(e.a aVar) {
        this.f14835a.put(aVar.a(), aVar);
    }
}
