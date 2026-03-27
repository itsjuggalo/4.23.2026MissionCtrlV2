package p5;

import android.content.Context;
import android.view.View;
import io.flutter.plugin.platform.AbstractC2015l;
import io.flutter.plugin.platform.InterfaceC2014k;

/* JADX INFO: renamed from: p5.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2429h0 extends AbstractC2015l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2400d f21886b;

    public C2429h0(C2400d c2400d) {
        super(V4.o.f5344a);
        this.f21886b = c2400d;
    }

    @Override // io.flutter.plugin.platform.AbstractC2015l
    public InterfaceC2014k a(Context context, int i7, Object obj) {
        if (((Integer) obj) == null) {
            throw new IllegalStateException("An identifier is required to retrieve a View instance.");
        }
        Object objH = this.f21886b.h(r3.intValue());
        if (objH instanceof InterfaceC2014k) {
            return (InterfaceC2014k) objH;
        }
        if (objH instanceof View) {
            return new a(objH);
        }
        throw new IllegalStateException("Unable to find a PlatformView or View instance: " + obj + ", " + objH);
    }

    /* JADX INFO: renamed from: p5.h0$a */
    public class a implements InterfaceC2014k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f21887a;

        public a(Object obj) {
            this.f21887a = obj;
        }

        @Override // io.flutter.plugin.platform.InterfaceC2014k
        public View getView() {
            return (View) this.f21887a;
        }

        @Override // io.flutter.plugin.platform.InterfaceC2014k
        public void a() {
        }
    }
}
