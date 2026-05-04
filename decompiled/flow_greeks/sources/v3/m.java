package v3;

import android.content.Context;
import androidx.fragment.app.i0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import v3.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f23103a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o.b f23104b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i0 f23107a;

        public b(i0 i0Var) {
            this.f23107a = i0Var;
        }

        @Override // v3.p
        public Set a() {
            HashSet hashSet = new HashSet();
            b(this.f23107a, hashSet);
            return hashSet;
        }

        public final void b(i0 i0Var, Set set) {
            List listV0 = i0Var.v0();
            int size = listV0.size();
            for (int i10 = 0; i10 < size; i10++) {
                androidx.fragment.app.p pVar = (androidx.fragment.app.p) listV0.get(i10);
                b(pVar.getChildFragmentManager(), set);
                com.bumptech.glide.k kVarA = m.this.a(pVar.getLifecycle());
                if (kVarA != null) {
                    set.add(kVarA);
                }
            }
        }
    }

    public m(o.b bVar) {
        this.f23104b = bVar;
    }

    public com.bumptech.glide.k a(androidx.lifecycle.i iVar) {
        c4.l.a();
        return (com.bumptech.glide.k) this.f23103a.get(iVar);
    }

    public com.bumptech.glide.k b(Context context, com.bumptech.glide.b bVar, androidx.lifecycle.i iVar, i0 i0Var, boolean z10) {
        c4.l.a();
        com.bumptech.glide.k kVarA = a(iVar);
        if (kVarA != null) {
            return kVarA;
        }
        k kVar = new k(iVar);
        com.bumptech.glide.k kVarA2 = this.f23104b.a(bVar, kVar, new b(i0Var), context);
        this.f23103a.put(iVar, kVarA2);
        kVar.c(new a(iVar));
        if (z10) {
            kVarA2.a();
        }
        return kVarA2;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.lifecycle.i f23105a;

        public a(androidx.lifecycle.i iVar) {
            this.f23105a = iVar;
        }

        @Override // v3.l
        public void e() {
            m.this.f23103a.remove(this.f23105a);
        }

        @Override // v3.l
        public void a() {
        }

        @Override // v3.l
        public void h() {
        }
    }
}
