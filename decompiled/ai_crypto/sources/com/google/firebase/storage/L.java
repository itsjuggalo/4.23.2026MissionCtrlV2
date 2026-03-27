package com.google.firebase.storage;

import android.app.Activity;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.firebase.storage.E;
import e4.C1479a;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue f12378a = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f12379b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public E f12380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f12382e;

    public interface a {
        void a(Object obj, Object obj2);
    }

    public L(E e7, int i7, a aVar) {
        this.f12380c = e7;
        this.f12381d = i7;
        this.f12382e = aVar;
    }

    public void d(Activity activity, Executor executor, final Object obj) {
        boolean z7;
        e4.g gVar;
        AbstractC1207s.k(obj);
        synchronized (this.f12380c.J()) {
            try {
                z7 = (this.f12380c.B() & this.f12381d) != 0;
                this.f12378a.add(obj);
                gVar = new e4.g(executor);
                this.f12379b.put(obj, gVar);
                if (activity != null) {
                    AbstractC1207s.b(!activity.isDestroyed(), "Activity is already destroyed!");
                    C1479a.a().c(activity, obj, new Runnable() { // from class: com.google.firebase.storage.J
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f12373a.e(obj);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z7) {
            final E.a aVarG0 = this.f12380c.g0();
            gVar.a(new Runnable() { // from class: com.google.firebase.storage.K
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12375a.f(obj, aVarG0);
                }
            });
        }
    }

    public final /* synthetic */ void f(Object obj, E.a aVar) {
        this.f12382e.a(obj, aVar);
    }

    public final /* synthetic */ void g(Object obj, E.a aVar) {
        this.f12382e.a(obj, aVar);
    }

    public void h() {
        if ((this.f12380c.B() & this.f12381d) != 0) {
            final E.a aVarG0 = this.f12380c.g0();
            for (final Object obj : this.f12378a) {
                e4.g gVar = (e4.g) this.f12379b.get(obj);
                if (gVar != null) {
                    gVar.a(new Runnable() { // from class: com.google.firebase.storage.I
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f12370a.g(obj, aVarG0);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e(Object obj) {
        AbstractC1207s.k(obj);
        synchronized (this.f12380c.J()) {
            this.f12379b.remove(obj);
            this.f12378a.remove(obj);
            C1479a.a().b(obj);
        }
    }
}
