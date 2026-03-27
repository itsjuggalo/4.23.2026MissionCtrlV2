package com.google.firebase.storage;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class F {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F f12340c = new F();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f12341a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12342b = new Object();

    public static F b() {
        return f12340c;
    }

    public void a(E e7) {
        synchronized (this.f12342b) {
            this.f12341a.put(e7.I().toString(), new WeakReference(e7));
        }
    }

    public void c(E e7) {
        synchronized (this.f12342b) {
            try {
                String string = e7.I().toString();
                WeakReference weakReference = (WeakReference) this.f12341a.get(string);
                E e8 = weakReference != null ? (E) weakReference.get() : null;
                if (e8 == null || e8 == e7) {
                    this.f12341a.remove(string);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
