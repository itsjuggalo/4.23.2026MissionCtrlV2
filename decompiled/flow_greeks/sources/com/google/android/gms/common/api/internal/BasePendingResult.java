package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.k;
import com.google.android.gms.internal.base.zao;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@KeepName
public abstract class BasePendingResult<R extends com.google.android.gms.common.api.k> extends com.google.android.gms.common.api.h {
    static final ThreadLocal zaa = new o1();
    public static final /* synthetic */ int zad = 0;

    @KeepName
    private p1 resultGuardian;
    protected final a zab;
    protected final WeakReference zac;
    private com.google.android.gms.common.api.l zah;
    private com.google.android.gms.common.api.k zaj;
    private Status zak;
    private volatile boolean zal;
    private boolean zam;
    private boolean zan;
    private com.google.android.gms.common.internal.l zao;
    private volatile d1 zap;
    private final Object zae = new Object();
    private final CountDownLatch zaf = new CountDownLatch(1);
    private final ArrayList zag = new ArrayList();
    private final AtomicReference zai = new AtomicReference();
    private boolean zaq = false;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends zao {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(com.google.android.gms.common.api.l lVar, com.google.android.gms.common.api.k kVar) {
            int i10 = BasePendingResult.zad;
            sendMessage(obtainMessage(1, new Pair((com.google.android.gms.common.api.l) com.google.android.gms.common.internal.s.k(lVar), kVar)));
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 2) {
                    ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.f5458i);
                    return;
                }
                StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 34);
                sb2.append("Don't know how to handle message: ");
                sb2.append(i10);
                Log.wtf("BasePendingResult", sb2.toString(), new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            com.google.android.gms.common.api.l lVar = (com.google.android.gms.common.api.l) pair.first;
            com.google.android.gms.common.api.k kVar = (com.google.android.gms.common.api.k) pair.second;
            try {
                lVar.a(kVar);
            } catch (RuntimeException e10) {
                BasePendingResult.zal(kVar);
                throw e10;
            }
        }
    }

    public BasePendingResult(com.google.android.gms.common.api.g gVar) {
        this.zab = new a(gVar != null ? gVar.f() : Looper.getMainLooper());
        this.zac = new WeakReference(gVar);
    }

    public final com.google.android.gms.common.api.k a() {
        com.google.android.gms.common.api.k kVar;
        synchronized (this.zae) {
            com.google.android.gms.common.internal.s.o(!this.zal, "Result has already been consumed.");
            com.google.android.gms.common.internal.s.o(isReady(), "Result is not ready.");
            kVar = this.zaj;
            this.zaj = null;
            this.zah = null;
            this.zal = true;
        }
        android.support.v4.media.session.b.a(this.zai.getAndSet(null));
        return (com.google.android.gms.common.api.k) com.google.android.gms.common.internal.s.k(kVar);
    }

    @Override // com.google.android.gms.common.api.h
    public final void addStatusListener(h.a aVar) {
        com.google.android.gms.common.internal.s.b(aVar != null, "Callback cannot be null.");
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

    public final R await() {
        com.google.android.gms.common.internal.s.j("await must not be called on the UI thread");
        com.google.android.gms.common.internal.s.o(!this.zal, "Result has already been consumed");
        com.google.android.gms.common.internal.s.o(this.zap == null, "Cannot await if then() has been called.");
        try {
            this.zaf.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f5456g);
        }
        com.google.android.gms.common.internal.s.o(isReady(), "Result is not ready.");
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
                a aVar = this.zab;
                aVar.removeMessages(2);
                aVar.a(lVar, a());
            }
        }
        ArrayList arrayList = this.zag;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((h.a) arrayList.get(i10)).a(this.zak);
        }
        arrayList.clear();
    }

    public void cancel() {
        synchronized (this.zae) {
            try {
                if (!this.zam && !this.zal) {
                    zal(this.zaj);
                    this.zam = true;
                    b(createFailedResult(Status.f5459j));
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
        boolean z10;
        synchronized (this.zae) {
            z10 = this.zam;
        }
        return z10;
    }

    public final boolean isReady() {
        return this.zaf.getCount() == 0;
    }

    public final void setCancelToken(com.google.android.gms.common.internal.l lVar) {
        synchronized (this.zae) {
        }
    }

    public final void setResult(R r10) {
        synchronized (this.zae) {
            try {
                if (this.zan || this.zam) {
                    zal(r10);
                    return;
                }
                isReady();
                com.google.android.gms.common.internal.s.o(!isReady(), "Results have already been set");
                com.google.android.gms.common.internal.s.o(!this.zal, "Result has already been consumed");
                b(r10);
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
                boolean z10 = true;
                com.google.android.gms.common.internal.s.o(!this.zal, "Result has already been consumed.");
                if (this.zap != null) {
                    z10 = false;
                }
                com.google.android.gms.common.internal.s.o(z10, "Cannot set callbacks if then() has been called.");
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
        com.google.android.gms.common.internal.s.o(!this.zal, "Result has already been consumed.");
        synchronized (this.zae) {
            try {
                com.google.android.gms.common.internal.s.o(this.zap == null, "Cannot call then() twice.");
                com.google.android.gms.common.internal.s.o(this.zah == null, "Cannot call then() if callbacks are set.");
                com.google.android.gms.common.internal.s.o(!this.zam, "Cannot call then() if result was canceled.");
                this.zaq = true;
                this.zap = new d1(this.zac);
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

    public final boolean zaj() {
        boolean zIsCanceled;
        synchronized (this.zae) {
            try {
                if (((com.google.android.gms.common.api.g) this.zac.get()) == null || !this.zaq) {
                    cancel();
                }
                zIsCanceled = isCanceled();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zIsCanceled;
    }

    public final void zak() {
        boolean z10 = true;
        if (!this.zaq && !((Boolean) zaa.get()).booleanValue()) {
            z10 = false;
        }
        this.zaq = z10;
    }

    public final /* synthetic */ com.google.android.gms.common.api.k zam() {
        return this.zaj;
    }

    public final void zan(e1 e1Var) {
        this.zai.set(e1Var);
    }

    @Override // com.google.android.gms.common.api.h
    public final R await(long j10, TimeUnit timeUnit) {
        if (j10 > 0) {
            com.google.android.gms.common.internal.s.j("await must not be called on the UI thread when time is greater than zero.");
        }
        com.google.android.gms.common.internal.s.o(!this.zal, "Result has already been consumed.");
        com.google.android.gms.common.internal.s.o(this.zap == null, "Cannot await if then() has been called.");
        try {
            if (!this.zaf.await(j10, timeUnit)) {
                forceFailureUnlessReady(Status.f5458i);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f5456g);
        }
        com.google.android.gms.common.internal.s.o(isReady(), "Result is not ready.");
        return (R) a();
    }

    public final void setResultCallback(com.google.android.gms.common.api.l lVar, long j10, TimeUnit timeUnit) {
        synchronized (this.zae) {
            try {
                if (lVar == null) {
                    this.zah = null;
                    return;
                }
                boolean z10 = true;
                com.google.android.gms.common.internal.s.o(!this.zal, "Result has already been consumed.");
                if (this.zap != null) {
                    z10 = false;
                }
                com.google.android.gms.common.internal.s.o(z10, "Cannot set callbacks if then() has been called.");
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.zab.a(lVar, a());
                } else {
                    this.zah = lVar;
                    a aVar = this.zab;
                    aVar.sendMessageDelayed(aVar.obtainMessage(2, this), timeUnit.toMillis(j10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void zal(com.google.android.gms.common.api.k kVar) {
    }
}
