package okhttp3.internal.http;

import okhttp3.ResponseBody;
import w6.InterfaceC2794g;

/* JADX INFO: loaded from: classes2.dex */
public final class RealResponseBody extends ResponseBody {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f20844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2794g f20845c;

    public RealResponseBody(String str, long j7, InterfaceC2794g interfaceC2794g) {
        this.f20843a = str;
        this.f20844b = j7;
        this.f20845c = interfaceC2794g;
    }

    @Override // okhttp3.ResponseBody
    public InterfaceC2794g G() {
        return this.f20845c;
    }

    @Override // okhttp3.ResponseBody
    public long h() {
        return this.f20844b;
    }
}
