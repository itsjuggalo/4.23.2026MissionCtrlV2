package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;

/* JADX INFO: loaded from: classes2.dex */
public final class CacheStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Request f20697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Response f20698b;

    public static class Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f20699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Request f20700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Response f20701c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Date f20702d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f20703e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Date f20704f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f20705g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Date f20706h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f20707i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f20708j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f20709k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f20710l;

        public Factory(long j7, Request request, Response response) {
            this.f20710l = -1;
            this.f20699a = j7;
            this.f20700b = request;
            this.f20701c = response;
            if (response != null) {
                this.f20707i = response.z0();
                this.f20708j = response.i0();
                Headers headersM = response.M();
                int iG = headersM.g();
                for (int i7 = 0; i7 < iG; i7++) {
                    String strE = headersM.e(i7);
                    String strH = headersM.h(i7);
                    if ("Date".equalsIgnoreCase(strE)) {
                        this.f20702d = HttpDate.b(strH);
                        this.f20703e = strH;
                    } else if ("Expires".equalsIgnoreCase(strE)) {
                        this.f20706h = HttpDate.b(strH);
                    } else if ("Last-Modified".equalsIgnoreCase(strE)) {
                        this.f20704f = HttpDate.b(strH);
                        this.f20705g = strH;
                    } else if ("ETag".equalsIgnoreCase(strE)) {
                        this.f20709k = strH;
                    } else if ("Age".equalsIgnoreCase(strE)) {
                        this.f20710l = HttpHeaders.f(strH, -1);
                    }
                }
            }
        }

        public static boolean e(Request request) {
            return (request.c("If-Modified-Since") == null && request.c("If-None-Match") == null) ? false : true;
        }

        public final long a() {
            Date date = this.f20702d;
            long jMax = date != null ? Math.max(0L, this.f20708j - date.getTime()) : 0L;
            int i7 = this.f20710l;
            if (i7 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i7));
            }
            long j7 = this.f20708j;
            return jMax + (j7 - this.f20707i) + (this.f20699a - j7);
        }

        public final long b() {
            if (this.f20701c.i().d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.d());
            }
            if (this.f20706h != null) {
                Date date = this.f20702d;
                long time = this.f20706h.getTime() - (date != null ? date.getTime() : this.f20708j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f20704f == null || this.f20701c.y0().i().x() != null) {
                return 0L;
            }
            Date date2 = this.f20702d;
            long time2 = (date2 != null ? date2.getTime() : this.f20707i) - this.f20704f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        public CacheStrategy c() {
            CacheStrategy cacheStrategyD = d();
            return (cacheStrategyD.f20697a == null || !this.f20700b.b().j()) ? cacheStrategyD : new CacheStrategy(null, null);
        }

        public final CacheStrategy d() {
            String str;
            if (this.f20701c == null) {
                return new CacheStrategy(this.f20700b, null);
            }
            if (this.f20700b.f() && this.f20701c.G() == null) {
                return new CacheStrategy(this.f20700b, null);
            }
            if (!CacheStrategy.a(this.f20701c, this.f20700b)) {
                return new CacheStrategy(this.f20700b, null);
            }
            CacheControl cacheControlB = this.f20700b.b();
            if (cacheControlB.h() || e(this.f20700b)) {
                return new CacheStrategy(this.f20700b, null);
            }
            CacheControl cacheControlI = this.f20701c.i();
            long jA = a();
            long jB = b();
            if (cacheControlB.d() != -1) {
                jB = Math.min(jB, TimeUnit.SECONDS.toMillis(cacheControlB.d()));
            }
            long millis = 0;
            long millis2 = cacheControlB.f() != -1 ? TimeUnit.SECONDS.toMillis(cacheControlB.f()) : 0L;
            if (!cacheControlI.g() && cacheControlB.e() != -1) {
                millis = TimeUnit.SECONDS.toMillis(cacheControlB.e());
            }
            if (!cacheControlI.h()) {
                long j7 = millis2 + jA;
                if (j7 < millis + jB) {
                    Response.Builder builderV = this.f20701c.V();
                    if (j7 >= jB) {
                        builderV.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jA > 86400000 && f()) {
                        builderV.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy(null, builderV.c());
                }
            }
            String str2 = this.f20709k;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.f20704f != null) {
                    str2 = this.f20705g;
                } else {
                    if (this.f20702d == null) {
                        return new CacheStrategy(this.f20700b, null);
                    }
                    str2 = this.f20703e;
                }
                str = "If-Modified-Since";
            }
            Headers.Builder builderF = this.f20700b.e().f();
            Internal.f20668a.b(builderF, str, str2);
            return new CacheStrategy(this.f20700b.h().c(builderF.d()).a(), this.f20701c);
        }

        public final boolean f() {
            return this.f20701c.i().d() == -1 && this.f20706h == null;
        }
    }

    public CacheStrategy(Request request, Response response) {
        this.f20697a = request;
        this.f20698b = response;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.i().b() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(okhttp3.Response r3, okhttp3.Request r4) {
        /*
            int r0 = r3.A()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.H(r0)
            if (r0 != 0) goto L5a
            okhttp3.CacheControl r0 = r3.i()
            int r0 = r0.d()
            r1 = -1
            if (r0 != r1) goto L5a
            okhttp3.CacheControl r0 = r3.i()
            boolean r0 = r0.c()
            if (r0 != 0) goto L5a
            okhttp3.CacheControl r0 = r3.i()
            boolean r0 = r0.b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            okhttp3.CacheControl r3 = r3.i()
            boolean r3 = r3.i()
            if (r3 != 0) goto L6f
            okhttp3.CacheControl r3 = r4.b()
            boolean r3 = r3.i()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheStrategy.a(okhttp3.Response, okhttp3.Request):boolean");
    }
}
