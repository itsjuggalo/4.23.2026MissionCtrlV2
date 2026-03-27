package androidx.lifecycle;

import F5.AbstractC0556n;
import android.content.Context;
import androidx.lifecycle.v;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements G0.b {
    @Override // G0.b
    public List a() {
        return AbstractC0556n.g();
    }

    @Override // G0.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC0967m b(Context context) {
        kotlin.jvm.internal.r.f(context, "context");
        G0.a aVarE = G0.a.e(context);
        kotlin.jvm.internal.r.e(aVarE, "getInstance(context)");
        if (!aVarE.g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        C0964j.a(context);
        v.b bVar = v.f7820i;
        bVar.b(context);
        return bVar.a();
    }
}
