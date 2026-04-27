package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.internal.InterfaceC0437o;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public abstract class BasePendingResult<R extends com.google.android.gms.common.api.s> extends com.google.android.gms.common.api.q {
    static final ThreadLocal zaa = new F1.j(2);
    public static final /* synthetic */ int zad = 0;

    @KeepName
    private a0 resultGuardian;
    protected final HandlerC0402e zab;
    protected final WeakReference zac;
    private com.google.android.gms.common.api.t zah;
    private com.google.android.gms.common.api.s zaj;
    private Status zak;
    private volatile boolean zal;
    private boolean zam;
    private boolean zan;
    private InterfaceC0437o zao;
    private volatile S zap;
    private final Object zae = new Object();
    private final CountDownLatch zaf = new CountDownLatch(1);
    private final ArrayList zag = new ArrayList();
    private final AtomicReference zai = new AtomicReference();
    private boolean zaq = false;

    public BasePendingResult(com.google.android.gms.common.api.o oVar) {
        this.zab = new HandlerC0402e(oVar != null ? ((H) oVar).f5099b.getLooper() : Looper.getMainLooper());
        this.zac = new WeakReference(oVar);
    }

    public static void zal(com.google.android.gms.common.api.s sVar) {
    }

    public final com.google.android.gms.common.api.s a() {
        com.google.android.gms.common.api.s sVar;
        synchronized (this.zae) {
            com.google.android.gms.common.internal.I.i("Result has already been consumed.", !this.zal);
            com.google.android.gms.common.internal.I.i("Result is not ready.", isReady());
            sVar = this.zaj;
            this.zaj = null;
            this.zah = null;
            this.zal = true;
        }
        if (this.zai.getAndSet(null) != null) {
            throw new ClassCastException();
        }
        com.google.android.gms.common.internal.I.g(sVar);
        return sVar;
    }

    public final void addStatusListener(com.google.android.gms.common.api.p pVar) {
        com.google.android.gms.common.internal.I.a("Callback cannot be null.", pVar != null);
        synchronized (this.zae) {
            try {
                if (isReady()) {
                    pVar.a(this.zak);
                } else {
                    this.zag.add(pVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @ResultIgnorabilityUnspecified
    public final R await() {
        com.google.android.gms.common.internal.I.f("await must not be called on the UI thread");
        com.google.android.gms.common.internal.I.i("Result has already been consumed", !this.zal);
        com.google.android.gms.common.internal.I.i("Cannot await if then() has been called.", this.zap == null);
        try {
            this.zaf.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f5058f);
        }
        com.google.android.gms.common.internal.I.i("Result is not ready.", isReady());
        return (R) a();
    }

    public final void b(com.google.android.gms.common.api.s sVar) {
        this.zaj = sVar;
        this.zak = sVar.getStatus();
        this.zaf.countDown();
        if (this.zam) {
            this.zah = null;
        } else {
            com.google.android.gms.common.api.t tVar = this.zah;
            if (tVar != null) {
                this.zab.removeMessages(2);
                this.zab.a(tVar, a());
            }
        }
        ArrayList arrayList = this.zag;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((com.google.android.gms.common.api.p) arrayList.get(i)).a(this.zak);
        }
        this.zag.clear();
    }

    public void cancel() {
        synchronized (this.zae) {
            try {
                if (!this.zam && !this.zal) {
                    zal(this.zaj);
                    this.zam = true;
                    b(createFailedResult(Status.f5061m));
                }
            } finally {
            }
        }
    }

    public abstract com.google.android.gms.common.api.s createFailedResult(Status status);

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
        boolean z6;
        synchronized (this.zae) {
            z6 = this.zam;
        }
        return z6;
    }

    public final boolean isReady() {
        return this.zaf.getCount() == 0;
    }

    public final void setCancelToken(InterfaceC0437o interfaceC0437o) {
        synchronized (this.zae) {
        }
    }

    public final void setResult(R r6) {
        synchronized (this.zae) {
            try {
                if (this.zan || this.zam) {
                    zal(r6);
                    return;
                }
                isReady();
                com.google.android.gms.common.internal.I.i("Results have already been set", !isReady());
                com.google.android.gms.common.internal.I.i("Result has already been consumed", !this.zal);
                b(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setResultCallback(com.google.android.gms.common.api.t tVar) {
        synchronized (this.zae) {
            try {
                if (tVar == null) {
                    this.zah = null;
                    return;
                }
                boolean z6 = true;
                com.google.android.gms.common.internal.I.i("Result has already been consumed.", !this.zal);
                if (this.zap != null) {
                    z6 = false;
                }
                com.google.android.gms.common.internal.I.i("Cannot set callbacks if then() has been called.", z6);
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.zab.a(tVar, a());
                } else {
                    this.zah = tVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <S extends com.google.android.gms.common.api.s> com.google.android.gms.common.api.v then(com.google.android.gms.common.api.u uVar) {
        S s6;
        com.google.android.gms.common.internal.I.i("Result has already been consumed.", !this.zal);
        synchronized (this.zae) {
            try {
                com.google.android.gms.common.internal.I.i("Cannot call then() twice.", this.zap == null);
                com.google.android.gms.common.internal.I.i("Cannot call then() if callbacks are set.", this.zah == null);
                com.google.android.gms.common.internal.I.i("Cannot call then() if result was canceled.", !this.zam);
                this.zaq = true;
                this.zap = new S(this.zac);
                S s7 = this.zap;
                synchronized (s7.f5123b) {
                    s6 = new S(s7.f5124c);
                    s7.f5122a = s6;
                }
                if (isReady()) {
                    this.zab.a(this.zap, a());
                } else {
                    this.zah = this.zap;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return s6;
    }

    public final void zak() {
        boolean z6 = true;
        if (!this.zaq && !((Boolean) zaa.get()).booleanValue()) {
            z6 = false;
        }
        this.zaq = z6;
    }

    public final boolean zam() {
        boolean zIsCanceled;
        synchronized (this.zae) {
            try {
                if (((com.google.android.gms.common.api.o) this.zac.get()) == null || !this.zaq) {
                    cancel();
                }
                zIsCanceled = isCanceled();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zIsCanceled;
    }

    public final void zan(T t6) {
        this.zai.set(t6);
    }

    @Override // com.google.android.gms.common.api.q
    @ResultIgnorabilityUnspecified
    public final R await(long j4, TimeUnit timeUnit) {
        if (j4 > 0) {
            com.google.android.gms.common.internal.I.f("await must not be called on the UI thread when time is greater than zero.");
        }
        com.google.android.gms.common.internal.I.i("Result has already been consumed.", !this.zal);
        com.google.android.gms.common.internal.I.i("Cannot await if then() has been called.", this.zap == null);
        try {
            if (!this.zaf.await(j4, timeUnit)) {
                forceFailureUnlessReady(Status.f5060l);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f5058f);
        }
        com.google.android.gms.common.internal.I.i("Result is not ready.", isReady());
        return (R) a();
    }

    public final void setResultCallback(com.google.android.gms.common.api.t tVar, long j4, TimeUnit timeUnit) {
        synchronized (this.zae) {
            try {
                if (tVar == null) {
                    this.zah = null;
                    return;
                }
                boolean z6 = true;
                com.google.android.gms.common.internal.I.i("Result has already been consumed.", !this.zal);
                if (this.zap != null) {
                    z6 = false;
                }
                com.google.android.gms.common.internal.I.i("Cannot set callbacks if then() has been called.", z6);
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.zab.a(tVar, a());
                } else {
                    this.zah = tVar;
                    HandlerC0402e handlerC0402e = this.zab;
                    handlerC0402e.sendMessageDelayed(handlerC0402e.obtainMessage(2, this), timeUnit.toMillis(j4));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
