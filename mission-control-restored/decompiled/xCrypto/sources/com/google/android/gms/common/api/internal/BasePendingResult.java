package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.InterfaceC0934l;
import com.google.android.gms.internal.base.zau;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasePendingResult<R extends com.google.android.gms.common.api.k> extends com.google.android.gms.common.api.h {
    static final ThreadLocal zaa = new x0();
    public static final /* synthetic */ int zad = 0;
    private y0 resultGuardian;
    protected final a zab;
    protected final WeakReference zac;
    private com.google.android.gms.common.api.l zah;
    private com.google.android.gms.common.api.k zaj;
    private Status zak;
    private volatile boolean zal;
    private boolean zam;
    private boolean zan;
    private InterfaceC0934l zao;
    private volatile n0 zap;
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
            int i4 = BasePendingResult.zad;
            sendMessage(obtainMessage(1, new Pair((com.google.android.gms.common.api.l) AbstractC0940s.k(lVar), kVar)));
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i4 = message.what;
            if (i4 != 1) {
                if (i4 == 2) {
                    ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.f9656i);
                    return;
                }
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + i4, new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            com.google.android.gms.common.api.l lVar = (com.google.android.gms.common.api.l) pair.first;
            com.google.android.gms.common.api.k kVar = (com.google.android.gms.common.api.k) pair.second;
            try {
                lVar.a(kVar);
            } catch (RuntimeException e4) {
                BasePendingResult.zal(kVar);
                throw e4;
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
            AbstractC0940s.o(!this.zal, "Result has already been consumed.");
            AbstractC0940s.o(isReady(), "Result is not ready.");
            kVar = this.zaj;
            this.zaj = null;
            this.zah = null;
            this.zal = true;
        }
        android.support.v4.media.session.b.a(this.zai.getAndSet(null));
        return (com.google.android.gms.common.api.k) AbstractC0940s.k(kVar);
    }

    @Override // com.google.android.gms.common.api.h
    public final void addStatusListener(h.a aVar) {
        AbstractC0940s.b(aVar != null, "Callback cannot be null.");
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
        AbstractC0940s.j("await must not be called on the UI thread");
        AbstractC0940s.o(!this.zal, "Result has already been consumed");
        AbstractC0940s.o(this.zap == null, "Cannot await if then() has been called.");
        try {
            this.zaf.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f9654g);
        }
        AbstractC0940s.o(isReady(), "Result is not ready.");
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
        for (int i4 = 0; i4 < size; i4++) {
            ((h.a) arrayList.get(i4)).a(this.zak);
        }
        this.zag.clear();
    }

    public void cancel() {
        synchronized (this.zae) {
            try {
                if (!this.zam && !this.zal) {
                    zal(this.zaj);
                    this.zam = true;
                    b(createFailedResult(Status.f9657j));
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
        boolean z4;
        synchronized (this.zae) {
            z4 = this.zam;
        }
        return z4;
    }

    public final boolean isReady() {
        return this.zaf.getCount() == 0;
    }

    public final void setCancelToken(InterfaceC0934l interfaceC0934l) {
        synchronized (this.zae) {
        }
    }

    public final void setResult(R r4) {
        synchronized (this.zae) {
            try {
                if (this.zan || this.zam) {
                    zal(r4);
                    return;
                }
                isReady();
                AbstractC0940s.o(!isReady(), "Results have already been set");
                AbstractC0940s.o(!this.zal, "Result has already been consumed");
                b(r4);
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
                boolean z4 = true;
                AbstractC0940s.o(!this.zal, "Result has already been consumed.");
                if (this.zap != null) {
                    z4 = false;
                }
                AbstractC0940s.o(z4, "Cannot set callbacks if then() has been called.");
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
        AbstractC0940s.o(!this.zal, "Result has already been consumed.");
        synchronized (this.zae) {
            try {
                AbstractC0940s.o(this.zap == null, "Cannot call then() twice.");
                AbstractC0940s.o(this.zah == null, "Cannot call then() if callbacks are set.");
                AbstractC0940s.o(!this.zam, "Cannot call then() if result was canceled.");
                this.zaq = true;
                this.zap = new n0(this.zac);
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
        boolean z4 = true;
        if (!this.zaq && !((Boolean) zaa.get()).booleanValue()) {
            z4 = false;
        }
        this.zaq = z4;
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

    public final void zan(o0 o0Var) {
        this.zai.set(o0Var);
    }

    @Override // com.google.android.gms.common.api.h
    @ResultIgnorabilityUnspecified
    public final R await(long j4, TimeUnit timeUnit) {
        if (j4 > 0) {
            AbstractC0940s.j("await must not be called on the UI thread when time is greater than zero.");
        }
        AbstractC0940s.o(!this.zal, "Result has already been consumed.");
        AbstractC0940s.o(this.zap == null, "Cannot await if then() has been called.");
        try {
            if (!this.zaf.await(j4, timeUnit)) {
                forceFailureUnlessReady(Status.f9656i);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f9654g);
        }
        AbstractC0940s.o(isReady(), "Result is not ready.");
        return (R) a();
    }

    public final void setResultCallback(com.google.android.gms.common.api.l lVar, long j4, TimeUnit timeUnit) {
        synchronized (this.zae) {
            try {
                if (lVar == null) {
                    this.zah = null;
                    return;
                }
                boolean z4 = true;
                AbstractC0940s.o(!this.zal, "Result has already been consumed.");
                if (this.zap != null) {
                    z4 = false;
                }
                AbstractC0940s.o(z4, "Cannot set callbacks if then() has been called.");
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.zab.a(lVar, a());
                } else {
                    this.zah = lVar;
                    a aVar = this.zab;
                    aVar.sendMessageDelayed(aVar.obtainMessage(2, this), timeUnit.toMillis(j4));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
