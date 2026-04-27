package com.google.firebase.storage;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f5605c = new t();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f5606a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5607b = new Object();

    public final void a(s sVar) {
        synchronized (this.f5607b) {
            try {
                String string = sVar.d().toString();
                WeakReference weakReference = (WeakReference) this.f5606a.get(string);
                s sVar2 = weakReference != null ? (s) weakReference.get() : null;
                if (sVar2 == null || sVar2 == sVar) {
                    this.f5606a.remove(string);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
