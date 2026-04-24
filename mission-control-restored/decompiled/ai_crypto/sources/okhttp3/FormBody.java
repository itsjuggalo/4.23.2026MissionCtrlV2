package okhttp3;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import w6.C2792e;
import w6.InterfaceC2793f;

/* JADX INFO: loaded from: classes2.dex */
public final class FormBody extends RequestBody {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MediaType f20479c = MediaType.a("application/x-www-form-urlencoded");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f20480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f20481b;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f20482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f20483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Charset f20484c;

        public Builder() {
            this(null);
        }

        public Builder(Charset charset) {
            this.f20482a = new ArrayList();
            this.f20483b = new ArrayList();
            this.f20484c = charset;
        }
    }

    @Override // okhttp3.RequestBody
    public long a() {
        return f(null, true);
    }

    @Override // okhttp3.RequestBody
    public MediaType b() {
        return f20479c;
    }

    @Override // okhttp3.RequestBody
    public void e(InterfaceC2793f interfaceC2793f) throws EOFException {
        f(interfaceC2793f, false);
    }

    public final long f(InterfaceC2793f interfaceC2793f, boolean z7) throws EOFException {
        C2792e c2792e = z7 ? new C2792e() : interfaceC2793f.d();
        int size = this.f20480a.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (i7 > 0) {
                c2792e.v(38);
            }
            c2792e.I((String) this.f20480a.get(i7));
            c2792e.v(61);
            c2792e.I((String) this.f20481b.get(i7));
        }
        if (!z7) {
            return 0L;
        }
        long jE0 = c2792e.E0();
        c2792e.i();
        return jE0;
    }
}
