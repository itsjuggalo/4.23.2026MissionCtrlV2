package androidx.lifecycle;

import X2.AbstractC0769p;
import android.content.Context;
import androidx.lifecycle.v;
import java.util.List;
import p0.C1685a;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements p0.b {
    @Override // p0.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC0850m a(Context context) {
        kotlin.jvm.internal.r.f(context, "context");
        C1685a c1685aD = C1685a.d(context);
        kotlin.jvm.internal.r.e(c1685aD, "getInstance(context)");
        if (!c1685aD.e(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        C0847j.a(context);
        v.b bVar = v.f7711j;
        bVar.b(context);
        return bVar.a();
    }

    @Override // p0.b
    public List dependencies() {
        return AbstractC0769p.g();
    }
}
