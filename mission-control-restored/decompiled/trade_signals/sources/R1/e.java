package R1;

import R1.a;
import S1.AbstractC0882n;
import S1.AbstractServiceConnectionC0878j;
import S1.C0869a;
import S1.C0870b;
import S1.C0873e;
import S1.C0885q;
import S1.C0892y;
import S1.D;
import S1.InterfaceC0881m;
import S1.N;
import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.AbstractC1283c;
import com.google.android.gms.common.internal.AbstractC1294n;
import com.google.android.gms.common.internal.C1284d;
import java.util.Collections;
import l2.AbstractC2328l;
import l2.C2329m;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final R1.a f7098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a.d f7099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0870b f7100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Looper f7101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f7102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f7103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InterfaceC0881m f7104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C0873e f7105j;

    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f7106c = new C0100a().a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0881m f7107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Looper f7108b;

        /* JADX INFO: renamed from: R1.e$a$a, reason: collision with other inner class name */
        public static class C0100a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public InterfaceC0881m f7109a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Looper f7110b;

            /* JADX WARN: Multi-variable type inference failed */
            public a a() {
                if (this.f7109a == null) {
                    this.f7109a = new C0869a();
                }
                if (this.f7110b == null) {
                    this.f7110b = Looper.getMainLooper();
                }
                return new a(this.f7109a, this.f7110b);
            }
        }

        public a(InterfaceC0881m interfaceC0881m, Account account, Looper looper) {
            this.f7107a = interfaceC0881m;
            this.f7108b = looper;
        }
    }

    public e(Context context, R1.a aVar, a.d dVar, a aVar2) {
        this(context, null, aVar, dVar, aVar2);
    }

    public C1284d.a b() {
        C1284d.a aVar = new C1284d.a();
        aVar.d(null);
        aVar.c(Collections.emptySet());
        aVar.e(this.f7096a.getClass().getName());
        aVar.b(this.f7096a.getPackageName());
        return aVar;
    }

    public AbstractC2328l c(AbstractC0882n abstractC0882n) {
        return j(2, abstractC0882n);
    }

    public String d(Context context) {
        return null;
    }

    public final C0870b e() {
        return this.f7100e;
    }

    public String f() {
        return this.f7097b;
    }

    public final int g() {
        return this.f7102g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a.f h(Looper looper, C0892y c0892y) {
        C1284d c1284dA = b().a();
        a.f fVarA = ((a.AbstractC0099a) AbstractC1294n.j(this.f7098c.a())).a(this.f7096a, looper, c1284dA, this.f7099d, c0892y, c0892y);
        String strF = f();
        if (strF != null && (fVarA instanceof AbstractC1283c)) {
            ((AbstractC1283c) fVarA).setAttributionTag(strF);
        }
        if (strF == null || !(fVarA instanceof AbstractServiceConnectionC0878j)) {
            return fVarA;
        }
        android.support.v4.media.session.b.a(fVarA);
        throw null;
    }

    public final N i(Context context, Handler handler) {
        return new N(context, handler, b().a());
    }

    public final AbstractC2328l j(int i8, AbstractC0882n abstractC0882n) {
        C2329m c2329m = new C2329m();
        this.f7105j.z(this, i8, abstractC0882n, c2329m, this.f7104i);
        return c2329m.a();
    }

    public e(Context context, Activity activity, R1.a aVar, a.d dVar, a aVar2) {
        AbstractC1294n.k(context, "Null context is not permitted.");
        AbstractC1294n.k(aVar, "Api must not be null.");
        AbstractC1294n.k(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) AbstractC1294n.k(context.getApplicationContext(), "The provided context did not have an application context.");
        this.f7096a = context2;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : d(context);
        this.f7097b = attributionTag;
        this.f7098c = aVar;
        this.f7099d = dVar;
        this.f7101f = aVar2.f7108b;
        C0870b c0870bA = C0870b.a(aVar, dVar, attributionTag);
        this.f7100e = c0870bA;
        this.f7103h = new D(this);
        C0873e c0873eT = C0873e.t(context2);
        this.f7105j = c0873eT;
        this.f7102g = c0873eT.k();
        this.f7104i = aVar2.f7107a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            C0885q.u(activity, c0873eT, c0870bA);
        }
        c0873eT.D(this);
    }
}
