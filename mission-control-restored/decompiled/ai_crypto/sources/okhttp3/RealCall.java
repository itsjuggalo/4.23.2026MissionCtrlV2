package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import w6.C2790c;

/* JADX INFO: loaded from: classes2.dex */
final class RealCall implements Call {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OkHttpClient f20598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RetryAndFollowUpInterceptor f20599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2790c f20600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EventListener f20601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Request f20602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f20603f;

    public final class AsyncCall extends NamedRunnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Callback f20605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RealCall f20606c;

        @Override // okhttp3.internal.NamedRunnable
        public void c() {
            boolean z7;
            Throwable th;
            IOException e7;
            this.f20606c.f20600c.w();
            try {
                try {
                    z7 = true;
                    try {
                        this.f20605b.a(this.f20606c, this.f20606c.c());
                    } catch (IOException e8) {
                        e7 = e8;
                        IOException iOExceptionI = this.f20606c.i(e7);
                        if (z7) {
                            Platform.l().s(4, "Callback failure for " + this.f20606c.j(), iOExceptionI);
                        } else {
                            this.f20606c.f20601d.b(this.f20606c, iOExceptionI);
                            this.f20605b.b(this.f20606c, iOExceptionI);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        this.f20606c.cancel();
                        if (!z7) {
                            this.f20605b.b(this.f20606c, new IOException("canceled due to " + th));
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    this.f20606c.f20598a.i().c(this);
                    throw th3;
                }
            } catch (IOException e9) {
                z7 = false;
                e7 = e9;
            } catch (Throwable th4) {
                z7 = false;
                th = th4;
            }
            this.f20606c.f20598a.i().c(this);
        }

        public void l(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e7) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e7);
                    this.f20606c.f20601d.b(this.f20606c, interruptedIOException);
                    this.f20605b.b(this.f20606c, interruptedIOException);
                    this.f20606c.f20598a.i().c(this);
                }
            } catch (Throwable th) {
                this.f20606c.f20598a.i().c(this);
                throw th;
            }
        }

        public RealCall m() {
            return this.f20606c;
        }

        public String n() {
            return this.f20606c.f20602e.i().l();
        }
    }

    public RealCall(OkHttpClient okHttpClient, Request request, boolean z7) {
        this.f20598a = okHttpClient;
        this.f20602e = request;
        this.f20603f = z7;
        this.f20599b = new RetryAndFollowUpInterceptor(okHttpClient, z7);
        C2790c c2790c = new C2790c() { // from class: okhttp3.RealCall.1
            @Override // w6.C2790c
            public void C() {
                RealCall.this.cancel();
            }
        };
        this.f20600c = c2790c;
        c2790c.g(okHttpClient.b(), TimeUnit.MILLISECONDS);
    }

    public static RealCall e(OkHttpClient okHttpClient, Request request, boolean z7) {
        RealCall realCall = new RealCall(okHttpClient, request, z7);
        realCall.f20601d = okHttpClient.k().a(realCall);
        return realCall;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RealCall clone() {
        return e(this.f20598a, this.f20602e, this.f20603f);
    }

    public Response c() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f20598a.o());
        arrayList.add(this.f20599b);
        arrayList.add(new BridgeInterceptor(this.f20598a.g()));
        arrayList.add(new CacheInterceptor(this.f20598a.p()));
        arrayList.add(new ConnectInterceptor(this.f20598a));
        if (!this.f20603f) {
            arrayList.addAll(this.f20598a.q());
        }
        arrayList.add(new CallServerInterceptor(this.f20603f));
        Response responseC = new RealInterceptorChain(arrayList, null, null, null, 0, this.f20602e, this, this.f20601d, this.f20598a.d(), this.f20598a.x(), this.f20598a.B()).c(this.f20602e);
        if (!this.f20599b.e()) {
            return responseC;
        }
        Util.f(responseC);
        throw new IOException("Canceled");
    }

    @Override // okhttp3.Call
    public void cancel() {
        this.f20599b.b();
    }

    public boolean d() {
        return this.f20599b.e();
    }

    public String f() {
        return this.f20602e.i().z();
    }

    public StreamAllocation g() {
        return this.f20599b.k();
    }

    public IOException i(IOException iOException) {
        if (!this.f20600c.x()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public String j() {
        StringBuilder sb = new StringBuilder();
        sb.append(d() ? "canceled " : "");
        sb.append(this.f20603f ? "web socket" : "call");
        sb.append(" to ");
        sb.append(f());
        return sb.toString();
    }
}
