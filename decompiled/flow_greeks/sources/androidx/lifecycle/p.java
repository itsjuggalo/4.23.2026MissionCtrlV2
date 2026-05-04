package androidx.lifecycle;

import androidx.lifecycle.i;
import java.util.Map;
import q.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (p.this.mDataLock) {
                obj = p.this.mPendingData;
                p.this.mPendingData = p.NOT_SET;
            }
            p.this.setValue(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends d {
        public b(s sVar) {
            super(sVar);
        }

        @Override // androidx.lifecycle.p.d
        public boolean e() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends d implements k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final m f2464e;

        public c(m mVar, s sVar) {
            super(sVar);
            this.f2464e = mVar;
        }

        @Override // androidx.lifecycle.k
        public void b(m mVar, i.a aVar) {
            i.b bVarB = this.f2464e.getLifecycle().b();
            if (bVarB == i.b.DESTROYED) {
                p.this.removeObserver(this.f2466a);
                return;
            }
            i.b bVar = null;
            while (bVar != bVarB) {
                a(e());
                bVar = bVarB;
                bVarB = this.f2464e.getLifecycle().b();
            }
        }

        @Override // androidx.lifecycle.p.d
        public void c() {
            this.f2464e.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.p.d
        public boolean d(m mVar) {
            return this.f2464e == mVar;
        }

        @Override // androidx.lifecycle.p.d
        public boolean e() {
            return this.f2464e.getLifecycle().b().b(i.b.STARTED);
        }
    }

    public p() {
        Object obj = NOT_SET;
        this.mPendingData = obj;
        this.mPostValueRunnable = new a();
        this.mData = obj;
        this.mVersion = -1;
    }

    public static void assertMainThread(String str) {
        if (p.c.f().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public final void b(d dVar) {
        if (dVar.f2467b) {
            if (!dVar.e()) {
                dVar.a(false);
                return;
            }
            int i10 = dVar.f2468c;
            int i11 = this.mVersion;
            if (i10 >= i11) {
                return;
            }
            dVar.f2468c = i11;
            dVar.f2466a.a(this.mData);
        }
    }

    public void changeActiveCounter(int i10) {
        int i11 = this.mActiveCount;
        this.mActiveCount = i10 + i11;
        if (this.mChangingActiveState) {
            return;
        }
        this.mChangingActiveState = true;
        while (true) {
            try {
                int i12 = this.mActiveCount;
                if (i11 == i12) {
                    this.mChangingActiveState = false;
                    return;
                }
                boolean z10 = i11 == 0 && i12 > 0;
                boolean z11 = i11 > 0 && i12 == 0;
                if (z10) {
                    onActive();
                } else if (z11) {
                    onInactive();
                }
                i11 = i12;
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
                b.d dVarD = this.mObservers.d();
                while (dVarD.hasNext()) {
                    b((d) ((Map.Entry) dVarD.next()).getValue());
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

    public void observe(m mVar, s sVar) {
        assertMainThread("observe");
        if (mVar.getLifecycle().b() == i.b.DESTROYED) {
            return;
        }
        c cVar = new c(mVar, sVar);
        d dVar = (d) this.mObservers.g(sVar, cVar);
        if (dVar != null && !dVar.d(mVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVar != null) {
            return;
        }
        mVar.getLifecycle().a(cVar);
    }

    public void observeForever(s sVar) {
        assertMainThread("observeForever");
        b bVar = new b(sVar);
        d dVar = (d) this.mObservers.g(sVar, bVar);
        if (dVar instanceof c) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVar != null) {
            return;
        }
        bVar.a(true);
    }

    public void postValue(Object obj) {
        boolean z10;
        synchronized (this.mDataLock) {
            z10 = this.mPendingData == NOT_SET;
            this.mPendingData = obj;
        }
        if (z10) {
            p.c.f().c(this.mPostValueRunnable);
        }
    }

    public void removeObserver(s sVar) {
        assertMainThread("removeObserver");
        d dVar = (d) this.mObservers.p(sVar);
        if (dVar == null) {
            return;
        }
        dVar.c();
        dVar.a(false);
    }

    public void removeObservers(m mVar) {
        assertMainThread("removeObservers");
        for (Map.Entry entry : this.mObservers) {
            if (((d) entry.getValue()).d(mVar)) {
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f2466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2468c = -1;

        public d(s sVar) {
            this.f2466a = sVar;
        }

        public void a(boolean z10) {
            if (z10 == this.f2467b) {
                return;
            }
            this.f2467b = z10;
            p.this.changeActiveCounter(z10 ? 1 : -1);
            if (this.f2467b) {
                p.this.dispatchingValue(this);
            }
        }

        public boolean d(m mVar) {
            return false;
        }

        public abstract boolean e();

        public void c() {
        }
    }

    public void onActive() {
    }

    public void onInactive() {
    }
}
