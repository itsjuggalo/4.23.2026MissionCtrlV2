package Z0;

import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Y3.d f3946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f3947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f3948c;

    public f(Context context, d dVar) {
        Y3.d dVar2 = new Y3.d(context, 8);
        this.f3948c = new HashMap();
        this.f3946a = dVar2;
        this.f3947b = dVar;
    }

    public final synchronized g a(String str) {
        if (this.f3948c.containsKey(str)) {
            return (g) this.f3948c.get(str);
        }
        CctBackendFactory cctBackendFactoryZ = this.f3946a.z(str);
        if (cctBackendFactoryZ == null) {
            return null;
        }
        d dVar = this.f3947b;
        g gVarCreate = cctBackendFactoryZ.create(new b(dVar.f3941a, dVar.f3942b, dVar.f3943c, str));
        this.f3948c.put(str, gVarCreate);
        return gVarCreate;
    }
}
