package okhttp3;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import w6.C2792e;
import w6.C2795h;
import w6.InterfaceC2793f;

/* JADX INFO: loaded from: classes2.dex */
public final class MultipartBody extends RequestBody {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final MediaType f20515e = MediaType.a("multipart/mixed");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final MediaType f20516f = MediaType.a("multipart/alternative");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final MediaType f20517g = MediaType.a("multipart/digest");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MediaType f20518h = MediaType.a("multipart/parallel");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final MediaType f20519i = MediaType.a("multipart/form-data");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte[] f20520j = {58, 32};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final byte[] f20521k = {13, 10};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte[] f20522l = {45, 45};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2795h f20523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaType f20524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f20525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f20526d;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2795h f20527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MediaType f20528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f20529c;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String str) {
            this.f20528b = MultipartBody.f20515e;
            this.f20529c = new ArrayList();
            this.f20527a = C2795h.j(str);
        }
    }

    public static final class Part {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Headers f20530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RequestBody f20531b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long f(InterfaceC2793f interfaceC2793f, boolean z7) throws EOFException {
        C2792e c2792e;
        if (z7) {
            interfaceC2793f = new C2792e();
            c2792e = interfaceC2793f;
        } else {
            c2792e = 0;
        }
        int size = this.f20525c.size();
        long j7 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Part part = (Part) this.f20525c.get(i7);
            Headers headers = part.f20530a;
            RequestBody requestBody = part.f20531b;
            interfaceC2793f.a0(f20522l);
            interfaceC2793f.m(this.f20523a);
            interfaceC2793f.a0(f20521k);
            if (headers != null) {
                int iG = headers.g();
                for (int i8 = 0; i8 < iG; i8++) {
                    interfaceC2793f.I(headers.e(i8)).a0(f20520j).I(headers.h(i8)).a0(f20521k);
                }
            }
            MediaType mediaTypeB = requestBody.b();
            if (mediaTypeB != null) {
                interfaceC2793f.I("Content-Type: ").I(mediaTypeB.toString()).a0(f20521k);
            }
            long jA = requestBody.a();
            if (jA != -1) {
                interfaceC2793f.I("Content-Length: ").q0(jA).a0(f20521k);
            } else if (z7) {
                c2792e.i();
                return -1L;
            }
            byte[] bArr = f20521k;
            interfaceC2793f.a0(bArr);
            if (z7) {
                j7 += jA;
            } else {
                requestBody.e(interfaceC2793f);
            }
            interfaceC2793f.a0(bArr);
        }
        byte[] bArr2 = f20522l;
        interfaceC2793f.a0(bArr2);
        interfaceC2793f.m(this.f20523a);
        interfaceC2793f.a0(bArr2);
        interfaceC2793f.a0(f20521k);
        if (!z7) {
            return j7;
        }
        long jE0 = j7 + c2792e.E0();
        c2792e.i();
        return jE0;
    }

    @Override // okhttp3.RequestBody
    public long a() throws EOFException {
        long j7 = this.f20526d;
        if (j7 != -1) {
            return j7;
        }
        long jF = f(null, true);
        this.f20526d = jF;
        return jF;
    }

    @Override // okhttp3.RequestBody
    public MediaType b() {
        return this.f20524b;
    }

    @Override // okhttp3.RequestBody
    public void e(InterfaceC2793f interfaceC2793f) throws EOFException {
        f(interfaceC2793f, false);
    }
}
