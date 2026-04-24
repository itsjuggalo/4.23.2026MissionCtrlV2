package okhttp3.internal.http2;

import com.revenuecat.purchases.common.Constants;
import okhttp3.Headers;
import okhttp3.internal.Util;
import w6.C2795h;

/* JADX INFO: loaded from: classes2.dex */
public final class Header {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2795h f20892d = C2795h.j(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2795h f20893e = C2795h.j(":status");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C2795h f20894f = C2795h.j(":method");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C2795h f20895g = C2795h.j(":path");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C2795h f20896h = C2795h.j(":scheme");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C2795h f20897i = C2795h.j(":authority");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2795h f20898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2795h f20899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20900c;

    public interface Listener {
        void a(Headers headers);
    }

    public Header(String str, String str2) {
        this(C2795h.j(str), C2795h.j(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return this.f20898a.equals(header.f20898a) && this.f20899b.equals(header.f20899b);
    }

    public int hashCode() {
        return ((527 + this.f20898a.hashCode()) * 31) + this.f20899b.hashCode();
    }

    public String toString() {
        return Util.q("%s: %s", this.f20898a.N(), this.f20899b.N());
    }

    public Header(C2795h c2795h, String str) {
        this(c2795h, C2795h.j(str));
    }

    public Header(C2795h c2795h, C2795h c2795h2) {
        this.f20898a = c2795h;
        this.f20899b = c2795h2;
        this.f20900c = c2795h.H() + 32 + c2795h2.H();
    }
}
