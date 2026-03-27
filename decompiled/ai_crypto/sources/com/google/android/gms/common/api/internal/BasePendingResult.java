package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.InterfaceC1201l;
import com.google.android.gms.internal.base.zau;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasePendingResult<R extends com.google.android.gms.common.api.k> extends com.google.android.gms.common.api.h {
    static final ThreadLocal zaa = new u0();
    public static final /* synthetic */ int zad = 0;
    private v0 resultGuardian;
    protected final a zab;
    protected final WeakReference zac;
    private com.google.android.gms.common.api.l zah;
    private com.google.android.gms.common.api.k zaj;
    private Status zak;
    private volatile boolean zal;
    private boolean zam;
    private boolean zan;
    private InterfaceC1201l zao;
    private volatile k0 zap;
    private final Object zae = new Object();
    private final CountDownLatch zaf = new CountDownLatch(1);
    private final ArrayList zag = new ArrayList();
    private final AtomicReference zai = new AtomicReference();
    private boolean zaq = false;

    public static class a extends zau {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(com.google.android.gms.common.api.l lVar, com.google.android.gms.common.api.k kVar) {
            int i7 = BasePendingResult.zad;
            sendMessage(obtainMessage(1, new Pair((com.google.android.gms.common.api.l) AbstractC1207s.k(lVar), kVar)));
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i7 = message.what;
            if (i7 != 1) {
                if (i7 == 2) {
                    ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.f10841i);
                    return;
                }
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + i7, new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            com.google.android.gms.common.api.l lVar = (com.google.android.gms.common.api.l) pair.first;
            com.google.android.gms.common.api.k kVar = (com.google.android.gms.common.api.k) pair.second;
            try {
                lVar.a(kVar);
            } catch (RuntimeException e7) {
                BasePendingResult.zal(kVar);
                throw e7;
            }
        }
    }

    public BasePendingResult(com.google.android.gms.common.api.f fVar) {
        this.zab = new a(fVar != null ? fVar.f() : Looper.getMainLooper());
        this.zac = new WeakReference(fVar);
    }

    public static void zal(com.google.android.gms.common.api.k kVar) {
    }

    public final com.google.android.gms.common.api.k a() {
        com.google.android.gms.common.api.k kVar;
        synchronized (this.zae) {
            AbstractC1207s.o(!this.zal, "Result has already been consumed.");
            AbstractC1207s.o(isReady(), "Result is not ready.");
            kVar = this.zaj;
            this.zaj = null;
            this.zah = null;
            this.zal = true;
        }
        android.support.v4.media.session.b.a(this.zai.getAndSet(null));
        return (com.google.android.gms.common.api.k) AbstractC1207s.k(kVar);
    }

    @Override // com.google.android.gms.common.api.h
    public final void addStatusListener(h.a aVar) {
        AbstractC1207s.b(aVar != null, "Callback cannot be null.");
        synchronized (this.zae) {
            try {
                if (isReady()) {
                    aVar.a(this.zak);
                } else {
                    this.zag.add(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @ResultIgnorabilityUnspecified
    public final R await() {
        AbstractC1207s.j("await must not be called on the UI thread");
        AbstractC1207s.o(!this.zal, "Result has already been consumed");
        AbstractC1207s.o(this.zap == null, "Cannot await if then() has been called.");
        try {
            this.zaf.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f10839g);
        }
        AbstractC1207s.o(isReady(), "Result is not ready.");
        return (R) a();
    }

    public final void b(com.google.android.gms.common.api.k kVar) {
        this.zaj = kVar;
        this.zak = kVar.getStatus();
        this.zaf.countDown();
        if (this.zam) {
            this.zah = null;
        } else {
            com.google.android.gms.common.api.l lVar = this.zah;
            if (lVar != null) {
                this.zab.removeMessages(2);
                this.zab.a(lVar, a());
            }
        }
        ArrayList arrayList = this.zag;
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((h.a) arrayList.get(i7)).a(this.zak);
        }
        this.zag.clear();
    }

    public void cancel() {
        synchronized (this.zae) {
            try {
                if (!this.zam && !this.zal) {
                    zal(this.zaj);
                    this.zam = true;
                    b(createFailedResult(Status.f10842j));
                }
            } finally {
            }
        }
    }

    public abstract com.google.android.gms.common.api.k createFailedResult(Status status);

    @Deprecated
    public final void forceFailureUnlessReady(Status status) {
        synchronized (this.zae) {
            try {
                if (!isReady()) {
                    setResult(createFailedResult(status));
                    this.zan = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isCanceled() {
        boolean z7;
        synchronized (this.zae) {
            z7 = this.zam;
        }
        return z7;
    }

    public final boolean isReady() {
        return this.zaf.getCount() == 0;
    }

    public final void setCancelToken(InterfaceC1201l interfaceC1201l) {
        synchronized (this.zae) {
        }
    }

    public final void setResult(R r7) {
        synchronized (this.zae) {
            try {
                if (this.zan || this.zam) {
                    zal(r7);
                    return;
                }
                isReady();
                AbstractC1207s.o(!isReady(), "Results have already been set");
                AbstractC1207s.o(!this.zal, "Result has already been consumed");
                b(r7);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setResultCallback(com.google.android.gms.common.api.l lVar) {
        synchronized (this.zae) {
            try {
                if (lVar == null) {
                    this.zah = null;
                    return;
                }
                boolean z7 = true;
                AbstractC1207s.o(!this.zal, "Result has already been consumed.");
                if (this.zap != null) {
                    z7 = false;
                }
                AbstractC1207s.o(z7, "Cannot set callbacks if then() has been called.");
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.zab.a(lVar, a());
                } else {
                    this.zah = lVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <S extends com.google.android.gms.common.api.k> com.google.android.gms.common.api.n then(com.google.android.gms.common.api.m mVar) {
        com.google.android.gms.common.api.n nVarB;
        AbstractC1207s.o(!this.zal, "Result has already been consumed.");
        synchronized (this.zae) {
            try {
                AbstractC1207s.o(this.zap == null, "Cannot call then() twice.");
                AbstractC1207s.o(this.zah == null, "Cannot call then() if callbacks are set.");
                AbstractC1207s.o(!this.zam, "Cannot call then() if result was canceled.");
                this.zaq = true;
                this.zap = new k0(this.zac);
                nVarB = this.zap.b(mVar);
                if (isReady()) {
                    this.zab.a(this.zap, a());
                } else {
                    this.zah = this.zap;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVarB;
    }

    public final void zak() {
        boolean z7 = true;
        if (!this.zaq && !((Boolean) zaa.get()).booleanValue()) {
            z7 = false;
        }
        this.zaq = z7;
    }

    public final boolean zam() {
        boolean zIsCanceled;
        synchronized (this.zae) {
            try {
                if (((com.google.android.gms.common.api.f) this.zac.get()) == null || !this.zaq) {
                    cancel();
                }
                zIsCanceled = isCanceled();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zIsCanceled;
    }

    public final void zan(l0 l0Var) {
        this.zai.set(l0Var);
    }

    @Override // com.google.android.gms.common.api.h
    @ResultIgnorabilityUnspecified
    public final R await(long j7, TimeUnit timeUnit) {
        if (j7 > 0) {
            AbstractC1207s.j("await must not be called on the UI thread when time is greater than zero.");
        }
        AbstractC1207s.o(!this.zal, "Result has already been consumed.");
        AbstractC1207s.o(this.zap == null, "Cannot await if then() has been called.");
        try {
            if (!this.zaf.await(j7, timeUnit)) {
                forceFailureUnlessReady(Status.f10841i);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f10839g);
        }
        AbstractC1207s.o(isReady(), "Result is not ready.");
        return (R) a();
    }

    public final void setResultCallback(com.google.android.gms.common.api.l lVar, long j7, TimeUnit timeUnit) {
        synchronized (this.zae) {
            try {
                if (lVar == null) {
                    this.zah = null;
                    return;
                }
                boolean z7 = true;
                AbstractC1207s.o(!this.zal, "Result has already been consumed.");
                if (this.zap != null) {
                    z7 = false;
                }
                AbstractC1207s.o(z7, "Cannot set callbacks if then() has been called.");
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.zab.a(lVar, a());
                } else {
                    this.zah = lVar;
                    a aVar = this.zab;
                    aVar.sendMessageDelayed(aVar.obtainMessage(2, this), timeUnit.toMillis(j7));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
