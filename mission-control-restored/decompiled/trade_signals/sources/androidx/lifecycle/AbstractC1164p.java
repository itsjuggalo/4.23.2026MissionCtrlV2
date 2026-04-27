package androidx.lifecycle;

import androidx.lifecycle.AbstractC1157i;
import java.util.Map;
import p.C2536c;
import q.C2616b;

/* JADX INFO: renamed from: androidx.lifecycle.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1164p {
    static final Object NOT_SET = new Object();
    static final int START_VERSION = -1;
    private boolean mChangingActiveState;
    private volatile Object mData;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;
    final Object mDataLock = new Object();
    private C2616b mObservers = new C2616b();
    int mActiveCount = 0;

    /* JADX INFO: renamed from: androidx.lifecycle.p$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (AbstractC1164p.this.mDataLock) {
                obj = AbstractC1164p.this.mPendingData;
                AbstractC1164p.this.mPendingData = AbstractC1164p.NOT_SET;
            }
            AbstractC1164p.this.setValue(obj);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.p$b */
    public class b extends d {
        public b(s sVar) {
            super(sVar);
        }

        @Override // androidx.lifecycle.AbstractC1164p.d
        public boolean e() {
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.p$c */
    public class c extends d implements InterfaceC1159k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final InterfaceC1161m f11999e;

        public c(InterfaceC1161m interfaceC1161m, s sVar) {
            super(sVar);
            this.f11999e = interfaceC1161m;
        }

        @Override // androidx.lifecycle.InterfaceC1159k
        public void b(InterfaceC1161m interfaceC1161m, AbstractC1157i.a aVar) {
            AbstractC1157i.b bVarB = this.f11999e.getLifecycle().b();
            if (bVarB == AbstractC1157i.b.DESTROYED) {
                AbstractC1164p.this.removeObserver(this.f12001a);
                return;
            }
            AbstractC1157i.b bVar = null;
            while (bVar != bVarB) {
                a(e());
                bVar = bVarB;
                bVarB = this.f11999e.getLifecycle().b();
            }
        }

        @Override // androidx.lifecycle.AbstractC1164p.d
        public void c() {
            this.f11999e.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.AbstractC1164p.d
        public boolean d(InterfaceC1161m interfaceC1161m) {
            return this.f11999e == interfaceC1161m;
        }

        @Override // androidx.lifecycle.AbstractC1164p.d
        public boolean e() {
            return this.f11999e.getLifecycle().b().b(AbstractC1157i.b.STARTED);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.p$d */
    public abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f12001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12003c = -1;

        public d(s sVar) {
            this.f12001a = sVar;
        }

        public void a(boolean z7) {
            if (z7 == this.f12002b) {
                return;
            }
            this.f12002b = z7;
            AbstractC1164p.this.changeActiveCounter(z7 ? 1 : -1);
            if (this.f12002b) {
                AbstractC1164p.this.dispatchingValue(this);
            }
        }

        public void c() {
        }

        public boolean d(InterfaceC1161m interfaceC1161m) {
            return false;
        }

        public abstract boolean e();
    }

    public AbstractC1164p() {
        Object obj = NOT_SET;
        this.mPendingData = obj;
        this.mPostValueRunnable = new a();
        this.mData = obj;
        this.mVersion = -1;
    }

    public static void assertMainThread(String str) {
        if (C2536c.f().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public final void a(d dVar) {
        if (dVar.f12002b) {
            if (!dVar.e()) {
                dVar.a(false);
                return;
            }
            int i8 = dVar.f12003c;
            int i9 = this.mVersion;
            if (i8 >= i9) {
                return;
            }
            dVar.f12003c = i9;
            dVar.f12001a.a(this.mData);
        }
    }

    public void changeActiveCounter(int i8) {
        int i9 = this.mActiveCount;
        this.mActiveCount = i8 + i9;
        if (this.mChangingActiveState) {
            return;
        }
        this.mChangingActiveState = true;
        while (true) {
            try {
                int i10 = this.mActiveCount;
                if (i9 == i10) {
                    this.mChangingActiveState = false;
                    return;
                }
                boolean z7 = i9 == 0 && i10 > 0;
                boolean z8 = i9 > 0 && i10 == 0;
                if (z7) {
                    onActive();
                } else if (z8) {
                    onInactive();
                }
                i9 = i10;
            } catch (Throwable th) {
                this.mChangingActiveState = false;
                throw th;
            }
        }
    }

    public void dispatchingValue(androidx.lifecycle.p.d dVar) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (dVar != null) {
                a(dVar);
                dVar = null;
            } else {
                C2616b.d dVarE = this.mObservers.e();
                while (dVarE.hasNext()) {
                    a((d) ((Map.Entry) dVarE.next()).getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public Object getValue() {
        Object obj = this.mData;
        if (obj != NOT_SET) {
            return obj;
        }
        return null;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    public boolean hasObservers() {
        return this.mObservers.size() > 0;
    }

    public boolean isInitialized() {
        return this.mData != NOT_SET;
    }

    public void observe(InterfaceC1161m interfaceC1161m, s sVar) {
        assertMainThread("observe");
        if (interfaceC1161m.getLifecycle().b() == AbstractC1157i.b.DESTROYED) {
            return;
        }
        c cVar = new c(interfaceC1161m, sVar);
        d dVar = (d) this.mObservers.n(sVar, cVar);
        if (dVar != null && !dVar.d(interfaceC1161m)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVar != null) {
            return;
        }
        interfaceC1161m.getLifecycle().a(cVar);
    }

    public void observeForever(s sVar) {
        assertMainThread("observeForever");
        b bVar = new b(sVar);
        d dVar = (d) this.mObservers.n(sVar, bVar);
        if (dVar instanceof c) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVar != null) {
            return;
        }
        bVar.a(true);
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    public void postValue(Object obj) {
        boolean z7;
        synchronized (this.mDataLock) {
            z7 = this.mPendingData == NOT_SET;
            this.mPendingData = obj;
        }
        if (z7) {
            C2536c.f().c(this.mPostValueRunnable);
        }
    }

    public void removeObserver(s sVar) {
        assertMainThread("removeObserver");
        d dVar = (d) this.mObservers.C(sVar);
        if (dVar == null) {
            return;
        }
        dVar.c();
        dVar.a(false);
    }

    public void removeObservers(InterfaceC1161m interfaceC1161m) {
        assertMainThread("removeObservers");
        for (Map.Entry entry : this.mObservers) {
            if (((d) entry.getValue()).d(interfaceC1161m)) {
                removeObserver((s) entry.getKey());
            }
        }
    }

    public void setValue(Object obj) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = obj;
        dispatchingValue(null);
    }
}
