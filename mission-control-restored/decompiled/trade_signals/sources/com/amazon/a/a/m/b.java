package com.amazon.a.a.m;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.amazon.a.a.e.b<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f13872a = new com.amazon.a.a.o.c("ExpirableValueDataStore");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.k.b f13873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, a> f13874c = new HashMap();

    public synchronized <T> T b(String str) {
        try {
            if (com.amazon.a.a.o.c.f14105a) {
                f13872a.a("Fetching value: " + str);
            }
            a aVar = this.f13874c.get(str);
            if (aVar != null) {
                return (T) aVar.h();
            }
            if (com.amazon.a.a.o.c.f14105a) {
                f13872a.a("Value not present in store, returning null");
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void c(String str) {
        try {
            a aVar = this.f13874c.get(str);
            if (aVar == null) {
                return;
            }
            if (com.amazon.a.a.o.c.f14105a) {
                f13872a.a("Removing value associated with key: " + str + ", value: " + aVar);
            }
            this.f13874c.remove(str);
            aVar.f();
        } catch (Throwable th) {
            throw th;
        }
    }

    public String toString() {
        return this.f13874c.toString();
    }

    @Override // com.amazon.a.a.e.b
    public synchronized void a(a aVar) {
        try {
            if (com.amazon.a.a.o.c.f14105a) {
                f13872a.a("Observed expiration: " + aVar + " removing from store!");
            }
            Iterator<Map.Entry<String, a>> it = this.f13874c.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue() == aVar) {
                    if (com.amazon.a.a.o.c.f14105a) {
                        f13872a.a("Removing entry from store: " + aVar);
                    }
                    it.remove();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(String str, a aVar) {
        try {
            com.amazon.a.a.o.a.a.a((Object) str, "key");
            com.amazon.a.a.o.a.a.a((Object) aVar, "value");
            if (com.amazon.a.a.o.c.f14105a) {
                f13872a.a("Placing value into store with key: " + str + ", expiration: " + aVar.a());
            }
            this.f13873b.b(aVar);
            aVar.a(this);
            this.f13874c.put(str, aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized <T> void a(String str, T t8) {
        try {
            if (com.amazon.a.a.o.c.f14105a) {
                f13872a.a("Placing non-expiring value into store with key: " + str);
            }
            this.f13874c.put(str, new a(t8, new Date()) { // from class: com.amazon.a.a.m.b.1
                @Override // com.amazon.a.a.e.a
                public void d() {
                    if (com.amazon.a.a.o.c.f14106b) {
                        b.f13872a.b("Woah, non-expirable value was expired!!!!");
                    }
                }
            });
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean a(String str) {
        return b(str) != null;
    }
}
