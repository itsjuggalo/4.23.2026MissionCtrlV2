package f4;

import Z1.m;
import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class e implements V3.b, k, j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f6471c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6473b = false;

    public static g c(m mVar) {
        String str = mVar.f3974a;
        String str2 = mVar.e;
        if (str2 == null) {
            str2 = null;
        }
        String str3 = mVar.f3979g;
        if (str3 == null) {
            str3 = null;
        }
        g gVar = new g();
        if (str == null) {
            throw new IllegalStateException("Nonnull field \"apiKey\" is null.");
        }
        gVar.f6476a = str;
        String str4 = mVar.f3975b;
        if (str4 == null) {
            throw new IllegalStateException("Nonnull field \"appId\" is null.");
        }
        gVar.f6477b = str4;
        if (str2 == null) {
            throw new IllegalStateException("Nonnull field \"messagingSenderId\" is null.");
        }
        gVar.f6478c = str2;
        if (str3 == null) {
            throw new IllegalStateException("Nonnull field \"projectId\" is null.");
        }
        gVar.f6479d = str3;
        gVar.e = null;
        gVar.f6480f = mVar.f3976c;
        gVar.f6481g = mVar.f3978f;
        gVar.f6482h = null;
        gVar.i = mVar.f3977d;
        gVar.f6483j = null;
        gVar.f6484k = null;
        gVar.f6485l = null;
        gVar.f6486m = null;
        gVar.f6487n = null;
        return gVar;
    }

    @Override // V3.b
    public final void onAttachedToEngine(V3.a aVar) {
        k.a(aVar.f3288b, this);
        j.b(aVar.f3288b, this);
        this.f6472a = aVar.f3287a;
    }

    @Override // V3.b
    public final void onDetachedFromEngine(V3.a aVar) {
        this.f6472a = null;
        k.a(aVar.f3288b, null);
        j.b(aVar.f3288b, null);
    }
}
