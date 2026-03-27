package R0;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: renamed from: R0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0806c {

    /* JADX INFO: renamed from: R0.c$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile C0832p f6913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f6914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile InterfaceC0837t f6915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f6916d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f6917e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile boolean f6918f;

        public /* synthetic */ a(Context context, N0 n02) {
            this.f6914b = context;
        }

        public AbstractC0806c a() {
            Context context = this.f6914b;
            if (context == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            if (this.f6915c == null) {
                if (this.f6916d || this.f6917e) {
                    return d() ? new C0831o0(null, context, null, null, this) : new C0810e(null, context, null, null, this);
                }
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            }
            if (this.f6913a == null || !this.f6913a.a()) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            InterfaceC0837t interfaceC0837t = this.f6915c;
            C0832p c0832p = this.f6913a;
            if (interfaceC0837t == null) {
                return d() ? new C0831o0(null, c0832p, context, null, null, null, this) : new C0810e(null, c0832p, context, null, null, null, this);
            }
            InterfaceC0837t interfaceC0837t2 = this.f6915c;
            return d() ? new C0831o0(null, c0832p, context, interfaceC0837t2, null, null, null, this) : new C0810e(null, c0832p, context, interfaceC0837t2, null, null, null, this);
        }

        public a b(C0832p c0832p) {
            this.f6913a = c0832p;
            return this;
        }

        public a c(InterfaceC0837t interfaceC0837t) {
            this.f6915c = interfaceC0837t;
            return this;
        }

        public final boolean d() {
            try {
                Context context = this.f6914b;
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("com.google.android.play.billingclient.enableBillingOverridesTesting", false);
            } catch (Exception e8) {
                com.google.android.gms.internal.play_billing.V.n("BillingClient", "Unable to retrieve metadata value for enableBillingOverridesTesting.", e8);
                return false;
            }
        }
    }

    public static a h(Context context) {
        return new a(context, null);
    }

    public abstract void a(C0802a c0802a, InterfaceC0804b interfaceC0804b);

    public abstract void b(C0820j c0820j, InterfaceC0822k interfaceC0822k);

    public abstract void c();

    public abstract void d(C0824l c0824l, InterfaceC0816h interfaceC0816h);

    public abstract com.android.billingclient.api.a e(String str);

    public abstract boolean f();

    public abstract com.android.billingclient.api.a g(Activity activity, C0818i c0818i);

    public abstract void i(C0838u c0838u, r rVar);

    public abstract void j(C0841x c0841x, InterfaceC0836s interfaceC0836s);

    public abstract com.android.billingclient.api.a k(Activity activity, C0826m c0826m, InterfaceC0828n interfaceC0828n);

    public abstract void l(InterfaceC0812f interfaceC0812f);
}
