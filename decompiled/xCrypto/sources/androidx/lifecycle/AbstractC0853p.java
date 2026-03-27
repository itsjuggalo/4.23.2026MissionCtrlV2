package androidx.lifecycle;

import androidx.lifecycle.AbstractC0846i;
import java.util.Map;
import p.C1684c;
import q.b;

/* JADX INFO: renamed from: androidx.lifecycle.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0853p {
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
    private q.b mObservers = new q.b();
    int mActiveCount = 0;

    /* JADX INFO: renamed from: androidx.lifecycle.p$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (AbstractC0853p.this.mDataLock) {
                obj = AbstractC0853p.this.mPendingData;
                AbstractC0853p.this.mPendingData = AbstractC0853p.NOT_SET;
            }
            AbstractC0853p.this.setValue(obj);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.p$b */
    public class b extends d {
        public b(s sVar) {
            super(sVar);
        }

        @Override // androidx.lifecycle.AbstractC0853p.d
        public boolean e() {
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.p$c */
    public class c extends d implements InterfaceC0848k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final InterfaceC0850m f7703e;

        public c(InterfaceC0850m interfaceC0850m, s sVar) {
            super(sVar);
            this.f7703e = interfaceC0850m;
        }

        @Override // androidx.lifecycle.InterfaceC0848k
        public void a(InterfaceC0850m interfaceC0850m, AbstractC0846i.a aVar) {
            AbstractC0846i.b bVarB = this.f7703e.getLifecycle().b();
            if (bVarB == AbstractC0846i.b.DESTROYED) {
                AbstractC0853p.this.removeObserver(this.f7705a);
                return;
            }
            AbstractC0846i.b bVar = null;
            while (bVar != bVarB) {
                b(e());
                bVar = bVarB;
                bVarB = this.f7703e.getLifecycle().b();
            }
        }

        @Override // androidx.lifecycle.AbstractC0853p.d
        public void c() {
            this.f7703e.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.AbstractC0853p.d
        public boolean d(InterfaceC0850m interfaceC0850m) {
            return this.f7703e == interfaceC0850m;
        }

        @Override // androidx.lifecycle.AbstractC0853p.d
        public boolean e() {
            return this.f7703e.getLifecycle().b().c(AbstractC0846i.b.STARTED);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.p$d */
    public abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f7705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7707c = -1;

        public d(s sVar) {
            this.f7705a = sVar;
        }

        public void b(boolean z4) {
            if (z4 == this.f7706b) {
                return;
            }
            this.f7706b = z4;
            AbstractC0853p.this.changeActiveCounter(z4 ? 1 : -1);
            if (this.f7706b) {
                AbstractC0853p.this.dispatchingValue(this);
            }
        }

        public void c() {
        }

        public boolean d(InterfaceC0850m interfaceC0850m) {
            return false;
        }

        public abstract boolean e();
    }

    public AbstractC0853p() {
        Object obj = NOT_SET;
        this.mPendingData = obj;
        this.mPostValueRunnable = new a();
        this.mData = obj;
        this.mVersion = -1;
    }

    public static void assertMainThread(String str) {
        if (C1684c.f().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public final void b(d dVar) {
        if (dVar.f7706b) {
            if (!dVar.e()) {
                dVar.b(false);
                return;
            }
            int i4 = dVar.f7707c;
            int i5 = this.mVersion;
            if (i4 >= i5) {
                return;
            }
            dVar.f7707c = i5;
            dVar.f7705a.a(this.mData);
        }
    }

    public void changeActiveCounter(int i4) {
        int i5 = this.mActiveCount;
        this.mActiveCount = i4 + i5;
        if (this.mChangingActiveState) {
            return;
        }
        this.mChangingActiveState = true;
        while (true) {
            try {
                int i6 = this.mActiveCount;
                if (i5 == i6) {
                    this.mChangingActiveState = false;
                    return;
                }
                boolean z4 = i5 == 0 && i6 > 0;
                boolean z5 = i5 > 0 && i6 == 0;
                if (z4) {
                    onActive();
                } else if (z5) {
                    onInactive();
                }
                i5 = i6;
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
                b(dVar);
                dVar = null;
            } else {
                b.d dVarI = this.mObservers.i();
                while (dVarI.hasNext()) {
                    b((d) ((Map.Entry) dVarI.next()).getValue());
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

    public void observe(InterfaceC0850m interfaceC0850m, s sVar) {
        assertMainThread("observe");
        if (interfaceC0850m.getLifecycle().b() == AbstractC0846i.b.DESTROYED) {
            return;
        }
        c cVar = new c(interfaceC0850m, sVar);
        d dVar = (d) this.mObservers.m(sVar, cVar);
        if (dVar != null && !dVar.d(interfaceC0850m)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVar != null) {
            return;
        }
        interfaceC0850m.getLifecycle().a(cVar);
    }

    public void observeForever(s sVar) {
        assertMainThread("observeForever");
        b bVar = new b(sVar);
        d dVar = (d) this.mObservers.m(sVar, bVar);
        if (dVar instanceof c) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVar != null) {
            return;
        }
        bVar.b(true);
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    public void postValue(Object obj) {
        boolean z4;
        synchronized (this.mDataLock) {
            z4 = this.mPendingData == NOT_SET;
            this.mPendingData = obj;
        }
        if (z4) {
            C1684c.f().c(this.mPostValueRunnable);
        }
    }

    public void removeObserver(s sVar) {
        assertMainThread("removeObserver");
        d dVar = (d) this.mObservers.n(sVar);
        if (dVar == null) {
            return;
        }
        dVar.c();
        dVar.b(false);
    }

    public void removeObservers(InterfaceC0850m interfaceC0850m) {
        assertMainThread("removeObservers");
        for (Map.Entry entry : this.mObservers) {
            if (((d) entry.getValue()).d(interfaceC0850m)) {
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
